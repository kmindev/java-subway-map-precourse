package subway.view.input;

public class LineInputView extends InputView {
    private static final String ENTER_ADD_LINE_NAME_PROMPT = "## 등록할 노선 이름을 입력하세요.";
    private static final String ENTER_DELETE_LINE_NAME_PROMPT = "## 삭제할 노선 이름을 입력하세요.";
    private static final String ENTER_LINE_IN_UP_STATION_NAME_PROMPT = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String ENTER_LINE_IN_DOWN_STATION_NAME_PROMPT = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";

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
