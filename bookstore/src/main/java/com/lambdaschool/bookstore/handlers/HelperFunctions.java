package com.lambdaschool.bookstore.handlers;

import com.lambdaschool.bookstore.models.ValidationError;

import java.util.List;

//@Component
public interface HelperFunctions {
    List<ValidationError> getConstraintViolation(Throwable cause);

        // Find any data violations that might be associated with the error and report them
        // data validations get wrapped in other exceptions as we work through the Spring
        // exception chain. Hence we have to search the entire Spring Exception Stack
        // to see if we have any violation constraints.

    }

