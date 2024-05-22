package subway.service;

import subway.command.MainCommand;
import subway.view.InputView;
import subway.view.OutputView;

public class MainService {

    public static void run() {
        OutputView.printMain();
        try {
            MainCommand mainCommand = InputView.readMainCommand();
            mainCommand.execute();
        } catch (Exception e) {
            OutputView.printError(e.getMessage());
            MainService.run();
        }
    }

    public static void stationManagement() {
        StationService.run();
    }

    public static void quit() {
    }
}
