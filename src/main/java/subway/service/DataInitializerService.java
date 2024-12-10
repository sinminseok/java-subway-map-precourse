package subway.service;

import subway.constants.InitInformation;
import subway.domain.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataInitializerService {
    private final StationRepository stationRepository;
    private final SectionRepository sectionRepository;
    private final LineRepository lineRepository;

    public DataInitializerService(StationRepository stationRepository, SectionRepository sectionRepository, LineRepository lineRepository) {
        this.stationRepository = stationRepository;
        this.sectionRepository = sectionRepository;
        this.lineRepository = lineRepository;
    }

    public void initStations() {
        InitInformation.initStations.stream()
                .forEach(name -> {
                    stationRepository.addStation(new Station(name));
                });
    }

    public void initLines() {
        InitInformation.initLines.stream()
                .forEach(name -> {
                    lineRepository.addLine(new Line(name));
                });
    }

    public void initSections() {
        Map<String, List<String>> initLines = InitInformation.initSections;
        for (String key : initLines.keySet()) {
            Line line = lineRepository.findByName(key).get();
            List<Station> stations = initLines.get(key).stream()
                    .map(name -> stationRepository.findByName(name))
                    .collect(Collectors.toList());
            sectionRepository.addSection(new Section(line, stations));
        }
    }
}
