package com.milovanjakovljevic.weather_app.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.milovanjakovljevic.weather_app.models.WeatherModel;

public class WeatherResponse {

    @SerializedName("main")
    @Expose
    private WeatherModel weather;

    public WeatherModel getWeather(){
        return weather;
    }

    @Override
    public String toString() {
        return "WeatherResponse{" +
                "weather=" + weather +
                '}';
    }
}
