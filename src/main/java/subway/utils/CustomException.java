package subway.utils;


import subway.constants.ErrorMessage;

public class CustomException extends IllegalArgumentException {
    public CustomException(final ErrorMessage message) {
        super(message.getMessage());
        System.out.println(message.getMessage());
    }
}