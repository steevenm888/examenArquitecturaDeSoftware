/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.producto.ws;

import ec.edu.espe.model.Producto;
import ec.edu.espe.services.ProductoServicio;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author esteban
 */
@WebService(serviceName = "ProductoWS")
public class ProductoWS {

    @EJB
    private ProductoServicio ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "listarTodos")
    public List<Producto> listarTodos() {
        return ejbRef.listarTodos();
    }

    @WebMethod(operationName = "descontarExistencia")
    public void descontarExistencia(@WebParam(name = "id") String id, @WebParam(name = "cantidad") Integer cantidad) throws RuntimeException {
        ejbRef.descontarExistencia(id, cantidad);
    }
    
}
