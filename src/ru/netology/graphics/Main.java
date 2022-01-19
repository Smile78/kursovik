package ru.netology.graphics;


import ru.netology.graphics.image.*;
import ru.netology.graphics.server.GServer;

public class Main {
    public static void main(String[] args) throws Exception {
//        TextGraphicsConverter converter = null; // Создайте тут объект вашего класса конвертера
        TextGraphicsConverter converter = new TextGraphicsConverterClass();


        // Или то же, но с выводом на экран:
//        String url = "https://raw.githubusercontent.com/netology-code/java-diplom/main/pics/simple-test.png";
        converter.setTextColorSchema(new TextColorSchemaClass3());
        String url = "https://i.ibb.co/6DYM05G/edu0.jpg";
        String imgTxt = converter.convert(url);
        System.out.println(imgTxt);

//
//        GServer server = new GServer(converter); // Создаём объект сервера
//        server.start(); // Запускаем

    }


}

