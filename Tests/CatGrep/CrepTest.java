package CatGrep;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by shurik on 06.04.2017.
 */
public class CrepTest {
    @Test
    public void word() throws IOException {
        Crep result = new Crep();
        String[] args = {"поворот", "C:\\\\files\\a.txt"};
        String lines = "Операции: поворот указанного числа слоев,\n" +
                "поворот всего кубика (т.е. переименование граней),\n";
        assertEquals(lines, result.word(args));
    }

    @Test
    public void wordI() throws IOException {
        Crep result = new Crep();
        String[] args = {"-i", "кубика", "C:\\\\files\\a.txt"};
        String lines = "Хранит состояние кубика Рубика.\n" +
                "поворот всего кубика (т.е. переименование граней),\n" +
                "запрос состояния грани. Произвольный размер кубика.\n" +
                "Случайная установка состояния кубика.\n";
        assertEquals(lines.toLowerCase(), result.word(args));
    }

    @Test
    public void wordV() throws IOException {
        Crep result = new Crep();
        String[] args = {"-v", "кубика", "C:\\\\files\\a.txt"};
        String lines = "Операции: поворот указанного числа слоев,\n";
        assertEquals(lines, result.word(args));
    }

    @Test
    public void wordVI() throws IOException {
        Crep result = new Crep();
        String[] args = {"-v", "-i", "хранит", "C:\\\\files\\a.txt"};
        String lines = "Операции: поворот указанного числа слоев,\n" +
                "поворот всего кубика (т.е. переименование граней),\n" +
                "запрос состояния грани. Произвольный размер кубика.\n" +
                "Случайная установка состояния кубика.\n";
        assertEquals(lines.toLowerCase(), result.word(args));
    }

    @Test
    public void wordR() throws IOException {
        Crep result = new Crep();
        String[] args = {"-r", "[з]", "C:\\\\files\\a.txt"};
        String lines = "Операции: поворот указанного числа слоев,\n" +
                "запрос состояния грани. Произвольный размер кубика.\n";
        assertEquals(lines, result.word(args));
    }

    @Test
    public void wordRV() throws IOException {
        Crep result = new Crep();
        String[] args = {"-r", "-v", "[з]", "C:\\\\files\\a.txt"};
        String lines = "Хранит состояние кубика Рубика.\n" +
                "поворот всего кубика (т.е. переименование граней),\n" +
                "Случайная установка состояния кубика.\n";
        assertEquals(lines, result.word(args));
    }

    @Test
    public void wordRI() throws IOException {
        Crep result = new Crep();
        String[] args = {"-r", "-i", "[з]", "C:\\\\files\\a.txt"};
        String lines = "операции: поворот указанного числа слоев,\n" +
                "запрос состояния грани. произвольный размер кубика.\n";
        assertEquals(lines, result.word(args));
    }

    @Test
    public void wordRVI() throws IOException {
        Crep result = new Crep();
        String[] args = {"-r", "-v", "-i", "[з]", "C:\\\\files\\a.txt"};
        String lines = "Хранит состояние кубика Рубика.\n" +
                "поворот всего кубика (т.е. переименование граней),\n" +
                "Случайная установка состояния кубика.\n";
        assertEquals(lines.toLowerCase(), result.word(args));
    }
}