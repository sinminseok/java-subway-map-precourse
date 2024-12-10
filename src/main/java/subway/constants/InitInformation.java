package subway.constants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InitInformation {
    public static final List<String> initStations = List.of("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
    public static final List<String> initLines = List.of("2호선", "3호선", "신분당선");
    public static final Map<String, List<String>> initSections = new HashMap<String, List<String>>() {{
        put("2호선", List.of("교대역", "강남역", "역삼역"));
        put("3호선", List.of("교대역", "남부터미널역", "양재역", "매봉역"));
        put("신분당선", List.of("강남역", "양재역", "양재시민의숲역"));
    }};
}
