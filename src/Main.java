import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        Scanner scanner = new Scanner(System.in);
        String expressao;

        while (true) {
            System.out.print("Digite a expressão em Notaçao Polonesa Inversa (NPI) ou 'sair' para encerrar: ");
            expressao = scanner.nextLine();

            if (expressao.equalsIgnoreCase("sair")) {
                System.out.println("Saindo do programa...");
                break;
            }

            try {
                double resultado = calc.contas(expressao);
                System.out.println("Resultado: " + resultado);
            } catch (ExpressaoInvalida e) {
                System.err.println(e.getMessage());
            }
        }

        scanner.close();
    }
}
