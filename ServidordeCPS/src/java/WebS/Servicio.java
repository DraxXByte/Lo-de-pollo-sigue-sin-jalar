/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebS;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import Modelo.*; 

/**
 *
 * @author Invitado
 */
@WebService(serviceName = "Servicio")
public class Servicio {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Registro")
    public String Registro(@WebParam(name = "Nom") String Nom, @WebParam(name = "User") String User, @WebParam(name = "contra") String contra, @WebParam(name = "contra2") String contra2, @WebParam(name = "edad") String edad, @WebParam(name = "carrer") String carrer, @WebParam(name = "puest") String puest) {
        //TODO write your implementation code here:
        Registro res = new Registro();
        String respuesta = res.RegistrarUsuario(Nom, User, contra, contra2, edad, carrer, puest);
        return respuesta;
    }
}
