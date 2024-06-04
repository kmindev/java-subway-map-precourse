package subway.controller;

import subway.command.SectionCommand;
import subway.domain.Line;
import subway.domain.Section;
import subway.domain.Station;
import subway.service.SectionService;
import subway.view.input.SectionInputView;
import subway.view.output.SectionOutPutView;

import java.util.List;

public class SectionController {
    private static final String ADD_SECTION_SUCCESS_MESSAGE = "구간이 등록되었습니다.";
    private static final String DELETE_SECTION_SUCCESS_MESSAGE = "구간이 삭제되었습니다.";

    public static void run() {
        SectionOutPutView.printSectionManagement();
        try {
            String readSectionCommand = SectionInputView.readSectionCommand();
            SectionCommand sectionCommand = SectionCommand.getSectionCommandType(readSectionCommand);

            sectionCommand.execute();
        } catch (Exception e) {
            SectionOutPutView.printError(e.getMessage());
            MainController.run();
        }
    }

    public static void addSection() {
        try {
            String readLineName = SectionInputView.readLineName();
            String readStationName = SectionInputView.readStationName();
            String readSectionOrder = SectionInputView.readSectionOrder();

            SectionService.addSection(Line.from(readLineName), Station.from(readStationName), Integer.parseInt(readSectionOrder) - 1);

            SectionOutPutView.printInfo(ADD_SECTION_SUCCESS_MESSAGE);
        } catch (Exception e) {
            SectionOutPutView.printError(e.getMessage());
        }
        MainController.run();
    }

    public static void deleteSection() {
        try {
            String deleteLineNameInSection = SectionInputView.readDeleteLineNameInSection();
            String deleteStationNameInSection = SectionInputView.readDeleteStationNameInSection();
            SectionService.deleteSection(Line.from(deleteLineNameInSection), Station.from(deleteStationNameInSection));

            SectionOutPutView.printInfo(DELETE_SECTION_SUCCESS_MESSAGE);
        } catch (Exception e) {
            SectionOutPutView.printError(e.getMessage());
        }
        MainController.run();
    }

    public static void back() {
        MainController.run();
    }

    public static void printLines() {
        List<Section> sections = SectionService.findAll();
        SectionOutPutView.printAllSection(sections);
        MainController.run();
    }

}
