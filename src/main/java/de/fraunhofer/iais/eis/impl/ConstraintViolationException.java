package de.fraunhofer.iais.eis.impl;

import de.fraunhofer.iais.eis.Dataset;

import javax.validation.ConstraintViolation;
import java.util.Set;

/**
 * Created by christian on 19.01.17.
 */
public class ConstraintViolationException extends Exception {

    private Set<ConstraintViolation<?>> violations;

    public ConstraintViolationException() {
    }

    public ConstraintViolationException(Set<ConstraintViolation<?>> violations) {
        this.violations = violations;
    }
}
