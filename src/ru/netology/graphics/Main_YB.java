package ru.netology.graphics;

//import ru.netology.graphics.server.*;

//import ru.netology.graphics.image.TextColorSchemaClass2;
//import ru.netology.graphics.image.TextGraphicsConverterClass;

import ru.netology.graphics.image.TextColorSchemaClass2;
import ru.netology.graphics.image.TextGraphicsConverter;
import ru.netology.graphics.image.TextGraphicsConverterClass;
import ru.netology.graphics.server.GServer;
//import ru.netology.graphics.image.TextGraphicsConverter;

//import java.io.*;


// BadImageSizeException	- Класс исключения, которое вы будете выбрасывать
// TextColorSchema	        - Интерфейс цветовой схемы, который вы будете реализовывать
// TextGraphicsConverter	- Интерфейс конвертера картинок, который вы будете реализовывать
// GServer	                - Готовый класс сервера, который будет использовать ваш конвертер; вам туда лезть не нужно
// Main	                    - Запуск приложения. В нём запускается сервер,
//                            также в нём можно будет конвертировать картинки в текстовые файлы без сервера


public class Main_YB {
    public static void main(String[] args) throws Exception {
        TextGraphicsConverter converter = new TextGraphicsConverterClass(); // Создайте тут объект вашего класса конвертера


        //ToDo
        // almost...:   ++
        // turn right   ++
        // doble        ++
        // exception    ++
        // ratio        ++
        // maxRatio nd nthr metds ++
        // поля и схема по умолчанию итд   ++

        //     Или то же, но с выводом на экран:

//        String url = "https://i.ibb.co/bXPpzFL/Screenshot-from-2021-11-04-20-05-30.png" ;                             // градиент из ридми        // eror ---ОК -ваще нету такого
//        String url = "https://github.com/netology-code/java-diplom/blob/main/pics/preview.png";                       // хз                      // eror ---ОК -картинка внутри гитхаба

//        String url = "https://raw.githubusercontent.com/netology-code/java-diplom/main/pics/simple-test.png";         // градиент из реплит      // ок
        String url = "https://i.ibb.co/6DYM05G/edu0.jpg";                                                             // филип из реплит         // ок       853/1280 ratio 0,666

//        converter.setMaxRatio(0.56);                                    //  exc  ok
//        converter.setMaxRatio(0.67);                                    //       ok
//        converter.setTextColorSchema(new TextColorSchemaClass1());       //       ok
        converter.setTextColorSchema(new TextColorSchemaClass2());       //       ok

        converter.setMaxWidth(50);                                      //       ok            // но серверу пофигу
        converter.setMaxHeight(30);                                     //       ok            // но серверу пофигу


        String imgTxt = converter.convert(url);
        System.out.println(imgTxt);


        //  почемуто сервер меняет стороны...
        GServer server = new GServer(converter); // Создаём объект сервера
        server.start(); // Запускаем

    }


}

