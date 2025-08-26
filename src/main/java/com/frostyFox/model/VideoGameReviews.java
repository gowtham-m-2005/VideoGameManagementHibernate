package com.frostyFox.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class VideoGameReviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewId;
    private float rating;
    private String comment;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "game_id" )
    private VideoGame game;

    @ManyToOne
    @JoinColumn(name = "reviewer_id")
    private Reviewer reviewer_obj;

    public VideoGameReviews(float rating, String comment){
        this.rating = rating;
        this.comment = comment;
        this.date = new Date();
    }

    public VideoGameReviews(){

    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public VideoGame getGame() {
        return game;
    }

    public void setGame(VideoGame game) {
        this.game = game;
    }

    public Reviewer getReviewer_obj() {
        return reviewer_obj;
    }

    public void setReviewer_obj(Reviewer reviewer_obj) {
        this.reviewer_obj = reviewer_obj;
    }

    @Override
    public String toString() {
        return "VideoGameReviews{" +
                "comment='" + comment + '\'' +
                ", reviewId=" + reviewId +
                ", rating=" + rating +
                ", date=" + date +
                ", game=" + game +
                ", reviewer_obj=" + reviewer_obj +
                '}';
    }
}
