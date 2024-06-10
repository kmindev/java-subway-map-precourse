package subway.domain;

import java.util.*;

public class LineRepository {
    private static final int LINE_NAME_MIN_SIZE = 2;
    private static final String LINE_NAME_TOO_SHORT_ERROR = "노선 이름은 " + LINE_NAME_MIN_SIZE + "글자 이상입니다.";
    private static final String LINE_ALREADY_EXISTS_ERROR = "이미 등록된 노선 이름입니다.";
    private static final String LINE_DELETE_ERROR = "삭제되지 않았습니다.";

    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        if (line.getName().length() < LINE_NAME_MIN_SIZE) {
            throw new IllegalArgumentException(LINE_NAME_TOO_SHORT_ERROR);
        }

        if (LineRepository.lines().contains(line)) {
            throw new IllegalArgumentException(LINE_ALREADY_EXISTS_ERROR);
        }

        lines.add(line);
    }

    public static void deleteLine(String lineName) {
        if (!lines.removeIf(item -> Objects.equals(item.getName(), lineName))) {
            throw new IllegalArgumentException(lineName + " " + LINE_DELETE_ERROR);
        }
    }

    public static Optional<Line> findById(Line line) {
        return lines().stream()
                .filter(item -> item.equals(line))
                .findFirst();
    }

}
