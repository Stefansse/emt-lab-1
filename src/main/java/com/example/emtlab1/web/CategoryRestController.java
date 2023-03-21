package com.example.emtlab1.web;


import com.example.emtlab1.model.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryRestController {

    @GetMapping
    public List<Category> getCategories() {
        return new ArrayList<>(EnumSet.allOf(Category.class));
    }
}
