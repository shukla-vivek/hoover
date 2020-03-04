package com.company.hoover.exception;

import com.company.hoover.model.Hoover;

public class ServiceException extends Exception implements Hoover{


	private static final long serialVersionUID = -3683226092685875562L;

	public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }
}
