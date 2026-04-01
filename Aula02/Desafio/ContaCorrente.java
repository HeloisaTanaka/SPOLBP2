package Aula02.Desafio;

public class ContaCorrente extends ContaBancaria {

    private double limiteChequeEspecial;

    public ContaCorrente(int numero, double saldo, double limiteChequeEspecial){
        super(numero, saldo);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    @Override
    public boolean sacar(double valor) {
        if (this.limiteChequeEspecial >= this.saldo-valor){
            this.saldo-=valor;
            System.out.println("Saque realizado com sucesso!");
            return true;
        } else {
            System.out.println("Erro ao sacar, você ultrapasou o seu limite de cheque especial");
            return false;
        }
    }
}
