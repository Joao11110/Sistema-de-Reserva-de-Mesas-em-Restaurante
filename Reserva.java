package src.restaurante;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import src.db.Banco;

public class Reserva {

    private int id;
    private Date dataReserva;
    private int quantidadePessoas;
    private float valor;
    private String metodoPagamento;
    private String idMesa;
    private String idRestaurante;
    private String idCliente;

    public Reserva(Date dataReserva, int quantidadePessoas, float valor, String metodoPagamento, 
    String idRestaurante, String idCliente, String idMesa) {
        this.dataReserva = dataReserva;
        this.quantidadePessoas = quantidadePessoas;
        this.valor = valor;
        this.metodoPagamento = metodoPagamento;
        this.idRestaurante = idRestaurante;
        this.idCliente = idCliente;
        this.idMesa = idMesa;
    }
    
    public Reserva(){
    }

    public void cadastrarReserva(Banco db) {
        System.out.println("controle");
        String query = String.format("INSERT INTO Reserva (data_reserva, quantidade_pessoas, valor, metodo_pagamento, restaurante, cliente, numero_mesa) VALUES ('%tF', '%d', '%.2f', '%s', %s, %s, '%d')", 
        getDataReserva(), getQuantidadePessoas(), getValor(), getMetodoPagamento(), getIdRestaurante(), getIdCliente(), getIdMesa());
        db.queryUpdate(query);
    }

    public void pesquisarReserva(Banco db, int reservaId) throws SQLException {
        String query = String.format("SELECT * FROM Reserva WHERE id_reserva = %d", reservaId);
        ResultSet rs = db.querySearch(query);
    
        setId(rs.getInt("id_reserva"));
        String datast = rs.getString("data_reserva");
        Date data = Date.valueOf(datast);
        setDataReserva(data);
        setQuantidadePessoas(rs.getInt("quantidade_pessoas"));
        setValor(rs.getFloat("valor"));
        setMetodoPagamento(rs.getString("metodo_pagamento"));
        setIdRestaurante(rs.getString("restaurante"));
        setIdCliente(rs.getString("cliente"));
        setIdMesa(rs.getString("numero_mesa"));
    }

    public static boolean pesquisarReservaNoDia(Banco db, Date data, String mesaId, String restauranteId) throws SQLException {
        String query = String.format("SELECT * FROM Reserva WHERE data_reserva = '%tF' and numero_mesa = '%s' and restaurante = '%s'", data, mesaId, restauranteId);
        ResultSet rs = db.querySearch(query);
       
        if (rs.next()){
            System.out.println("Mesa indisponivel para a data");
            return true;
        }
        return false;
    }
    
    
    public void listarReservas(Banco db) throws SQLException {
        String query = "SELECT * FROM Reserva";
        ResultSet rs = db.querySearch(query);

        while (rs.next()){
            setId(rs.getInt("id_reserva"));
            String datast = rs.getString("data_reserva");
            Date data = Date.valueOf(datast);
            setDataReserva(data);
            setQuantidadePessoas(rs.getInt("quantidade_pessoas"));
            setValor(rs.getFloat("valor"));
            setMetodoPagamento(rs.getString("metodo_pagamento"));
            setIdRestaurante(rs.getString("restaurante"));
            setIdMesa(rs.getString("numero_mesa"));
            System.out.println(toString());
            }
    }

    public void editarReserva(Banco db) {
        String query = String.format("UPDATE Reserva SET numero_mesa = '%s', data_reserva = '%s', quantidade_pessoas = '%d', valor = '%.2f', metodo_pagamento = '%s', restaurante = '%s', cliente = '%s' WHERE id = %d",getIdMesa(), getDataReserva(), getQuantidadePessoas(), getValor(), getMetodoPagamento(), getIdRestaurante(), getIdCliente(), getId());
        db.queryUpdate(query);
    }

    public void removerReserva(Banco db) {
        String query = String.format("DELETE FROM Reserva WHERE id = %d", getId());
        db.queryUpdate(query);
    }
    
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public Date getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(Date dataReserva) {
        this.dataReserva = dataReserva;
    }
   
    public int getQuantidadePessoas() {
        return quantidadePessoas;
    }

    public void setQuantidadePessoas(int quantidadePessoas) {
        this.quantidadePessoas = quantidadePessoas;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public String getIdMesa(){
        return idMesa;
    }

    public void setIdMesa(String idMesa){
        this.idMesa = idMesa;
    }

    public String getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(String idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public String toString() {
        return "Reserva {id=" + getId() + ", dataReserva=" + getDataReserva() + ", quantidadePessoas=" + getQuantidadePessoas() + ", valor=" + getValor() + ", metodoPagamento=" + getMetodoPagamento() + ", mesa=" + getIdMesa() + ", restaurante=" + getIdRestaurante() + ", cliente=" + getIdCliente() + "}";
    }
}