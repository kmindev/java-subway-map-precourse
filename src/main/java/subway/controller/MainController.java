package subway.controller;

import subway.command.MainCommand;
import subway.view.InputView;
import subway.view.OutputView;

public class MainController {

    public static void run() {
        OutputView.printMain();
        try {
            String readMainCommand = InputView.readMainCommand();
            MainCommand mainCommand = MainCommand.getMainCommandType(readMainCommand);
            mainCommand.execute();
        } catch (Exception e) {
            OutputView.printError(e.getMessage());
            MainController.run();
        }
    }

    public static void stationManagement() {
        StationController.run();
    }

    public static void lineManagement() {
        LineController.run();
    }

    public static void sectionManagement() {
        SectionController.run();
    }

    public static void quit() {
    }
}
