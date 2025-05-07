import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Tela extends JFrame {
    private JPanel painel;
    private JButton jbFechar, jbCalcular;
    private JLabel jlAnoNasc;
    private JTextField jtxAnoNasc;

    public Tela(){
        painel = new JPanel();
        jbFechar = new JButton("Fechar");
        jbCalcular = new JButton("Calcular");
        jlAnoNasc = new JLabel("Ano de nascimento");
        jtxAnoNasc = new JTextField();
    }

    public void configurarJanela(){
        setVisible(true);
        setTitle("Aula 23/04");
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocation(600, 100);
        add(painel);
        configurarPainel();

    }

    public void configurarPainel(){
        painel.setBackground(Color.PINK);
        painel.setLayout (null);
        jlAnoNasc.setBounds(10, 10, 130, 20);
        painel.add(jlAnoNasc);
        jtxAnoNasc.setBounds(145, 10, 90, 20);
        painel.add(jtxAnoNasc);
        jbCalcular.setBounds(30, 30, 100, 20);
        painel.add(jbCalcular);
        jbFechar.setBounds(135, 30, 100, 20);
        jbFechar.addActionListener(evento->{
            JOptionPane.showMessageDialog(this, "Você está saindo.");
            System.exit(0);
        });
        jbCalcular.addActionListener(evento->{
            String retorno = jtxAnoNasc.getText();
            int ano = Integer.parseInt(retorno);
            int idade = 2025 - ano;
            JOptionPane.showMessageDialog(this, "A sua idade é: " + idade + " anos!", 
                "Retorno da idade", JOptionPane.PLAIN_MESSAGE);
        });
        painel.add(jbFechar);


        
    }

    //sem lambda
    /*public void actionPerformed (ActionEvent evento){
        if (evento.getSource() == jbTeste){
            JOptionPane.showMessageDialog(this, "aaaaaaaaaaa");
        }
    }*/


}