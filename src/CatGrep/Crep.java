package CatGrep;

import java.io.*;
import java.util.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by shurik on 16.03.2017.
 */
public class Crep {
    private static void exists(String fileName) throws FileNotFoundException { // проверка существования файла
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException(file.getName());
        }
    }

    public String word(String[] args) throws IOException {
        String fileName = args[args.length - 1];
        File file = new File(fileName);
        exists(fileName);
        StringBuilder newLines = new StringBuilder();
        String word = args[args.length - 2];
        String pattern = "";

        CrepFilter crepChecker = new CrepFilter(args);
        if (crepChecker.getCheckI()) {// игнорирование регистра слов
            word = word.toLowerCase();
        }
        if (crepChecker.getCheckR()) { // вместо слова задается регулярное выражение для поиска
            pattern = word;
        }

        try (BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()))) {
            String line;
            while ((line = in.readLine()) != null) {
                if (crepChecker.getCheckI()) { // игнорирование регистра слов
                    line = line.toLowerCase();
                }
                if (!crepChecker.getCheckR()) { // (regex)
                    if (line.contains(word) != crepChecker.getCheckV()) {
                        newLines.append(line).append("\n");
                    }
                } else {
                    Pattern r = Pattern.compile(pattern);  // Создание Pattern объекта
                    Matcher m = r.matcher(line);
                    if (m.find() != crepChecker.getCheckV()) {
                        newLines.append(line).append("\n");
                    }
                }
            }
        }
        return newLines.toString();
    }

    public static void main(String[] args) throws IOException {
        Crep result = new Crep();
        CrepFilter crepFilter = new CrepFilter(args);
        if (args.length < 2) {
            System.out.print(!Objects.equals(crepFilter.getCheckH(), "") ?
                    crepFilter.getCheckH() : "Нет аргументов");
            System.exit(0);
        }
        System.out.println(crepFilter.getCheckH());
        String yesNo = crepFilter.getCheckV() ? " не" : "";
        System.out.println("Строки из файла " + args[args.length - 1] + yesNo + " содержащие \"" +
                args[args.length - 2] + "\"\n");
        System.out.println(result.word(args));
    }
}