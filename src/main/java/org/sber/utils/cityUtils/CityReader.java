package org.sber.utils.cityUtils;

import org.sber.models.City;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class CityReader {
    public final static String DEFAULT_CITIES_FILE = "src/main/resources/Задача ВС Java Сбер.csv";

    public static List<City> read() throws IOException, ParseException {
        final var cities = new ArrayList<City>();

        var lineNumber = 1;
        try (var reader = new BufferedReader(new FileReader(DEFAULT_CITIES_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                cities.add(parseStringCity(line, lineNumber++));
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File not found: " + DEFAULT_CITIES_FILE);
        } catch (IOException e) {
            throw new IOException("Error reading file: " + e.getMessage());
        }

        return cities;
    }

    private static City parseStringCity(String line, int lineNumber) throws ParseException {
        try {
            final var cityParams = line.split(";");

            return new City.CityBuilder()
                    .setName(cityParams[1])
                    .setRegion(cityParams[2])
                    .setDistrict(cityParams[3])
                    .setPopulation(Long.parseLong(cityParams[4]))
                    .setFoundation(cityParams.length < 6? "" : cityParams[5])
                    .build();
        } catch (Exception e) {
            throw new ParseException(String.format("Error parsing line %d: %s", lineNumber,
                    e.getMessage()), lineNumber);
        }
    }
}
