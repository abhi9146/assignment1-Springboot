package com.assignment.demo.services;

import com.assignment.demo.entity.Brand;
import com.assignment.demo.entity.Category;
import com.assignment.demo.entity.Product;
import com.assignment.demo.repository.BrandRepository;
import com.assignment.demo.repository.CategoryRepository;
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
    private CategoryRepository categoryRepository;
    @Autowired
    private BrandRepository brandRepository;

    public void saveProduct(Product product) {
        productRepository.save(product);
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

    public void addCategory(Long productId, Long categoryId) {
        Product product=productRepository.findById(productId).orElse(null);
        Category category=categoryRepository.findById(categoryId).orElse(null);

        product.setCategory(category);
        productRepository.save(product);
    }
    public void addBrand(Long productId, Long brandId) {
        Product product=productRepository.findById(productId).orElse(null);
        Brand brand=brandRepository.findById(brandId).orElse(null);

        List<Brand> productBrands = product.getBrands();
        productBrands.add(brand);
        product.setBrands(productBrands);
        productRepository.save(product);
    }
}
