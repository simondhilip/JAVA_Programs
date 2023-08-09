package com.telusko.practice;

import java.util.Scanner;

import static com.telusko.practice.Greetings.*;

public class QuizInitate {

    public String getName() {
        return name;
    }

    public static String name ;
    public void callQuizMaster() throws QuizException {
        try{
            Scanner sc = new Scanner(System. in );
            Greetings g = new Greetings();
            g.displayWelMsg();
            System.out.print("Hey There..! Are you a Player or Admin :: ");
            String role = sc.nextLine();
            QuestionService service = new QuestionService();


            if (role.equalsIgnoreCase("admin")) {

                System.out.println("Good Morning Mr.Admin");

                Admin admin = new Admin(5);
                admin.createQuestions();

                System.out.println("Questions created successfully!");
                System.out.print("Press ENTER your name to continue continue ::");
                name = sc.nextLine();

                Player player = new Player(name);
                System.out.println("");
                System.out.println(ANSI_CYAN + "All the best " + Greetings.bold(name) + ", Welcome to the Quiz program" + ANSI_CYAN);

                Greetings.displayRules();
                System.out.println("");

                player.playQuiz(admin.getQuestions());

            }
            else if (role.equalsIgnoreCase("player")) {
                System.out.print("Hello Greeting from " + Greetings.bold("TELUSKO") + ", Please enter your name :: ");
                name = sc.nextLine();
                System.out.println("");

                System.out.println("All the best " + ANSI_BLUE + Greetings.bold(name) + ANSI_RESET + ", Welcome to the Quiz program");
                Greetings.displayRules();
                System.out.println("");

                System.out.print(Greetings.bold("Are you ready to start the Quizz ?") + ANSI_CYAN + " (Y/N) :: " + ANSI_CYAN + ANSI_RESET);
                String state = sc.nextLine();

                if (state.equalsIgnoreCase("Y")) {
                    service.playQuiz();
                    System.out.println("Hey "+ QuizInitate.name +" You have scored " + Player.getScore());

                }
                else {
                    System.out.println("");
                    System.out.println(ANSI_RED + "Please take your time and startover !!! " + ANSI_RESET);
                    System.out.println("");

                }

            }
            else {
                System.out.println("Invalid Entry Please restart the Quiz...");
                throw new QuizException("Invalid Entry try again");
            }
        }
        catch (Exception e){
            if (e instanceof QuizException) {
                try {
                    throw e; // Re-throw the QuizException to be caught in the main method
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
            System.out.println("There is some error occured in QuestionMater");
        }
    }
}
