package subway.config;

import subway.domain.LineRepository;
import subway.domain.SectionRepository;
import subway.domain.StationRepository;
import subway.service.DataInitializerService;
import subway.service.LineService;
import subway.service.SectionService;
import subway.service.StationService;

public class AppConfig {
    private final static StationRepository stationRepository = new StationRepository();
    private final static LineRepository lineRepository = new LineRepository();
    private final static SectionRepository sectionRepository = new SectionRepository();

    public AppConfig(){
    }

    public static DataInitializerService getDataInitializerService(){
        DataInitializerService dataInitializerService = new DataInitializerService(stationRepository, sectionRepository, lineRepository);
        return dataInitializerService;
    }

    public static StationService getStationService(){
        StationService stationService = new StationService(stationRepository);
        return stationService;
    }

    public static LineService getLineService(){
        LineService lineService = new LineService(lineRepository);
        return lineService;
    }

    public static SectionService getSectionService(){
        SectionService sectionService = new SectionService(sectionRepository);
        return sectionService;
    }
}
