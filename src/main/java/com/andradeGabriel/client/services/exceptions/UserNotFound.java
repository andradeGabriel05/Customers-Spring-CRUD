package com.andradeGabriel.client.services.exceptions;

public class UserNotFound extends RuntimeException {

    public UserNotFound(String message) {
        super(message);
    }
}
