package com.dev.boot.amazonreviewsapp.service;

import com.dev.boot.amazonreviewsapp.entity.model.Review;
import java.util.List;

public interface ReviewService {

    Review add(Review review);

    List<Review> addAll(List<Review> reviews);

    List<Review> getByUser(String userId);

    List<Review> getByProduct(String productId);

    List<String> getMostActiveUsers();

    List<String> getMostPopularProducts();

    List<String> getMostPopularWordsInReviews();

}
