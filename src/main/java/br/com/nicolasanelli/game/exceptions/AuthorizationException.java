package br.com.nicolasanelli.game.exceptions;

public class AuthorizationException extends RuntimeException {

    private final ApiError error;
    public AuthorizationException(ApiError error) {
        this.error = error;
    }
    public AuthorizationException(ApiError error, String detail) {
        super(detail);
        this.error = error;
    }
    public ApiError getError() { return error; }
}
