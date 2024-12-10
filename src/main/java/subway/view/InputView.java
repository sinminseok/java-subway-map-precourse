package subway.view;

import subway.constants.FunctionOption;

import java.util.Scanner;

import static subway.constants.ViewMessage.INPUT_FUNCTION_OPTION_MESSAGE;

public class InputView {

    private InputView(){
    }

    public static FunctionOption intputOption(){
        System.out.println(INPUT_FUNCTION_OPTION_MESSAGE);
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        return FunctionOption.valueOfCommand(input);
    }

    public static String inputRegisterStationName(){
        System.out.println("## 등록할 역 이름을 입력하세요.");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        //todo 공백인지 검증
        return input;
    }

    public static String inputDeleteStationName(){
        System.out.println("## 삭제할 역 이름을 입력하세요.");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        //todo 공백인지 검증
        return input;
    }
}
