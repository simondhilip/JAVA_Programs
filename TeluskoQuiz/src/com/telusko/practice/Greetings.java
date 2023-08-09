package com.telusko.practice;

public class Greetings {

    public String line = repeatChar('*', 65);
    public String padding = repeatChar(' ', 63);
    public String calign = repeatChar(' ',55);

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String SET_PLAIN_TEXT = "\033[0;0m";
    public static final String SET_BOLD_TEXT = "\033[0;1m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    public void displayWelMsg() {

        String welcomeMsg = "Welcome to the Quiz app powered by TELUSKO";

        System.out.println(calign+ANSI_YELLOW + line + ANSI_RESET);
        System.out.println(calign+ANSI_YELLOW + "*" + ANSI_RESET + padding + ANSI_YELLOW + "*" + ANSI_RESET);
        System.out.println(calign+ANSI_YELLOW + "*" + ANSI_CYAN + "          " + welcomeMsg + "           " + ANSI_YELLOW + "*" + ANSI_RESET);
        System.out.println(calign+ANSI_YELLOW + "*" + ANSI_RESET + padding + ANSI_YELLOW + "*" + ANSI_RESET);
        System.out.println(calign+ANSI_YELLOW + line + ANSI_RESET);
    }

    private String repeatChar(char c, int times) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(c);
        }
        return sb.toString();
    }


    public static String bold(String str) {
        return (SET_BOLD_TEXT + str + SET_PLAIN_TEXT);
    }


    public static void displayRules() throws InterruptedException {
        String important = ANSI_RED; // You can choose a color that represents importance
        String reset = ANSI_RESET;

        String[] rules = {
                "IMPORTANT !!! Please read the below rules carefully !!!",
                "1. You have a total of " + important + "5" + reset + " questions",
                "2. You have " + important + "15 Seconds" + reset + " to answer each question",
                "3. For each correct answer, " + important + "2" + reset + " marks will be added",
                "4. For each wrong answer, a negative of " + important + "1" + reset + " mark will be deducted"
        };

        for (String rule : rules) {
            System.out.println();
            Thread.sleep(500);
            System.out.print(rule);
        }
        System.out.println(); // Print a newline at the end
    }

    public void displayCongrats() {

        System.out.println(calign+ANSI_YELLOW + line + ANSI_RESET);
        System.out.println(calign+ANSI_YELLOW +"*"+padding+"*"+ANSI_RESET);
        System.out.println(calign+ANSI_YELLOW +"*"+ANSI_CYAN+"             Congratulations, you rocked the show!             "+ANSI_YELLOW+"*"+ANSI_RESET);
        System.out.println(calign+ANSI_YELLOW +"*"+padding+"*"+ANSI_RESET);
        System.out.println(calign+ANSI_YELLOW + line + ANSI_RESET);
    }








}
