# Simulador de Taxa de Variação Instantânea

Este projeto é uma aplicação desenvolvida em **Java** para a disciplina de Cálculo. O objetivo é calcular a taxa de variação instantânea (derivada) de funções específicas e visualizar graficamente a reta tangente no ponto escolhido.

O software resolve dois problemas práticos:
1.  **Análise de Algoritmos:** Variação do tempo de execução.
2.  **Biologia:** Crescimento de uma população de fitoplâncton.

## 🚀 Funcionalidades

*   **Interface Gráfica:** Navegação simples para escolha da questão e entrada de dados.
*   **Cálculo Passo a Passo:** Exibe na tela a substituição dos valores na função derivada e o resultado final.
*   **Visualização Gráfica:** Gera um gráfico interativo contendo:
    *   A curva da função original ($f(n)$).
    *   A reta tangente no ponto $n$ escolhido.
    *   Marcação visual do ponto de tangência.

## 🛠️ Tecnologias Utilizadas

*   **Java (JDK 8+)**: Linguagem base.
*   **Java Swing**: Para construção das janelas e interface.
*   **JFreeChart**: Biblioteca externa para plotagem dos gráficos cartesianos.

## 📋 Pré-requisitos

Para rodar este código, você precisa ter o **Java Development Kit (JDK)** instalado e as bibliotecas do **JFreeChart** configuradas no projeto.

## 🔧 Como Rodar (versão VS Code)

1.  Clone o repositório no seu ambiente.
2.  Compile o arquivo principal na raiz no cmd:
    ```bash
    javac -encoding UTF-8 -cp "libs/*" src\TaxadeVariacao.java -d out
    ```
3.  Execute a aplicação:
    ```bash
    java -cp "out;libs/*" TaxadeVariacao
    ```
*(Se estiver usando IDEs como IntelliJ ou Eclipse, basta adicionar a biblioteca nas configurações do projeto e rodar a classe `TaxadeVariacao`).*

## 📚 Funções Analisadas

**Questão 1 (Tempo de Execução):**
*   Função: $T(n) = 5n^3 + n^2 - 6n + 10$
*   Derivada: $T'(n) = 15n^2 + 2n - 6$

**Questão 2 (População):**
*   Função: $P(n) = n^3 - 5n^2 + 20n + 12$
*   Derivada: $P'(n) = 3n^2 - 10n + 20$

---
**Componentes do grupo:**
- Alexandre Ribeiro - RA 12724133597 
- Eraldino Ramos Albergaria Lopes - RA 12724123513
- Victor Botto Silva Passos - RA 12724130769
- ⁠Paulo Victor Nonato de Jesus - RA 12724129348
- Rafael Silva Rangel de Almeida - RA 1272412932
- Davi Floriano Hermida de Souza Cruz - RA 1272413195
