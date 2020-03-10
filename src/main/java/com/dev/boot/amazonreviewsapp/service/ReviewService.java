package com.dev.boot.amazonreviewsapp.service;

import com.dev.boot.amazonreviewsapp.entity.model.Review;
import java.util.List;
import java.util.Set;

public interface ReviewService {

    List<Review> addAll(List<Review> reviews);

    Set<String> getMostActiveUsers();

    Set<String> getMostPopularProducts();

    Set<String> getMostPopularWordsInReviews();

}
