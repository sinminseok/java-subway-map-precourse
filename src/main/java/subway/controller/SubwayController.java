package subway.controller;

import subway.constants.FunctionOption;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayController {

    public void run(){
        //메인 기능 입력
        OutputView.printMainOption();
        FunctionOption option = InputView.intputOption();

        if(option.isOne()){
            manageStation();
        }
    }

    public void manageStation(){
        OutputView.printStationOption();
        FunctionOption option = InputView.intputOption();
        String stationName = InputView.inputRegisterStationName();
        //역 등록 로직 구현
        OutputView.printSuccessRegisterStation();
    }
}
