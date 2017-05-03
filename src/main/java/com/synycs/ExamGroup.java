package com.synycs;

import javaslang.Tuple2;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by synycs on 2/5/17.
 */
public class ExamGroup {
    private int examGroupId;
    private String examGroupName;
    private double mean;

    public ExamGroup(Tuple2<Integer,String> tuple2, List<Exam> exams){
        this.examGroupId=tuple2._1;
        this.examGroupName=tuple2._2;
        this.mean=exams.stream().mapToDouble(Exam::getMark).
                reduce((a,b)->a+b).getAsDouble();
    }
    public String getExamGroupName() {
        return examGroupName;
    }

    public void setExamGroupName(String examGroupName) {
        this.examGroupName = examGroupName;
    }

    public int getExamGroupId() {
        return examGroupId;
    }

    public void setExamGroupId(int examGroupId) {
        this.examGroupId = examGroupId;
    }

    public double getMean() {
        return mean;
    }

    public void setMean(double mean) {
        this.mean = mean;
    }


}
