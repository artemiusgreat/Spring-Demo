package com.company.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExceptionProcessor implements Thread.UncaughtExceptionHandler {

    private static Logger processor = LoggerFactory.getLogger(ExceptionProcessor.class);

    public void uncaughtException(Thread process, Throwable exception) {
        processor.error("Error", exception);
    }
}