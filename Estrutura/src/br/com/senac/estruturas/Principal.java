package br.com.senac.estruturas;


public class Principal {

    public static void main(String[] args) {
        ListaEncadeada no = new ListaEncadeada();
        System.out.println(no);
            no.adicionar(3);
            no.adicionar(4);
            no.adicionar(5);
            no.adicionar(7);
            no.adicionar(8);
            System.out.println(no);
            no.adicionar(1,1);
            no.adicionar(2,2);
            no.adicionar(6,6);
            System.out.println(no);
            
            no.adicionar("henrique");
            no.adicionar("aa");
            System.out.println("\nBuscar");
            System.out.println(no.buscar("henriqu"));
            System.out.println(no.buscar(9));
            
            System.out.println("\nRemover");
            System.out.println(no.remover("aa"));
            System.out.println(no.remover(2));
            
            System.out.println(no);
            System.out.println("\nExiste");
            System.out.println(no.existe("joao"));
            System.out.println(no.existe("henrique"));
    }
}
