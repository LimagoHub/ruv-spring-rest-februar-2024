package de.ruv.webapp.domain;

public class SchweineServiceException extends RuntimeException{
    public SchweineServiceException() {
    }

    public SchweineServiceException(final String message) {
        super(message);
    }

    public SchweineServiceException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public SchweineServiceException(final Throwable cause) {
        super(cause);
    }

    public SchweineServiceException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
