/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

/**
 *
 * @author ruand
 */



import conexao.Conexao;
import java.sql.Connection;




import javax.swing.table.DefaultTableModel;
import java.sql.Statement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Funcao {
    private static conexao.Conexao con = new Conexao();
    private  static Connection conexao = con.conectaBD();
    private static PreparedStatement ps = null;
    
    public static boolean isRegister(Sentencias s){
        String sql = Sentencias.REGISTRAR;
        
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1,s.getNome());
             ps.setString(2, s.getEmail());
             ps.setString(3, s.getSenha());
              ps.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
  //          Logger.getLogger(Funcao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static boolean isUpdate(Sentencias s){
        String sql = Sentencias.ATUALIZAR;
        
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1,s.getNome());
             ps.setString(2, s.getEmail());
             ps.setString(3, s.getSenha());
             ps.setString(4, s.getRa());
             
              ps.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
            
  //          Logger.getLogger(Funcao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static boolean isDelete(Sentencias s){
        String sql = Sentencias.ELIMINAR;
        
        try {
            ps = conexao.prepareStatement(sql);
            
             ps.setString(1, s.getRa());
             
              ps.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
            
  //          Logger.getLogger(Funcao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static boolean isTruncate(){
        String sql = Sentencias.ELIMINAR_TODO;
        
        try {
            ps = conexao.prepareStatement(sql);
            ps.executeUpdate();
             
             
            
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
            
  //          Logger.getLogger(Funcao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void setListar(String buscar){
        DefaultTableModel modelo = (DefaultTableModel)tela_u.table.getModel();
        while (modelo.getRowCount() > 0){
            modelo.removeRow(0);
        }
       String sql = "";
       if(buscar.equals("")){
            sql = Sentencias.LISTAR;
        }else{
            sql = "SELECT * FROM cadastro WHERE ("
            + "nome LIKE '%" + buscar + "%' OR "
            + "email LIKE '%" + buscar + "%' OR "
            + "ra LIKE '%" + buscar + "%'"
            + ")";

        }
        
        String datos[] = new String[4];
       try{
            Statement st = conexao.createStatement();
             ResultSet rs = st.executeQuery(sql);
            
          while(rs.next()){
                 datos[0] = rs.getString("ra");
                datos[1] = rs.getString("nome");
                datos[2] = rs.getString("email");
                datos[3] = rs.getString("senha");
               
               modelo.addRow(datos);
            }
            
            
      }catch(SQLException ex ){
           // Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, e); 
        }
    }
    public static String extraerRAMax(){
        String sql = "SELECT MAX(ra) FROM CADSTRO";
        int ra=0;
        try{
            Statement st = conexao.createStatement();
             ResultSet rs = st.executeQuery(sql);
             if (rs.next()){
                 ra=rs.getInt("ra");
             }
             if (ra==0){
                 ra=1;
             }else{
                 ra = ra+1;
             }
                 
             return String.valueOf(ra);
            }catch(SQLException ex ){
                return null;
           // Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, e); 
        }

         
    }
}