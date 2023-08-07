package com.telusko.practice;

import java.util.Scanner;

public class QuestionService {

    Question[] questions;
    String[] selection;
    int score = 0;

    public QuestionService() {
        initializeDefaultQuestions();
    }

    public QuestionService(Question[] customQuestions) {
        questions = customQuestions;
        selection = new String[questions.length];
    }

    private void initializeDefaultQuestions() {
        questions = new Question[5];
        selection = new String[5];
        questions[0] = new Question(1, "size of int", "2", "6", "4", "8", "4");
        questions[1] = new Question(2, "size of double", "2", "6", "4", "8", "8");
        questions[2] = new Question(3, "size of char", "2", "6", "4", "8", "2");
        questions[3] = new Question(4, "size of long", "2", "6", "4", "8", "8");
        questions[4] = new Question(5, "size of boolean", "1", "2", "4", "8", "1");
    }

    public void playQuiz() throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < questions.length; i++) {
            Question q = questions[i];
            int qno = i+1;
            System.out.println(Utilitytext.bold("Question") + " " + Utilitytext.bold(Integer.toString(qno)) + " : " + Utilitytext.bold(q.question()));
            Thread.sleep(2000);
            System.out.println("1. " + q.opt1());
            Thread.sleep(1000);
            System.out.println("2. " + q.opt2());
            Thread.sleep(1000);
            System.out.println("3. " + q.opt3());
            Thread.sleep(1000);
            System.out.println("4. " + q.opt4());
            Thread.sleep(1000);

            System.out.print("Please enter your answer: ");
            selection[i] = sc.nextLine().trim();

            calculateScore(i);

            if (score == 10) {
                System.out.println("\n**********************************************");
                System.out.println("*                                            *");
                System.out.println("*   Congratulations, you rocked the show!    *");
                System.out.println("*                                            *");
                System.out.println("**********************************************\n");
            }
        }
    }

    public void calculateScore(int questionIndex) throws InterruptedException {
        Question q = questions[questionIndex];
        String answer = q.answer();
        String selAnswer = selection[questionIndex];

        if (answer.equals(selAnswer)) {
            score = score + 2;
            System.out.println("Correct answer! Adding points.");
        } else {
            score = score - 1;
            System.out.println("Sorry, wrong answer. Deducting points.");
        }

        System.out.println("Score after question " + (questionIndex + 1) + " : " + score);
        Thread.sleep(1000);
    }
}
