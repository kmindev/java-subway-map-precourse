package subway.service;

import subway.domain.*;

import java.util.List;

public class SectionService {
    private static final String LINE_NOT_FOUND_ERROR = "해당 노선을  찾을 수 없습니다.";
    private static final String STATION_NOT_FOUND_ERROR = "해당역을 찾을 수 없습니다.";

    public static void addSection(Line line, Station station, int sectionOrder) {
        Line findLine = LineRepository.findById(line)
                .orElseThrow(() -> new IllegalArgumentException(LINE_NOT_FOUND_ERROR));

        Station findStation = StationRepository.findById(station)
                .orElseThrow(() -> new IllegalArgumentException(STATION_NOT_FOUND_ERROR));

        SectionRepository.addSection(findLine, findStation, sectionOrder);
    }

    public static void deleteSection(Line line, Station deleteStation) {
        Line findLine = LineRepository.findById(line)
                .orElseThrow(() -> new IllegalArgumentException(LINE_NOT_FOUND_ERROR));

        Station findStation = StationRepository.findById(deleteStation)
                .orElseThrow(() -> new IllegalArgumentException(LINE_NOT_FOUND_ERROR));

        SectionRepository.deleteSection(findLine, findStation);
    }

    public static List<Section> findAll() {
        return SectionRepository.sections();
    }

}
