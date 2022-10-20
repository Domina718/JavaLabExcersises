package org.example;

import java.awt.Color;
public class ColorConverter {
    public static void main(String[] args) {

        String hexColor = "0x1FF0FF";

        Color c = Color.decode(hexColor);

        float[] hsbCode = new float[3];

        Color.RGBtoHSB(c.getRed(), c.getGreen(), c.getBlue(), hsbCode);
        System.out.println("Boja u HEX formatu: 0x" +
                Integer.toHexString(c.getRGB() & 0x00FFFFFF));
        System.out.println("Boja u RGB formatu: " + c.getRed() + ", " +
                c.getGreen() + ", " + c.getBlue());
        System.out.println("Boja u HSB formatu: " + hsbCode[0] * 360 + "°, " +
                hsbCode[1] * 100 + "%, " + hsbCode[2] * 100 + "%");

        float[] myHSBcode = new float[3];
        float[] myCMYKcode = new float[4];
        float[] myHSLcode = new float[3];

        MyColor myColor=MyColor.decode(hexColor);

        MyColor.RGBtoHSB(myColor.getRed(), myColor.getGreen(), myColor.getBlue(), myHSBcode);
        MyColor.RGBtoCMYK(myColor.getRed(), myColor.getGreen(), myColor.getBlue(), myCMYKcode);
        MyColor.RGBtoHSL(myColor.getRed(), myColor.getGreen(), myColor.getBlue(), myHSLcode);

        System.out.println("\nColor in HEX format: 0x" +
                Integer.toHexString(myColor.getRGB() & 0x00FFFFFF));
        System.out.println("Color in RGB format: " + myColor.getRed() + ", " +
                myColor.getGreen() + ", " + myColor.getBlue());
        System.out.println("Color in HSB format: " + myHSBcode[0] * 360 + "°, " +
                myHSBcode[1] * 100 + "%, " + myHSBcode[2] * 100 + "%");
        System.out.println("Color in CMYK format: " + "Cyan: " + myCMYKcode[0] +
                " Magenta: " + myCMYKcode[1] + " Yellow: " + myCMYKcode[2] + " Black: " + myCMYKcode[3] );
        System.out.println("Color in HSL format: " + myHSLcode[0]  + "°, " +
                myHSLcode[1] * 100 + "%, " + myHSLcode[2] * 100 + "%");
    }
}
