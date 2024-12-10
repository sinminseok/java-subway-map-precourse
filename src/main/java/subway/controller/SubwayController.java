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
                manageLine();
            }
            if(option.isThree()){
                //구간 관리
                manageTerm();
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
            String stationName = InputView.inputDeleteStationName();
            //역 삭제 로직 구현
            OutputView.printSuccessDeleteStation();
        }
        if(option.isThree()){
            //역 조회 로직
            //OutputView.printStations();
        }
        if (option.isBack()){
            return;
        }
    }

    public void manageLine(){
        OutputView.printLineOption();
        FunctionOption option = InputView.intputOption();
        if(option.isOne()){
            //노선 등록
            String lineName = InputView.inputRegisterLineName();
            String topStation = InputView.inputRegisterLineTopStation();
            String bottomStation = InputView.inputRegisterLineBottomStation();

            OutputView.printSuccessRegisterLine();
        }
        if(option.isTWO()){
            //노선 삭제
            String lineName = InputView.inputDeleteLineName();
            //역 삭제 로직 구현
            OutputView.printSuccessDeleteLine();
        }
        if(option.isThree()){
            //노선 조회
            //OutputView.printLines(lineNames);
        }
        if (option.isBack()){
            return;
        }
    }

    public void manageTerm(){
        OutputView.printTermOption();
        FunctionOption option = InputView.intputOption();
        if(option.isOne()){
            String lineName = InputView.inputRegisterTermLine();
            String stationName = InputView.inputRegisterTermStation();
            String number = InputView.inputRegisterTermNumber();
            //구간 등록
            OutputView.printSuccessRegisterTerm();
        }
        if(option.isTWO()){
            String lineName = InputView.inputDeleteTermLineName();
            String stationName = InputView.inputDeleteTermStationName();
            OutputView.printSuccessDeleteTerm();
        }
        if(option.isBack()){
            return;
        }
    }
}
