package subway.service;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.SectionRepository;
import subway.domain.Station;

import java.util.List;

public class LineService {

    public static void addLine(Line line, Station upStation, Station downStation) {
        // line 추가
        LineRepository.addLine(line);

        // section(구간) 초기값 설정
        initSection(line, downStation, upStation);
    }

    public static void deleteLineByName(String deleteLineName) {
        LineRepository.deleteLineByName(deleteLineName);
    }

    public static List<Line> selectLines() {
        return LineRepository.lines();
    }

    private static void initSection(Line line, Station downStation, Station upStation) {
        try {
            SectionRepository.initSection(line, downStation, upStation);
        } catch (Exception e) {
            LineRepository.deleteLineByName(line.getName());
            throw e;
        }
    }

}
