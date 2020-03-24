package com.dev.boot.amazonreviewsapp.entity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productId;
    private String userId;
    private String profileName;
    private int helpfulnessNominator;
    private int helpfulnessDenominator;
    private int score;
    private Long time;
    @Column(length = 250)
    private String summary;
    @Column(columnDefinition = "TEXT")
    private String text;


}
