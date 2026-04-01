package Aula02.Herança;

public class Professor extends Pessoa {
    
    public String area;
    
    public Professor(String nome, String area){
        super(nome);
        this.area = area;
    }

    @Override
    public void Apresentar(){
        System.out.println("Olá, eu sou o Prof." + this.nome + " da área de " + this.area);
    }
}
