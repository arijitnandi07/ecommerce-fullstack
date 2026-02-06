package com.ecom.productcatalog.Service;

import com.ecom.productcatalog.Repository.ProductRepository;
import com.ecom.productcatalog.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAllWithCategory();
    }

    public List<Product> getProductByCategory(Long categoryId) {
        return productRepository.findByCategoryWithCategory(categoryId);
    }
}
