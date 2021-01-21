/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.api;

import ec.edu.espe.repository.Producto;
import ec.edu.espe.repository.ProductoWS;
import ec.edu.espe.repository.ProductoWS_Service;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

/**
 * REST Web Service
 *
 * @author esteban
 */
@Path("producto")
public class ProductoResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProductoResource
     */
    public ProductoResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.api.ProductoResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public List<Producto> getJson() {
        ProductoWS_Service service = new ProductoWS_Service();
        ProductoWS port = service.getProductoWSPort();
        port.listarTodos();
        List<ec.edu.espe.repository.Producto> productos= port.listarTodos();
        List<Producto> productosModel= new ArrayList<>();
        for(ec.edu.espe.repository.Producto producto : productos){
            productosModel.add(this.buildProducto(producto));
        }
        return productosModel;
    }

    /**
     * PUT method for updating or creating an instance of ProductoResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    public Producto buildProducto(ec.edu.espe.repository.Producto producto) {
        Producto pro = new Producto();
        pro.setCodigo(producto.getCodigo());
        pro.setNombre(producto.getNombre());
        pro.setExistencia(producto.getExistencia());
        pro.setPrecio(producto.getPrecio());
        return pro;
    }
}
