public class Divisao implements Operacoes{
    @Override
    public double conta(double a, double b){
        if (b == 0) {
            throw new ArithmeticException("Erro: Não eh possivel dividir por zero.");
        }
        return a/b;
    }
}
