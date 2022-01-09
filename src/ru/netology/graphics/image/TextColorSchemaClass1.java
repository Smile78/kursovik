package ru.netology.graphics.image;

import ru.netology.graphics.image.TextColorSchema;


//Предлагается следующая логика его работы.
// Вот список символов от самых «тёмных» к самым «светлым»: '▇', '●', '◉', '◍', '◎', '○', '☉', '◌', '-'.

// Если вы программируете на винде, то рекомендуем другой список из более стандартных символов,
// иначе может отрисовываться криво: '#', '$', '@', '%', '*', '+', '-', '''.
//
// В зависимости от переданного значения интенсивности белого, должен выбираться соответствующий символ.
// Например, если значение близко к 0, то выбрать надо '▇'; если к 255, то '-'.
// Если где-то посередине, то и выбирать надо тоже где-то посередине.

public class TextColorSchemaClass1 implements TextColorSchema {

    //можно тернарным или делением 256 на сайз чар массива

    @Override
    public char convert(int color) {

        if (color <= 31) return '#';
        else if (color <= 62) return '$';
        else if (color <= 95) return '@';
        else if (color <= 127) return '%';
        else if (color <= 159) return '*';
        else if (color <= 191) return '+';
        else if (color <= 223) return '-';
        else return '\'';

    }
}
