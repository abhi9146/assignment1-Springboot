package com.assignment.demo.controllers;

import com.assignment.demo.entity.Category;
import com.assignment.demo.services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryServices categoryServices;

    // to add single product
    @PostMapping("/addCategory")
    public void addProduct(@RequestBody Category category){
        categoryServices.saveCategory(category);
    }

    // to get a single product
    @GetMapping("/getCategory/{id}")
    public Category getCategory(@PathVariable Long id){
        return categoryServices.getCategory(id);
    }
    // to get all products
    @GetMapping("/getCategorys")
    public List<Category> getCategorys(){
        return categoryServices.getAllCategories();
    }
    // update a product
    @PutMapping("/updateCategory")
    public void updateProduct(@RequestBody Category category){
        categoryServices.updateCategory(category);
    }

    // deleting a product
    @DeleteMapping("/deleteCategory/{id}")
    public void deleteProduct(@PathVariable Long id){
        categoryServices.deleteCategory(id);
    }
}
