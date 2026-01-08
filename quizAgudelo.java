/*
Name: Nicholas Agudelo
Date: April 21, 2023
Description: This program makes a fully computized exam based on arrays, loops, and inputs
*/

import java.util.Scanner;
import java.lang.Math;

public class quizAgudelo {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        Scanner kb = new Scanner(System.in);

        int num1 = 0;
        int num2 = 0;
        char[] equa = {'+', '-', '*', '/'};

        int[] score = new int[5]; // CREATE ONCE

        for (int i = 0; i < 5; i++) {
            answers(num1, num2, equa, i, kb, score);
        }

        // Add up score
        int total = 0;
        for (int i = 0; i < score.length; i++) {
            total += score[i];
        }

        System.out.println("Final score: " + total);
    }

    public static void answers(int num1, int num2, char[] equa,
                               int i, Scanner kb, int[] score) {

        num1 = (int) (Math.random() * 10) + 1;
        num2 = (int) (Math.random() * 10) + 1;
        char operator = equa[(int) (Math.random() * equa.length)];

        int correctAnswer = 0;

        switch (operator) {
            case '+':
                correctAnswer = num1 + num2;
                break;
            case '-':
                correctAnswer = num1 - num2;
                break;
            case '*':
                correctAnswer = num1 * num2;
                break;
            case '/':
                correctAnswer = num1 / num2;
                break;
        }

        System.out.print(num1 + " " + operator + " " + num2 + " = ");
        int userAnswer = kb.nextInt();

        if (userAnswer == correctAnswer) {
            int points = (int)(Math.random()*50) + 1;
            score[i] = points;
            System.out.println("Correct! You got " + points + " points!");
        } else {
            score[i] = 0;
            System.out.println("Wrong! Correct answer is " + correctAnswer + " >:p");
        }
    }
}
