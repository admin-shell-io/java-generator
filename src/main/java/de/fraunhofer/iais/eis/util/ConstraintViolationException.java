package de.fraunhofer.iais.eis.util;

import javax.validation.ConstraintViolation;
import java.util.Collection;
import java.util.Set;

/**
 * Created by christian on 19.01.17.
 */
public class ConstraintViolationException extends Exception {

    private Collection<String> messages;

    public ConstraintViolationException(Collection<String> messages) {
        this.messages = messages;
    }

    public Collection<String> getMessages() {
        return messages;
    }

    @Override
    public String toString() {
        return "ConstraintViolationException{" +
                "messages=" + messages +
                '}';
    }
}

