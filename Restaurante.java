package restaurante;

import java.util.ArrayList;
import java.util.Scanner;

public class Restaurante {

    private String endereco;
    private int anoAbertura;
    private static ArrayList<Restaurante> restaurantes = new ArrayList<>();
    
    public Restaurante(String endereco, int anoAbertura) {
        this.endereco = endereco;
        this.anoAbertura = anoAbertura;
    }
    
    public static void criarRestaurante() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nDigite o endereço do restaurante: ");
        String endereco = scanner.nextLine();
        System.out.println("\nDigite o ano de abertura do restaurante: ");
        int anoAbertura = scanner.nextInt();

        Restaurante restaurante = new Restaurante(endereco, anoAbertura);
        restaurantes.add(restaurante);

        System.out.println("Restaurante criado com sucesso!");
    }
    
    public static void visualizarRestaurante(String endereco) {
        for (Restaurante restaurante : restaurantes){
            if (restaurante.getEndereco() == endereco){
                System.out.println("Endereço: " + restaurante.getEndereco());
                System.out.println("Ano de abertura: " + restaurante.getAnoAbertura());
            }
        }

        System.out.println("\nRestaurante com endereço: " + endereco + "não foi encontrado!");
    }

    public static void atualizarRestaurante(String novoEndereco, int novoAnoAbertura) {
        for(Restaurante restaurante : restaurantes) {
            if(restaurante.getEndereco() == novoEndereco) {
                restaurante.setEndereco(novoEndereco);
                System.out.println("Endereço foi atualizado!");
            }
            else{
                System.out.println("Endereço não existe.");
            }
            if(restaurante.getAnoAbertura() == novoAnoAbertura){
                restaurante.setAnoAbertura(novoAnoAbertura);
                System.out.println("O ano de abertura foi atualizado!");
            }
            else{
                System.out.println("Ano é inválido.");
            }
        }
    }

    public void excluirRestaurante() {
        restaurantes.remove(this);
        System.out.println("Restaurante excluído com sucesso!");
    }

    public static void listarRestaurantes() {
        if (restaurantes.isEmpty()) {
            System.out.println("Não há restaurantes cadastrados.");
        } else {
            System.out.println("-----------------------------");
            System.out.println("Lista de restaurantes:\n");
            System.out.println("-----------------------------");
            for (Restaurante restaurante : restaurantes) {
                System.out.println("Endereço: " + restaurante.endereco);
                System.out.println("Ano de abertura: " + restaurante.anoAbertura);
                System.out.println("-----------------------------");
            }
        }
    }

    public String getEndereco() {
        return endereco;
    }

    public int getAnoAbertura() {
        return anoAbertura;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setAnoAbertura(int anoAbertura) {
        this.anoAbertura = anoAbertura;
    }
}
