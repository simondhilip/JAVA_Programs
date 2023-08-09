package com.telusko.practice;

import java.sql.SQLOutput;
import java.util.Scanner;

import static com.telusko.practice.Greetings.*;

public class QuestionService {

    Question[] questions;
    String[] selection;

    public int getScore() {
        return score;
    }

    public static int score ;

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
        questions[0] = new Question(1, "Which of the following is true about the final keyword in Java ?", "A final class cannot be subclassed.", "A final method cannot be overridden.", "A final variable cannot be reassigned.", "All of the above.", "d");
        questions[1] = new Question(2, "Which method must be implemented by a class implementing the Runnable interface?", "run()", "start()", "stop()", "init()", "a");
        questions[2] = new Question(3, "What is the base class of all exceptions in Java?", "Throwable", "Exception", "Error", "RuntimeException", "a");
        questions[3] = new Question(4, "What is the default value of a boolean variable in a class in Java?","false","true","null","0","a");
        questions[4] = new Question(5, "What is the result of the following code snippet?\n" +
                "\n|---------------------------|\n"+
                "| int a = 5;                |\n" +
                "| int b = 10;               |\n" +
                "| a = b = b / a;            |\n" +
                "| System.out.println(b);    |\n"+
                "|---------------------------|", "10", "5", "2", "0", "c");
    }

    public void playQuiz() throws QuizException {
        try{

            Scanner sc = new Scanner(System.in);

            for (int i = 0; i < questions.length; i++) {
                Question q = questions[i];
                int qno = i+1;
                System.out.println(Greetings.bold("Question") + " " + Greetings.bold(Integer.toString(qno)) + " : " + Greetings.bold(q.question()));
                Thread.sleep(2000);
                System.out.println("a) " + q.opt1());
                Thread.sleep(1000);
                System.out.println("b) " + q.opt2());
                Thread.sleep(1000);
                System.out.println("c) " + q.opt3());
                Thread.sleep(1000);
                System.out.println("d) " + q.opt4());
                Thread.sleep(1000);


                System.out.print("Please enter your answer: ");
                selection[i] = sc.nextLine().trim();

                if (!selection[i].toLowerCase().matches("[a-d]")) {
                    System.out.println("Invalid answer selection. Please choose between a, b, c, or d.");
                    System.out.print("Please enter your answer: ");
                    selection[i] = sc.nextLine().trim();
                    if (!selection[i].matches("[a-d]")){
                        System.out.println("");
                        System.out.println(ANSI_RED+" INVALID OPTION - negative mark initiated"+ANSI_RESET);
                        System.out.println("");
                    }

                }

                calculateScore(i);

                if (score == 10) {
                    Greetings g = new Greetings();
                    g.displayCongrats();
                }

            }
        }
        catch (Exception e){
            System.out.println("Error playing playQuiz");
        }
    }

    public void calculateScore(int questionIndex)  {
        try{
            Question q = questions[questionIndex];
            String answer = q.answer();
            String selAnswer = selection[questionIndex];

            if (answer.equalsIgnoreCase(selAnswer)) {
                score = score + 2;
                System.out.println("");
                System.out.println("---------------------------------------------------");
                System.out.println(ANSI_GREEN+"Correct answer! Adding points."+ANSI_RESET);
            } else {
                score = score - 1;
                System.out.println("");
                System.out.println("---------------------------------------------------");
                System.out.println(ANSI_RED+"Sorry, wrong answer. Deducting points."+ANSI_RESET);
                System.out.println("The correct answer is :: " +ANSI_GREEN+answer +ANSI_RESET);
            }

            System.out.println("Score after question " + (questionIndex + 1) + " : " + score);
            System.out.println("---------------------------------------------------");
            System.out.println("");
            Thread.sleep(1000);
        }
        catch (Exception e){
            System.out.println("Issue in calculating score");
        }
    }
}
