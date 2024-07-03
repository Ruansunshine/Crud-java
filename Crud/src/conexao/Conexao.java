package conexao;

import java.sql.Connection; // representa uma conexão com um banco de dados específico.

import java.sql.DriverManager; //gerencia uma lista de drivers de banco de dados.
import java.sql.SQLException; //Exceção que fornece informações sobre um erro de acesso ao banco de dados ou outros erros.

public class Conexao { //classe pública chamada Conexao, será acessível a de qualquer outra classe.
    
    public Connection conectaBD(){ //método público chamado conectaBD que retorna um objeto Connection.
        Connection conn = null; //variavel conn do tipo conection inicizalizada
       
        try { //excessao
           
            Class.forName("com.mysql.cj.jdbc.Driver"); //garante que esteja disponivel para drive
           
           conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud", "root", "");// variavel conn recebe a localização, estabelec a conexao com o banco
            return conn; //dando certo retorna a conexao na localização
        } catch (SQLException | ClassNotFoundException erro) { //Captura exceções do tipo SQLException (erros de SQL) 
            //e ClassNotFoundException (quando a classe do driver não é encontrada).
            erro.printStackTrace();//imprime a pilha de erros(ajuda na deouração)
          return null; //se ocorrer uma excessao durante  a tentativa de conectar
        }
    }
}

