import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class Tela2 extends JFrame{
    
    private JPanel painel;
    private JPanel regioes[];
    private JButton[] jbBotoesNorte, jbBotoesCentro;
    private JLabel jlEast, jlWest, jlObservacao;
    private JTextArea jtxaObservacao;
    private JScrollPane jspObservacao;
    private JMenuBar barra;
    private JMenu jmSobre;
    private JMenuItem jmiAbout, jmiOpcoes;
    
    public Tela2(){
        painel = new JPanel();
        regioes = new JPanel[5];
        for (int i=0; i<5; i++){
            regioes[i] = new JPanel();
        }
              
        jbBotoesNorte = new JButton[3];
        for (int i=0; i<3; i++){
            jbBotoesNorte[i] = new JButton("Botao " + (i+1));
        }

        jlEast = new JLabel("East");
        jlWest = new JLabel("West");
        jlObservacao = new JLabel("Observacao: ");
        jtxaObservacao = new JTextArea(10, 20);
        jspObservacao = new JScrollPane(jtxaObservacao);
        barra = new JMenuBar();
        jmSobre = new JMenu("Sobre");
        jmiAbout = new JMenuItem("About");
        jmiOpcoes = new JMenu ("versao");

        jbBotoesCentro = new JButton[6];
        for (int i=0; i<6; i++){
            jbBotoesCentro[i] = new JButton("Botao " + (i+1));
        }

        configurarJanela();
    }
    
    public void configurarJanela(){
        setVisible(true);
        setTitle("Aula 07/05");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        add(painel);
        setJMenuBar(barra);
        configurarPainel();
    }
    
    public void configurarPainel(){
       painel.setLayout(new BorderLayout());
       configurarPainelNorth();
       painel.add(regioes[0], BorderLayout.NORTH);
       configurarPainelEast();
       painel.add(regioes[1], BorderLayout.EAST);
       configurarPainelSouth();
       painel.add(regioes[2], BorderLayout.SOUTH);
       configurarPainelWest();
       painel.add(regioes[3], BorderLayout.WEST);
       configurarPainelCenter();
       painel.add(regioes[4], BorderLayout.CENTER);

       barra.add(jmSobre);
       jmSobre.add(jmiAbout);
       jmSobre.add(jmiOpcoes);

    }
    
    private void configurarPainelNorth(){
        regioes[0].setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 5));
        regioes[0].setBackground(Color.WHITE);
        jbBotoesNorte[0].addActionListener(eveto->{
            JOptionPane.showMessageDialog(this, "Clicou botao 1");
        });
        jbBotoesNorte[1].addActionListener(eveto->{
            JOptionPane.showMessageDialog(this, "Clicou botao 2");
        });
        jbBotoesNorte[2].addActionListener(eveto->{
            JOptionPane.showMessageDialog(this, "Clicou botao 3");
        });

        for (int i=0; i<3; i++){
            regioes[0].add(jbBotoesNorte[i]);
        }
    }
    
    private void configurarPainelEast(){
        regioes[1].setBackground(Color.ORANGE);
        regioes[1].add(jlEast);
    }
    
    private void configurarPainelSouth(){
        regioes[2].setBackground(Color.RED);
        regioes[2].add(jlObservacao);
        regioes[2].add(jspObservacao);
    }
    
    private void configurarPainelWest(){
        regioes[3].setBackground(Color.YELLOW);
        jlWest.setText("aaaaaaaaaaaaaaaaa");
        regioes[3].add(jlWest);
    }
    
    private void configurarPainelCenter(){
        regioes[4].setLayout(new GridLayout(3, 3));
        regioes[4].setBackground(Color.BLUE);
        for (int i = 0; i<6; i++){
            regioes[4].add(jbBotoesCentro[i]);
            jbBotoesCentro[0].addActionListener(evento->{
                JOptionPane.showMessageDialog(this, "uepaaa");
            });
            jbBotoesCentro[1].addActionListener(evento->{
                String texto = jtxaObservacao.getText();
                JOptionPane.showMessageDialog(this, "Texto do Sul: \n"+texto);
            });
            jbBotoesCentro[2].addActionListener(evento->{
                jlObservacao.setFont(new Font ("Courier New", Font.BOLD, 20));
            });
            jbBotoesCentro[3].addActionListener(evento->{
                jbBotoesNorte[1].setForeground(Color.RED);
            });
            jbBotoesCentro[4].addActionListener(evento->{
                jlEast.setFont(new Font ("Arial Black", Font.BOLD, 20));
            });
            jbBotoesCentro[5].addActionListener(evento->{
                regioes[0].setBackground(Color.GREEN);
            });
        }
    }
    
}