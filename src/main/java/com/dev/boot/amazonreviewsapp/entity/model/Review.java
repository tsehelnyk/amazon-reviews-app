package com.dev.boot.amazonreviewsapp.entity.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Email
@Table(name = "rewiews")
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
    @Column(length = 1500)
    private String text;


}
