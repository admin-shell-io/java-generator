package de.fraunhofer.iais.eis.handcrafted.impl;

import javax.validation.ConstraintViolation;
import java.util.Set;

/**
 * Created by christian on 19.01.17.
 */
public class ConstraintViolationException extends Exception {

    private Set<ConstraintViolation<?>> violations;

    public ConstraintViolationException() {
    }

    public <T> void setViolations(Set<ConstraintViolation<T>> constraintViolations) {

    }

}

