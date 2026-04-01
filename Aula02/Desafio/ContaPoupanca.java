package Aula02.Desafio;

public class ContaPoupanca extends ContaBancaria {

    public ContaPoupanca(double saldo, int numero) {
        super(numero, saldo);
    } 

    public boolean renderJuros(double taxa){
        this.saldo += this.saldo*taxa;
        return true;
    }
}
