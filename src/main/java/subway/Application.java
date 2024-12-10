package subway;

import subway.controller.SubwayController;

import static subway.config.AppConfig.*;


public class Application {
    public static void main(String[] args) {
        SubwayController subwayController = new SubwayController(getDataInitializerService(), getStationService(), getLineService(), getSectionService());
        subwayController.run();
    }
}
