package subway.view;

import java.util.List;
import java.util.Map;

import static subway.constants.ViewMessage.*;

public class OutputView {

    public static void printMainOption() {
        System.out.println(MAIN_SCREEN_OPTION_MESSAGE);
    }

    public static void printStationOption() {
        System.out.println(STATION_SCREEN_OPTION_MESSAGE);
    }

    public static void printSuccessRegisterStation() {
        System.out.println(STATION_REGISTER_SUCCESS_MESSAGE);
    }

    public static void printSuccessDeleteStation() {
        System.out.println(STATION_DELETE_SUCCESS_MESSAGE);
    }

    public static void printLineOption() {
        System.out.println(LINE_SCREEN_OPTION_MESSAGE);
    }

    public static void printSuccessRegisterLine() {
        System.out.println(LINE_REGISTER_SUCCESS_MESSAGE);
    }

    public static void printLines(List<String> lineNames) {
        System.out.println(LINE_LIST_MESSAGE);
        lineNames.stream()
                .forEach(name -> System.out.println(ITEM_INFO + name));
    }

    public static void printSubwayRoute(Map<String, List<String>> routes) {
        System.out.println(SUBWAY_ROUTE_MESSAGE);
        for (String key : routes.keySet()) {
            List<String> stationNames = routes.get(key);
            printSection(key, stationNames);
            System.out.println();
        }
    }

    private static void printSection(String lineName, List<String> stationNames) {
        System.out.println(ITEM_INFO + lineName);
        System.out.println(LINE_STATION_DIVISION);
        stationNames.stream()
                .forEach(name -> System.out.println(ITEM_INFO + name));
    }

    public static void printStations(List<String> stationNames) {
        System.out.println(STATIONS_LIST_MESSAGE);
        stationNames.stream()
                .forEach(name -> System.out.println(ITEM_INFO + name));
    }

    public static void printSuccessDeleteLine() {
        System.out.println(LINE_DELETE_SUCCESS_MESSAGE);
    }

    public static void printTermOption() {
        System.out.println(TERM_SCREEN_OPTION_MESSAGE);
    }

    public static void printSuccessRegisterTerm() {
        System.out.println(TERM_REGISTER_SUCCESS_MESSAGE);
    }

    public static void printSuccessDeleteTerm() {
        System.out.println(TERM_DELETE_SUCCESS_MESSAGE);
    }
}
