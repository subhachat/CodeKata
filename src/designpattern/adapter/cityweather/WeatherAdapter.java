package designpattern.adapter.cityweather;

public class WeatherAdapter implements City {

    private City city;

    public WeatherAdapter(City city) {
        this.city = city;
        if ((this.city.getTemperatureScale().equals("°C") && this.city.getTemperature() > 38)
                || (this.city.getTemperatureScale().equals("°F") && this.city.getTemperature() > 100)) {
            this.setHasWeatherWarning(true);
        }
    }

    @Override
    public String getName() {
        return city.getName();
    }

    @Override
    public double getTemperature() {
        return city.getTemperature();
    }

    @Override
    public String getTemperatureScale() {
        return city.getTemperatureScale();
    }

    @Override
    public boolean getHasWeatherWarning() {
        return city.getHasWeatherWarning();
    }

    @Override
    public void setHasWeatherWarning(boolean hasWeatherWarning) {
        city.setHasWeatherWarning(hasWeatherWarning);
    }
}
