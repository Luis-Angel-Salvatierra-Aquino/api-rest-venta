package pe.edu.idat.api_rest_ventas.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.idat.api_rest_ventas.model.Product;
import pe.edu.idat.api_rest_ventas.repository.projection.ResumenProductProjection;

import java.util.List;

@Repository
public interface ProductRepository
        extends JpaRepository<Product, Integer> {

    @Transactional
    @Modifying
    @Query(value =
            """
            UPDATE products SET unitprice=:unitprice,
            unitsinstock=:unitsinstock,
            discontinued=:discontinued
            WHERE productid=:productid
            """, nativeQuery = true)
    void actualizarPrecioStockProducto(
            @Param("unitprice") Double unitprice,
            @Param("unitsinstock") Integer unitsinstock,
            @Param("discontinued") Boolean discontinued,
            @Param("productid") Integer productid);

    /* Select * from products
    where discontinued = :discontinued
     and productname  LIKE '%a%' */
    //Consulta funciones JPA
    List<Product> findByDiscontinuedAndProductnameContaining(
            Boolean discontinued,
            String productname);
    //Consulta JPQL
    @Query("""
            SELECT p FROM product p 
            WHERE discontinued = :discontinued 
            AND productname LIKE :productname
            """)
    List<Product> buscarProductosXNombreEstado(
            @Param("discontinued") Boolean discontinued,
            @Param("productname") String productname);

    @Query(value = """
        SELECT * FROM products
        WHERE discontinued = :discontinued
        AND productname LIKE :productname
        """, nativeQuery = true)
    List<Product> buscarProductosXNombreEstadoSQL(
            @Param("discontinued") Boolean discontinued,
            @Param("productname") String productname);


    @Query(value = """
            select p.ProductID, p.ProductName, p.UnitsInStock,
            c.CategoryName, s.ContactName, s.Address
            from products p
            inner join categories c on p.CategoryID = c.CategoryID
            inner join suppliers s ON p.SupplierID = s.SupplierID
            where UnitsInStock <= :unitsinstock
            """, nativeQuery = true)
    List<ResumenProductProjection> obtenerProductosXStockMinimo(
            @Param("unitsinstock") Integer unitsinstock);

}
