package Modelo;
import java.sql.*;
public class Registro {
    Conexion conexion;
    
    public Registro(){
    conexion = new Conexion();
    
    }
    
    public String RegistrarUsuario(String Nom, String User, String contra, String contra2, String edad,String carrer, String puest){
    String respuesta="No se puede amiguito :c";
    Cifrado elcifrado = new Cifrado();
    try{   
    Connection accesoDB = conexion.getConexion();
    PreparedStatement ps = accesoDB.prepareStatement("insert into Arquitecto values(?,?,?,?,?,?,?,?)");
    ps.setString(1, elcifrado.deci(contra2));
    ps.setString(2, elcifrado.deci(Nom));
    ps.setString(3, elcifrado.deci(edad));
    ps.setString(4, elcifrado.deci(carrer));
    ps.setString(5, elcifrado.deci(puest));
    ps.setString(6, elcifrado.deci(contra2));
    ps.setString(7, elcifrado.deci(contra));
    ps.setString(8, elcifrado.deci(User));
    int rs = ps.executeUpdate();
    
    if(rs>0){
    respuesta="Registro Logrado";
    }else{
    respuesta ="Error";
    }
    }catch(Exception e){
    
    }   
    return respuesta;}
}
