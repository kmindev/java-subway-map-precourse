package subway.domain;


import java.util.*;

public class SectionRepository {
    private static final String SECTION_NOT_FOUND_ERROR = "해당 구간을 찾을 수 없습니다.";
    private static final String SECTION_OUT_OF_RANGE_ERROR = "구간 순서 범위 초과";
    private static final String ALREADY_REGISTERED_STATION_IN_SECTION_ERROR = "이미 등록된 역";
    private static final String SECTION_DELETE_FAIL_ERROR = "구간 삭제를 실패 하였습니다.";
    private static final int SECTION_MIN_SIZE = 2;
    private static final String LINE_NOT_FOUND_ERROR = "해당 노선을  찾을 수 없습니다.";
    private static final String STATION_NOT_FOUND_ERROR = "해당역을 찾을 수 없습니다.";
    private static final String LINE_REGISTER_ERROR = "노선 등록 실패";

    private static final List<Section> sections = new ArrayList<>();

    public static List<Section> sections() {
        return Collections.unmodifiableList(sections);
    }

    public static void initSection(Line line, Station... stations) {
        Arrays.stream(stations)
                .forEach(station -> StationRepository.findById(station)
                        .orElseThrow(() -> new IllegalArgumentException(LINE_REGISTER_ERROR + " - " + STATION_NOT_FOUND_ERROR))
                );

        Section section = Section.of(line, stations);
        sections.add(section);
    }

    public static Optional<Section> findById(Station findStation) {
        return sections.stream()
                .filter(section -> section.getStations().contains(findStation))
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

        StationRepository.findById(station)
                .orElseThrow(() -> new IllegalArgumentException(STATION_NOT_FOUND_ERROR));

        if (section.getStations().contains(station)) {
            throw new IllegalArgumentException(ALREADY_REGISTERED_STATION_IN_SECTION_ERROR);
        }

        section.getStations().add(sectionOrder, station);
    }

    public static void deleteSection(Line line, Station deleteStation) {
        LineRepository.findById(line)
                .orElseThrow(() -> new IllegalArgumentException(LINE_NOT_FOUND_ERROR));

        StationRepository.findById(deleteStation)
                .orElseThrow(() -> new IllegalArgumentException(LINE_NOT_FOUND_ERROR));

        Section section = sections.stream()
                .filter(item -> item.getLine().equals(line))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(SECTION_NOT_FOUND_ERROR));

        if (section.getStations().size() - 1 < SECTION_MIN_SIZE) {
            throw new IllegalArgumentException(SECTION_OUT_OF_RANGE_ERROR);
        }

        if (!section.getStations().removeIf(station -> Objects.equals(station, deleteStation))) {
            throw new IllegalArgumentException(SECTION_DELETE_FAIL_ERROR);
        }
    }

    public static void deleteLine(Line line) {
        sections.removeIf(section -> section.getLine().equals(line));
    }

}
