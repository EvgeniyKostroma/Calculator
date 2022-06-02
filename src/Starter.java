
import java.util.Scanner;

public class Starter {

    public static void main(String[] args) throws MyException {
        Scanner input = new Scanner(System.in);
        System.out.println("Добро пожаловать в калькулятор (Арабский/Римский)\nПримеры ввода\n1) III + II\n2) 7 * 8 \n3) X / II");
        Calculator calculator = new Calculator();
        for (; ; ) {
            System.out.print("Введите операцию: ");
            String operation = input.nextLine();
            if (operation.contains("+")) {
                String sum = calculator.sum(operation);
                System.out.println("Ответ: " + sum);
            } else if (operation.contains("-")) {
                String sub = calculator.sub(operation);
                System.out.println("Ответ: " + sub);
            } else if (operation.contains("*")) {
                String mul = calculator.mul(operation);
                System.out.println("Ответ: " + mul);
            } else if (operation.contains("/")) {
                String div = calculator.div(operation);
                System.out.println("Ответ: " + div);
            } else {
                try {
                    throw new MyException("Некорректный формат ввода!");
                } catch (MyException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}