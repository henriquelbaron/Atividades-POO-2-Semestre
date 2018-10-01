/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadebanco.SistemaDeBanco;

/**
 *
 * @author Alunos
 */
public class Negocio {

    private static Correntista[] CORRENTISTA = new Correntista[100];
    private static Integer QUANTIDADE = 0;

    public static void addCorrentista(String nome, int agencia, int conta, double saldo) {
        Correntista cliente = new Correntista();
        cliente.setNome(nome);
        cliente.setAgencia(agencia);
        cliente.setConta(conta);
        cliente.setSaldo(saldo);
        CORRENTISTA[QUANTIDADE] = cliente;
        QUANTIDADE++;
    }

    public static Correntista logar(int conta, int agencia) {
        Correntista[] pesquisa = new Correntista[100];
        for (int i = 0; i < QUANTIDADE; i++) {
            Correntista cliente = CORRENTISTA[i];
            if (cliente.getAgencia() == agencia && cliente.getConta() == conta) {
                return cliente;
            }
        }
        return null;
    }

    public static void transferir(Double quantia, int conta) {
        for (int i = 0; i < QUANTIDADE; i++) {
            Correntista correntista = CORRENTISTA[i];
            if (correntista.getConta() == conta) {
                correntista.setSaldo(correntista.getSaldo()+quantia);
            }
        }
    }
    
    public static boolean verificaConta(int conta){
        for (int i = 0; i < QUANTIDADE; i++) {
            Correntista correntista = CORRENTISTA[i];
            if (correntista.getConta() == conta) {
                return true;
            }
        }
        return false;
    }

}
