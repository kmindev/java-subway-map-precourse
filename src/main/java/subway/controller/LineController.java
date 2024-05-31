package subway.controller;

import subway.command.LineCommand;
import subway.domain.Line;
import subway.domain.Station;
import subway.service.LineService;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LineController {
    private static final String ADD_LINE_SUCCESS_MESSAGE = "노선이 등록되었습니다.";
    private static final String DELETE_LINE_SUCCESS_MESSAGE = "노선이 삭제되었습니다.";

    public static void run() {
        OutputView.printLineManagement();
        try {
            String readLineCommand = InputView.readLineManagementCommand();
            LineCommand lineCommand = LineCommand.getStationCommandType(readLineCommand);

            lineCommand.execute();
        } catch (Exception e) {
            OutputView.printError(e.getMessage());
            MainController.run();
        }
    }

    public static void addLine() {
        try {
            String addLineName = InputView.readAddLineName();
            String upStationName = InputView.readUpStationName();
            String downStationName = InputView.readDownStationName();

            LineService.addLine(Line.from(addLineName), Station.from(upStationName), Station.from(downStationName));

            OutputView.printInfo(ADD_LINE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            OutputView.printError(e.getMessage());
        }
        MainController.run();
    }

    public static void deleteLine() {
        try {
            String deleteLineName = InputView.readDeleteLineName();

            LineService.deleteLineByName(deleteLineName);

            OutputView.printInfo(DELETE_LINE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            OutputView.printError(e.getMessage());
        }
        MainController.run();
    }

    public static void selectLine() {
        List<Line> lines = LineService.selectLines();

        OutputView.printInfo(lines.stream().map(Line::getName).collect(Collectors.toList()));

        MainController.run();
    }

    public static void back() {
        MainController.run();
    }
}
