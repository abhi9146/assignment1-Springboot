package com.assignment.demo.services;
import com.assignment.demo.entity.Brand;
import com.assignment.demo.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServices {
    @Autowired
    private BrandRepository brandRepository;

    public void saveBrand(Brand brand) {
        brandRepository.save(brand);
    }

    public Brand getBrand(Long id) {
        return brandRepository.findById(id).orElse(null);
    }
    public List<Brand> getBrands() {
        return brandRepository.findAll();
    }
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    public void updateBrand(Brand brand) {
        brandRepository.save(brand);
    }

    public void deleteBrand(Long id) {
        brandRepository.deleteById(id);
    }
}
