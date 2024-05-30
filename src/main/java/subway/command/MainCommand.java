package subway.command;

import subway.controller.MainController;

public enum MainCommand {
    STATION_MANAGEMENT("1", "1. 역 관리", MainController::stationManagement),
    QUIT("Q", "Q. 종료", MainController::quit);

    private static final String ERROR_MESSAGE = "지원하지 않는 기능입니다.";

    private final String command;
    private final String description;
    private final Runnable action;

    MainCommand(String command, String description, Runnable action) {
        this.command = command;
        this.description = description;
        this.action = action;
    }

    public String getDescription() {
        return description;
    }

    public static MainCommand getMainCommandType(String command) {
        for (MainCommand mainCommand : MainCommand.values()) {
            if (command.equals(mainCommand.command)) {
                return mainCommand;
            }
        }
        throw new IllegalArgumentException(ERROR_MESSAGE);
    }

    public void execute() {
        action.run();
    }
}
