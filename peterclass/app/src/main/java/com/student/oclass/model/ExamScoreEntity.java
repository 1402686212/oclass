package com.student.oclass.model;

/**
 * 分数列表的数据结构
 * @author huangyebiaoke
 * @email huangyebiaoke@outlook.com
 */
public class ExamScoreEntity {
    private String title;
    private String time;
    private int score;

    public ExamScoreEntity(String title, String time, int score) {
        this.title = title;
        this.time = time;
        this.score = score;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
