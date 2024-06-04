package subway.domain;


import java.util.*;

public class SectionRepository {
    private static final String SECTION_NOT_FOUND_ERROR = "해당 구간을 찾을 수 없습니다.";
    private static final String SECTION_OUT_OF_RANGE_ERROR = "구간 순서 범위 초과";
    private static final String ALREADY_REGISTERED_STATION_IN_SECTION_ERROR = "이미 등록된 역";
    private static final String SECTION_DELETE_FAIL_ERROR = "구간 삭제를 실패 하였습니다.";
    private static final int SECTION_MIN_SIZE = 2;


    private static final List<Section> sections = new ArrayList<>();


    public static final List<Section> sections() {
        return Collections.unmodifiableList(sections);
    }

    public static void initSection(Section section) {
        sections.add(section);
    }

    public static Optional<Station> findByStationName(Station findStation) {
        return sections.stream()
                .flatMap(section -> section.getStations().stream())
                .filter(station -> station.equals(findStation))
                .findFirst();
    }


    public static void addSection(Line line, Station station, int sectionOrder) {
        Section section = sections.stream()
                .filter(item -> item.getLine().equals(line))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(SECTION_NOT_FOUND_ERROR));

        int currentSectionSize = section.getStations().size();

        if (sectionOrder < 0 || sectionOrder >= currentSectionSize) {
            throw new IllegalArgumentException(SECTION_OUT_OF_RANGE_ERROR);
        }

        if (section.getStations().contains(station)) {
            throw new IllegalArgumentException(ALREADY_REGISTERED_STATION_IN_SECTION_ERROR);
        }

        section.getStations().add(sectionOrder, station);
    }

    public static void deleteSection(Line line, Station deleteStation) {
        Section section = sections.stream()
                .filter(item -> item.getLine().equals(line))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(SECTION_NOT_FOUND_ERROR));

        if (section.getStations().size() - 1 < SECTION_MIN_SIZE ) {
            throw new IllegalArgumentException(SECTION_OUT_OF_RANGE_ERROR);
        }

        if (!section.getStations().removeIf(station -> Objects.equals(station, deleteStation))) {
            throw new IllegalArgumentException(SECTION_DELETE_FAIL_ERROR);
        }
    }

}
