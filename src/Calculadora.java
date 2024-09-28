import java.util.Stack;

public class Calculadora {
    private Stack<Double> stack = new Stack<>();
    public double contas(String expressao) throws ExpressaoInvalida {
        String[] simbolos = expressao.split(" ");
        for (String simbolo : simbolos){
            switch (simbolo){
                case "+":
                    executarOperacao(new Soma());
                    break;
                case "-":
                    executarOperacao(new Subtracao());
                    break;
                case "*":
                    executarOperacao(new Multiplicacao());
                    break;
                case "/":
                    try {
                        executarOperacao(new Divisao());
                    } catch (ArithmeticException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                default:
                    try{
                        double numero = Double.parseDouble(simbolo);
                        stack.push(numero);
                    } catch (NumberFormatException e){
                        throw new ExpressaoInvalida("Erro: Simbolo invalido na expressao.");
                    }
            }
        }
        if (stack.size() != 1) {
            throw new ExpressaoInvalida("Erro: Expressao invalida. Digite uma nova expressao: ");
        }
        return stack.pop();
    }
    private void executarOperacao(Operacoes operacao) {
        double b = stack.pop();
        double a = stack.pop();
        double resultado = operacao.conta(a, b);
        stack.push(resultado);
    }
}
