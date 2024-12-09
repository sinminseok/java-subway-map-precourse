package subway.view;

import subway.constants.FunctionOption;

import java.util.Scanner;

import static subway.constants.ViewMessage.INPUT_FUNCTION_OPTION_MESSAGE;

public class InputView {

    private InputView(){
    }

    public static FunctionOption inputMainOption(){
        System.out.println(INPUT_FUNCTION_OPTION_MESSAGE);
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        return FunctionOption.valueOfCommand(input);
    }
}
