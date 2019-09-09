package calculate;



import java.io.IOException;;
import java.util.Scanner;
import java.util.Stack;

public class Calculator {
    Calculation calculation = new Calculation();

    private int calculateResult(String RPN) {
        Stack<String> stack = new Stack<String>();


        for (String currentSymbol : RPN.split(" ")) {


                if (Model.isNumber(currentSymbol)) {
                    stack.push(currentSymbol);
                    continue;
                }


                if (Model.isOperator(currentSymbol)) {
                    int result = 0;
                    int second = Integer.parseInt(stack.pop());
                    int first = Integer.parseInt(stack.pop());


                    if ( first < 0 || second < 0 || first > 10 || second > 10 ) {
                        System.out.println ("\nОшибка выполнения программы, числа должны быть не отрицательны и меньше либо равны 10");
                        System.exit(0);
                    }

                   if ( Model.numberStatusIsArabic == Model.numberStatusIsRoman ) {
                       System.out.println ("\nОшибка выполнения программы. Цифры должны быть одинакового формата, либо римские, либо арабские");
                       System.exit(0);
                   }

                    switch (currentSymbol) {

                        case "/":
                            result = calculation.div(first, second);
                            break;
                        case "*":
                            result = calculation.multi(first, second);
                            break;
                        case "+":
                            result = calculation.sum(first, second);
                            break;
                        case "-":
                            result = calculation.deduct(first, second);
                            break;
                    }
                    stack.push(String.valueOf(result));
                }
            }

            return Integer.parseInt(stack.pop());
        }



    public static void main(String[] args) throws IOException {

        Calculator calculator = new Calculator();

        System.out.println("Добрый день. Данный калькулятор позволяет осуществлять только операции сложения '+', вычитания '-', деления '/', умножения '*' ");
        System.out.println("Калькулятор осуществляет операции с римскими и арабскими цифрами в диапазоне от 1 до 10. Цифры не могут быть отрицательными ");
        System.out.println("Введите уравнение: ");
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        scan.close();

        String rpn = Model.getRPN(s);

        int result = calculator.calculateResult(rpn);

        if (Model.numberStatusIsArabic) {
            System.out.println("\nРезультат уравнения равен: " + result);
        }
        else {
            Convert convert = new Convert();
            String romanResult = convert.intToRoman(result);
            System.out.println("\nРезультат уравнения равен: " + romanResult);

        }
    }
}
