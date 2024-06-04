package subway.view.output;

import subway.command.LineCommand;
import subway.domain.Line;

import java.util.List;

public class LineOutPutView extends OutputView {
    private static final String LINE_MANAGEMENT_TITLE = "## 노선 관리 화면";
    private static final String PRINT_LINE_TITLE = "## 노선 목록";

    public static void printLineManagement() {
        StringBuilder out = new StringBuilder(LINE_MANAGEMENT_TITLE).append("\n");

        for (LineCommand lineCommand : LineCommand.values()) {
            out.append(lineCommand.getDescription()).append("\n");
        }

        System.out.println(out);
    }

    public static void printLines(List<Line> lines) {
        StringBuilder out = new StringBuilder(PRINT_LINE_TITLE).append("\n");
        for (Line line : lines) {
            out.append(INFO_FORMAT).append(" ").append(line.getName()).append("\n");
        }
        System.out.println(out);
    }

    public static void printError(String message) {
        StringBuilder out = new StringBuilder(ERROR_FORMAT);
        out.append(message).append("\n");
        System.out.println(out);
    }

}
