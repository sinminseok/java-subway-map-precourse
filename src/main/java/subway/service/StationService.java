package subway.service;

import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.List;
import java.util.stream.Collectors;

public class StationService {
    private final StationRepository repository;

    public StationService(StationRepository repository) {
        this.repository = repository;
    }

    public List<String> findAllStationNames(){
        return repository.stations().stream()
                .map(station -> station.getName())
                .collect(Collectors.toList());
    }

    public Station findByName(String name){
        return repository.findByName(name);
    }

    public void registerStation(String name){
        //todo 존재하는지 검증
        repository.addStation(new Station(name));
    }

    public void deleteStation(String name){
        //todo 존재하는지 검증
        repository.deleteStation(name);
    }
}
