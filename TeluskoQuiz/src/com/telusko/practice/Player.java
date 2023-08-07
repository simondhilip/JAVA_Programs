package com.telusko.practice;

import java.util.Scanner;

public class Player {
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public void playQuiz(Question[] questions) throws InterruptedException {
        QuestionService service = (questions != null && questions.length > 0) ? new QuestionService(questions) : new QuestionService();
        System.out.println("All the best " + name + ", Welcome to the Quiz program");
        // You can call a method to display rules here if needed
        System.out.println("");
        System.out.print("Are you ready to start the Quiz? (Y/N) :: ");
        Scanner sc = new Scanner(System.in);
        String state = sc.nextLine();
        if (state.equalsIgnoreCase("Y")) {
            service.playQuiz();
        } else {
            System.out.println("");
            System.out.println("Please take your time and start over !!! ");
            System.out.println("");
        }
    }
}
