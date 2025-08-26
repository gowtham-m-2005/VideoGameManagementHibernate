package com.frostyFox.controller;

import com.frostyFox.model.*;

import java.util.Scanner;

public class InputController {
    private final InputHelper inputHelper = new InputHelper();
    private final GenericDAO<VideoGamePrice> videoGamePriceDAO = new GenericDAO<>();

    public VideoGame getVideoGameFromInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter VideoGame Details : \n");
        return new VideoGame(
            inputHelper.getString("Title : "),
            inputHelper.getString("Genre : "),
            inputHelper.getString("Platform : "),
            inputHelper.getFloat("Rating : "),
            inputHelper.getInt("Release Year : "),
            inputHelper.getString("Developer : "),
            inputHelper.getString("Publisher : "),
                getSystemRequirementsFromInput()
        );
    }


    public SystemRequirements getSystemRequirementsFromInput() {
        System.out.println("\nEnter System Requirements\n");

        return new SystemRequirements(
                inputHelper.getString("OS : "),
                inputHelper.getBoolean("Multiplayer Supported : "),
                inputHelper.getInt("Minimum Storage : "),
                inputHelper.getInt("Minimum Memory : "),
                inputHelper.getString("Graphics : ")
        );
    }

    public VideoGamePrice getVideoGamePriceFromInput(VideoGame game){
        System.out.println("\nEnter VideoGame Price Details ");

        return new VideoGamePrice(
                inputHelper.getString("Edition : "),
                inputHelper.getFloat("Base Price : "),
                inputHelper.getFloat("Discount : "),
                inputHelper.getString("Currency"),
                game
        );
    }

    public VideoGameReviews getVideoGameReviewFromInput(VideoGame game, Reviewer reviewer){
        System.out.println("\nEnter VideoGame Review Details : ");

        VideoGameReviews videoGameReviews = new VideoGameReviews(
                inputHelper.getFloat("Enter Rating : "),
                inputHelper.getString("Enter Comment : ")
        );

        videoGameReviews.setGame(game);
        videoGameReviews.setReviewer_obj(reviewer);

        return  videoGameReviews;
    }

    public Reviewer getReviewerFromInput(){
        System.out.println("\nEnter Reviewer Details : ");

        return new Reviewer(
                inputHelper.getString("Name : "),
                inputHelper.getString("Email : "),
                inputHelper.getInt("Total Reviews")
        );
    }
}
