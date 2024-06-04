package subway.command;

import subway.controller.SectionController;

public enum SectionCommand {
    ADD_SECTION("1", "1. 구간 등록", SectionController::addSection),
    DELETE_SECTION("2", "2. 구간 삭제", SectionController::deleteSection),
    BACK("B", "B. 돌아가기", SectionController::back);

    private static final String ERROR_MESSAGE = "지원하지 않는 기능입니다.";

    private final String command;
    private final String description;
    private final Runnable action;

    SectionCommand(String command, String description, Runnable action) {
        this.command = command;
        this.description = description;
        this.action = action;
    }

    public String getDescription() {
        return description;
    }

    public static SectionCommand getSectionCommandType(String command) {
        for (SectionCommand sectionCommand : SectionCommand.values()) {
            if (command.equals(sectionCommand.command)) {
                return sectionCommand;
            }
        }

        throw new IllegalArgumentException(ERROR_MESSAGE);
    }

    public void execute() {
        action.run();
    }

}
