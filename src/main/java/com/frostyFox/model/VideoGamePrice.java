package com.frostyFox.model;

import jakarta.persistence.*;

@Entity
public class VideoGamePrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    private String edition;
    private float basePrice;
    private float discount;
    private String currency;

    @OneToOne
    @MapsId
    @JoinColumn(name = "game_id")
    private VideoGame videoGame;

    public VideoGamePrice(String edition, float basePrice, float discount, String currency, VideoGame videoGame){
        this.edition = edition;
        this.basePrice = basePrice;
        this.discount = discount;
        this.currency = currency;
        this.videoGame = videoGame;
    }

    public VideoGamePrice(){

    }

    public float getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(float basePrice) {
        this.basePrice = basePrice;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }


    public VideoGame getVideoGame() {
        return videoGame;
    }

    public void setVideoGame(VideoGame videoGame) {
        this.videoGame = videoGame;
    }

    @Override
    public String toString() {
        return "VideoGamePrice{" +
                "basePrice=" + basePrice +
                ", edition='" + edition + '\'' +
                ", discount=" + discount +
                ", currency='" + currency + '\'' +
                ", videoGame=" + videoGame +
                '}';
    }
}
