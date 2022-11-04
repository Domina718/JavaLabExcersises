package org.mqtt;

import java.util.Random;

public class Sensor {
    private String name;
    private float value;
    private int factor;
    private int rangeLow;
    private int rangeHigh;
    private String unit;

    public Sensor(String name, int factor, int rangeLow, int rangeHigh, String unit) {
        this.name = name;
        this.factor = factor;
        this.rangeLow = rangeLow;
        this.rangeHigh = rangeHigh;
        this.unit = unit;
        setSensor();
    }

    private void setSensor() {
        if (factor != 0) {
            this.value = (float) getRandomNumber(rangeLow, rangeHigh) / factor;
        } else {
            this.value = (float) getRandomNumber(rangeLow, rangeHigh);
        }
    }

    private int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    @Override
    public String toString() {
        return "\n" + name + " je " + value + " " + unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public int getFactor() {
        return factor;
    }

    public void setFactor(int factor) {
        this.factor = factor;
    }

    public int getRangeLow() {
        return rangeLow;
    }

    public void setRangeLow(int rangeLow) {
        this.rangeLow = rangeLow;
    }

    public int getRangeHigh() {
        return rangeHigh;
    }

    public void setRangeHigh(int rangeHigh) {
        this.rangeHigh = rangeHigh;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
