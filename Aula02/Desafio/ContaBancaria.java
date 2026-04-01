package Aula02.Desafio;

public class ContaBancaria {
    protected double saldo;
    protected int numero;

    public ContaBancaria(int numero, double saldo) {
        this.saldo = saldo;
        this.numero = numero;
    }

    public boolean sacar(double valor){
        if(this.saldo >= valor){
            this.saldo -= valor;
            System.out.println("Saque de R$\" + valor + \" realizado com sucesso.");
            return true;
        } else { 
            System.out.println("Saldo insuficiente");
            return false;
        }
    }

    public boolean depositar(double valor){
        if(valor>0){
            this.saldo+=valor;
            System.out.println("Depósito de R$" + valor + " feito com sucesso.");
            return true;
        } else {
            System.out.println("Falha ao depositar R$" + valor);
            return false;
        }
        
    }

    public double getSaldo(){
        return this.saldo;
    }


}
