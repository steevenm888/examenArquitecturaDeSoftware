package ec.edu.espe.model;

import ec.edu.espe.model.Producto;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-20T21:27:09")
@StaticMetamodel(ProductoKardex.class)
public class ProductoKardex_ { 

    public static volatile SingularAttribute<ProductoKardex, Date> fecha;
    public static volatile SingularAttribute<ProductoKardex, Integer> existencia;
    public static volatile SingularAttribute<ProductoKardex, Integer> id;
    public static volatile SingularAttribute<ProductoKardex, Integer> cantidad;
    public static volatile SingularAttribute<ProductoKardex, Producto> producto;

}