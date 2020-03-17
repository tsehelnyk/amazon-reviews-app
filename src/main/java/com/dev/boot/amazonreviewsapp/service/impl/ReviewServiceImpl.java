package com.dev.boot.amazonreviewsapp.service.impl;

import com.dev.boot.amazonreviewsapp.entity.model.Review;
import com.dev.boot.amazonreviewsapp.repository.ReviewRepository;
import com.dev.boot.amazonreviewsapp.service.ReviewService;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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
        List<String> w = reviewRepository.getReviewsText();
        Map<String, Integer> words = w
                .stream()
                .flatMap(text -> Arrays.stream(text.replaceAll("[^a-zA-Z\\s]", "").split(" ")))
                .filter(word -> !word.equals(""))
                .collect(Collectors.toMap(k -> k, k -> 1, (a, b) -> a + b, HashMap::new));

        Set<Integer> values = words.values()
                .stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toCollection(LinkedHashSet::new));

        return values
                .stream()
                .flatMap(val -> getKeys(words, val).stream())
                .limit(1000)
                .collect(Collectors.toCollection(LinkedHashSet::new));
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
