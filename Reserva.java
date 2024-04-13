package restaurante;

import java.util.ArrayList;
import java.util.List;

public class Reserva {
    private String dataReserva;
    private String turno;
    private int quantidadePessoas;
    private float valor;
    private String metodoPagamento;

    private static List<Reserva> reservas = new ArrayList<>();

    public Reserva(String dataReserva, String turno, int quantidadePessoas, float valor, String metodoPagamento) {
        this.dataReserva = dataReserva;
        this.turno = turno;
        this.quantidadePessoas = quantidadePessoas;
        this.valor = valor;
        this.metodoPagamento = metodoPagamento;
        reservas.add(this);
        System.out.println("Sucesso.");
    }

    public void visualizarReserva() {
        System.out.println("Data: " + dataReserva);
        System.out.println("Turno: " + turno);
        System.out.println("Quantidade de Pessoas: " + quantidadePessoas);
        System.out.println("Valor: " + valor);
        System.out.println("Método de Pagamento: " + metodoPagamento);
    }

    public static void listarReservas() {
        System.out.println("Lista de reservas:");
        for (Reserva reserva : reservas) {
            reserva.visualizarReserva();
            System.out.println("-----------");
        }
    }
    
    public void atualizarReserva(String novaData, String novoTurno, int novaQuantidadePessoas, float novoValor, String novoMetodoPagamento) {
        this.dataReserva = novaData;
        this.turno = novoTurno;
        this.quantidadePessoas = novaQuantidadePessoas;
        this.valor = novoValor;
        this.metodoPagamento = novoMetodoPagamento;
        System.out.println("Sucesso.");
    }

    public void cancelarReserva() {
        reservas.remove(this);
        System.out.println("Sucesso.");
    }
}