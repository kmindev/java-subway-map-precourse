package subway.controller;

import subway.command.LineCommand;
import subway.domain.Line;
import subway.domain.Station;
import subway.service.LineService;
import subway.view.input.LineInputView;
import subway.view.output.LineOutPutView;

import java.util.List;

public class LineController {
    private static final String ADD_LINE_SUCCESS_MESSAGE = "노선이 등록되었습니다.";
    private static final String DELETE_LINE_SUCCESS_MESSAGE = "노선이 삭제되었습니다.";

    public static void run() {
        LineOutPutView.printLineManagement();
        try {
            String readLineCommand = LineInputView.readLineManagementCommand();
            LineCommand lineCommand = LineCommand.getLineCommandType(readLineCommand);

            lineCommand.execute();
        } catch (Exception e) {
            LineOutPutView.printError(e.getMessage());
            MainController.run();
        }
    }

    public static void addLine() {
        try {
            String addLineName = LineInputView.readAddLineName();
            String upStationName = LineInputView.readUpStationName();
            String downStationName = LineInputView.readDownStationName();

            LineService.addLine(Line.from(addLineName), Station.from(upStationName), Station.from(downStationName));

            LineOutPutView.printInfo(ADD_LINE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            LineOutPutView.printError(e.getMessage());
        }
        MainController.run();
    }

    public static void deleteLine() {
        try {
            String deleteLineName = LineInputView.readDeleteLineName();

            LineService.deleteLineByName(deleteLineName);

            LineOutPutView.printInfo(DELETE_LINE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            LineOutPutView.printError(e.getMessage());
        }
        MainController.run();
    }

    public static void selectLine() {
        List<Line> lines = LineService.selectLines();
        LineOutPutView.printLines(lines);
        MainController.run();
    }

    public static void back() {
        MainController.run();
    }

}
