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

    public void word(String[] args) throws FileNotFoundException {
        String fileName = args[args.length - 1];
        File file = new File(fileName);
        exists(fileName);
        StringBuilder newLines = new StringBuilder();
        String word = args[args.length - 2];
        boolean checkR = false;
        boolean checkI = false;
        boolean checkV = false;
        String pattern = "";
        for (String arg : args) {
            if (Objects.equals(arg, "-i")) {// игнорирование регистра слов
                checkI = true;
                word = word.toLowerCase();
            }
            if (Objects.equals(arg, "-v")) { // инвертирует условие фильтрации
                checkV = true;
            }
            if (Objects.equals(arg, "-r")) { // вместо слова задается регулярное выражение для поиска
                pattern = word;
                checkR = true;
            }
            if (Objects.equals(arg, "-h")) { // помощь
                System.out.print("Введите нужные вам команды и имя файла\n" +
                        "word - задает слово для поиска (на консоль выводится только содержащие его строки\n" +
                        "[-r] - (regex) вместо слова задает регулярное выражение для поиска (на консоль выводятся " +
                        "только строки, содержащие данное выражение)\n" +
                        "[-v] - инвертирует условие фильтрации (выводится только то,что ему НЕ соответсствует)\n" +
                        "[-i] - игнорировать регистр слов");
            }
        }
        try {
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                String line;
                while ((line = in.readLine()) != null) {
                    if (!checkV) { // инвертирует условие фильтрации
                        if (checkI) { // игнорирование регистра слов
                            line = line.toLowerCase();
                        }
                        if (!checkR) { // (regex)
                            if (line.contains(word)) {
                                newLines.append(line).append("\n");
                            }
                        } else {
                            Pattern r = Pattern.compile(pattern);  // Создание Pattern объекта
                            Matcher m = r.matcher(line);
                            if (m.find()) {
                                newLines.append(line).append("\n");
                            }
                        }
                    } else {
                        if (checkI) { //игнорирование регистра слов
                            line = line.toLowerCase();
                        }
                        if (!checkR) { // (regex)
                            if (!line.contains(word)) {
                                newLines.append(line).append("\n");
                            }
                        } else {
                            Pattern r = Pattern.compile(pattern);  // Создание Pattern объекта
                            Matcher m = r.matcher(line);
                            if (!m.find()) {
                                newLines.append(line).append("\n");
                            }
                        }
                    }
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(newLines.toString());
    }

    public static void main(String[] args) throws FileNotFoundException {
        Crep result = new Crep();
        result.word(args);
    }
}