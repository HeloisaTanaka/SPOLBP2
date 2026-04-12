package Atividade03;

import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.io.IOException;

interface PagamentoStrategy{
    double pagamento(double valor);
}

class Pix implements PagamentoStrategy {
    public double pagamento(double valor) {return valor*0.9;}
}

class Credito implements PagamentoStrategy{
    public double pagamento(double valor) {return valor;}
}

class Debito implements PagamentoStrategy{
    public double pagamento(double valor) {return valor*0.8;}
}

class definirPagamento{
    PagamentoStrategy formaPagamento;

    void setEstrategia(PagamentoStrategy pagamento){
        this.formaPagamento = pagamento;
    }

    double pagar(double valor){
        return formaPagamento.pagamento(valor);
    }
}

class AuditoriaLog {
    private static AuditoriaLog instancia;

    private AuditoriaLog() {}

    public static synchronized AuditoriaLog getInstance(){
        if (instancia == null){
            instancia = new AuditoriaLog();
        }
        return instancia;
    }

    public void gravar(String conteudo){
        Path caminho = Path.of("Atividade03/log.txt");
        
        try{
            Files.writeString(caminho, conteudo + System.lineSeparator(), 
                          StandardOpenOption.CREATE, 
                          StandardOpenOption.APPEND);
            System.out.println("Arquivo gravado com sucesso");
        } catch (IOException e){
            System.out.println("Erro ao gravar: " + e.getMessage());
        }
    }
}

class PagamentoFactory {
    public static PagamentoStrategy criarPagamento(String tipo){
        if (tipo.equals("Pix")){
            return new Pix();
        } else if (tipo.equals("Credito")){
            return new Credito();
        } else if (tipo.equals("Debito")) {
            return new Debito();
        }throw new IllegalArgumentException("Forma de pagamento inválida: " + tipo);
    }
}
public class main {
    public static void main(String[] args) {
        double carrinho = 100.00;

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a forma de pagamento - Pix, Credito ou Debito: ");
        String formaDePagamento = sc.nextLine();

        PagamentoStrategy estrategia = PagamentoFactory.criarPagamento(formaDePagamento);
        double valor = estrategia.pagamento(carrinho);

        AuditoriaLog log = AuditoriaLog.getInstance();
        log.gravar("Pagamento de R$" + valor + " realizado via " + formaDePagamento);

        sc.close();


    }
}
