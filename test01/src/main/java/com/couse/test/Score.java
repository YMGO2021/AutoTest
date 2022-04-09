package com.couse.test;

public class Score {
    public void getScore(int score) throws ScoreException {
        if(score < 0 || score > 100){
            throw new ScoreException("输入的分数不在0-100之间");
        }else{
            System.out.println("输入的分数正常");
        }
    }
}
