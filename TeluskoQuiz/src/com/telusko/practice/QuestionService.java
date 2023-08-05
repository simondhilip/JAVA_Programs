package com.telusko.practice;

import java.util.Scanner;
import java.util.concurrent.*;

public class QuestionService {

    Question[] questions = new Question[5];
    String selection[] = new String[5];

    public QuestionService()
    {
        questions[0] = new Question(1, "size of int", "2", "6", "4", "8", "4");
        questions[1] = new Question(2, "size of double", "2", "6", "4", "8", "8");
        questions[2] = new Question(3, "size of char", "2", "6", "4", "8", "2");
        questions[3] = new Question(4, "size of long", "2", "6", "4", "8", "8");
        questions[4] = new Question(5, "size of boolean", "1", "2", "4", "8", "1");
    }

    public void displayQuestions()
    {
        for(Question question : questions) {
            System.out.println(question.toString());
        }
    }

    public void playQuiz()
    {
        for(int i=0; i<questions.length; i++){
            Question q = questions[i];
            System.out.println("Question " + (i+1) + " : " + q.question());

            System.out.println("1. " +q.opt1());
            System.out.println("2. " +q.opt2());
            System.out.println("3. " +q.opt3());
            System.out.println("4. " +q.opt4());

            ExecutorService executor = Executors.newSingleThreadExecutor();
            Future<String> future = executor.submit(new Callable<String>() {
                public String call() {
                    Scanner sc = new Scanner(System.in);
                    return sc.nextLine().trim();
                }
            });

            // Display the remaining time
            Thread timerThread = new Thread(new Runnable() {
                public void run() {
                    try {
                        for (int j = 15; j >= 0; j--) {
                            System.out.print("\rRemaining time: " + j + " seconds");
                            Thread.sleep(1000);
                        }
                    } catch (InterruptedException e) {
                        // The thread was interrupted, which means the user has entered an answer
                    }
                }
            });

            timerThread.start();

            try {
                selection[i] = future.get(15, TimeUnit.SECONDS);
                // If the user has entered an answer, interrupt the timer thread
                timerThread.interrupt();
            } catch (TimeoutException e) {
                System.out.println("\nTimeout! Moving to the next question.");
                selection[i] = "";  // if no answer is provided within the time limit, save it as an empty string
            } catch (Exception e) {
                e.printStackTrace();
            }

            executor.shutdownNow();

            calculateScore(i);
        }
    }

    public void calculateScore(int questionIndex){
        int score=0;

        for(int i=0; i<=questionIndex; i++){
            Question q = questions[i];
            String answer = q.answer();
            String selAnswer = selection[i];

            if(answer.equals(selAnswer)){
                score = score +2;
            }
            else {
                score = score-1;
            }
        }

        Question q = questions[questionIndex];
        String answer = q.answer();
        String selAnswer = selection[questionIndex];

        if(answer.equals(selAnswer)){
            System.out.println("Correct answer! Adding points.");
        }
        else {
            System.out.println("Sorry, wrong answer. Deducting points.");
        }

        System.out.println("Score after question " + (questionIndex+1) + " : " + score);
    }

}
