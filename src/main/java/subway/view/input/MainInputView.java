package subway.view.input;

public class MainInputView extends InputView {

    public static String readMainCommand() {
        System.out.println(SELECT_COMMAND_PROMPT);
        String command = scanner.next();
        System.out.println();

        return command;
    }

}
