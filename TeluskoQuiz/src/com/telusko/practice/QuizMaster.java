package com.telusko.practice;


import java.util.Scanner;


public class QuizMaster {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        displayMessage();
        System.out.print("Hey There..! Are you a Player or Admin :: ");
        String role = sc.nextLine();
        QuestionService service = new QuestionService();



        if (role.equalsIgnoreCase("admin")) {

            System.out.println("Good Morning Mr.Admin");

        }
        else if (role.equalsIgnoreCase("player")) {
            System.out.print("Hello Greeting from Telusko, Please enter your name :: ");
            String name = sc.nextLine();
            System.out.println("");
            System.out.println("All the best " + Utilitytext.bold(name) + ", Welocme to the Quiz program");
            displayRules();
            System.out.println("");
            System.out.print(Utilitytext.bold("Are you ready to start the Quizz ?") +" (Y/N) :: ");
            String state = sc.nextLine();
            if(state.equalsIgnoreCase("Y")){
                service.playQuiz();

            }
            else {
                System.out.println("");
                System.out.println("Please take your time and startover !!! ");
                System.out.println("");

            }



        }
        else {
            System.out.println("Invalid Entry Please restart the Quiz...");
        }



    }

    public static void displayMessage(){
        System.out.println("*****************************************************************");
        System.out.println("*****************************************************************");
        System.out.println("Welcome to the Quiz app powered by TELUSKO");
        System.out.println("*****************************************************************");
        System.out.println("*****************************************************************");
    }

    public static  void displayRules(){
        System.out.println(" ");
        System.out.print(" IMPORTANT !!! Please read the below rules carefully !!! ");
        System.out.println(" ");
        System.out.println("1. You have total of "+Utilitytext.bold("5")+" questions");
        System.out.println("2. You have"+ Utilitytext.bold("15 Seconds ") +"to answer each question");
        System.out.println("3. For each correct answer " + Utilitytext.bold("2")+" marks will be added");
        System.out.println("4. For each wrong answer negative of "+Utilitytext.bold("1")+" mark will be deducted");

    }


}

class Utilitytext {
    public static final String SET_PLAIN_TEXT = "\033[0;0m";
    public static final String SET_BOLD_TEXT = "\033[0;1m";


    public static String bold(String str) {
        return (SET_BOLD_TEXT + str + SET_PLAIN_TEXT);
    }
}


