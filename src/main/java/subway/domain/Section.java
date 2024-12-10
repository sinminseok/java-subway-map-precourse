package subway.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Section {
    private final Line line;
    private final List<Station> stations;

    public Section(final Line line, final List<Station> stations) {
        this.line = line;
        this.stations = stations;
    }

    public boolean isExistStationName(String name){
        return stations.stream()
                .filter(station -> station.isSameName(name))
                .findFirst()
                .isPresent();
    }

    public void appendNewStation(Station station, int index){
        stations.add(index, station);
    }

    public boolean isSameLine(Line line){
        return this.line.equals(line);
    }

    public String getLineName(){
        return line.getName();
    }

    public List<String> getStationNames(){
        return stations.stream()
                .map(station -> station.getName())
                .collect(Collectors.toList());
    }

    public Line getLine() {
        return line;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void deleteStation(Station deleteStation) {
        stations.remove(deleteStation);
    }
}
