import javax.swing.*;
import java.awt.*;

public class Exercicio3 extends JFrame{
    public Exercicio3(){
        setTitle("Login");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel painelForms = new JPanel(new GridLayout(2,2));

        JLabel lbUtilizador = new JLabel("Utilizador");
        JTextField txUtilizador = new JTextField();
        JLabel lbSenha = new JLabel("Senha: ");
        JPasswordField txSenha = new JPasswordField();

        painelForms.add(lbUtilizador);
        painelForms.add(txUtilizador);
        painelForms.add(lbSenha);
        painelForms.add(txSenha);

        JPanel painelBotao = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton botao = new JButton("Enviar");
        painelBotao.add(botao);

        //Evento do botão
        botao.addActionListener(e ->{
            if (txUtilizador.getText().equals("admin") && txSenha.getText().equals("1234")){
                JOptionPane.showMessageDialog(null, "Login realizado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Falha ao fazer login");
                txUtilizador.setText("");
                txSenha.setText("");
            }
        });

        add(painelForms, BorderLayout.CENTER);
        add(painelBotao, BorderLayout.SOUTH);
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(()->{
            new Exercicio3().setVisible(true);
        });
    }
}
