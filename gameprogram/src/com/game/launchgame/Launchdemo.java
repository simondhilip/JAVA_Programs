package com.game.launchgame;


import java.util.Scanner;

public class Launchdemo {

    public static void main(String[] args) {

        /*Player g = new Player();
        System.out.println(g.playerGuessingNumber(1));*/

        ExecuteGame e= new ExecuteGame();
        e.executetheGame();



    }


}

class Guesser {
    int guessNumber;
    int guessingNumber(){
        Scanner g = new Scanner(System.in);
        System.out.print("Hey Guesser !!! Enter the number :: " );
        guessNumber = g.nextInt();
        return guessNumber;
    }
}

class Player {
    int playerGuessNumber;
    int playerGuessingNumber(int PlayerNo){
        Scanner g = new Scanner(System.in);
        System.out.print("Player " + PlayerNo + " Enter the Guessed number :: " );
        playerGuessNumber = g.nextInt();
        return playerGuessNumber;
    }
}

class Umpire{
    int numFromGuesser;
    int numFromPlayer1;
    int numFromPlayer2;
    int numFromPlayer3;

    void getGuessNumber(){
        Guesser g = new Guesser();
        numFromGuesser = g.guessingNumber();
    }

    void getPlayersNumber(){
        Player p1= new Player();
        numFromPlayer1=p1.playerGuessingNumber(1);

        Player p2= new Player();
        numFromPlayer2=p2.playerGuessingNumber(2);

        Player p3= new Player();
        numFromPlayer3=p3.playerGuessingNumber(3);
    }
    void announcerWinner(){

        if(numFromGuesser==numFromPlayer1){
            if (numFromGuesser==numFromPlayer2 && numFromGuesser==numFromPlayer3){
                System.out.println("All Players won the Game");
            }
            else {
                System.out.println("Player 1 won the Game");

            }
        }
        else if(numFromGuesser==numFromPlayer2){
            if (numFromGuesser==numFromPlayer3){
                System.out.println("Player 2 and 3 won the Game");
            }
            else {
                System.out.println("Player 2 won the Game");
            }
        }
        else if(numFromGuesser==numFromPlayer3){
            if (numFromGuesser==numFromPlayer1){
                System.out.println("Player 1 and Player 2 won the Game");
            }
            else{
                System.out.println("Player 3 won the Game");

            }
        }
        else {
            System.out.println("Game Over, No-One win the Game.");
        }
    }



}


class ExecuteGame{

    void executetheGame(){
        Umpire u = new Umpire();
        u.getGuessNumber();
        u.getPlayersNumber();
        u.announcerWinner();

    }

}