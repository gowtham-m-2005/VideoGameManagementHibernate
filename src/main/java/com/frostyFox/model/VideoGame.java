package com.frostyFox.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
//@Table(name="videogame_table")
public class VideoGame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int game_id;
    private String title;
    private String genre;
//    @Column(name="platforms")
    private String platform;
    private int release_year;
    private float rating;
    private String developer;
    private String publisher;

    @Embedded
    private SystemRequirements systemRequirements;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<VideoGameReviews> reviewsList = new ArrayList<>();

    public VideoGame(String title, String genre, String platform, float rating, int release_year, String developer, String publisher, SystemRequirements systemRequirements) {
        this.genre = genre;
        this.platform = platform;
        this.rating = rating;
        this.release_year = release_year;
        this.title = title;
        this.developer = developer;
        this.publisher = publisher;
        this.systemRequirements = systemRequirements;
    }

    public VideoGame() {
    }

    public void addReview(VideoGameReviews reviews){
        reviewsList.add(reviews);
        reviews.setGame(this);
    }

    public void removeReview(VideoGameReviews reviews){
        reviewsList.remove(reviews);
        reviews.setGame(null);
    }

    public int getGame_id() {
        return game_id;
    }

    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public SystemRequirements getSystemRequirements() {
        return systemRequirements;
    }

    public void setSystemRequirements(SystemRequirements systemRequirements) {
        this.systemRequirements = systemRequirements;
    }

    public List<VideoGameReviews> getReviewsList() {
        return reviewsList;
    }

    public void setReviewsList(List<VideoGameReviews> reviewsList) {
        this.reviewsList = reviewsList;
    }

    @Override
    public String toString() {
        return "VideoGame{" +
                "developer='" + developer + '\'' +
                ", game_id=" + game_id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", platform='" + platform + '\'' +
                ", release_year=" + release_year +
                ", rating=" + rating +
                ", publisher='" + publisher + '\'' +
                ", systemRequirements=" + systemRequirements +
                ", reviewsList=" + reviewsList +
                '}';
    }
}
