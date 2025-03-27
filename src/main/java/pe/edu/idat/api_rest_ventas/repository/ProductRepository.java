package pe.edu.idat.api_rest_ventas.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.idat.api_rest_ventas.model.Product;

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
    List<Product> findByDiscontinuedAndProductnameContaining(
            Boolean discontinued,
            String productname);

}
