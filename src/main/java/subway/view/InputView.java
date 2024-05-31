package subway.view;

import java.util.Scanner;

public class InputView {
    private static final String SELECT_COMMAND_PROMPT = "## 원하는 기능을 선택하세요.";
    private static final String ENTER_ADD_STATION_NAME_PROMPT = "## 등록할 역 이름을 입력하세요.";
    private static final String ENTER_DELETE_STATION_NAME_PROMPT = "## 삭제할 역 이름을 입력하세요.";
    private static final String ENTER_ADD_LINE_NAME_PROMPT = "## 등록할 노선 이름을 입력하세요.";
    private static final String ENTER_DELETE_LINE_NAME_PROMPT = "## 삭제할 노선 이름을 입력하세요.";
    private static final String ENTER_LINE_IN_UP_STATION_NAME_PROMPT = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String ENTER_LINE_IN_DOWN_STATION_NAME_PROMPT = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";

    private static final Scanner scanner = new Scanner(System.in);

    // Main
    public static String readMainCommand() {
        System.out.println(SELECT_COMMAND_PROMPT);
        String command = scanner.next();
        System.out.println();

        return command;
    }

    // Station
    public static String readStationManagementCommand() {
        System.out.println(SELECT_COMMAND_PROMPT);
        String command = scanner.next();
        System.out.println();

        return command;
    }

    public static String readAddStationName() {
        System.out.println(ENTER_ADD_STATION_NAME_PROMPT);
        String stationName = scanner.next();
        System.out.println();

        return stationName;
    }

    public static String readDeleteStationName() {
        System.out.println(ENTER_DELETE_STATION_NAME_PROMPT);
        String stationName = scanner.next();
        System.out.println();

        return stationName;
    }

    // Line
    public static String readLineManagementCommand() {
        System.out.println(SELECT_COMMAND_PROMPT);
        String command = scanner.next();
        System.out.println();

        return command;
    }

    public static String readAddLineName() {
        System.out.println(ENTER_ADD_LINE_NAME_PROMPT);
        String lineName = scanner.next();
        System.out.println();

        return lineName;
    }

    public static String readUpStationName() {
        System.out.println(ENTER_LINE_IN_UP_STATION_NAME_PROMPT);
        String stationName = scanner.next();
        System.out.println();

        return stationName;
    }

    public static String readDownStationName() {
        System.out.println(ENTER_LINE_IN_DOWN_STATION_NAME_PROMPT);
        String stationName = scanner.next();
        System.out.println();

        return stationName;
    }

    public static String readDeleteLineName() {
        System.out.println(ENTER_DELETE_LINE_NAME_PROMPT);
        String lineName = scanner.next();
        System.out.println();

        return lineName;
    }

}
