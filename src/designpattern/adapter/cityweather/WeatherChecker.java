package designpattern.adapter.cityweather;

import java.util.Objects;

public class WeatherChecker {
    public static void main(String... args) {
        City chicago = new NorthAmericanCity("Chicago", 16);
        WeatherAdapter northamWeather1 = new WeatherAdapter(chicago);
        printWarning(chicago);

        City phoenix = new NorthAmericanCity("Phoenix", 102);
        WeatherAdapter northamWeather2 = new WeatherAdapter(phoenix);
        printWarning(phoenix);

        City bangkok = new AsianCity("Bangkok", 104);
        WeatherAdapter asianWeather1 = new WeatherAdapter(bangkok);
        printWarning(asianWeather1);

        City osaka = new AsianCity("Osaka", 42);
        WeatherAdapter asianWeather2 = new WeatherAdapter(osaka);
        printWarning(asianWeather2);
    }

    public static void printWarning(City city) {
        Objects.requireNonNull(city);
        if (city.getHasWeatherWarning()) {
            System.out.println("Warning! High temperature alert in {" + city.getName() + "}. Currently it is " + city.getTemperature() + city.getTemperatureScale());
        } else {
            System.out.println("Temperature in " + city.getName() + " is OK.");
        }
    }
}
