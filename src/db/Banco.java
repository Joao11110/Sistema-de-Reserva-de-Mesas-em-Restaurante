package src.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Banco { 
    private Connection db = null; 
    private Statement statement = null;
    
    public Banco() { //Estabelece a conexão com o banco
        try{
            this.db = DriverManager.getConnection("jdbc:sqlite:src/db/data.db");
            this.statement = this.db.createStatement(); // Utiliza o statement para executar consultas SQL
            this.statement.setQueryTimeout(5); //Tempo limite para a consulta           
        }catch (SQLException e){
            System.out.println(e); //Imprime uma exceção de SQL
        }
    }

    public void Desconetar() { //Fecha a conexão com o banco
        try {
            if(db != null){
              db.close();
              statement.close();
            }
          } catch(SQLException e) {
            System.out.println(e);
          }
    }

    public void queryUpdate(String query) { //Executa uma query de atualização
        try{
            statement.executeUpdate(query);
        }catch(SQLException e){
            System.out.println(e);
        }
    }

    public ResultSet querySearch(String query_busca) { //Executa uma query de busca
        ResultSet rs = null;
        try{
            rs = statement.executeQuery(query_busca);
            return rs;
        }catch (SQLException e){
            System.out.println(e);
            return rs;
        }
    }
}

