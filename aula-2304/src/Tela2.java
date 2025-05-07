import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Tela2 extends JFrame {
    private JPanel painel;
    private JRadioButton jrbFem, jrbMasc, jrbNaoB;
    private JCheckBox jckRock, jckPop, jckTrap, jckIndie;
    private JLabel jblSexo, jblEstilo;
    private ButtonGroup grupoSexo;
    private JButton jbImprimir;

    public Tela2(){
        painel = new JPanel();
        jrbFem = new JRadioButton("Feminino");
        jrbMasc = new JRadioButton("Masculino");
        jrbNaoB = new JRadioButton("Não binário");
        jckRock = new JCheckBox("Rock");
        jckPop = new JCheckBox("Pop");
        jckTrap = new JCheckBox("Trap");
        jckIndie = new JCheckBox("Indie");
        jblSexo = new JLabel("Sexo: ");
        jblEstilo = new JLabel("Estilo Musical Preferido: ");
        grupoSexo = new ButtonGroup();
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
        //painel.setLayout (null);
        grupoSexo.add(jrbFem);
        grupoSexo.add(jrbMasc);
        grupoSexo.add(jrbNaoB);
        painel.add(jblSexo);
        painel.add(jrbFem);
        painel.add(jrbMasc);
        painel.add(jrbNaoB);
        painel.add(jblEstilo);
        painel.add(jckRock);
        painel.add(jckPop);
        painel.add(jckTrap);
        painel.add(jckIndie);
        jbImprimir.addActionListener((evento ->{
            String retorno = "Sexo: ";
            if (jrbFem.isSelected())
                retorno +="Feminino\n";
            else if (jrbMasc.isSelected())
                retorno +="Masculino\n";
            else if (jrbNaoB.isSelected())
                retorno +="Não Binário";

            retorno += "Estilo Musical Favorito: \n";
            if (jckRock.isSelected())
                retorno+="ROCK AND ROLL!!!!!\n";
            if (jckPop.isSelected())
                retorno+="Pop\n";
            if (jckTrap.isSelected())
                retorno+="Trap\n";
            if (jckIndie.isSelected())
                retorno+="Indie\n";
            
            JOptionPane.showMessageDialog(this, retorno, "Resultado", JOptionPane.PLAIN_MESSAGE);

        }));
        painel.add(jbImprimir);
    }

}