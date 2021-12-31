package ru.netology.graphics;

import ru.netology.graphics.image.TextColorSchema;


//Предлагается следующая логика его работы.
// Вот список символов от самых «тёмных» к самым «светлым»: '▇', '●', '◉', '◍', '◎', '○', '☉', '◌', '-'.

// Если вы программируете на винде, то рекомендуем другой список из более стандартных символов,
// иначе может отрисовываться криво: '#', '$', '@', '%', '*', '+', '-', '''.
//
// В зависимости от переданного значения интенсивности белого, должен выбираться соответствующий символ.
// Например, если значение близко к 0, то выбрать надо '▇'; если к 255, то '-'.
// Если где-то посередине, то и выбирать надо тоже где-то посередине.

public class TextColorSchemaClass implements TextColorSchema {
    @Override
    public char convert(int color) {

        if (color<=255) return '\'';
        else if (color<=223) return '-';
        else if (color<=191) return '+';
        else if (color<=159) return '*';
        else if (color<=127) return '%';
        else if (color<=95) return '@';
        else if (color<=63&&color>31) return '$';
        else  return '#';

        //можно тернарным или делением 256 на сайз чар массива
    }
}
