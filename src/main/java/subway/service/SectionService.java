package subway.service;

import subway.constants.ErrorMessage;
import subway.domain.Line;
import subway.domain.Section;
import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.utils.CustomException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class SectionService {
    private final SectionRepository repository;

    public SectionService(SectionRepository repository) {
        this.repository = repository;
    }

    /**
     * 이미 노선에 등록되어 있는 역은 삭제할 수 없다.
     */
    public void validateCanDeleteStation(String stationName){
        if(repository.isRegisterStation(stationName)){
            throw new CustomException(ErrorMessage.ERROR_NOT_DELETE_STATION);
        }
    }

    public void registerSection(Line line, Station topStation, Station bottomStation){
        repository.addSection(new Section(line, List.of(topStation, bottomStation)));
    }

    public void appendSection(Line line, Station newStation, int index){
        Optional<Section> section = repository.findByLine(line);
        section.get().appendNewStation(newStation, index);
    }

    public void deleteSection(Line line, Station deleteStation){
        Optional<Section> section = repository.findByLine(line);
        section.get().deleteStation(deleteStation);
    }

    public Map<String, List<String>> findSectionRoute() {
        Map<String, List<String>> response = new HashMap<>();
        List<Section> sections = repository.sections();
        for(Section section : sections){
            response.put(section.getLineName(), section.getStationNames());
        }
        return response;
    }

}
