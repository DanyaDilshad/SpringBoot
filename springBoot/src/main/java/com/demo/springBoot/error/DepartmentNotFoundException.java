package com.demo.springBoot.error;

import com.demo.springBoot.controller.DepartmentController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DepartmentNotFoundException extends Exception{

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentNotFoundException.class);

    public DepartmentNotFoundException() {

        super();
        LOGGER.info("Handling Department Not Found Exception");
    }

    public DepartmentNotFoundException(String message) {

        super(message);
        LOGGER.info("Handling Department Not Found Exception");
    }

    public DepartmentNotFoundException(String message, Throwable cause) {
        super(message, cause);
        LOGGER.info("Handling Department Not Found Exception");
    }

    public DepartmentNotFoundException(Throwable cause) {
        super(cause);
        LOGGER.info("Handling Department Not Found Exception");
    }


    protected DepartmentNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        LOGGER.info("Handling Department Not Found Exception");
    }
}
