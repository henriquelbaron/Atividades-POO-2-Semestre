
import java.util.List;

public class ListaEncadeada implements Lista {

    private Integer quantidade;
    private No inicio;

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
        return inicio;
    }

    public void setElemento(No elemento) {
        this.inicio = elemento;
    }

    @Override
    public void adicionar(Object o) {
        No novoElemento = new No();
        novoElemento.setElemento(o);
        if (null == inicio) {
            inicio = novoElemento;
        } else {
            No auxiliar = inicio;
            while (auxiliar.getProximo() != null) {
                auxiliar = auxiliar.getProximo();
            }
            auxiliar.setProximo(novoElemento);
        }
        quantidade++;
    }

    @Override
    public void adicionar(Object o, Integer id) {
        if (id > quantidade) {
            System.out.println("Erro");
            return;
        }
        if (id.equals(1)) {
            No elemento = new No();
            elemento.setElemento(o);
            No aux = inicio;
            inicio = elemento;
            inicio.setProximo(aux);
        } else {
            No novoElemento = new No();
            novoElemento.setElemento(o);
            No auxiliar = inicio;
            Integer indice = 1;
            while (!id.equals(indice + 1)) {
                auxiliar = auxiliar.getProximo();
                indice++;
            }
            No temporario = auxiliar.getProximo();
            novoElemento.setProximo(temporario);
            auxiliar.setProximo(novoElemento);
        }
        quantidade++;
    }

    @Override
    public Object buscar(Object o) {
        No auxiliar = inicio;
        while (auxiliar.getProximo() != null) {
            if (auxiliar.getProximo().equals(o)) {
                return auxiliar;
            }

        }
        return null;
    }

    @Override
    public Object buscar(Integer i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean remover(Object o) {
        No novoElemento = new No();
        if (null == inicio) {
            return false;
        } else {
            No auxiliar = inicio;
            while (auxiliar.getProximo() != null) {
                if (auxiliar.getProximo().equals(o)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Boolean remover(Integer i) {
        if (i == 1) {
            inicio = inicio.getProximo();
        }
        Integer id = 1;
      
    }

    @Override
    public Integer tamanho() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean existe(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        String texto = "";
        if (this.quantidade > 0) {
            No auxiliar = inicio;
            while (auxiliar != null) {
                texto += auxiliar.getElemento() + ",";
                auxiliar = auxiliar.getProximo();

            }
            return texto.substring(0, texto.length() - 1);
        }
        return texto;
    }
}
