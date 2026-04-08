package Aula03.Imposto;

interface ImpostoStrategy {
    double calcular(double valor);
}

class Icms implements ImpostoStrategy{
    public double calcular(double valor) {return valor * 0.18;}
}

class Iss implements ImpostoStrategy{
    public double calcular(double valor) {return valor * 0.05;}
}

class CalculadoraDeImposto{
    private ImpostoStrategy estrategia;

    public void setEstrategia(ImpostoStrategy e){
        this.estrategia = e;
    }

    public double calcular(double peso){
        return estrategia.calcular(peso);
    }
}

public class calcularImposto {
    public static void main(String[] args) {
        CalculadoraDeImposto calculadora = new CalculadoraDeImposto();
        double valor = 200000;

        calculadora.setEstrategia(new Icms());
        System.out.println("ICMS: " + calculadora.calcular(valor));

        calculadora.setEstrategia(new Iss());
        System.out.println("ISS: "+ calculadora.calcular(valor));
        

    }
    
}