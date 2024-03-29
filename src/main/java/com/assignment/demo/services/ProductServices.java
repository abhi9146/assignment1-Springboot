package com.assignment.demo.services;

import com.assignment.demo.entity.Brand;
import com.assignment.demo.entity.Product;
import com.assignment.demo.repository.BrandRepository;
import com.assignment.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServices {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private BrandRepository brandRepository;

    public void saveProduct(Product product) {
        productRepository.save(product);
        List<Brand> brands = product.getBrands();

        // Iterate through the brands list
        for (Brand brand : brands) {
            // Check if the brand already exists in the Brand entity
            Brand existingBrand = brandRepository.findByName(brand.getName());
            if (existingBrand != null) {
                // If the brand already exists, update its product name
                existingBrand.setName(product.getName());
            } else {
                // If the brand doesn't exist, save it to the Brand entity
                brand.setName(product.getName());
                brandRepository.save(brand);
            }
        } if (brands != null && !brands.isEmpty()) {
            // Iterate through the brands list
            for (Brand brand : brands) {
                // Check if the brand already exists in the Brand entity
                Brand existingBrand = brandRepository.findByName(brand.getName());
                if (existingBrand != null) {
                    // If the brand already exists, update its product name
                    existingBrand.setName(product.getName());
                } else {
                    // If the brand doesn't exist, save it to the Brand entity
                    brand.setName(product.getName());
                    brandRepository.save(brand);
                }
            }
        }
    }

    public Product getProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
