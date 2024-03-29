package com.assignment.demo.controllers;

import com.assignment.demo.services.BrandServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.assignment.demo.entity.Brand;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    private BrandServices brandServices;

    @PostMapping("/addBrand")
    public void addBrand(@RequestBody Brand brand ){
        brandServices.saveBrand(brand);
    }

    @GetMapping("/getBrand/{id}")
    public Brand getBrand(@PathVariable Long id){
        return brandServices.getBrand(id);
    }
    @GetMapping("/getBrands")
    public List<Brand> getBrands(){
        return brandServices.getBrands();
    }

    @PutMapping("/updateBrand")
    public void updateBrand(@RequestBody Brand brand){
        brandServices.updateBrand(brand);
    }

    @DeleteMapping("/deleteBrand/{id}")
    public void deleteBrand(@PathVariable Long id){
        brandServices.deleteBrand(id);
    }
}
