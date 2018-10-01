/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadebanco.SistemaDeBanco;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * Crie um programa que implemente um sistema bancário com dados de 50
 * correntistas. Carregue os dados dos correntistas a partir do arquivo
 * “correntistas.txt” e após isso inicie o menu inicial pedindo para o usuário
 * fazer login (solicitando agência e senha). Depois do usuário logar apresente
 * e implemente um menu de opções com as funcionalidades: (i) Saldo; (ii) Sacar;
 * (iii) Depositar; (iv) Transferir; (v) Sair. A opção sair deve voltar para o
 * menu inicial. Atentando que não é permitido fazer operação bancária que
 * resulte saldo negativo.
 */
public class Principal {

    /**
     * @param args the command line arguments
     *
     * @author xAcer
     */
    private static Correntista CONTALOGADA = new Correntista();
    public static DecimalFormat df = new DecimalFormat("#,###.00");
    
    public static void main(String[] args) throws Exception {
        addCorrentista();
        boolean infinito;
        JOptionPane.showMessageDialog(null, "Bem vindo!");
        do {
            JOptionPane.showMessageDialog(null, "Por Favor insira sua Conta e Agencia para efetuar o Loguin");
            int conta = Integer.valueOf(JOptionPane.showInputDialog("Conta:"));
            int agencia = Integer.valueOf(JOptionPane.showInputDialog("Agencia:"));
            CONTALOGADA = Negocio.logar(conta, agencia);
            if (CONTALOGADA != null) {
                System.out.println(CONTALOGADA.toString());
                JOptionPane.showMessageDialog(null, "Bem vindo " + CONTALOGADA.getNome());
                mostrarMenu();
            } else {
                int v = JOptionPane.showConfirmDialog(null, "Agencia e Conta incorretas\nDeseja tentar Novamente?", "Titulo", JOptionPane.YES_NO_OPTION);
                if (v == 1) {
                    JOptionPane.showMessageDialog(null, "Obrigado!\n Até mais!");
                    System.exit(0);
                    break;
                }
            }
        } while (infinito = true);
    }

    private static void mostrarMenu() {
        String menu = ">>>MENU<<<<\n"
                + "(1) Verificar Saldo\n"
                + "(2) Sacar\n"
                + "(3) Depositar\n"
                + "(4) Tranferir\n"
                + "(0) Sair";
        String opcao = "";
        do {
        try {
            opcao = JOptionPane.showInputDialog(menu);
            switch (opcao) {
                case "1":
                    JOptionPane.showMessageDialog(null, df.format(CONTALOGADA.getSaldo()) + " Reais");
                    break;
                case "2":
                    sacar();
                    break;
                case "3":
                    depositar();
                    break;
                case "4":
                    transferir();
                    break;
                case "0":
                    CONTALOGADA = null;
                    JOptionPane.showMessageDialog(null, "Volte Sempre!");
                    break;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Somente numero são aceitos");
        }
        } while (!opcao.equals("0"));
    }

    private static void sacar() {
        double saque = Double.valueOf(JOptionPane.showInputDialog("Digite o valor"));
        if (CONTALOGADA.getSaldo() >= saque) {
            CONTALOGADA.setSaldo(CONTALOGADA.getSaldo() - saque);
            JOptionPane.showMessageDialog(null, "Saque efetuado com sucesso");
        } else {
            saldoNegativo();
        }
    }
    
    private static void depositar() {
        double deposito = Double.valueOf(JOptionPane.showInputDialog("Informe a quantia do Deposito"));
        CONTALOGADA.setSaldo(CONTALOGADA.getSaldo() + deposito);
        JOptionPane.showMessageDialog(null, "Deposito Efetuado");
    }
    
    private static void transferir() {
        double valor = Double.parseDouble(JOptionPane.showInputDialog("Quanto Deseja Tranferir?"));
        if (CONTALOGADA.getSaldo() <= valor) {
            saldoNegativo();
        }
        int conta = Integer.parseInt(JOptionPane.showInputDialog("Para qual conta deseja realizar tranferencia?"));
        if (!Negocio.verificaConta(conta)) {
            JOptionPane.showMessageDialog(null, "Conta incorreta");
        } else {
            CONTALOGADA.setSaldo(CONTALOGADA.getSaldo() - valor);
            Negocio.transferir(valor, conta);
            JOptionPane.showMessageDialog(null, "Transferencia realizada com sucesso!");
        }
    }

    private static void saldoNegativo() {
        int v = JOptionPane.showConfirmDialog(null, "Saldo insuficiente!\nDeseja realizar Deposito?",
                "SALDO INSUFICIENTE!", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
        if (v == 0) {
            depositar();
            transferir();
        } else {
            mostrarMenu();
        }
    }
    
    private static void addCorrentista() throws Exception {
        try {
            FileReader leitor = new FileReader("correntistas.txt");
            BufferedReader bf = new BufferedReader(leitor);
            String linha = bf.readLine();
            String conteudo = "";
            while (linha != null) {
                conteudo += linha + "\n";
                linha = bf.readLine();
            }
            bf.close();
            String[] ler = conteudo.split("\n");
            for (int i = 1; i < ler.length; i++) {
                String string = ler[i];
                String[] dados = string.split(";");
                String nome = dados[0];
                int agencia = Integer.valueOf(dados[1]);
                int conta = Integer.valueOf(dados[2]);
                double saldo = Double.valueOf(dados[3]);
                Negocio.addCorrentista(nome, agencia, conta, saldo);
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Arquivo não encontrado");
            System.exit(0);
        } 
    }
    
}
