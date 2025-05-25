import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

public class Tela extends JFrame {
    private JPanel painel;
    private JLabel jlLogin, jlCep, jlOpcoes;
    private JPasswordField jpfLogin;
    private JButton jbImprimir;
    private JFormattedTextField jftxCep, jftxTeste;
    private JSpinner jspOpcoes, jspIntervalo;

    public Tela (){
        painel = new JPanel();
        jlLogin = new JLabel("Login:");
        jpfLogin = new JPasswordField();
        jbImprimir = new JButton("Imprimir");
        jlCep = new JLabel("CEP:");
        try{
            jftxCep = new JFormattedTextField(new MaskFormatter("##.###-###"));
            jftxTeste = new JFormattedTextField(new MaskFormatter("UUUU"));
        }catch (ParseException erro){
            System.out.println(erro.getMessage());
        }
        jlOpcoes = new JLabel("Opções");
        jspOpcoes = new JSpinner(new SpinnerListModel(new String[]{"Opção 1", "Opção 2", "Opção 3", "Opção 4", "Opção 5"}));
        jspIntervalo = new JSpinner(new SpinnerNumberModel(50, 0, 100, 1));
    }

    public void configurarJanela(){
        setVisible(true);
        setTitle("Aula 14/05");
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
        
        jlLogin.setBounds(10, 10, 50, 20);
        painel.add(jlLogin);
        jpfLogin.setBounds(65, 10, 100, 20);
        painel.add(jpfLogin);
        
        jbImprimir.setBounds(170, 10, 90, 20);
        jbImprimir.addActionListener(evento ->{
            String senha = new String(jpfLogin.getPassword());
            JOptionPane.showMessageDialog(this, "CEP: "+jftxCep.getText()+"\nSenha: " +senha+ 
                                    "\nOpção: "+jspOpcoes.getValue().toString()+
                                    "\nIntervalo: "+jspIntervalo.getValue().toString(), 
                                    "INFO", JOptionPane.PLAIN_MESSAGE);
        });
        painel.add(jbImprimir);

        jlCep.setBounds(10, 40, 50, 20);
        painel.add(jlCep);
        jftxCep.setBounds(65, 40, 100, 20);
        painel.add(jftxCep);
        jftxTeste.setBounds(170, 40, 50, 20);
        painel.add(jftxTeste);

        jlOpcoes.setBounds(10, 70, 50, 20);
        painel.add(jlOpcoes);
        jspOpcoes.setBounds(65, 70, 100, 20);
        painel.add(jspOpcoes);
        jspIntervalo.setBounds(170, 70, 70, 20);
        painel.add(jspIntervalo);

    }
}