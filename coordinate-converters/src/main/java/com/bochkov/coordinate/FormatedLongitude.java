package com.bochkov.coordinate;

/**
 * Created by bochkov on 12.07.17.
 */
public class FormatedLongitude extends LongitudeConverter {
    Number coordinate;

    public FormatedLongitude(Number coordinate) {
        this.coordinate = coordinate;
    }

    public FormatedLongitude() {
    }

    @Override
    public String toString() {
        if (coordinate != null) {
            return super.getAsString(coordinate.floatValue());
        }
        return "";
    }
}
