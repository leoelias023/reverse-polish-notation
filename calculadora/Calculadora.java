package calculadora;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import calculadora.util.Pilha;

public class Calculadora {

    public static void main(String[] args) {

        Pilha<Double> stack = new Pilha<>();
        List<String> oper = parseOperation(args[0]);

        oper.forEach(op -> {

            if (isOperand(op)) {
                stack.push(getOperand(op));
            } else {

                Double first = stack.pop();
                Double second = stack.pop();
                Double result = null;

                switch(op) {
                    case "+":
                        result = second + first;
                        break;
                    case "-":
                        result = second - first;
                        break;
                    case "*":
                        result = second * first;
                        break;
                    case "/":
                        result = second / first;
                        break;
                }

                if (result == null) {
                    throw new IllegalArgumentException("Operação inválida");
                } 

                stack.push(result);
            }

        });

        System.out.println(
            String.format(
                "O resultado é %s", stack.pop()
            )
        );
    }    

    private static Double getOperand(String input) {
        if (!isOperand(input)) {
            throw new IllegalArgumentException("O input recebido não é um operando");
        }

        return Double.parseDouble(input);
    }

    private static boolean isOperand(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }

    private static List<String> parseOperation(String operation) {
        return Arrays.asList(operation.trim().split("\\s+"))
            .stream()
            .map(op -> op.trim())
            .collect(Collectors.toList());
    }
}
