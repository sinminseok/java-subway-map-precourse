package subway.domain;

import subway.constants.ErrorMessage;
import subway.utils.CustomException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean isExistName(String name){
        return stations.stream()
                .filter(station -> station.isSameName(name))
                .findFirst()
                .isPresent();
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static Station findByName(String findName){
        return stations.stream()
                .filter(station -> station.isSameName(findName))
                .findFirst()
                .orElseThrow(() -> new CustomException(ErrorMessage.ERROR_EXIST_STATION_NAME));
    }
}
