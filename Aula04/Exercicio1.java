import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Exercicio1 extends JFrame {
    public Exercicio1(){
        setTitle("Primeira Janela - LBP2");
        setSize(800, 600);

        //Define a operação que irá ocorrer após o fechamento da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null); //Null deixa centralizado
    }

    public static void main(String[] args){
        //Para invocar a janela de maneira mais segura
        //Linha de processo assíncrono, assim, caso a janela não abra, o código não quebra
        SwingUtilities.invokeLater(() -> {
            Exercicio1 janela = new Exercicio1();

            janela.setVisible(true);
        });
    }
}
