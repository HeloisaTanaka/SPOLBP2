package Aula02.Herança;

public class Main {
    public static void main(String[] args){
        Pessoa p1 = new Pessoa("Almir");
        p1.Apresentar();

        System.out.println("--------------------------");

        Professor prof1 = new Professor("Motta", "Banco de dados");
        prof1.Apresentar();
    }
}
