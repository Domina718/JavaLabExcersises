package org.example;

import java.awt.*;

public class MyColor {
    private int red;
    private int green;
    private int blue;

    public int getRGB(){
        String rgb = Integer.toHexString(red) + Integer.toHexString(green) + Integer.toHexString(blue);
        return Integer.parseInt(rgb,16);
    }

    public static void RGBtoCMYK(int red, int green, int blue, float[] cmykValues){
        float cyan, magenta, yellow, black;
        int maxValue = Math.max(Math.max(red, green), blue);

        if(maxValue == 0){
            cyan = 0.0f;
            magenta = 0.0f;
            yellow = 0.0f;
            black = 1.0f;

        } else {

            float white = maxValue / 255.0f;
            cyan = (white - red / 255.f) / white;
            magenta = (white - green / 255.0f) / white;
            yellow = (white - blue / 255.f) / white;
            black = 1.0f - white;
        }

        cmykValues[0] = cyan;
        cmykValues[1] = magenta;
        cmykValues[2] = yellow;
        cmykValues[3] = black;
    }

    public static void RGBtoHSL(int r, int g, int b, float[] hslValues){
        float hue = 0.0f, saturation, lightness;
        float red = (float) r / 255.0f;
        float green = (float) g / 255.0f;
        float blue = (float) b / 255.0f;

        float maxValue = Math.max(Math.max(red, green), blue);
        float minValue = Math.min(Math.min(red, green), blue);
        float maxMinDiff = maxValue - minValue;

        if (maxMinDiff == 0)
            hue = 0.0f;
        else if (maxValue == red)
            hue = 60.0f * (((green - blue) / maxMinDiff) % 6);
        else if (maxValue == green)
            hue = 60.0f * (((blue - red) / maxMinDiff) + 2.0f);
        else if (maxValue == blue)
            hue = (60.0f * ((red - green) / maxMinDiff) + 4.0f);

        lightness = maxMinDiff / 2.0f;

        if (maxMinDiff == 0)
            saturation = 0.0f;
        else
            saturation = maxMinDiff / (1.0f - Math.abs(2.0f * lightness - 1.0f));

        if(hue < 0){
            hue += 360;
        }

        hslValues[0] = hue;
        hslValues[1] = saturation;
        hslValues[2] = lightness;
    }


    public static float[] RGBtoHSB(int r, int g, int b, float[] hsbvals) {
        float hue, saturation, brightness;
        if (hsbvals == null) {
            hsbvals = new float[3];
        }
        int cmax = (r > g) ? r : g;
        if (b > cmax) cmax = b;
        int cmin = (r < g) ? r : g;
        if (b < cmin) cmin = b;

        brightness = ((float) cmax) / 255.0f;
        if (cmax != 0)
            saturation = ((float) (cmax - cmin)) / ((float) cmax);
        else
            saturation = 0;
        if (saturation == 0)
            hue = 0;
        else {
            float redc = ((float) (cmax - r)) / ((float) (cmax - cmin));
            float greenc = ((float) (cmax - g)) / ((float) (cmax - cmin));
            float bluec = ((float) (cmax - b)) / ((float) (cmax - cmin));
            if (r == cmax)
                hue = bluec - greenc;
            else if (g == cmax)
                hue = 2.0f + redc - bluec;
            else
                hue = 4.0f + greenc - redc;
            hue = hue / 6.0f;
            if (hue < 0)
                hue = hue + 1.0f;
        }
        hsbvals[0] = hue;
        hsbvals[1] = saturation;
        hsbvals[2] = brightness;
        return hsbvals;
    }

    public static MyColor decode(String nm) throws NumberFormatException {
        Integer intval = Integer.decode(nm);
        int i = intval.intValue();
        return new MyColor((i >> 16) & 0xFF, (i >> 8) & 0xFF, i & 0xFF);
    }

    public MyColor(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }
}
