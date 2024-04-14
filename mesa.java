package Mesa;

public class mesa {
    private int capacidade;
    private int numeroMesa;

    private static List<Mesa> mesas = new ArrayList<Mesa>();

    public Mesa(int capacidade, int numeroMesa) {
        this.capacidade = capacidade;
        this.numeroMesa = numeroMesa;
    }
    //métodos get e set
    public int getCapacidade(){
        return capacidade;
    }
    public void setCapacidade(int capacidade){
        this.capacidade = capacidade;
    }
    public int getNumeroMesa(){
        return numeroMesa;
    }
    public void setNumeroMesa(int numeroMesa){
        this.numeroMesa = numeroMesa;
    }
}
