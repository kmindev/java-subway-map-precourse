package subway.domain;

import java.util.List;
import java.util.Objects;

public class Section {
    private Line line;
    private List<Station> stations;

    private Section(Line line, List<Station> stations) {
        this.line = line;
        this.stations = stations;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Section section = (Section) object;
        return Objects.equals(line, section.line);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(line);
    }
    @Override
    public String toString() {
        return "Section{" +
                "line=" + line +
                ", stations=" + stations +
                '}';
    }
}
