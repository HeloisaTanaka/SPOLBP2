import javax.swing.*;
import java.awt.*;

public class Exercicio2 extends JFrame{
    public Exercicio2(){
        setTitle("Login");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //O BorderLayout é o padrão
        setLayout(new BorderLayout());

        //JPanel fica dentro do BorderLayout
        //Dentro do JPanel, ficam os demais layouts e elementos
        JPanel painelForms = new JPanel(new GridLayout(2,2));

        //Criação dos elementos
        JLabel lbUtilizador = new JLabel("Utilizador");
        JTextField txUtilizador = new JTextField();
        JLabel lbSenha = new JLabel("Senha: ");
        JPasswordField txSenha = new JPasswordField();

        //Adiciona os elementos ao painelForms, que seguem o layout do grid
        painelForms.add(lbUtilizador);
        painelForms.add(txUtilizador);
        painelForms.add(lbSenha);
        painelForms.add(txSenha);

        //Cria um novo painel
        JPanel painelBotao = new JPanel(new FlowLayout(FlowLayout.CENTER));
        //Cria o botão
        JButton botao = new JButton("Enviar");
        //Adiciona o botão ao painelBotao
        painelBotao.add(botao);

        //Adiciona os Paineis ao BorderLayout
        add(painelForms, BorderLayout.CENTER);
        add(painelBotao, BorderLayout.SOUTH);
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(()->{
            new Exercicio2().setVisible(true);
        });
    }
}
