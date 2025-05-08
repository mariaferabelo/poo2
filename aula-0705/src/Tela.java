import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class Tela extends JFrame {
    private JPanel painel;
    private JButton[] jbBotoes;
    
    
    
    public Tela(){
        painel = new JPanel();
        jbBotoes = new JButton[5];
        for (int i=0; i<5; i++){
            jbBotoes[i] = new JButton("Botao "+(i+1));
        }

    }

    public void configurarJanela(){
        setVisible(true);
        setTitle("Aula 30/04");
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocation(600, 500);
        add(painel);
        configurarPainel();

    }

    public void configurarPainel(){
        painel.setBackground(Color.PINK);
        //painel.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 20));
        painel.setLayout(new GridLayout(3, 2, 15, 15));
        for (int i=0; i<5; i++){
            painel.add (jbBotoes[i]);
        }
        
    }
}