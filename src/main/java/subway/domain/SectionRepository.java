package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class SectionRepository {
    private static final List<Section> sections = new ArrayList<>();

    public static List<Section> sections() {
        return Collections.unmodifiableList(sections);
    }

    public static void addSection(Section section){
        sections.add(section);
    }

    public static Optional<Section> findByLine(Line line){
        return sections.stream()
                .filter(section -> section.isSameLine(line))
                .findFirst();
    }

    public static boolean isRegisterStation(String name){
        for(Section section : sections){
            if(section.isExistStationName(name)){
                return true;
            }
        }
        return false;
    }
}
