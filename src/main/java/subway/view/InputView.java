package subway.view;

import subway.command.MainCommand;
import subway.command.StationCommand;
import subway.domain.Station;

import java.util.Scanner;

public class InputView {
    private static final String SELECT_COMMAND_PROMPT = "## 원하는 기능을 선택하세요.";
    private static final String ENTER_ADD_STATION_NAME_PROMPT = "## 등록할 역 이름을 입력하세요.";
    private static final String ENTER_DELETE_STATION_NAME_PROMPT = "## 삭제할 역 이름을 입력하세요.";

    private static final Scanner scanner = new Scanner(System.in);

    public static MainCommand readMainCommand() {
        System.out.println(SELECT_COMMAND_PROMPT);
        String command = scanner.next();
        System.out.println();

        return MainCommand.getMainCommandType(command);
    }

    public static StationCommand readStationManagementCommand() {
        System.out.println(SELECT_COMMAND_PROMPT);
        String command = scanner.next();
        System.out.println();

        return StationCommand.getStationCommandType(command);
    }

    public static Station readAddStationName() {
        System.out.println(ENTER_ADD_STATION_NAME_PROMPT);
        String stationName = scanner.next();
        System.out.println();

        return Station.from(stationName);
    }

    public static Station readDeleteStationName() {
        System.out.println(ENTER_DELETE_STATION_NAME_PROMPT);
        String stationName = scanner.next();
        System.out.println();

        return Station.from(stationName);
    }

}
