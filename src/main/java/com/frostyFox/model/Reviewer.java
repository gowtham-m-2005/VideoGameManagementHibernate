package com.frostyFox.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Reviewer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewer_id;
    private String displayName;
    private String email;
    private int total_reviews;
    private Date joinedDate;


    @OneToMany(mappedBy = "reviewer_obj", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<VideoGameReviews> reviews;

    public Reviewer(String displayName, String email, int total_reviews){
        this.displayName = displayName;
        this.email = email;
        this.total_reviews = total_reviews;
        this.joinedDate = new Date();
    }

    public Reviewer() {
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getReviewer_id() {
        return reviewer_id;
    }

    public void setReviewer_id(int reviewer_id) {
        this.reviewer_id = reviewer_id;
    }

    public List<VideoGameReviews> getReviews() {
        return reviews;
    }

    public void setReviews(List<VideoGameReviews> reviews) {
        this.reviews = reviews;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public int getTotal_reviews() {
        return total_reviews;
    }

    public void setTotal_reviews(int total_reviews) {
        this.total_reviews = total_reviews;
    }
}
