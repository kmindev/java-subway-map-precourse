package subway.domain;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class SectionRepository {
    private static final List<Section> sections = new ArrayList<>();


    public static final List<Section> sections() {
        return Collections.unmodifiableList(sections);
    }

    public static void addSection(Section section) {
        sections.add(section);
    }

    public static Optional<Station> findByStationName(Station findStation) {
        return sections.stream()
                .flatMap(section -> section.getStations().stream())
                .filter(station -> station.equals(findStation))
                .findFirst();
    }


}
