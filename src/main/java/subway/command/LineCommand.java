package subway.command;


import subway.controller.LineController;

public enum LineCommand {
    ADD_LINE("1", "1. 노선 등록", LineController::addLine),
    DELETE_LINE("2", "2. 노선 삭제", LineController::deleteLine),
    SELECT_LINE("3", "3. 노선 조회", LineController::selectLine),
    BACK("B", "B. 돌아가기", LineController::back);

    private static final String ERROR_MESSAGE = "지원하지 않는 기능입니다.";

    private final String command;
    private final String description;
    private final Runnable action;

    LineCommand(String command, String description, Runnable action) {
        this.command = command;
        this.description = description;
        this.action = action;
    }

    public String getDescription() {
        return description;
    }

    public static LineCommand getStationCommandType(String command) {
        for (LineCommand lineCommand : LineCommand.values()) {
            if (command.equals(lineCommand.command)) {
                return lineCommand;
            }
        }

        throw new IllegalArgumentException(ERROR_MESSAGE);
    }

    public void execute() {
        action.run();
    }

}
