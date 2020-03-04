package com.dev.boot.amazonreviewsapp.service.impl;

import com.dev.boot.amazonreviewsapp.entity.model.Review;
import com.dev.boot.amazonreviewsapp.repository.ReviewRepository;
import com.dev.boot.amazonreviewsapp.service.ReviewService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public Review add(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getByUser(String userId) {
        return reviewRepository.findAll();
    }

    @Override
    public List<Review> getByProduct(String productId) {
        return reviewRepository.findAll();
    }

    @Override
    public List<String> getMostActiveUsers() {
        return null;
    }

    @Override
    public List<String> getMostPopularProducts() {
        return null;
    }

    @Override
    public List<String> getMostPopularWordsInReviews() {
        return null;
    }
}
