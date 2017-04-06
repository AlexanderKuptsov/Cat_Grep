package CatGrep;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

/**
 * Created by shurik on 06.04.2017.
 */
public class CrepTest {
    @Test
    public void word() throws FileNotFoundException {
        Crep result = new Crep();
        String[] args = {"поворот", "C:\\\\files\\a.txt"};
        String lines = "Операции: поворот указанного числа слоев,\n" +
                "поворот всего кубика (т.е. переименование граней),\n";
        assertEquals(lines, result.word(args));
    }

    @Test
    public void wordI() throws FileNotFoundException {
        Crep result = new Crep();
        String[] args = {"-i", "кубика", "C:\\\\files\\a.txt"};
        String lines = "Хранит состояние кубика Рубика.\n" +
                "поворот всего кубика (т.е. переименование граней),\n" +
                "запрос состояния грани. Произвольный размер кубика.\n" +
                "Случайная установка состояния кубика.\n";
        assertEquals(lines.toLowerCase(), result.word(args));
    }

    @Test
    public void wordV() throws FileNotFoundException {
        Crep result = new Crep();
        String[] args = {"-v", "кубика", "C:\\\\files\\a.txt"};
        String lines = "Операции: поворот указанного числа слоев,\n";
        assertEquals(lines.toLowerCase(), result.word(args));
    }

    @Test
    public void wordVI() throws FileNotFoundException {
        Crep result = new Crep();
        String[] args = {"-v", "-i", "хранит", "C:\\\\files\\a.txt"};
        String lines = "Хранит состояние кубика Рубика.\n" +
                "Операции: поворот указанного числа слоев,\n" +
                "поворот всего кубика (т.е. переименование граней),\n" +
                "запрос состояния грани. Произвольный размер кубика.\n" +
                "Случайная установка состояния кубика.\n";
        assertEquals(lines, result.word(args));
    }

    @Test
    public void wordR() throws FileNotFoundException {
        Crep result = new Crep();
        String[] args = {"-r", "[з]", "C:\\\\files\\a.txt"};
        String lines = "Операции: поворот указанного числа слоев,\n" +
                "запрос состояния грани. Произвольный размер кубика.\n";
        assertEquals(lines, result.word(args));
    }

    @Test
    public void wordRV() throws FileNotFoundException {
        Crep result = new Crep();
        String[] args = {"-r", "-v", "[з]", "C:\\\\files\\a.txt"};
        String lines = "хранит состояние кубика рубика.\n" +
                "поворот всего кубика (т.е. переименование граней),\n" +
                "случайная установка состояния кубика.\n";
        assertEquals(lines, result.word(args));
    }
}