import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Janela extends JFrame {
    private JPanel painel;
    private JComboBox jcbFonte, jcbCor, jcbTamanho;
    private JLabel jlFonte, jlCor,jlTamanho;
    private JButton jbAltFormatacao, jbLimpaFormatacao, jbApaga;
    private JRadioButton jrbNegrito, jrbNormal, jrbItalico, jrbNegItalico;
    private JLabel jblSexo, jblEstilo;
    private ButtonGroup grupoFormatacao;
    private JTextArea jtxaTexto;
    private JScrollPane jspTexto;


    public Janela(){
        painel = new JPanel();

        /*jcbFonte = new JComboBox(new String[]{"Espírito Santo", "Minas Gerais", "Rio de Janeiro", "São Paulo"});
        jcbCor = ;
        jcbTamanho = ;*/

        jlFonte = new JLabel("Fonte: ");
        jlCor = new JLabel("Cor: ");
        jlTamanho = new JLabel("Tamanho: ");

        jbAltFormatacao = new JButton("Alterar Formatação");
        jbAltFormatacao = new JButton("Limpar Formatação");
        jbAltFormatacao = new JButton("Apagar Texto");

        jrbNegrito = new JRadioButton("Negrito");
        jrbNormal = new JRadioButton("Normal");
        jrbItalico = new JRadioButton("Italico");
        jrbNegItalico = new JRadioButton("Negrito-Itálico");
        grupoFormatacao = new ButtonGroup();

        jtxaTexto = new JTextArea();
        jspTexto = new JScrollPane(jtxaTexto);
    }

    public void configurarJanela(){
        setVisible(true);
        setTitle("Aula 23/04");
        setSize(800,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocation(600, 100);
        add(painel);
        configurarPainel();

    }

    public void configurarPainel(){
        painel.setBackground(Color.PINK);
        painel.setLayout (null);




        jspTexto.setBounds(10, 10, 190, 100);
        jspTexto.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jspTexto.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        //jspTexto.setLineWrap(true);
        painel.add(jspTexto);

        

        jbAltFormatacao.setBounds(110, 130, 90, 20);
        jbAltFormatacao.addActionListener(evento ->{
            jtxaTexto.setFont(new Font("Arial", Font.BOLD, 16));
            jtxaTexto.setForeground(Color.MAGENTA);
        });
        painel.add(jbAltFormatacao);

        
    }


}