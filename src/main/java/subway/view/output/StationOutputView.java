package subway.view.output;

import subway.command.StationCommand;
import subway.domain.Station;

import java.util.List;

public class StationOutputView extends OutputView {
    private static final String STATION_MANAGEMENT_TITLE = "## 역 관리 화면";
    private static final String PRINT_STATION_TITLE = "## 역 목록";

    public static void printStationManagement() {
        StringBuilder out = new StringBuilder(STATION_MANAGEMENT_TITLE).append("\n");

        for (StationCommand stationCommand : StationCommand.values()) {
            out.append(stationCommand.getDescription()).append("\n");
        }

        System.out.println(out);
    }

    public static void printStation(List<Station> stations) {
        StringBuilder out = new StringBuilder(PRINT_STATION_TITLE).append("\n");
        for (Station station : stations) {
            out.append(INFO_FORMAT).append(" ").append(station.getName()).append("\n");
        }
        System.out.println(out);
    }

    public static void printError(String message) {
        StringBuilder out = new StringBuilder(ERROR_FORMAT);
        out.append(message).append("\n");
        System.out.println(out);
    }

}
