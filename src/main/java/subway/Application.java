package subway;

import subway.controller.MainController;
import subway.domain.Line;
import subway.domain.Section;
import subway.domain.Station;
import subway.service.LineService;
import subway.service.StationService;

public class Application {
    public static void main(String[] args) {
        init();
        MainController.run();
    }

    private static void init() {
        stationInit();
        lineInit();
    }

    private static void stationInit() {
        Station[] stations = {
                Station.from("교대역"),
                Station.from("강남역"),
                Station.from("역삼역"),
                Station.from("남부터미널역"),
                Station.from("양재역"),
                Station.from("양재시민의숲역"),
                Station.from("매봉역"),
        };

        for (Station station : stations) {
            StationService.addStation(station);
        }
    }

    private static void lineInit() {
        Section[] sections = {
                Section.of(Line.from("2호선"),
                        Station.from("교대역"),
                        Station.from("강남역"),
                        Station.from("역삼역")),

                Section.of(Line.from("3호선"),
                        Station.from("교대역"),
                        Station.from("남부터미널역"),
                        Station.from("양재역"),
                        Station.from("매봉역")),

                Section.of(Line.from("신분당선"),
                        Station.from("강남역"),
                        Station.from("양재역"),
                        Station.from("양재시민의숲역"))
        };

        for (Section section : sections) {
            LineService.addLine(section.getLine(), section.getStations().toArray(new Station[0]));
        }
    }


}
