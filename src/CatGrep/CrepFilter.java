package CatGrep;

import java.util.Objects;

/**
 * Created by shurik on 13.04.2017.
 */
class CrepFilter {
    private boolean checkR = false;
    private boolean checkI = false;
    private boolean checkV = false;
    private boolean checkH = false;

    CrepFilter(String[] args) {
        for (String arg : args) {
            if (Objects.equals(arg, "-i")) { // игнорирование регистра слов
                checkI = true;
            }
            if (Objects.equals(arg, "-v")) { // инвертирует условие фильтрации
                checkV = true;
            }
            if (Objects.equals(arg, "-r")) { // вместо слова задается регулярное выражение для поиска
                checkR = true;
            }
            if (Objects.equals(arg, "-h")) { // помощь
                checkH = true;
            }
        }
    }

    boolean getCheckI() {
        return checkI;
    }

    boolean getCheckV() {
        return checkV;
    }

    boolean getCheckR() {
        return checkR;
    }

    String getCheckH() {
        return checkH ? "Введите нужные вам команды и имя файла\n" +
                "word - задает слово для поиска (на консоль выводится только содержащие его строки\n" +
                "[-r] - (regex) вместо слова задает регулярное выражение для поиска (на консоль выводятся " +
                "только строки, содержащие данное выражение)\n" +
                "[-v] - инвертирует условие фильтрации (выводится только то,что ему НЕ соответсствует)\n" +
                "[-i] - игнорировать регистр слов\n" : "";
    }
}
