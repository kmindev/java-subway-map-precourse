package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final int STATION_NAME_MIN_SIZE = 2;
    private static final String STATION_NAME_TOO_SHORT_ERROR = "역 이름은 " + STATION_NAME_MIN_SIZE + "글자 이상입니다.";
    private static final String STATION_ALREADY_EXISTS_ERROR = "이미 등록된 역 이름입니다.";
    private static final String STATION_DELETE_FAIL_MESSAGE = "삭제되지 않았습니다.";
    public static final String LINE_REGISTERED_MESSAGE = "노선에 등록되어 있는 역입니다.";

    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        if (station.getName().length() < STATION_NAME_MIN_SIZE) {
            throw new IllegalArgumentException(STATION_NAME_TOO_SHORT_ERROR);
        }

        if (stations.contains(station)) {
            throw new IllegalArgumentException(STATION_ALREADY_EXISTS_ERROR);
        }

        stations.add(station);
    }

    public static void deleteStation(String name) {
        if (SectionRepository.stationIsExist(name)) {
            throw new IllegalArgumentException(name + " " + STATION_DELETE_FAIL_MESSAGE + " " + LINE_REGISTERED_MESSAGE);
        }

        if (!stations.removeIf(station -> Objects.equals(station.getName(), name))) {
            throw new IllegalArgumentException(name + " " + STATION_DELETE_FAIL_MESSAGE);
        }
    }

}
