/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

/**
 *
 * @author ruand
 */
public class Sentencias {;
        
   public static String LISTAR = "SELECT * FROM cadastro";
   
   public static String REGISTRAR = "INSERT INTO cadastro ("
                   + "nome, "
                   + "email, "
                   + "senha) "
                   + "VALUES (?,?,?)";

      
                public static String ATUALIZAR = "UPDATE cadastro SET "
               + "nome=?, "
               + "email=?, "
               + "senha=? "
               + "WHERE RA=?";
                
           public static String ELIMINAR = "DELETE FROM cadastro WHERE ra=?";
           public static String ELIMINAR_TODO = "TRUNCATE TABLE cadastro";
           
           private String ra;
           private String nome;
           private String email;
           private String senha;

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
