package com.dev.boot.amazonreviewsapp.repository;

import com.dev.boot.amazonreviewsapp.entity.model.Review;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query(value = "SELECT PROFILE_NAME FROM " +
            "(SELECT PROFILE_NAME, COUNT(PROFILE_NAME) AS F FROM REVIEWS " +
            "GROUP BY PROFILE_NAME ORDER BY F DESC " +
            "LIMIT 1000) ", nativeQuery = true)
    Set<String> getMostActiveUsers();

    @Query(value = "SELECT PRODUCT_ID FROM " +
            "(SELECT PRODUCT_ID, COUNT(PRODUCT_ID) AS F FROM REVIEWS " +
            "GROUP BY PRODUCT_ID ORDER BY F DESC " +
            "LIMIT 1000) ", nativeQuery = true)
    Set<String> getMostPopularProducts();

    @Query(value = "SELECT TEXT FROM REVIEWS", nativeQuery = true)
    List<String> getReviewsText();
}
