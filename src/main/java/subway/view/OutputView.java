package subway.view;

import java.util.List;

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

    public static void printStations(List<String> stationNames){
        System.out.println(STATIONS_LIST_MESSAGE);
        stationNames.stream()
                .forEach(name -> System.out.println(STATION_INFORMATION_FORM + name));
    }
}
