package com.synycs;

import javaslang.Tuple2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by synycs on 30/3/17.
 */
public class Test {
    private static final Logger logger= LoggerFactory.getLogger(Test.class);
    public List<String> getAll(){
        logger.info("got info");
        logger.info("got info about all");
        logger.error("error {}",new Exception());
      return Arrays.asList("naga","bharat");
    }
    public static void main(String[] args){
        Exam exam=new Exam();
        exam.setExamGroupId(1);
        exam.setExamGroupName("unit-1");
        exam.setMark(10);
        exam.setStudentId(1);
        exam.setSubjectId(1);
        Exam exam1=new Exam();
        exam1.setExamGroupId(1);
        exam1.setExamGroupName("unit-1");
        exam1.setMark(9);
        exam1.setStudentId(2);
        exam1.setSubjectId(1);
        Exam exam2=new Exam();
        exam2.setExamGroupId(2);
        exam2.setExamGroupName("unit-2");
        exam2.setMark(10);
        exam2.setStudentId(1);
        exam2.setSubjectId(1);
        Exam exam3=new Exam();
        exam3.setExamGroupId(2);
        exam3.setExamGroupName("unit-2");
        exam3.setMark(9);
        exam3.setStudentId(2);
        exam3.setSubjectId(1);
        List<Exam> exams=Arrays.asList(exam,exam1,exam2,exam3);
        Map<Integer,List<Exam>> examBySub= exams.stream().
                collect(Collectors.groupingBy(Exam::getSubjectId));
        List<Subject> subjects=examBySub.entrySet().stream().map(x->new Subject(x.getKey(),x.getValue())).
                collect(Collectors.toList());

        subjects.forEach(System.out::println);


    }
}
