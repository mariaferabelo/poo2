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
    private ButtonGroup grupoFormatacao;
    private JTextArea jtxaTexto;
    private JScrollPane jspTexto;

    public Janela(){
        painel = new JPanel();

        jcbFonte = new JComboBox(new String[]{"Arial", "Courier New", "Garamond", "Georgia", "Helvetica",
                                                 "Lucida Console", "Tahoma", "Times New Roman", "Trebuchet MS", "Verdana"});
        jcbCor = new JComboBox(new String[]{"Amarelo", "Azul", "Branco", "Cinza", "Laranja", "Preto", "Rosa",
                                            "Roxo", "Verde", "Vermelho"});
        jcbTamanho = new JComboBox(new String[]{"8", "12", "14", "16", "18", "20", "22", "50", "60", "70"});

        jlFonte = new JLabel("Fonte: ");
        jlCor = new JLabel("Cor: ");
        jlTamanho = new JLabel("Tamanho: ");

        jbAltFormatacao = new JButton("Alterar Formatação");
        jbLimpaFormatacao = new JButton("Limpar Formatação");
        jbApaga = new JButton("Apagar Texto");

        jrbNegrito = new JRadioButton("Negrito");
        jrbNormal = new JRadioButton("Normal");
        jrbItalico = new JRadioButton("Itálico");
        jrbNegItalico = new JRadioButton("Negrito-Itálico");
        grupoFormatacao = new ButtonGroup();

        jtxaTexto = new JTextArea();
        jspTexto = new JScrollPane(jtxaTexto, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    }

    public void configurarJanela(){
        setVisible(true);
        setTitle("Janela");
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocation(600, 200);
        add(painel);
        configurarPainel();
    }

    public void configurarPainel(){
        painel.setBackground(Color.PINK);
        painel.setLayout (null);

        jlFonte.setBounds(20,20, 40, 20);
        painel.add(jlFonte);
        jcbFonte.setBounds(60, 20, 140, 20);
        painel.add(jcbFonte);

        jlTamanho.setBounds(235,20, 75, 20);
        painel.add(jlTamanho);
        jcbTamanho.setBounds(300, 20, 50, 20);
        painel.add(jcbTamanho);

        jlCor.setBounds(385,20, 30, 20);
        painel.add(jlCor);
        jcbCor.setBounds(415, 20, 100, 20);
        painel.add(jcbCor);

        grupoFormatacao.add(jrbNormal);
        grupoFormatacao.add(jrbNegrito);
        grupoFormatacao.add(jrbItalico);
        grupoFormatacao.add(jrbNegItalico);
        jrbNormal.setBounds(20, 60, 100, 30);
        painel.add(jrbNormal);
        jrbNegrito.setBounds(140, 60, 100, 30);
        painel.add(jrbNegrito);
        jrbItalico.setBounds(260, 60, 100, 30);
        painel.add(jrbItalico);
        jrbNegItalico.setBounds(380, 60, 120, 30);
        painel.add(jrbNegItalico);

        jbAltFormatacao.setBounds(20, 100, 150, 30);
        jbAltFormatacao.addActionListener(evento ->{
            String novaFonte = (String) jcbFonte.getSelectedItem();
            int novoTamanho = Integer.parseInt((String) jcbTamanho.getSelectedItem());
            String novaCor = (String) jcbCor.getSelectedItem();
            int tipoFonte = Font.PLAIN;
            if (jrbItalico.isSelected()){
                tipoFonte = Font.ITALIC;
            }else if (jrbNegrito.isSelected()){
                tipoFonte = Font.BOLD;
            }else if (jrbNegItalico.isSelected()){
                tipoFonte = Font.BOLD | Font.ITALIC;
            }

            Font novaFormatacao = new Font (novaFonte, tipoFonte, novoTamanho);
            jtxaTexto.setFont(novaFormatacao);
            
            switch (novaCor) {
                case "Preto":
                    jtxaTexto.setForeground(Color.BLACK);
                    break;
                case "Vermelho":
                    jtxaTexto.setForeground(Color.RED);
                    break;
                case "Azul":
                    jtxaTexto.setForeground(Color.BLUE);
                    break;
                case "Amarelo":
                    jtxaTexto.setForeground(Color.YELLOW);
                    break;
                case "Verde":
                    jtxaTexto.setForeground(Color.GREEN);
                    break;
                case "Roxo":
                    jtxaTexto.setForeground(Color.MAGENTA);
                    break;
                case "Rosa":
                    jtxaTexto.setForeground(Color.PINK);
                    break;
                case "Branco":
                    jtxaTexto.setForeground(Color.WHITE);
                    break;
                case "Cinza":
                    jtxaTexto.setForeground(Color.GRAY);
                    break;
                case "Laranja":
                    jtxaTexto.setForeground(Color.ORANGE);
                    break;
                }
        });
        painel.add(jbAltFormatacao);

        jbLimpaFormatacao.setBounds(200, 100, 150, 30);
        jbLimpaFormatacao.addActionListener(evento ->{
            jtxaTexto.setFont(new Font("Arial", Font.PLAIN, 12));
            jtxaTexto.setForeground(Color.BLACK);
            jrbNormal.setSelected(true);
        });
        painel.add(jbLimpaFormatacao);

        jbApaga.setBounds(380, 100, 150, 30);
        jbApaga.addActionListener(evento ->{
            jtxaTexto.setText("");
        });
        painel.add(jbApaga);

        jtxaTexto.setLineWrap(true);
        jspTexto.setBounds(20, 140, 500, 300);
        painel.add(jspTexto);
    }
}