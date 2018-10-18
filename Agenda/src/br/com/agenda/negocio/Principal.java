package br.com.agenda.negocio;


import br.com.agenda.dominio.Contato;
import br.com.agenda.view.AdicionarNovo;
import br.com.agenda.view.FramePrincipal;
import br.com.agenda.view.ListaDeContatos;
import com.sun.org.apache.bcel.internal.generic.F2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alunos
 */
public class Principal {
    
    
    private static FramePrincipal frame;
    
    public static void main(String[] args) {
        Negocio.salvar(new Contato("Henrique","000.000.000-00","seuemail@gmail.com"));
        Negocio.salvar(new Contato("Luiza","000.000.000-00","seuemail@gmail.com"));
        Negocio.salvar(new Contato("Felipe","000.000.000-00","seuemail@gmail.com"));
        Negocio.salvar(new Contato("Robson","000.000.000-00","seuemail@gmail.com"));
        Negocio.salvar(new Contato("Érick","000.000.000-00","seuemail@gmail.com"));
        Negocio.salvar(new Contato("Agostinho","000.000.000-00","seuemail@gmail.com"));
        Negocio.salvar(new Contato("Willian","000.000.000-00","seuemail@gmail.com"));
        Negocio.salvar(new Contato("Gabriel","000.000.000-00","seuemail@gmail.com"));
        
        
        frame = new FramePrincipal();
        frame.setTitle("Agenda");
//        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void listarContatos() {
        ListaDeContatos lista = new ListaDeContatos();
        frame.setContentPane(lista);
        frame.setVisible(true);
    }
    public static void alterar(Contato c){
        AdicionarNovo painel = new AdicionarNovo(c);
        frame.setContentPane(painel);
        frame.setVisible(true);
    }
    public static void adicionarNovo(){
        AdicionarNovo painel = new AdicionarNovo(null);
        frame.setContentPane(painel);
        frame.setVisible(true);
    }

}
