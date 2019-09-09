package calculate;

import java.io.IOException;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Stack;

public class Model {

   public static boolean numberStatusIsRoman = false;
   public static boolean numberStatusIsArabic = false;

    //Создаем обратную польскую запись переданного выражения
    public static String getRPN(String inputString) throws EmptyStackException {
        LinkedList<String> opn = new LinkedList<String>();
        Stack<String> stack = new Stack<String>(); //Стек для хранения оператора



        for (String currentSymbol : inputString.split(" ")) {

                //Проверяем тип числа и добавляем число сразу в выходную строку.
                if (isNumber(currentSymbol)) {
                    numberStatusIsArabic = true;
                    opn.add(currentSymbol + " ");
                    continue;

                } else if (isRomanNumber(currentSymbol)) {
                    numberStatusIsRoman = true;
                    Convert convert = new Convert();
                    opn.add(convert.romanToInt(currentSymbol) + " ");
                    continue;
                }


                //Сохраняем оператор в стеке операторов.
                if (isOperator(currentSymbol)) {
                    stack.push(currentSymbol);
                    continue;
                }

            }


            // Добавляем оператор из стека в выходную строку.
            while (!stack.empty()) {
                opn.add(stack.pop() + " ");
            }

            //Создаем итоговую последовательность
            StringBuilder sb = new StringBuilder();
            for (String s : opn)
                sb.append(s);

            return sb.toString();
        }


    //Проверка, является ли часть выражения Арабским числом.
    public static boolean isNumber(String currentSymbol) {
        try {
            Integer.parseInt(currentSymbol);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //Проверка, является ли часть выражения строка оператором
    public static boolean isOperator(String c) {

        return c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/");
    }

    //Проверка, является ли часть выражения римским числом
    public static boolean isRomanNumber(String c) {

        return c.equals("I") || c.equals("II") || c.equals("III") || c.equals("IV") || c.equals("V") || c.equals("VI") || c.equals("VII") || c.equals("VIII") || c.equals("IX") || c.equals("X") ;
    }
}
