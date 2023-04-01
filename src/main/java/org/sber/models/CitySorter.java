package org.sber.models;

import java.util.Comparator;
import java.util.List;

public class CitySorter {

    public static void sortByName(List<City> cities) {
        if (cities == null) return;
        cities.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
    }

    public static void sortByDistrictThenName(List<City> cities) {
        if (cities == null) return;
        cities.sort(Comparator.comparing(City::getDistrict).thenComparing(City::getName));
    }
}
