package com.milovanjakovljevic.weather_app.models;

import android.os.Parcel;
import android.os.Parcelable;

public class WeatherModel implements Parcelable {
    private Double temp;
    private Double temp_min;
    private Double temp_max;
    private Double feels_like;

    public WeatherModel(Double temp, Double temp_min, Double temp_max, Double feels_like) {
        this.temp = temp;
        this.temp_min = temp_min;
        this.temp_max = temp_max;
        this.feels_like = feels_like;
    }

    protected WeatherModel(Parcel in) {
        if (in.readByte() == 0) {
            temp = null;
        } else {
            temp = in.readDouble();
        }
        if (in.readByte() == 0) {
            temp_min = null;
        } else {
            temp_min = in.readDouble();
        }
        if (in.readByte() == 0) {
            temp_max = null;
        } else {
            temp_max = in.readDouble();
        }
        if (in.readByte() == 0) {
            feels_like = null;
        } else {
            feels_like = in.readDouble();
        }
    }

    public static final Creator<WeatherModel> CREATOR = new Creator<WeatherModel>() {
        @Override
        public WeatherModel createFromParcel(Parcel in) {
            return new WeatherModel(in);
        }

        @Override
        public WeatherModel[] newArray(int size) {
            return new WeatherModel[size];
        }
    };

    public Double getTemp() {
        return temp;
    }

    public Double getTemp_min() {
        return temp_min;
    }

    public Double getTemp_max() {
        return temp_max;
    }

    public Double getFeels_like() {
        return feels_like;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (temp == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(temp);
        }
        if (temp_min == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(temp_min);
        }
        if (temp_max == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(temp_max);
        }
        if (feels_like == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(feels_like);
        }
    }
}
