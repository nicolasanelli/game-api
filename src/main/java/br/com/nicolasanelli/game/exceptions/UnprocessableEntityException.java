package br.com.nicolasanelli.game.exceptions;

public class UnprocessableEntityException extends RuntimeException {

    private final ApiError error;
    public UnprocessableEntityException(ApiError error) {
        this.error = error;
    }
    public UnprocessableEntityException(String detail) {
        this.error = new ApiError("4xx.xxx", detail);
    }
    public UnprocessableEntityException(ApiError error, String detail) {
        super(detail);
        this.error = error;
    }
    public ApiError getError() { return error; }
}
