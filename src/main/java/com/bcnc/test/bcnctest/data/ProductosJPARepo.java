package com.bcnc.test.bcnctest.data;

import com.bcnc.test.bcnctest.data.entity.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductosJPARepo extends JpaRepository<ProductsEntity, Long> {
}
