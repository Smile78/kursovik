package ru.netology.graphics.image;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Test {

    static int maxWidth = 100; //??

    static int maxHeight = 100; //??


    static double maxRatio = 0.56; //?? eror

    public static void main(String[] args) throws IOException, BadImageSizeException {

        //************************************

        String url = "https://i.ibb.co/6DYM05G/edu0.jpg";
        BufferedImage img = ImageIO.read(new URL(url));


        //************************************ ratio
        // Если конвертер попросили проверять на максимально допустимое соотношение сторон изображения

//         	9:16 (Vertical video)                     0.56
//          853/1280                            ratio 0.666         filip
//        	1:1 (Square)
//         	4:3 standard                              1.33
//         	16:10 standard
//         	16:9 standard           1.78:1      ratio 1.77
//   5:3 (= 15:9)
//         	1.85:1


        //************************************

//        JOptionPane.showMessageDialog(null, "getWidth :" +img.getWidth());
//        JOptionPane.showMessageDialog(null, "getHeight :" +img.getHeight());
//
//        double ratio = (double) img.getWidth() / img.getHeight();
//        JOptionPane.showMessageDialog(null, "ratio :" +ratio);

        //************************************

//        if (ratio > maxRatio) throw new BadImageSizeException(ratio, maxRatio);


        //************************************ пропорции


        //Если конвертеру выставили максимально допустимые ширину и/или высоту,
        // Пример 1: макс. допустимые 100x100, а картинка 500x200. Новый размер
        // будет 100x40 (в 5 раз меньше).
        // Пример 2: макс. допустимые 100x30, а картинка 150x15. Новый размер
        // будет 100x10 (в 1.5 раза меньше).

        //          853/1280                            ratio 0.666         filip
        //          0,8/1,2

        //          100 100
        //          853/12,8=66,6
        //          66,6 /100


        int newWidth = 0;
        int newHeight = 0;

        JOptionPane.showMessageDialog(null, "getWidth :" + img.getWidth());            //853
        JOptionPane.showMessageDialog(null, "getHeight :" + img.getHeight());         //1280

        double koef1 = (double) img.getWidth() / maxWidth; //во сска раз больше
        double koef2 = (double) img.getHeight() / maxHeight;

        if (koef1 >= koef2 && koef1 >= 1) {
            newWidth = (int) ((double) img.getWidth() / koef1);
            newHeight = (int) ((double) img.getHeight() / koef1);
        } else if (koef2 > koef1 && koef2 >= 1) {
            newWidth = (int) ((double) img.getWidth() / koef2);
            newHeight = (int) ((double) img.getHeight() / koef2);
        }
        if (koef1 >= koef2 && koef1 < 1) {
            newWidth = (int) ((double) img.getWidth() / koef1);
            newHeight = (int) ((double) img.getHeight() / koef1);
        } else if (koef2 > koef1 && koef2 < 1) {
            newWidth = (int) ((double) img.getWidth() / koef2);
            newHeight = (int) ((double) img.getHeight() / koef2);
        }

        JOptionPane.showMessageDialog(null, "newWidth :" + newWidth + " а дб 66");            //200 когда сервер работает ????
        JOptionPane.showMessageDialog(null, "newHeight :" + newHeight + " а дб 100");          //300 когда сервер работает ????

    }
}
