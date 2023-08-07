package com.telusko.practice;

import java.util.Scanner;

public class Admin {
    private Question[] questions;

    public Admin(int numberOfQuestions) {
        questions = new Question[numberOfQuestions];
    }

    public void createQuestions() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < questions.length; i++) {
            System.out.print("Enter the question text: ");
            String questionText = sc.nextLine();
            System.out.print("Enter option 1: ");
            String opt1 = sc.nextLine();
            System.out.print("Enter option 2: ");
            String opt2 = sc.nextLine();
            System.out.print("Enter option 3: ");
            String opt3 = sc.nextLine();
            System.out.print("Enter option 4: ");
            String opt4 = sc.nextLine();
            System.out.print("Enter the correct answer: ");
            String answer = sc.nextLine();
            questions[i] = new Question(i + 1, questionText, opt1, opt2, opt3, opt4, answer);
        }
    }

    public Question[] getQuestions() {
        return questions;
    }
}
