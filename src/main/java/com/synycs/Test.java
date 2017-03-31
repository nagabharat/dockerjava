package com.synycs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * Created by synycs on 30/3/17.
 */
public class Test {
    private static final Logger logger= LoggerFactory.getLogger(Test.class);
    public List<String> getAll(){
        logger.info("got info");
      return Arrays.asList("naga","bharat");
    }
}
