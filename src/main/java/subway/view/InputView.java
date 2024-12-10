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

    public static String inputRegisterLineName(){
        System.out.println("## 등록할 노선 이름을 입력하세요.");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        //todo 공백인지 검증
        return input;
    }

    public static String inputRegisterLineTopStation(){
        System.out.println("## 등록할 노선의 상행 종점역 이름을 입력하세요.");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        //todo 공백인지 검증
        return input;
    }

    public static String inputRegisterLineBottomStation(){
        System.out.println("## 등록할 노선의 하행 종점역 이름을 입력하세요.");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        //todo 공백인지 검증
        return input;
    }

    public static String inputDeleteLineName() {
        System.out.println("## 삭제할 노선 이름을 입력하세요.");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        //todo 공백인지 검증
        return input;
    }

    public static String inputRegisterTermLine(){
        System.out.println("## 노선을 입력하세요.");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        //todo 공백인지 검증
        return input;
    }

    public static String inputRegisterTermStation(){
        System.out.println("## 역이름을 입력하세요.");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        //todo 공백인지 검증
        return input;
    }

    public static int inputRegisterTermNumber(){
        System.out.println("## 순서를 입력하세요.");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        //todo 공백인지 검증
        return Integer.parseInt(input);
    }

    public static String inputDeleteTermLineName(){
        System.out.println("## 삭제할 구간의 노선을 입력하세요.");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        //todo 공백인지 검증
        return input;
    }

    public static String inputDeleteTermStationName(){
        System.out.println("## 삭제할 구간의 역을 입력하세요.");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        //todo 공백인지 검증
        return input;
    }
}
