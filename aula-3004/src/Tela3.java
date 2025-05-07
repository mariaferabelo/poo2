import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Tela3 extends JFrame {
    private JPanel painel;
    private JTable jtProduto;
    private JScrollPane jspProduto;
    private DefaultTableModel modeloProduto;
    private JButton jbAdicionar, jbImprimir;

    public Tela3(){
        painel = new JPanel();
        /*jtProduto = new JTable(new String [][]{{"1", "1", "1"}, {"2", "2", "2"}},
                                new String [] {"Descricao", "Preço", "Estoque"});*/
        modeloProduto = new DefaultTableModel(new String [] {"Descricao", "Preço", "Estoque"},0);
        jtProduto = new JTable(modeloProduto);
        jspProduto = new JScrollPane(jtProduto);
        jbAdicionar = new JButton("Adicionar");
        jbImprimir = new JButton("Imprimir");
        
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

        jtProduto.setBounds(10, 10, 160, 100);
        painel.add(jtProduto);

        jbAdicionar.setBounds(10, 120, 90, 20);
        jbAdicionar.addActionListener(evento ->{
            modeloProduto.addRow(new String [] {"Batata", "2,99", "50"});
            
        });
        painel.add(jbAdicionar);

        jbImprimir.setBounds(110, 120, 90, 20);
        jbImprimir.addActionListener(evento ->{
            int linha = jtProduto.getSelectedRow();
            JOptionPane.showMessageDialog(this, "Descrição: "+jtProduto.getValueAt(linha, 0)
                                        +"\nPreço: "+jtProduto.getValueAt(linha, 1)
                                        +"\nEstoque: "+jtProduto.getValueAt(linha, 2));
        });
        painel.add(jbImprimir);
        
    }

}