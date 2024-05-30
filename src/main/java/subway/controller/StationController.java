package subway.controller;

import subway.command.StationCommand;
import subway.domain.Station;
import subway.service.StationService;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class StationController {
    private static final String ADD_STATION_SUCCESS_MESSAGE = "지하철 역이 등록되었습니다.";
    private static final String DELETE_STATION_SUCCESS_MESSAGE = "지하철 역이 삭제되었습니다.";

    public static void run() {
        OutputView.printStationManagement();
        try {
            String readStationCommand = InputView.readStationManagementCommand();
            StationCommand stationCommand = StationCommand.getStationCommandType(readStationCommand);
            stationCommand.execute();
        } catch (Exception e) {
            OutputView.printError(e.getMessage());
            MainController.run();
        }
    }

    public static void addStation() {
        try {
            String readAddStationName = InputView.readAddStationName();
            Station station = Station.from(readAddStationName);
            StationService.addStation(station);
            OutputView.printInfo(ADD_STATION_SUCCESS_MESSAGE);
        } catch (Exception e) {
            OutputView.printError(e.getMessage());
        }

        MainController.run();
    }

    public static void deleteStation() {
        try {
            String readDeleteStationName = InputView.readDeleteStationName();
            StationService.deleteStation(readDeleteStationName);
            OutputView.printInfo(DELETE_STATION_SUCCESS_MESSAGE);
        } catch (Exception e) {
            OutputView.printError(e.getMessage());
        }
        MainController.run();
    }

    public static void selectStation() {
        List<Station> stations = StationService.selectStation();
        OutputView.printInfo(stations.stream().map(Station::getName).collect(Collectors.toList()));
        MainController.run();
    }

    public static void back() {
        MainController.run();
    }

}
