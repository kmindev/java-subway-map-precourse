package subway.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Section {
    private Line line;
    private List<Station> stations;

    private Section(Line line, List<Station> stations) {
        this.line = line;
        this.stations = stations;
    }

    public Line getLine() {
        return this.line;
    }

    public List<Station> getStations() {
        return this.stations;
    }

    public static Section of(Line line, Station downStation, Station upStation) {
        return new Section(line, new ArrayList<>(Arrays.asList(downStation, upStation)));
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
