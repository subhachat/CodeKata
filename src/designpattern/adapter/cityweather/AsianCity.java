package designpattern.adapter.cityweather;

public class AsianCity implements City{
    private String name;
    private double temperature;
    private boolean hasWeatherWarning = false;

    public AsianCity(String name, double temperature){
        this.name = name;
        this.temperature = (temperature-32)/1.8;
        /*if (temperature > 38.0d){
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
        return "°C";
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
