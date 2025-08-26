    package com.frostyFox.controller;

    import com.frostyFox.model.*;
    import org.hibernate.SessionFactory;
    import org.hibernate.cfg.Configuration;

    import java.util.Scanner;

    public class Main {
        private final InputController inputController = new InputController();
        private final  GenericDAO<VideoGame> videoGameDAO = new GenericDAO<>();
        private final  GenericDAO<VideoGamePrice> videoGamePriceDAO = new GenericDAO<>();
        private final GenericDAO<VideoGameReviews> videoGameReviewsDAO = new GenericDAO<>();

        public static void main(String[] args) {
            Main app = new Main();
            app.run();              // delegate to instance method
        }

        private void run() {
            SessionFactory sf = new Configuration()
                    .addAnnotatedClass(VideoGame.class)
                    .addAnnotatedClass(SystemRequirements.class)
                    .addAnnotatedClass(VideoGamePrice.class)
                    .addAnnotatedClass(VideoGameReviews.class)
                    .addAnnotatedClass(Reviewer.class)
                    .configure()
                    .buildSessionFactory();

            Scanner scanner = new Scanner(System.in);

            System.out.println("Choose an option to enter details");
            System.out.println("1.VideoGame Details");
            System.out.println("2.VideoGame Price Details");
            System.out.println("3.VideoGame Review Details");
            System.out.println("4.VideoGame Reviewer Details");

            System.out.println("Enter the choice");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    addVideoGame(sf);
                    break;
                }
                case 2 -> {
                    System.out.println("\nEnter Game Id :");
                    int gameId = scanner.nextInt();
                    scanner.nextLine();
                    addVideoGamePrice(sf,gameId);
                    break;
                }
                case 3 -> {
                    System.out.println("\nEnter Game Id :");
                    int gameId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter Reviewer Id : ");
                    int reviewerId = scanner.nextInt();
                    scanner.nextLine();

                    addVideoGameReviews(sf, gameId, reviewerId);
                    break;
                }
                case 4 -> {
                    addReviewer(sf);
                }
                default -> System.out.println("Invalid choice");
            }
        }

        private void addReviewer(SessionFactory sf) {
            GenericDAO<Reviewer> reviewerDAO = new GenericDAO<>();
            Reviewer reviewer = inputController.getReviewerFromInput();
            reviewerDAO.save(sf, reviewer);
        }

        private void addVideoGameReviews(SessionFactory sf, int gameId, int reviewerId) {
            Reviewer reviewer = findReviewer(sf, gameId);
            VideoGame game = findVideoGame(sf, gameId);
            VideoGameReviews review = inputController.getVideoGameReviewFromInput(game, reviewer);
            videoGameReviewsDAO.save(sf, review);
        }

        private void addVideoGame(SessionFactory sf) {
            VideoGame game = inputController.getVideoGameFromInput();
            videoGameDAO.save(sf, game);
            System.out.println("Game created: " + game);
        }

        public VideoGame findVideoGame(SessionFactory sf, int index){
            return videoGameDAO.find(sf, VideoGame.class, index);
        }

        public Reviewer findReviewer(SessionFactory sf, int id){
            GenericDAO<Reviewer>reviewerDAO = new GenericDAO<>();
            return reviewerDAO.find(sf, Reviewer.class, id);
        }

        private void addVideoGamePrice(SessionFactory sf, int gameId){
            VideoGame game = findVideoGame(sf, gameId);
            VideoGamePrice videoGamePrice = inputController.getVideoGamePriceFromInput(game);
            videoGamePriceDAO.save(sf, videoGamePrice);
        }
    }
