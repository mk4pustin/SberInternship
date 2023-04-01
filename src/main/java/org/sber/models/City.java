package org.sber.models;

public class City {
    private String name;
    private String region;
    private String district;
    private long population;
    private String foundation;

    public City() {
    }

    public City(String name, String region, String district, long population, String foundation) {
        this.name = name;
        this.region = region;
        this.district = district;
        this.population = population;
        this.foundation = foundation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public String getFoundation() {
        return foundation;
    }

    public void setFoundation(String foundation) {
        this.foundation = foundation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final var city = (City) o;

        if (population != city.population) return false;
        if (!name.equals(city.name)) return false;
        if (!region.equals(city.region)) return false;
        if (!district.equals(city.district)) return false;
        return foundation.equals(city.foundation);
    }

    @Override
    public int hashCode() {
        final var simpleNumber = 31;

        var result = name.hashCode();
        result = simpleNumber * result + region.hashCode();
        result = simpleNumber * result + district.hashCode();
        result = simpleNumber * result + (int) (population ^ (population >>> simpleNumber + 1));
        result = simpleNumber * result + foundation.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                ", foundation='" + foundation + '\'' +
                '}';
    }

    public static class CityBuilder {
        private final City city;

        public CityBuilder() {
            city = new City();
        }

        public CityBuilder setName(String name) {
            city.setName(name);
            return this;
        }

        public CityBuilder setRegion(String region) {
            city.setRegion(region);
            return this;
        }

        public CityBuilder setDistrict(String district) {
            city.setDistrict(district);
            return this;
        }

        public CityBuilder setPopulation(long population) {
            city.setPopulation(population);
            return this;
        }

        public CityBuilder setFoundation(String foundation) {
            city.setFoundation(foundation);
            return this;
        }

        public City build() {
            return city;
        }
    }
}
