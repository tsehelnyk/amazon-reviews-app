package com.dev.boot.amazonreviewsapp.repository;

import com.dev.boot.amazonreviewsapp.entity.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
