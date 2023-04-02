package org.sber;

import org.sber.models.City;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CityFinder {

    public static int getIndexOfCityWithMaxPopulation(List<City> cities) {
        var maxPopulationIndex = -1;

        var maxPopulation = -1L;
        var curPopulation = maxPopulation;
        for (var index = 0; index < cities.size(); index++) {
            curPopulation = cities.get(index).getPopulation();

            if (curPopulation > maxPopulation) {
                maxPopulationIndex = index;
                maxPopulation = curPopulation;
            }
        }

        return maxPopulationIndex;
    }

    public static Map<String, Integer> getRegionsWithCityCount(List<City> cities) {
        final var regionsCityCount = new HashMap<String, Integer>();

        cities.forEach(city -> regionsCityCount.put(city.getRegion(),
                regionsCityCount.getOrDefault(city.getRegion(), 0) + 1));
        return regionsCityCount;
    }
}
