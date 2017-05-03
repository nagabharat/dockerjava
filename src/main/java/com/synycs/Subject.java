package com.synycs;

import javaslang.Tuple2;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by synycs on 2/5/17.
 */
public class Subject {
    private int id;
    private List<ExamGroup> examGroups;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ExamGroup> getExamGroups() {
        return examGroups;
    }

    public void setExamGroups(List<ExamGroup> examGroups) {
        this.examGroups = examGroups;
    }

    public Subject(int id, List<Exam> exams) {
        this.id = id;
        Map<Tuple2<Integer,String>,List<Exam>>examMap= exams.stream().
                collect(Collectors.
                        groupingBy(x->new Tuple2<Integer,String>
                                (x.getExamGroupId(),x.getExamGroupName())));
        examGroups=examMap.entrySet().stream().
                map(x->new ExamGroup(x.getKey(),x.getValue())).
                collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", examGroups=" + examGroups +
                '}';
    }
}
