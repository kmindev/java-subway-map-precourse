package subway.service;

import subway.domain.*;

import java.util.List;

public class LineService {
    private static final int LINE_NAME_MIN_SIZE = 2;
    private static final String LINE_NAME_TOO_SHORT_ERROR = "노선 이름은 " + LINE_NAME_MIN_SIZE + "글자 이상입니다.";
    private static final String LINE_ALREADY_EXISTS_ERROR = "이미 등록된 노선 이름입니다.";
    private static final String LINE_DELETE_ERROR = "삭제되지 않았습니다.";
    private static final String LINE_REGISTER_ERROR = "노선 등록 실패";
    private static final String STATION_NOT_FOUND_ERROR = "해당 역이 존재하지 않습니다.";

    public static void addLine(Line line, Station upStation, Station downStation) {
        if (line.getName().length() < LINE_NAME_MIN_SIZE) {
            throw new IllegalArgumentException(LINE_NAME_TOO_SHORT_ERROR);
        }

        if (LineRepository.lines().contains(line)) {
            throw new IllegalArgumentException(LINE_ALREADY_EXISTS_ERROR);
        }

        LineRepository.addLine(line);

        initSection(line, downStation, upStation);
    }

    public static void deleteLineByName(String deleteLineName) {
        if (!LineRepository.deleteLineByName(deleteLineName)) {
            throw new IllegalArgumentException(deleteLineName + " " + LINE_DELETE_ERROR);
        }
        LineRepository.deleteLineByName(deleteLineName);
    }

    public static List<Line> selectLines() {
        return LineRepository.lines();
    }

    private static void initSection(Line line, Station downStation, Station upStation) {
        try {
            Station findDownStation = StationRepository.findById(downStation)
                    .orElseThrow(() -> new IllegalArgumentException(LINE_REGISTER_ERROR + " - " + STATION_NOT_FOUND_ERROR));

            Station findUpStation = StationRepository.findById(upStation)
                    .orElseThrow(() -> new IllegalArgumentException(LINE_REGISTER_ERROR + " - " + STATION_NOT_FOUND_ERROR));

            Section section = Section.of(line, findDownStation, findUpStation);
            SectionRepository.addSection(section);
        } catch (Exception e) {
            deleteLineByName(line.getName());
            throw e;
        }
    }

}
