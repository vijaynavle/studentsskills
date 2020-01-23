package org.peopleskill.exception;

public class InvalidDataException extends Exception {

    public InvalidDataException() {
        super();
    }

    public InvalidDataException(final String message) {
        super(message);
    }

    public InvalidDataException(final Throwable throwable) {
        super(throwable);
    }

    public InvalidDataException(final String message, final Throwable throwable) {
        super(message, throwable);
    }

}
