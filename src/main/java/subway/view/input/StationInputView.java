package subway.view.input;

public class StationInputView extends InputView {
    private static final String ENTER_ADD_STATION_NAME_PROMPT = "## 등록할 역 이름을 입력하세요.";
    private static final String ENTER_DELETE_STATION_NAME_PROMPT = "## 삭제할 역 이름을 입력하세요.";

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

}
