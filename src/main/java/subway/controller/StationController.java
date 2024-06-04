package subway.controller;

import subway.command.StationCommand;
import subway.domain.Station;
import subway.service.StationService;
import subway.view.input.StationInputView;
import subway.view.output.StationOutputView;

import java.util.List;

public class StationController {
    private static final String ADD_STATION_SUCCESS_MESSAGE = "지하철 역이 등록되었습니다.";
    private static final String DELETE_STATION_SUCCESS_MESSAGE = "지하철 역이 삭제되었습니다.";

    public static void run() {
        StationOutputView.printStationManagement();
        try {
            String readStationCommand = StationInputView.readStationManagementCommand();
            StationCommand stationCommand = StationCommand.getStationCommandType(readStationCommand);
            stationCommand.execute();
        } catch (Exception e) {
            StationOutputView.printError(e.getMessage());
            MainController.run();
        }
    }

    public static void addStation() {
        try {
            String readAddStationName = StationInputView.readAddStationName();
            Station station = Station.from(readAddStationName);
            StationService.addStation(station);
            StationOutputView.printInfo(ADD_STATION_SUCCESS_MESSAGE);
        } catch (Exception e) {
            StationOutputView.printError(e.getMessage());
        }

        MainController.run();
    }

    public static void deleteStation() {
        try {
            String readDeleteStationName = StationInputView.readDeleteStationName();
            StationService.deleteStation(readDeleteStationName);
            StationOutputView.printInfo(DELETE_STATION_SUCCESS_MESSAGE);
        } catch (Exception e) {
            StationOutputView.printError(e.getMessage());
        }
        MainController.run();
    }

    public static void selectStation() {
        List<Station> stations = StationService.selectStation();
        StationOutputView.printStation(stations);
        MainController.run();
    }

    public static void back() {
        MainController.run();
    }

}
