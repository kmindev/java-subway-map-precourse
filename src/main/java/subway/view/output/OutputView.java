package subway.view.output;

public class OutputView {
    protected static final String INFO_FORMAT = "[INFO] ";
    protected static final String ERROR_FORMAT = "[ERROR] ";

    public static void printInfo(String message) {
        StringBuilder out = new StringBuilder(INFO_FORMAT);
        out.append(message).append("\n");
        System.out.println(out);
    }

}
