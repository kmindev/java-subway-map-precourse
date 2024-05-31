package subway.domain;


import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class SectionRepository {
    private static final String REGISTER_SECTION_ERROR = "노선 등록 실패";

    private static final Map<Line, LinkedList<Station>> sections = new LinkedHashMap<>();

    public static boolean stationIsExist(String stationName) {
        return sections.values().stream()
                .flatMap(LinkedList::stream)
                .anyMatch(station -> station.getName().equals(stationName));
    }

    public static void initSection(Line line, Station downStation, Station upStation) {
        if (!LineRepository.lines().contains(line)) {
            throw new IllegalArgumentException(REGISTER_SECTION_ERROR);
        }

        if (!StationRepository.stations().contains(upStation) || !StationRepository.stations().contains(downStation)) {
            throw new IllegalArgumentException(REGISTER_SECTION_ERROR);
        }

        sections.put(line, new LinkedList<>(Arrays.asList(downStation, upStation)));
    }

}
