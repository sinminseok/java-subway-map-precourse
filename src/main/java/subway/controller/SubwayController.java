package subway.controller;

import subway.constants.FunctionOption;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayController {

    public void run(){
        while (true){
            OutputView.printMainOption();
            FunctionOption option = InputView.intputOption();

            if(option.isOne()){
                //역 관리
                manageStation();
            }
            if(option.isTWO()){
                //노선 관리

            }
            if(option.isThree()){
                //구간 관리

            }
            if(option.isQuit()){
                break;
            }
        }
    }

    public void manageStation(){
        OutputView.printStationOption();
        FunctionOption option = InputView.intputOption();
        if(option.isOne()){
            //역 등록
            String stationName = InputView.inputRegisterStationName();
            //역 등록 로직 구현
            OutputView.printSuccessRegisterStation();
        }
        if(option.isTWO()){
            //역 삭제

        }
        if(option.isThree()){
            //역 조회 로직
            //OutputView.printStations();
        }
    }
}
