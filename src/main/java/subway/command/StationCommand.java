package subway.command;

import subway.controller.StationController;

public enum StationCommand {
    ADD_STATION("1", "1. 역 등록", StationController::addStation),
    DELETE_STATION("2", "2. 역 삭제", StationController::deleteStation),
    SELECT_STATION("3", "3. 역 조회", StationController::selectStation),
    BACK("B", "B. 돌아가기", StationController::back);

    private static final String ERROR_MESSAGE = "지원하지 않는 기능입니다.";

    private final String command;
    private final String description;
    private final Runnable action;

    StationCommand(String command, String description, Runnable action) {
        this.command = command;
        this.description = description;
        this.action = action;
    }

    public String getDescription() {
        return description;
    }

    public static StationCommand getStationCommandType(String command) {
        for (StationCommand stationCommand : StationCommand.values()) {
            if (command.equals(stationCommand.command)) {
                return stationCommand;
            }
        }

        throw new IllegalArgumentException(ERROR_MESSAGE);
    }

    public void execute() {
        action.run();
    }

}
