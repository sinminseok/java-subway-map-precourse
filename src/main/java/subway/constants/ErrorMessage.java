package subway.constants;

public enum ErrorMessage {
    ERROR_NOT_EXIST_STATION_NAME("존재히지 않는 역 이름 입니다."),
    ERROR_EXIST_STATION_NAME("이미 존재하는 역 이름입니다."),
    ERROR_NOT_DELETE_STATION("노선에 등록된 지하철 역은 삭제할 수 없습니다."),
    ERROR_EXIST_LINE_NAME("이미 존재하는 노선 이름입니다."),
    ERROR_NOT_EXIST_LINE_NAME("존재히지 않는 노선 이름 입니다.");

    private static final String PREFIX = "[ERROR] ";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
