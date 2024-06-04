package subway.view.input;

public class SectionInputView extends InputView {
    private static final String ENTER_LINE_NAME_PROMPT = "## 노선을 입력하세요.";
    private static final String ENTER_STATION_NAME_PROMPT = "## 역이름을 입력하세요.";
    private static final String ENTER_STATION_ORDER_PROMPT = "## 순서를 입력하세요.";
    private static final String ENTER_DELETE_LINE_NAME_IN_SECTION_PROMPT = "## 삭제할 구간의 노선을 입력하세요.";
    private static final String ENTER_DELETE_STATION_NAME_IN_SECTION_PROMPT = "## 삭제할 구간의 역을 입력하세요.";

    public static String readSectionCommand() {
        System.out.println(SELECT_COMMAND_PROMPT);
        String command = scanner.next();
        System.out.println();

        return command;
    }

    public static String readLineName() {
        System.out.println(ENTER_LINE_NAME_PROMPT);
        String lineName = scanner.next();
        System.out.println();

        return lineName;
    }

    public static String readStationName() {
        System.out.println(ENTER_STATION_NAME_PROMPT);
        String stationName = scanner.next();
        System.out.println();

        return stationName;
    }

    public static String readSectionOrder() {
        System.out.println(ENTER_STATION_ORDER_PROMPT);
        String order = scanner.next();
        System.out.println();

        return order;
    }

    public static String readDeleteLineNameInSection() {
        System.out.println(ENTER_DELETE_LINE_NAME_IN_SECTION_PROMPT);
        String lineName = scanner.next();
        System.out.println();

        return lineName;
    }

    public static String readDeleteStationNameInSection() {
        System.out.println(ENTER_DELETE_STATION_NAME_IN_SECTION_PROMPT);
        String stationName = scanner.next();
        System.out.println();

        return stationName;
    }

}
