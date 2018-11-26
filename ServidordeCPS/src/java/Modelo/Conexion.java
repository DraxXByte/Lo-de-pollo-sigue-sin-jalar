package Modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Invitado
 */
public class Conexion {
    
    public Conexion(){
    
    }
    public Connection getConexion(){
    Connection con = null;
    try{
    
        Class.forName("com.mysql.jdbc.Driver").newInstance();
    
    con= DriverManager.getConnection("jdbc:mysql://localhost/ServiWeb","root","n0m3l0");
    }catch(SQLException ex){}catch(Exception e){}
    return con;
    }
}

