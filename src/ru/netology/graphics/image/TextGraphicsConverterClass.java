package ru.netology.graphics.image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import ru.netology.graphics.image.TextColorSchema;


public class TextGraphicsConverterClass implements TextGraphicsConverter {

    private int maxWidth;

    private int maxHeight;

    private double maxRatio;

    private TextColorSchema schema;

    public TextGraphicsConverterClass() {

        maxWidth = 100; //??
        maxHeight = 100; //??
        maxRatio = 1.85;     //          filip 0.666 ok
//        maxRatio =0.67;     //          filip 0.666 ok
//        maxRatio =0.56;     //   excp   filip 0.666 ok
        schema = new TextColorSchemaClass1();
    }


    @Override
    public void setMaxWidth(int width) {
        this.maxWidth = width;
    }

    @Override
    public void setMaxHeight(int height) {
        this.maxHeight = height;
    }

    @Override
    public void setMaxRatio(double maxRatio) {
        this.maxRatio = maxRatio;
    }

    @Override
//    public void setTextColorSchema(ru.netology.graphics.image.TextColorSchema schema) {
    public void setTextColorSchema(TextColorSchema schema) {
        this.schema = schema;
    }

    @Override
    public String convert(String url) throws IOException, BadImageSizeException {
        // Вот так просто мы скачаем картинку из интернета :)
        BufferedImage img = ImageIO.read(new URL(url));

        double ratio = (double) img.getWidth() / img.getHeight(); // если ширина в столькото раз больше высоты
//        JOptionPane.showMessageDialog(null, "ratio :" +ratio);
        if (ratio > maxRatio && maxRatio != 0.0)
            throw new BadImageSizeException(ratio, maxRatio);  //если пустой конструктор   Ратио всегда  больше

        ratio = (double) img.getHeight() / img.getWidth(); // если высота в столькото раз больше ширины или ратио2??
        if (ratio > maxRatio && maxRatio != 0.0)
            throw new BadImageSizeException(ratio, maxRatio);  //если пустой конструктор  Ратио всегда больше

        int newWidth = 0;
        int newHeight = 0;

        double koef1 = (double) img.getWidth() / maxWidth; //во сска раз больше
        double koef2 = (double) img.getHeight() / maxHeight;

        if (koef1 >= koef2) {
            newWidth = (int) ((double) img.getWidth() / koef1);
            newHeight = (int) ((double) img.getHeight() / koef1);
        } else if (koef2 > koef1) {
            newWidth = (int) ((double) img.getWidth() / koef2);
            newHeight = (int) ((double) img.getHeight() / koef2);
        }

        Image scaledImage = img.getScaledInstance(newWidth, newHeight, BufferedImage.SCALE_SMOOTH);

        BufferedImage bwImg = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_BYTE_GRAY);

        Graphics2D graphics = bwImg.createGraphics();

        graphics.drawImage(scaledImage, 0, 0, null);

        ImageIO.write(bwImg, "png", new File("out2.png"));                               // ооокэ --- даже не перевернутая

        WritableRaster bwRaster = bwImg.getRaster();

        char[][] cc = new char[newHeight][newWidth];
        String str = "";
        StringBuilder strB = new StringBuilder();
        strB.append("");

        for (int w = 0; w < newWidth; w++) {
            for (int h = 0; h < newHeight; h++) {
                int color = bwRaster.getPixel(w, h, new int[3])[0];
                char c = schema.convert(color);
                cc[h][w] = c;
            }
        }

        for (int i = 0; i < cc.length; i++) {
            for (int j = 0; j < cc[i].length; j++) {
                strB.append(String.valueOf(cc[i][j]));
                strB.append(String.valueOf(cc[i][j]));
            }
            strB.append("\n");
        }

        str = strB.toString();

        return str; // Возвращаем собранный текст.

    }

}
