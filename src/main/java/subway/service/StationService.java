package subway.service;

import subway.command.StationCommand;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;


public class StationService {
    private static final String ADD_STATION_SUCCESS_MESSAGE = "지하철 역이 등록되었습니다.";
    private static final String DELETE_STATION_SUCCESS_MESSAGE = "지하철 역이 삭제되었습니다.";

    public static void run() {
        OutputView.printStationManagement();
        StationCommand stationCommand = InputView.readStationManagementCommand();
        stationCommand.execute();
    }

    public static void addStation() {
        try {
            Station station = InputView.readAddStationName();
            StationRepository.addStation(station);
            OutputView.printInfo(ADD_STATION_SUCCESS_MESSAGE);
        } catch (Exception e) {
            OutputView.printError(e.getMessage());
        }

        MainService.run();
    }

    public static void deleteStation() {
        try {
            Station station = InputView.readDeleteStationName();
            StationRepository.deleteStation(station.getName());
            OutputView.printInfo(DELETE_STATION_SUCCESS_MESSAGE);
        } catch (Exception e) {
            OutputView.printError(e.getMessage());
        }
        MainService.run();
    }

    public static void selectStation() {
        List<Station> stations = StationRepository.stations();
        OutputView.printInfo(stations.stream().map(Station::getName).collect(Collectors.toList()));

        MainService.run();
    }

    public static void back() {
        MainService.run();
    }

}
