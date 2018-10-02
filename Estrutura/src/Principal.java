
public class Principal {
    public static void main(String[] args) {
        ListaEncadeada no = new ListaEncadeada();
        no.adicionar("henrique");
        no.adicionar("Denise");
        no.adicionar("Felipe");
        no.adicionar("Felipe");
        no.adicionar("Felipe");
        System.out.println(no.getQuantidade());
        
        System.out.println(no.buscar("henrique"));
    }
}
