package org.peopleskill.exception;

public class RecordNotFoundException extends Exception {

    public RecordNotFoundException() {
        super();
    }

    public RecordNotFoundException(final String message) {
        super(message);
    }

    public RecordNotFoundException(final Throwable throwable) {
        super(throwable);
    }

    public RecordNotFoundException(final String message, final Throwable throwable) {
        super(message, throwable);
    }

}
