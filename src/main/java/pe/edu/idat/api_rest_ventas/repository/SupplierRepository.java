package pe.edu.idat.api_rest_ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.idat.api_rest_ventas.model.Supplier;

@Repository
public interface SupplierRepository
        extends JpaRepository<Supplier, Integer> {
}
