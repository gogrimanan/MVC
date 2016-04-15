package com.example.vinit.mvc;

/**
 * Created by Vinit on 3/13/2016.
 */
public class Question {
    int questionId;
    boolean ans;

    public Question(int questionId, boolean ans) {
        this.questionId = questionId;
        this.ans = ans;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public boolean getAns() {
        return ans;
    }

    public void setAns(boolean ans) {
        this.ans = ans;
    }
}
