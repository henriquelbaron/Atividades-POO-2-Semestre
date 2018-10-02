
public interface Lista {
    public abstract void adicionar(Object o);
    public abstract void adicionar(Object o,Integer id);
    public abstract Object buscar(Object o);
    public abstract Object buscar(Integer i);
    public abstract Boolean remover(Object o);
    public abstract Boolean remover(Integer i);
    public abstract Integer tamanho();
    public abstract String toString();
    public abstract Boolean existe(Object o);
}
