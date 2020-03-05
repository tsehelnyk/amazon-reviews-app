package com.dev.boot.amazonreviewsapp.controller;

import com.dev.boot.amazonreviewsapp.entity.model.Review;
import com.dev.boot.amazonreviewsapp.service.ReviewService;
import com.dev.boot.amazonreviewsapp.util.CsvToObjectConverter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/data")
public class DataController {
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private CsvToObjectConverter csvToObjectConverter;

    @GetMapping("/add")
    public void LoadDataFromFile() {
        // call parser
        reviewService.add();
    }

    @GetMapping("/get")
    public List<Review> getReviews() {
        return null;
    }
}
