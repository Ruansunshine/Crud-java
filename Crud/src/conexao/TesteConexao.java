/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

import java.sql.Connection;
import conexao.Conexao; // Importe a classe Conexao aqui




public class TesteConexao {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectaBD();

        if (conn != null) {
            System.out.println("Conexão estabelecida com sucesso!");
            // Aqui você pode fazer qualquer operação que necessite da conexão
            // por exemplo: executar consultas SQL, inserções, atualizações, etc.
        } else {
            System.out.println("Falha ao estabelecer conexão!");
        }
    }
}
