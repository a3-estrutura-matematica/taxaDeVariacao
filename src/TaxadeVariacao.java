import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Math;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaxadeVariacao {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaInicial());
    }
}

class TelaInicial extends JFrame {

    public TelaInicial() {
        setTitle("Escolha a Questão");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2, 1, 10, 10));

        JButton btnQ1 = new JButton("Questão 1");
        JButton btnQ2 = new JButton("Questão 2");

        add(btnQ1);
        add(btnQ2);

        btnQ1.addActionListener(e -> new TelaEntrada(1));
        btnQ2.addActionListener(e -> new TelaEntrada(2));

        setVisible(true);
    }
}

class TelaEntrada extends JFrame {

    public TelaEntrada(int numeroQuestao) {
        setTitle("Entrada da Questão " + numeroQuestao);
        setSize(350, 150);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        JLabel label = new JLabel("Digite um número:");
        JTextField campo = new JTextField(10);
        JButton confirmar = new JButton("Confirmar");

        add(label);
        add(campo);
        add(confirmar);

        confirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = campo.getText();

                // Você trata o valor aqui se quiser
                new TelaSolucao(numeroQuestao, texto);
                dispose();
            }
        });

        setVisible(true);
    }
}

class TelaSolucao extends JFrame {

    private ChartPanel criarGraficoComTangente(
            double pontoN,
            java.util.function.DoubleFunction<Double> funcao,
            java.util.function.DoubleFunction<Double> derivada,
            String titulo,
            String nomeFuncao
    ) {

        XYSeries serieFuncao = new XYSeries(nomeFuncao);
        XYSeries serieTangente = new XYSeries("Tangente no ponto " + pontoN);
        XYSeries pointSeries = new XYSeries("Ponto de tangência");

        double xMin = pontoN - 5;
        double xMax = pontoN + 5;

        // Gera curva da função
        for (double x = xMin; x <= xMax; x += 0.1) {
            serieFuncao.add(x, funcao.apply(x));
        }

        // Cálculo do ponto e da reta tangente
        double y0 = funcao.apply(pontoN);
        double m = derivada.apply(pontoN);

        for (double x = xMin; x <= xMax; x += 0.1) {
            double yLinha = m * (x - pontoN) + y0;
            serieTangente.add(x, yLinha);
        }

        // Ponto onde a tangente toca
        pointSeries.add(pontoN, y0);

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(serieFuncao);
        dataset.addSeries(serieTangente);
        dataset.addSeries(pointSeries);

        JFreeChart chart = ChartFactory.createXYLineChart(
                titulo,
                "n",
                "f(n)",
                dataset
        );

        // ======== TRANSFORMAR EM PLANO CARTESIANO ========

        var plot = chart.getXYPlot();

        // Grid visível (tipo papel quadriculado)
        plot.setDomainGridlinesVisible(true);
        plot.setRangeGridlinesVisible(true);

        plot.setDomainGridlinePaint(new Color(180, 180, 180));
        plot.setRangeGridlinePaint(new Color(180, 180, 180));

        plot.setDomainGridlineStroke(new BasicStroke(1f));
        plot.setRangeGridlineStroke(new BasicStroke(1f));

        // Eixo X (y = 0)
        plot.setRangeZeroBaselineVisible(true);
        plot.setRangeZeroBaselineStroke(new BasicStroke(2f));
        plot.setRangeZeroBaselinePaint(Color.BLACK);

        // Eixo Y (x = 0)
        plot.setDomainZeroBaselineVisible(true);
        plot.setDomainZeroBaselineStroke(new BasicStroke(2f));
        plot.setDomainZeroBaselinePaint(Color.BLACK);

        // Nomes dos eixos
        plot.getDomainAxis().setLabel("Eixo X");
        plot.getRangeAxis().setLabel("Eixo Y");

        // ==================================================

        ChartPanel painel = new ChartPanel(chart);
        painel.setPreferredSize(new Dimension(450, 300));

        return painel;
    }




