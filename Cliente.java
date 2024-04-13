package restaurante;

import java.util.Scanner;
import java.util.ArrayList;


public class Cliente{
    private int telefone;
    private int cpf;

    private static List<Cliente> clients = new ArrayList<Cliente>();

    public Cliente(int telefone, int cpf){
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public static void criarCliente(int telefone, int cpf){
        Cliente novoCliente = new Cliente(telefone, cpf);
        clients.add(novoCliente);
    }

    public static void visualizarCliente(int telefone){
        for(Cliente cliente : clients){
            if(cliente.telefone == telefone){
                System.out.println(cliente.getCpf() + " - " + cliente.getTelefone());
            }
        }    
    }
