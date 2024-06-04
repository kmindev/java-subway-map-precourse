package subway.controller;

import subway.command.MainCommand;
import subway.view.output.MainOutPutView;
import subway.view.input.MainInputView;

public class MainController {

    public static void run() {
        MainOutPutView.printMain();
        try {
            String readMainCommand = MainInputView.readMainCommand();
            MainCommand mainCommand = MainCommand.getMainCommandType(readMainCommand);
            mainCommand.execute();
        } catch (Exception e) {
            MainOutPutView.printError(e.getMessage());
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

    public static void printLines() {
        SectionController.printLines();
    }

    public static void quit() {
    }

}
