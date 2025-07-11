package com.example.ecommerceSpring.repository;

import com.example.ecommerceSpring.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    //This is a custom query method using HQL. Explicitly define the query logic
    //http://localhost:7777/api/categories?minPrice=2500
    //SELECT p FROM PRODUCT_ENTITY p WHERE p.price > 5000 is a JPQL query (used in JPA/Hibernate).
    @Query("SELECT p FROM ProductEntity p WHERE p.price > :minPrice")
    List<ProductEntity> findExpensiveProduct(@Param("minPrice") double minPrice) ;

    @Query(value = "SELECT * FROM product_entity WHERE MATCH(NAME,DESCRIPTION) AGAINST (:keyword)" , nativeQuery = true)
    List<ProductEntity> searchFullText(@Param("keyword") String keyword) ;
}
