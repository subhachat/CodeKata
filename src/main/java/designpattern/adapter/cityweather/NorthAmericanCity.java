package designpattern.adapter.cityweather;

public class NorthAmericanCity implements City {
    private String name;
    private double temperature;
    private boolean hasWeatherWarning = false;

    public NorthAmericanCity(String name, double temperature) {
        this.name = name;
        this.temperature = temperature;
        /*if (temperature > 100.4d) {
            this.hasWeatherWarning = true;
        }*/
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getTemperature() {
        return this.temperature;
    }

    @Override
    public String getTemperatureScale() {
        return "°F";
    }

    @Override
    public boolean getHasWeatherWarning() {
        return this.hasWeatherWarning;
    }

    @Override
    public void setHasWeatherWarning(boolean hasWeatherWarning) {
        this.hasWeatherWarning = hasWeatherWarning;
    }
}
