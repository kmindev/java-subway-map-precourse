package subway.service;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.SectionRepository;
import subway.domain.Station;

import java.util.List;

public class LineService {

    public static void addLine(Line line, Station... stations) {
        LineRepository.addLine(line);
        initSection(line, stations);
    }

    public static void deleteLineByName(String deleteLineName) {
        LineRepository.deleteLine(deleteLineName);
        SectionRepository.deleteLine(Line.from(deleteLineName));
    }

    public static List<Line> selectLines() {
        return LineRepository.lines();
    }

    private static void initSection(Line line, Station... stations) {
        try {
            SectionRepository.initSection(line, stations);
        } catch (Exception e) {
            deleteLineByName(line.getName());
            throw e;
        }
    }

}
