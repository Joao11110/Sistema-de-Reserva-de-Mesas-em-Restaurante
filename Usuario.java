package restaurante;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private String senha;
    private int usuarioID;

    private static List<Usuario> usuarios = new ArrayList<>();

    public Usuario(String nome, String senha, int usuarioID) {
        this.nome = nome;
        this.senha = senha;
        this.usuarioID = usuarioID;
        usuarios.add(this);
        System.out.println("Sucesso.");
    }
    public void fazerLogin(int usuarioID, String senha) {
        if (this.usuarioID == usuarioID && this.senha.equals(senha)) {
             System.out.println("Login realizado");
         } else {
             System.out.println("Usuário ou senha incorretos.");
         }
     }
    public void alterarSenha(String senha, String novaSenha) {
        if (this.senha.equals(senha)) {
                this.senha = novaSenha;
                System.out.println("Senha alterada");
            } else {
            System.out.println("Senha atual incorreta");
        }
    }
    public static void visualizarUsuario(int usuarioID) {
        for (Usuario usuario : usuarios) {
            if (usuario.getUsuarioID() == usuarioID) {
                System.out.println("Nome: " + usuario.getNome());
                System.out.println("ID: " + usuario.getUsuarioID());
                System.out.println("Senha: " + usuario.getSenha());
                return;
            }
        }
        System.out.println("Usuário não encontrado.");
    }
    public static void atualizarUsuario(int usuarioID, String novoNome, String novaSenha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getUsuarioID() == usuarioID) {
                usuario.setNome(novoNome);
                usuario.setSenha(novaSenha);
                return;
            }
        }
        System.out.println("Usuário não encontrado.");
    }
    public static void excluirUsuario(int usuarioID) {
        for (Usuario usuario : usuarios) {
            if (usuario.getUsuarioID() == usuarioID) {
                usuarios.remove(usuario);
                System.out.println("Usuário excluído");
                return;
            }
        }
        System.out.println("Usuário não encontrado.");
    }
    public String getNome() {
        return nome;
    }
    public String getSenha() {
        return senha;
    }
    public int getUsuarioID() {
        return usuarioID;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public void setUsuarioID(int usuarioID) {
        this.usuarioID = usuarioID;
    }
    public static void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("Lista vazia.");
        } else {
            System.out.println("Lista de usuários:");
            for (Usuario usuario : usuarios) {
                System.out.println("Nome: " + usuario.getNome());
                System.out.println("ID: " + usuario.getUsuarioID());
                System.out.println("Senha: " + usuario.getSenha());
                System.out.println("-----------");
            }
        }
    }
}