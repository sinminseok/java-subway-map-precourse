package subway.view;

import static subway.constants.ViewMessage.*;

public class OutputView {

    public static void printMainOption(){
        System.out.println(MAIN_SCREEN_OPTION_MESSAGE);
    }

    public static void printStationOption(){
        System.out.println(STATION_SCREEN_OPTION_MESSAGE);
    }

    public static void printSuccessRegisterStation(){
        System.out.println(STATION_REGISTER_SUCCESS_MESSAGE);
    }
}
