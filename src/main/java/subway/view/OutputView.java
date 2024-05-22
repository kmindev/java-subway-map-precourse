package subway.view;

import subway.command.MainCommand;
import subway.command.StationCommand;

import java.util.List;

public class OutputView {
    private static final String MAIN_TITLE = "## 메인화면";
    private static final String STATION_MANAGEMENT_TITLE = "## 역 관리 화면";
    private static final String INFO_FORMAT = "[INFO] ";
    private static final String ERROR_FORMAT = "[ERROR] ";

    public static void printMain() {
        StringBuilder out = new StringBuilder(MAIN_TITLE).append("\n");

        for (MainCommand mainCommand : MainCommand.values()) {
            out.append(mainCommand.getDescription()).append("\n");
        }

        System.out.println(out);
    }

    public static void printStationManagement() {
        StringBuilder out = new StringBuilder(STATION_MANAGEMENT_TITLE).append("\n");

        for (StationCommand stationCommand : StationCommand.values()) {
            out.append(stationCommand.getDescription()).append("\n");
        }

        System.out.println(out);
    }

    public static void printInfo(String message) {
        StringBuilder out = new StringBuilder(INFO_FORMAT);
        out.append(message).append("\n");
        System.out.println(out);
    }

    public static void printInfo(List<String> messages) {
        StringBuilder out = new StringBuilder();
        for (String message : messages) {
            out.append(INFO_FORMAT).append(message).append("\n");
        }
        System.out.println(out);
    }

    public static void printError(String message) {
        StringBuilder out = new StringBuilder(ERROR_FORMAT);
        out.append(message).append("\n");
        System.out.println(out);
    }

}