    public TelaSolucao(int numeroQuestao, String valorDigitado) {
        setTitle("Solução da Questão " + numeroQuestao);
        setSize(1000, 380);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Painel onde você vai colocar a fórmula
        JPanel painelFormula = new JPanel();
        painelFormula.setLayout(new BoxLayout(painelFormula, BoxLayout.Y_AXIS));
        double n = Double.parseDouble(valorDigitado);
        if (numeroQuestao == 1) {
            double n_squared = Math.pow(n, 2);
            double termo_n_quadrado = 15 * n_squared;
            double termo_n = 2 * n;
            double taxaInstantanea = (15 * Math.pow(n, 2)) + (2 * n) - 6;

            painelFormula.add(Box.createVerticalStrut(15));

            painelFormula.add(Box.createVerticalStrut(10));

            JLabel formula = new JLabel(
                "<html><div style='text-align:center; font-size:16px; font-weight:bold;'>"
                + "Solução da Questão 1"
                +"</div>"
                +"<div style='text-align:center;'>"
                + "Função: &nbsp; <b>T(n) = 5n³ + n² - 6n + 10</b><br><br>"
                + "Derivada: &nbsp; <b>T'(n) = 15n² + 2n - 6</b><br><br>"
                + "1. Substituição: T'(" + n + ") = 15 * (" + n + ")² + 2 * (" + n + ") - 6<br><br>"
                + "2. Produtos: T'(" + n + ") = " + termo_n_quadrado + " + " + termo_n + " - 6<br><br>"
                + "3. Resultado Final: T'(" + n + ") = " + taxaInstantanea + "<br><br>"
                + "=== RESPOSTA QUESTÃO 1:=== <br><br>"
                + "A taxa de variação instantânea do Tempo de Execução para n = " + n + " é: " + taxaInstantanea
                + "</div></html>"
            );

            formula.setAlignmentX(Component.CENTER_ALIGNMENT);
            painelFormula.add(formula);

            painelFormula.add(Box.createVerticalStrut(20));


        } else {
            double n_squared = Math.pow(n, 2);
            double termo_n_quadrado = 3 * n_squared;
            double termo_n = 10 * n;
            double taxaInstantanea = (3 * Math.pow(n, 2)) - (10 * n) + 20;

            painelFormula.add(Box.createVerticalStrut(15));

            painelFormula.add(Box.createVerticalStrut(10));

            JLabel formula = new JLabel(
                "<html><div style='text-align:center; font-size:16px; font-weight:bold;'>"
                + "Solução da Questão 2"
                +"</div>"
                +"<div style='text-align:center;'>"
                + "Função: &nbsp; <b>P(n) = n³ - 5n² + 20n + 200</b><br><br>"
                + "Derivada: &nbsp; <b>P'(n) = 3n² - 10n + 20</b><br><br>"
                + "1. Substituição: P'(" + n + ") = 3 * (" + n + ")² - 10 * (" + n + ") + 20<br><br>"
                + "2. Produtos: P'(" + n + ") = " + termo_n_quadrado + " - " + termo_n + " + 20<br><br>"
                + "3. Resultado Final: P'(" + n + ") = " + taxaInstantanea + "<br><br>"
                + "=== RESPOSTA QUESTÃO 2:=== <br><br>"
                + "A taxa de variação instantânea do Fitoplâncton para n = " + n + " mg/L é: " + taxaInstantanea
                + "</div></html>"
            );

            formula.setAlignmentX(Component.CENTER_ALIGNMENT);
            painelFormula.add(formula);


        }

        // Painel onde você vai colocar o gráfico
        JPanel painelGrafico = new JPanel();
        painelGrafico.setBackground(Color.LIGHT_GRAY);
        painelGrafico.setPreferredSize(new Dimension(350, 0));

        if (numeroQuestao == 1) {
            ChartPanel grafico = criarGraficoComTangente(
                n,
                x -> 5*Math.pow(x,3) + Math.pow(x,2) - 6*x + 7, // função T(n)
                x -> 15*Math.pow(x,2) + 2*x - 6,                // derivada T'(n)
                "Gráfico da Função T(n) e Tangente",
                "T(n)"
            );

            painelGrafico.add(grafico);
        } else {
            ChartPanel grafico = criarGraficoComTangente(
                    n,
                    x -> Math.pow(x,3) - 5*Math.pow(x,2) + 20*x + 12, // função
                    x -> 3*Math.pow(x,2) - 10*x + 20,                 // derivada
                    "Gráfico da População e Tangente",
                    "P(n)"
            );

            painelGrafico.add(grafico);
        }

        add(painelGrafico, BorderLayout.CENTER);

        JScrollPane scroll = new JScrollPane(painelFormula);
        scroll.setPreferredSize(new Dimension(430, 0));
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        add(scroll, BorderLayout.EAST);

        setVisible(true);
    }
}

