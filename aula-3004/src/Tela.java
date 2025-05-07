import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Tela extends JFrame {
    private JPanel painel;
    private JComboBox jcbEstados;
    private JLabel jlEstados;
    private JButton jbAdicionar, jbImprimir;
    
    public Tela(){
        painel = new JPanel();
        jcbEstados = new JComboBox(new String[]{"Espírito Santo", "Minas Gerais", "Rio de Janeiro", "São Paulo"});
        jlEstados = new JLabel("Selecione o estado: ");
        jbAdicionar = new JButton("Adicionar");
        jbImprimir = new JButton("Imprimir");

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
        painel.setLayout (null);

        jlEstados.setBounds(10, 10, 120, 20);
        painel.add(jlEstados);
        jcbEstados.setBounds(135, 10, 130, 20);
        painel.add(jcbEstados);
        
        jbAdicionar.setBounds(10, 40, 120, 20);
        jbAdicionar.addActionListener(evento ->{
            String estado = JOptionPane.showInputDialog("Digite o nome do estado:");
            jcbEstados.addItem(estado);
        });
        painel.add(jbAdicionar);

        jbImprimir.setBounds(145, 40, 120, 20);
        jbImprimir.addActionListener(evento ->{
            String estado = jcbEstados.getSelectedItem().toString();
            int i = jcbEstados.getSelectedIndex();
            JOptionPane.showMessageDialog(this, "Índice selecionado: "+i+"\nCorresponde ao estado: "+estado);
        });
        painel.add(jbImprimir);
    }



}