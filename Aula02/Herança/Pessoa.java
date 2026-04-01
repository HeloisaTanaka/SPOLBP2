package Aula02.Herança;

public class Pessoa {
    protected String nome;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public void Apresentar() {
        System.out.println("Olá, sou " + this.nome);
    }
}