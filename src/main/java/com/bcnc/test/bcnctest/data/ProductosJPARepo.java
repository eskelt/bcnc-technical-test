package com.bcnc.test.bcnctest.data;

import com.bcnc.test.bcnctest.data.entity.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface ProductosJPARepo extends JpaRepository<ProductsEntity, Long> {

    @Query("SELECT p FROM ProductsEntity p " +
            "WHERE :applicationDate BETWEEN p.startDate AND p.endDate " +
            "AND p.productId = :productId " +
            "AND p.brand.id = :brandId " +
            "ORDER BY p.priority DESC")
    ProductsEntity findProductInfo(
            @Param("applicationDate") LocalDateTime applicationDate,
            @Param("productId") Integer productId,
            @Param("brandId") Integer brandId
    );

}
