package subway.domain;

import java.util.Objects;

public class Line {
    private String name;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현

    public static Line from(String lineName) {
        return new Line(lineName);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Line line = (Line) object;
        return Objects.equals(name, line.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "Line{" +
                "name='" + name + '\'' +
                '}';
    }

}
