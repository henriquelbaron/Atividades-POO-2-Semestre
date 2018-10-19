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
        Negocio.adicionar(new Contato(1,"Henrique","000.000.000-00","seuemail@gmail.com"));
        Negocio.adicionar(new Contato(2,"Luiza","000.000.000-00","seuemail@gmail.com"));
        Negocio.adicionar(new Contato(3,"Felipe","000.000.000-00","seuemail@gmail.com"));
        Negocio.adicionar(new Contato(4,"Robson","000.000.000-00","seuemail@gmail.com"));
        Negocio.adicionar(new Contato(5,"Érick","000.000.000-00","seuemail@gmail.com"));
        Negocio.adicionar(new Contato(6,"Agostinho","000.000.000-00","seuemail@gmail.com"));
        Negocio.adicionar(new Contato(7,"Willian","000.000.000-00","seuemail@gmail.com"));
        Negocio.adicionar(new Contato(9,"Gabriel","000.000.000-00","seuemail@gmail.com"));
        
        
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
    
    public static void criarNovo(){
        frame.setCursor(AdicionarNovo);
        frame.setVisible(true);
        
    }
}
