package subway.controller;

import subway.constants.FunctionOption;
import subway.domain.Line;
import subway.domain.Station;
import subway.service.DataInitializerService;
import subway.service.LineService;
import subway.service.SectionService;
import subway.service.StationService;
import subway.utils.Retry;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;
import java.util.Map;

public class SubwayController {

    private final DataInitializerService dataInitializerService;
    private final StationService stationService;
    private final LineService lineService;
    private final SectionService sectionService;

    public SubwayController(DataInitializerService dataInitializerService, StationService stationService, LineService lineService, SectionService sectionService) {
        this.dataInitializerService = dataInitializerService;
        this.stationService = stationService;
        this.lineService = lineService;
        this.sectionService = sectionService;
    }

    public void run() {
        initialize();
        while (true) {
            OutputView.printMainOption();
            FunctionOption option = InputView.intputOption();
            if (option.isOne()) {
                manageStation();
            }
            if (option.isTWO()) {
                manageLine();
            }
            if (option.isThree()) {
                manageTerm();
            }
            if (option.isFour()) {
                showSubwayRoute();
            }
            if (option.isQuit()) {
                break;
            }
        }
    }

    private void initialize() {
        dataInitializerService.initStations();
        dataInitializerService.initLines();
        dataInitializerService.initSections();
    }

    public void manageStation() {
        OutputView.printStationOption();
        FunctionOption option = InputView.intputOption();
        if (option.isOne()) {
            registerStation();
        }
        if (option.isTWO()) {
            deleteStation();
        }
        if (option.isThree()) {
            Retry.retryOnExceptionWithoutResult(() -> findStations());
        }
        if (option.isBack()) {
            return;
        }
    }

    private void registerStation(){
        String stationName = InputView.inputRegisterStationName();
        stationService.registerStation(stationName);
        OutputView.printSuccessRegisterStation();
    }

    private void deleteStation(){
        String stationName = InputView.inputDeleteStationName();
        sectionService.validateCanDeleteStation(stationName);
        stationService.deleteStation(stationName);
        OutputView.printSuccessDeleteStation();
    }

    private void findStations(){
        List<String> names = stationService.findAllStationNames();
        OutputView.printStations(names);
    }

    public void manageLine() {
        OutputView.printLineOption();
        FunctionOption option = InputView.intputOption();
        if (option.isOne()) {
            String lineName = InputView.inputRegisterLineName();
            lineService.validateExistLine(lineName);
            Station topStation = stationService.findByName(InputView.inputRegisterLineTopStation());
            Station bottomStation = stationService.findByName(InputView.inputRegisterLineBottomStation());
            Line line = lineService.registerLine(lineName);
            sectionService.registerSection(line, topStation, bottomStation);
            OutputView.printSuccessRegisterLine();
        }
        if (option.isTWO()) {
            String lineName = InputView.inputDeleteLineName();
            lineService.validateNotExistLine(lineName);
            lineService.deleteLine(lineName);
            OutputView.printSuccessDeleteLine();
        }
        if (option.isThree()) {
            List<String> names = lineService.findAllLineNames();
            OutputView.printLines(names);
        }
        if (option.isBack()) {
            return;
        }
    }

    public void manageTerm() {
        OutputView.printTermOption();
        FunctionOption option = InputView.intputOption();
        if (option.isOne()) {
            Line line = lineService.findByName(InputView.inputRegisterTermLine());
            Station station = stationService.findByName(InputView.inputRegisterTermStation());
            int index = InputView.inputRegisterTermNumber();
            sectionService.appendSection(line, station, index);
            OutputView.printSuccessRegisterTerm();
        }
        if (option.isTWO()) {
            Line line = lineService.findByName(InputView.inputDeleteTermLineName());
            Station station = stationService.findByName(InputView.inputDeleteTermStationName());
            sectionService.deleteSection(line, station);
            OutputView.printSuccessDeleteTerm();
        }
        if (option.isBack()) {
            return;
        }
    }

    public void showSubwayRoute(){
        Map<String, List<String>> sectionRoute = sectionService.findSectionRoute();
        OutputView.printSubwayRoute(sectionRoute);
    }
}
