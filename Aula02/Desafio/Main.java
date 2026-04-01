package Aula02.Desafio;

public class Main {
    public static void main(String[] args){
        ContaPoupanca cp1 = new ContaPoupanca(100, 98437892);
        cp1.sacar(150);
        cp1.renderJuros(0.1);
        System.out.println("Saldo: " + cp1.getSaldo());

        ContaCorrente cc1 = new ContaCorrente(23476875, 120, 300);
        cc1.sacar(200);
        System.out.println("Saldo: " + cc1.getSaldo());
    }
}
