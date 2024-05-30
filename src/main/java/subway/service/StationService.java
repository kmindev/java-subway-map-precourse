package subway.service;

import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.List;


public class StationService {

    public static void addStation(Station station) {
        StationRepository.addStation(station);
    }

    public static void deleteStation(String stationName) {
        StationRepository.deleteStation(stationName);
    }

    public static List<Station> selectStation() {
        return StationRepository.stations();
    }

}
