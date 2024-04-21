CREATE TABLE public.brands (
    id serial NOT NULL,
	description varchar NOT NULL,
	CONSTRAINT brands_pk PRIMARY KEY (id)
);

CREATE TABLE public.products (
	id serial NOT NULL,
	brand_id bigint NOT NULL,
	start_date timestamp NOT NULL,
	end_date timestamp NOT NULL,
	price_list bigint NOT NULL,
	product_id bigint NOT NULL,
	priority int NOT NULL,
	price numeric NOT NULL,
	currency varchar(3) NOT NULL,
	CONSTRAINT products_pk PRIMARY KEY (id),
	CONSTRAINT products_brand_fk FOREIGN KEY (brand_id) REFERENCES public.brands(id)
);