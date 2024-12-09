package subway.view;

import static subway.constants.ViewMessage.MAIN_SCREEN_OPTION_MESSAGE;
import static subway.constants.ViewMessage.STATION_SCREEN_OPTION_MESSAGE;

public class OutputView {

    public static void printMainOption(){
        System.out.println(MAIN_SCREEN_OPTION_MESSAGE);
    }

    public static void printStationOption(){
        System.out.println(STATION_SCREEN_OPTION_MESSAGE);
    }
}
