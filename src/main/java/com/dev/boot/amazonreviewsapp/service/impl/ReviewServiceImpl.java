package com.dev.boot.amazonreviewsapp.service.impl;

import com.dev.boot.amazonreviewsapp.entity.model.Review;
import com.dev.boot.amazonreviewsapp.repository.ReviewRepository;
import com.dev.boot.amazonreviewsapp.service.ReviewService;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public List<Review> addAll(List<Review> reviews) {
        return reviewRepository.saveAll(reviews);
    }

    @Override
    public Set<String> getMostActiveUsers() {
        return reviewRepository.getMostActiveUsers();
    }

    @Override
    public Set<String> getMostPopularProducts() {
        return reviewRepository.getMostPopularProducts();
    }

    @Override
    public Set<String> getMostPopularWordsInReviews() {
        Map<String, Integer> words = reviewRepository.getReviewsText()
                .stream()
                .flatMap(text -> Arrays.stream(text.replaceAll("[^a-zA-Z\\s]", "").split(" ")))
                .collect(Collectors.toMap(k -> k, k -> 1, (a, b) -> a + b, HashMap::new));

        return words.values()
                .stream()
                .distinct()
                .flatMap(val -> getKeys(words, val).stream())
                .limit(1000)
                .collect(Collectors.toSet());
    }

    private <K, V> Set<K> getKeys(Map<K, V> map, V value) {
        Set<K> keys = new HashSet<>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                keys.add(entry.getKey());
            }
        }
        return keys;
    }

}
