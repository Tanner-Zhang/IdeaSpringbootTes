package com.zyt.demo.service.ex;

public class JobInfoNotFoundException extends ServiceException {
    private static final long serialVersionUID = 7059951024147051774L;

    public JobInfoNotFoundException() {
        super();
    }

    public JobInfoNotFoundException(String message) {
        super(message);
    }

    public JobInfoNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public JobInfoNotFoundException(Throwable cause) {
        super(cause);
    }

    public JobInfoNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
