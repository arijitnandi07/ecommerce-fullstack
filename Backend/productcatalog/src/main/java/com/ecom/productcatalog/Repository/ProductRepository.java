package com.ecom.productcatalog.Repository;

import com.ecom.productcatalog.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("""
        select p
        from Product p
        join fetch p.category
    """)
    List<Product> findAllWithCategory();

    @Query("""
        select p
        from Product p
        join fetch p.category
        where p.category.id = :categoryId
    """)
    List<Product> findByCategoryWithCategory(@Param("categoryId") Long categoryId);
}
