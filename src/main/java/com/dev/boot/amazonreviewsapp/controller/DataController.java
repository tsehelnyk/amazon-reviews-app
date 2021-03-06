package com.dev.boot.amazonreviewsapp.controller;

import com.dev.boot.amazonreviewsapp.entity.model.Review;
import com.dev.boot.amazonreviewsapp.service.ReviewService;
import com.dev.boot.amazonreviewsapp.util.CsvToObjectsListConverter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/data")
public class DataController {
    private static final String FILE_PATH = "src/main/resources/tables/Reviews2.csv";

    @Autowired
    private ReviewService reviewService;
    @Autowired
    private CsvToObjectsListConverter csvToObjectsListConverter;

    @GetMapping("/add-from-csv")
    public String loadDataFromFile() throws IOException {
        LocalTime start = LocalTime.now();
        List<Review> reviews = csvToObjectsListConverter.convert(FILE_PATH);
        reviewService.addAll(reviews);
        System.out.println(Duration.between(start, LocalTime.now()));
        return "done";
    }

    @GetMapping("/get-users-top")
    public Set<String> getUsersTop() {
        return reviewService.getMostActiveUsers();
    }

    @GetMapping("/get-items-top")
    public Set<String> getItemsTop() {
        return reviewService.getMostPopularProducts();
    }

    @GetMapping("/get-words-top")
    public Set<String> getWordsTop() {
        return reviewService.getMostPopularWordsInReviews();
    }
}
