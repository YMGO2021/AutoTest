package com.couse.test;

import java.util.Scanner;

public class ScoreDemo {
    public static void main(String[] args) throws ScoreException {
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();
        Score scoreP = new Score();
        scoreP.getScore(score);
    }
}
