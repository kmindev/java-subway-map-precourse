package subway.service;

import subway.domain.Line;
import subway.domain.Section;
import subway.domain.SectionRepository;
import subway.domain.Station;

import java.util.List;

public class SectionService {

    public static void addSection(Line line, Station station, int sectionOrder) {
        SectionRepository.addSection(line, station, sectionOrder);
    }

    public static void deleteSection(Line line, Station deleteStation) {
        SectionRepository.deleteSection(line, deleteStation);
    }

    public static List<Section> findAll() {
        return SectionRepository.sections();
    }

}
