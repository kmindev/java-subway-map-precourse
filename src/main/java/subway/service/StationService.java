package subway.service;

import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.List;


public class StationService {
    private static final int STATION_NAME_MIN_SIZE = 2;
    private static final String STATION_NAME_TOO_SHORT_ERROR = "역 이름은 " + STATION_NAME_MIN_SIZE + "글자 이상입니다.";
    private static final String STATION_ALREADY_EXISTS_ERROR = "이미 등록된 역 이름입니다.";
    private static final String STATION_DELETE_FAIL_MESSAGE = "삭제되지 않았습니다.";
    public static final String LINE_REGISTERED_MESSAGE = "노선에 등록되어 있는 역입니다.";

    public static void addStation(Station station) {
        if (station.getName().length() < STATION_NAME_MIN_SIZE) {
            throw new IllegalArgumentException(STATION_NAME_TOO_SHORT_ERROR);
        }

        if (StationRepository.stations().contains(station)) {
            throw new IllegalArgumentException(STATION_ALREADY_EXISTS_ERROR);
        }

        StationRepository.addStation(station);
    }

    public static void deleteStation(String stationName) {
        SectionRepository.findByStationName(Station.from(stationName))
                .orElseThrow(() -> new IllegalArgumentException(stationName + " " + STATION_DELETE_FAIL_MESSAGE + " " + LINE_REGISTERED_MESSAGE));

        if (!StationRepository.deleteStation(stationName)) {
            throw new IllegalArgumentException(stationName + " " + STATION_DELETE_FAIL_MESSAGE + " " + LINE_REGISTERED_MESSAGE);
        }
    }

    public static List<Station> selectStation() {
        return StationRepository.stations();
    }

}
