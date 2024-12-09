package subway.constants;

import java.util.Arrays;

public enum FunctionOption {
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    QUIT("Q"),
    BACK("B");

    private final String command;

    FunctionOption(String command) {
        this.command = command;
    }

    public static FunctionOption valueOfCommand(String command){
        return Arrays.stream(values())
                .filter(option -> option.command.equals(command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바르지 않는 입력입니다."));
    }

}
