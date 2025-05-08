import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Tela1 extends JFrame {
    private JPanel painel;
    private JLabel jlNomeCompleto, jlDataNasc, jlNome;
    private TextField jtxNome;
    private JButton jbOk;
    
    public Tela1(){
        painel = new JPanel();
        jlNomeCompleto = new JLabel("Maria Fernanda Machado Rabelo");
        jlDataNasc = new JLabel ("01/08/2002");
        jlNome = new JLabel ("Nome: ");
        jtxNome = new TextField();
        jbOk = new JButton("OK");
    }

    public void configurarJanela(){
        setVisible(true);
        setTitle("Aula 16/04");
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocation(600, 100);
        add(painel);
        configurarPainel();
    }

    public void configurarPainel(){
        painel.setLayout(null);
        painel.setBackground(Color.PINK);
        jlNomeCompleto.setFont (new Font ("Arial", Font.BOLD, 20));
        jlNomeCompleto.setForeground(Color.RED);
        jlNomeCompleto.setBounds(10, 10, 400, 30);
        painel.add(jlNomeCompleto);
        jlDataNasc.setBounds(420, 10, 80, 30);
        painel.add(jlDataNasc);
        jlNome.setBounds(10, 50, 50, 30);
        painel.add(jlNome);
        jtxNome.setBounds(65,50,100,30);
        painel.add(jtxNome);
        jbOk.setBounds(50, 90, 60, 30);
        painel.add(jbOk);
        jbOk.addActionListener((e)-> {
            JOptionPane.showMessageDialog(this, "oiiiiiiiiiiiiiiiiii");
        });
    }
}