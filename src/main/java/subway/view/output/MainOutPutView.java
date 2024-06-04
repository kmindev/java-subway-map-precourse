package subway.view.output;

import subway.command.MainCommand;

public class MainOutPutView extends OutputView {
    private static final String MAIN_TITLE = "## 메인화면";

    public static void printMain() {
        StringBuilder out = new StringBuilder(MAIN_TITLE).append("\n");

        for (MainCommand mainCommand : MainCommand.values()) {
            out.append(mainCommand.getDescription()).append("\n");
        }

        System.out.println(out);
    }

    public static void printError(String message) {
        StringBuilder out = new StringBuilder(ERROR_FORMAT);
        out.append(message).append("\n");
        System.out.println(out);
    }

}
