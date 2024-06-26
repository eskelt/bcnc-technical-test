CREATE TABLE public.brands (
    id serial NOT NULL,
	description varchar NOT NULL,
	CONSTRAINT brands_pk PRIMARY KEY (id)
);

CREATE TABLE public.prices (
	id serial NOT NULL,
	brand_id bigint NOT NULL,
	start_date timestamp NOT NULL,
	end_date timestamp NOT NULL,
	price_list bigint NOT NULL,
	product_id bigint NOT NULL,
	priority int NOT NULL,
	price numeric(10, 2) NOT NULL,
	currency varchar(3) NOT NULL,
	CONSTRAINT prices_pk PRIMARY KEY (id),
	CONSTRAINT prices_brand_fk FOREIGN KEY (brand_id) REFERENCES public.brands(id)
);