package subway.controller;

import subway.command.SectionCommand;
import subway.domain.Line;
import subway.domain.Section;
import subway.domain.Station;
import subway.service.SectionService;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class SectionController {
    private static final String ADD_SECTION_SUCCESS_MESSAGE = "구간이 등록되었습니다.";
    private static final String DELETE_SECTION_SUCCESS_MESSAGE = "구간이 삭제되었습니다.";

    public static void run() {
        OutputView.printSectionManagement();
        try {
            String readSectionCommand = InputView.readSectionCommand();
            SectionCommand sectionCommand = SectionCommand.getSectionCommandType(readSectionCommand);

            sectionCommand.execute();
        } catch (Exception e) {
            OutputView.printError(e.getMessage());
            MainController.run();
        }
    }

    public static void addSection() {
        try {
            String readLineName = InputView.readLineName();
            String readStationName = InputView.readStationName();
            String readSectionOrder = InputView.readSectionOrder();

            SectionService.addSection(Line.from(readLineName), Station.from(readStationName), Integer.parseInt(readSectionOrder) - 1);

            OutputView.printInfo(ADD_SECTION_SUCCESS_MESSAGE);
        } catch (Exception e) {
            OutputView.printError(e.getMessage());
        }
        MainController.run();
    }

    public static void deleteSection() {
        try {
            String deleteLineNameInSection = InputView.readDeleteLineNameInSection();
            String deleteStationNameInSection = InputView.readDeleteStationNameInSection();
            SectionService.deleteSection(Line.from(deleteLineNameInSection), Station.from(deleteStationNameInSection));

            OutputView.printInfo(DELETE_SECTION_SUCCESS_MESSAGE);
        } catch (Exception e) {
            OutputView.printError(e.getMessage());
        }
        MainController.run();
    }

    public static void back() {
        MainController.run();
    }

    public static void printLines() {
        List<Section> sections = SectionService.findAll();
        List<String> printLines = new ArrayList<>();

        for (Section section : sections) {
            printLines.add(section.getLine().getName());
            printLines.add("---");
            for (Station station : section.getStations()) {
                printLines.add(station.getName());
            }
        }

        OutputView.printInfo(printLines);
    }
}
