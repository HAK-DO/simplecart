/*
 * AuthenticationException.java
 *
 * Created on February 11, 2005, 6:01 PM
 */

package org.simplecart.exceptions;

/**
 *
 * @author Daniel Watrous
 */
public class AuthenticationException extends Exception {

    /** Creates a new instance of AuthenticationException */
    public AuthenticationException() {}

    public AuthenticationException (String message) {
            super(message);
    }

    public AuthenticationException (String message, Throwable cause) {
            super(message, cause);
    }

    public AuthenticationException (Throwable cause) {
            super(cause);
    }
    
}
