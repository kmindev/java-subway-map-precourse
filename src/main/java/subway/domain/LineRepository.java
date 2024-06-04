package subway.domain;

import java.util.*;

public class LineRepository {


    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static Optional<Line> findById(Line line) {
        return lines().stream()
                .filter(item -> item.equals(line))
                .findFirst();
    }
    
}
