package subway.view.output;

import subway.command.SectionCommand;
import subway.domain.Section;
import subway.domain.Station;

import java.util.List;

public class SectionOutPutView extends OutputView {
    private static final String SECTION_MANAGEMENT_TITLE = "## 구간 관리 화면";

    public static void printSectionManagement() {
        StringBuilder out = new StringBuilder(SECTION_MANAGEMENT_TITLE).append("\n");

        for (SectionCommand sectionCommand : SectionCommand.values()) {
            out.append(sectionCommand.getDescription()).append("\n");
        }

        System.out.println(out);
    }

    public static void printAllSection(List<Section> sections) {
        StringBuilder out = new StringBuilder();
        for (Section section : sections) {
            out.append(INFO_FORMAT).append(section.getLine().getName()).append("\n");
            out.append(INFO_FORMAT).append("---").append("\n");

            for (Station station : section.getStations()) {
                out.append(INFO_FORMAT).append(station.getName()).append("\n");
            }
            out.append("\n");
        }
        System.out.print(out);
    }

    public static void printError(String message) {
        StringBuilder out = new StringBuilder(ERROR_FORMAT);
        out.append(message).append("\n");
        System.out.println(out);
    }

}
