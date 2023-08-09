package com.telusko.practice;

import java.util.Scanner;

import static com.telusko.practice.Greetings. * ;

public class QuizMaster {

    public static void main(String[] args)  {

        try{
            QuizInitate m = new QuizInitate();
            m.callQuizMaster();
        }
        catch (QuizException e){

            try{
                QuizInitate m = new QuizInitate();
                m.callQuizMaster();
            }
            catch (Exception c){
                System.out.println("There is some issue happened initiating the quiz");
            }
        }




    }

}