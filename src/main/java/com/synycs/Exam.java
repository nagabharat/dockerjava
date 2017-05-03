package com.synycs;

/**
 * Created by synycs on 2/5/17.
 */
public class Exam {
    private int studentId;
    private int subjectId;
    private int examGroupId;
    private String examGroupName;
    private double mark;

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getExamGroupId() {
        return examGroupId;
    }

    public void setExamGroupId(int examGroupId) {
        this.examGroupId = examGroupId;
    }

    public String getExamGroupName() {
        return examGroupName;
    }

    public void setExamGroupName(String examGroupName) {
        this.examGroupName = examGroupName;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }
}
