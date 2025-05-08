import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tela extends JFrame {
    private JPanel painel;
    public Tela(){
        painel = new JPanel();
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
        //painel.setBackground(Color.PINK);
    }
}