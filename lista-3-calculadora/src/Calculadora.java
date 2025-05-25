import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.math.BigInteger;

public class Calculadora extends JFrame {
    private JPanel painel;
    private JButton[] botoes;
    private JTextField display;
    private String[] rotulos = {
        "AC", "+/-", "%", "RAIZ Q", "/",
        "7", "8", "9", "X^Y", "*",
        "4", "5", "6", "X^2", "-",
        "1", "2", "3", "X^3", "+",
        "0", ".", "X!", "10^x", "="
    };
    
    private double primeiroNumero;
    private String operacao;
    private boolean novoNumero;
    private String ultimoNumeroPressionado;
    private int contadorRepeticoes;
    private boolean modoAC = true; // true para AC, false para C

    public Calculadora() {
        painel = new JPanel();
        botoes = new JButton[25];
        display = new JTextField(20);
        
        configurarJanela();
        configurarBotoes();
    }

    private void configurarJanela() {
        setTitle("Calculadora");
        setSize(450, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        
        JPanel contentPane = new JPanel(new BorderLayout(5, 5));
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        contentPane.setBackground(Color.PINK);
        
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.BOLD, 28));
        display.setBackground(Color.WHITE);
        contentPane.add(display, BorderLayout.NORTH);
        
        painel.setBackground(Color.PINK);
        painel.setLayout(new GridLayout(5, 5, 5, 5));
        contentPane.add(painel, BorderLayout.CENTER);
        
        setContentPane(contentPane);
    }

    private void configurarBotoes() {
        for (int i = 0; i < 25; i++) {
            botoes[i] = new JButton(rotulos[i]);
            botoes[i].setFont(new Font("Arial", Font.BOLD, 18));
            botoes[i].addActionListener(new BotaoListener());
            
            // Personalização do botão AC/C
            if (i == 0) {
                botoes[i].setBackground(new Color(255, 150, 150));
            } else if (rotulos[i].matches("[0-9]")) {
                botoes[i].setBackground(Color.WHITE);
            } else {
                botoes[i].setBackground(new Color(220, 220, 220));
            }
            
            painel.add(botoes[i]);
        }
    }

    private class BotaoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String comando = ((JButton)e.getSource()).getText();
            
            // Lógica para números repetidos
            if (comando.matches("[0-9]")) {
                if (novoNumero) {
                    display.setText(comando);
                    novoNumero = false;
                    ultimoNumeroPressionado = comando;
                    contadorRepeticoes = 1;
                } else {
                    if (comando.equals(ultimoNumeroPressionado)) {
                        contadorRepeticoes++;
                        String textoAtual = display.getText();
                        // Remove o último caractere (número) e adiciona N vezes
                        textoAtual = textoAtual.substring(0, textoAtual.length() - contadorRepeticoes + 1);
                        for (int i = 0; i < contadorRepeticoes; i++) {
                            textoAtual += comando;
                        }
                        display.setText(textoAtual);
                    } else {
                        display.setText(display.getText() + comando);
                        ultimoNumeroPressionado = comando;
                        contadorRepeticoes = 1;
                    }
                }
                return;
            }
            
            // Resetar contador para não números
            ultimoNumeroPressionado = "";
            contadorRepeticoes = 0;
            
            switch (comando) {
                case "AC":
                    if (modoAC) {
                        display.setText("");
                        primeiroNumero = 0;
                        operacao = null;
                        novoNumero = true;
                    } else {
                        display.setText("");
                    }
                    // Alterna entre AC e C
                    modoAC = !modoAC;
                    botoes[0].setText(modoAC ? "AC" : "C");
                    break;
                    
                case "+/-":
                    if (!display.getText().isEmpty() && !display.getText().equals("0")) {
                        if (display.getText().charAt(0) == '-') {
                            display.setText(display.getText().substring(1));
                        } else {
                            display.setText("-" + display.getText());
                        }
                    }
                    break;
                    
                case "%":
                    if (!display.getText().isEmpty()) {
                        double valor = Double.parseDouble(display.getText());
                        display.setText(String.valueOf(valor / 100));
                    }
                    break;
                    
                case "RAIZ Q":
                    if (!display.getText().isEmpty()) {
                        double valor = Double.parseDouble(display.getText());
                        if (valor >= 0) {
                            display.setText(String.valueOf(Math.sqrt(valor)));
                        } else {
                            display.setText("Erro");
                        }
                        novoNumero = true;
                    }
                    break;
                    
                case "X^2":
                    if (!display.getText().isEmpty()) {
                        double valor = Double.parseDouble(display.getText());
                        display.setText(String.valueOf(valor * valor));
                        novoNumero = true;
                    }
                    break;
                    
                case "X^3":
                    if (!display.getText().isEmpty()) {
                        double valor = Double.parseDouble(display.getText());
                        display.setText(String.valueOf(valor * valor * valor));
                        novoNumero = true;
                    }
                    break;
                    
                case "Xi":
                    if (!display.getText().isEmpty()) {
                        try {
                            int valor = Integer.parseInt(display.getText());
                            if (valor < 0) {
                                display.setText("Erro");
                            } else {
                                BigInteger fatorial = BigInteger.ONE;
                                for (int i = 2; i <= valor; i++) {
                                    fatorial = fatorial.multiply(BigInteger.valueOf(i));
                                }
                                display.setText(fatorial.toString());
                            }
                        } catch (NumberFormatException ex) {
                            display.setText("Erro");
                        }
                        novoNumero = true;
                    }
                    break;
                    
                case "10^x":
                    if (!display.getText().isEmpty()) {
                        double expoente = Double.parseDouble(display.getText());
                        display.setText(String.valueOf(Math.pow(10, expoente)));
                        novoNumero = true;
                    }
                    break;
                    
                case "=":
                    if (operacao != null && !display.getText().isEmpty()) {
                        double segundoNumero = Double.parseDouble(display.getText());
                        double resultado = calcular(primeiroNumero, segundoNumero, operacao);
                        display.setText(String.valueOf(resultado));
                        operacao = null;
                        novoNumero = true;
                        modoAC = true;
                        botoes[0].setText("AC");
                    }
                    break;
                    
                case "+":
                case "-":
                case "*":
                case "/":
                case "X^Y":
                    if (!display.getText().isEmpty()) {
                        primeiroNumero = Double.parseDouble(display.getText());
                        operacao = comando;
                        novoNumero = true;
                        modoAC = false;
                        botoes[0].setText("C");
                    }
                    break;
                    
                case ".":
                    if (novoNumero) {
                        display.setText("0.");
                        novoNumero = false;
                    } else if (!display.getText().contains(".")) {
                        display.setText(display.getText() + ".");
                    }
                    break;
                    
                default:
                    break;
            }
        }
        
        private double calcular(double num1, double num2, String op) {
            switch (op) {
                case "+": return num1 + num2;
                case "-": return num1 - num2;
                case "*": return num1 * num2;
                case "/": 
                    if (num2 == 0) return Double.NaN;
                    return num1 / num2;
                case "X^Y": return Math.pow(num1, num2);
                default: return num2;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculadora calc = new Calculadora();
            calc.setVisible(true);
        });
    }
}