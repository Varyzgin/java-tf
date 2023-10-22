package edu.project1;

import java.util.Arrays;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Hangman {
    private final static Logger LOGGER = LogManager.getLogger();

    public static void run(String[] args) {
        String[] dictionary = new String[]{"ok", "hello", "goodbye", "thanks"};

        LOGGER.trace("Welcome to the club, buddy!");
        char[] answer = dictionary[(int) (Math.random() * dictionary.length)].toCharArray();
        int maxAttempts = 5;
        int mistakes = 0;
        int unkonownLetters = answer.length;
        char[] answerUser = new char[answer.length];
        Arrays.fill(answerUser, '*');

        boolean run = true;
        while (unkonownLetters > 0 && mistakes < maxAttempts && run) {
            LOGGER.trace("Guess a letter:");

            char c = '1';
            boolean correctInput = false;
            Scanner scanner = new Scanner(System.in);

            while (!correctInput) {
                String s = scanner.next();
                if (s.equals("exit")) {
                    run = false;
                    break;
                }
                if (s.length() == 1) {
                    c = s.charAt(0);
                    if (!Character.isDigit(c)) {
                        correctInput = true;
                    }
                }
            }
            if (!run) {
                break;
            }
            boolean cExists = false;
            for (int i = 0; i < answer.length; i++) {
                if (c == answer[i]) {
                    cExists = true;
                    unkonownLetters--;
                    answerUser[i] = c;
                }
            }
            if (!cExists) {
                mistakes++;
                LOGGER.trace("Missed, mistake {} out of {}.", mistakes, maxAttempts);
            } else {
                LOGGER.trace("Hit!");
            }
            String s = "The word: ";
            for (int i = 0; i < answerUser.length; i++) {
                s += answerUser[i];
            }
            s += "\n";
            LOGGER.trace(s);
        }
        if (mistakes == maxAttempts) {
            LOGGER.trace("Have a nice dead!");
        }
        if (unkonownLetters == 0) {
            LOGGER.trace("Ok, you can live while it possible");
        }
    }
}
