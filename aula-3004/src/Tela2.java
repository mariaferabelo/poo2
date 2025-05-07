import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Tela2 extends JFrame {
    private JPanel painel;
    private JTextArea jtxaObservacao;
    private JScrollPane jspObservacao;
    private JButton jbImprimir;
    private JButton jbFormatar;

    public Tela2(){
        painel = new JPanel();
        jtxaObservacao = new JTextArea();
        jspObservacao = new JScrollPane(jtxaObservacao);
        jbImprimir = new JButton("Imprimir");
        jbFormatar = new JButton("Formatar");
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

        jspObservacao.setBounds(10, 10, 190, 100);
        jspObservacao.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jspObservacao.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jtxaObservacao.setLineWrap(true);
        painel.add(jspObservacao);

        jbImprimir.setBounds(10, 130, 85, 20);
        jbImprimir.addActionListener(evento ->{
            String texto = jtxaObservacao.getText();
            JOptionPane.showMessageDialog(this, texto);
        });
        painel.add(jbImprimir);

        jbFormatar.setBounds(110, 130, 90, 20);
        jbFormatar.addActionListener(evento ->{
            jtxaObservacao.setFont(new Font("Arial", Font.BOLD, 16));
            jtxaObservacao.setForeground(Color.MAGENTA);
        });
        painel.add(jbFormatar);

        
    }


}