
import java.util.List;

public class ListaEncadeada implements Lista {

    private Integer quantidade;
    private No novo;
    private List<No> lista;

    public ListaEncadeada() {
        this.quantidade = 0;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public No getElemento() {
        return novo;
    }

    public void setElemento(No elemento) {
        this.novo = elemento;
    }

    @Override
    public void adicionar(Object o) {
        No novoElemento = new No();
        novoElemento.setElemento(o);
        if (null == novo) {
            novo = novoElemento;
        } else {
            No auxiliar = novo;
            while (auxiliar.getProximo() != null) {
                auxiliar = auxiliar.getProximo();
            }
            auxiliar.setProximo(novoElemento);
        }
        quantidade++;
    }

    @Override
    public void adicionar(Object o, Integer id) throws Exception{
        if(id > quantidade){
            E
            
        }
     if (id.equals(1)){
         
     }
    }

    @Override
    public Object buscar(Object o) {
       No busca = new No();
       busca.setElemento(o);
       while(busca){
                   
               }
        return null;
    }

    @Override
    public Object buscar(Integer i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean remover(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean remover(Integer i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer tamanho() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean existe(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
