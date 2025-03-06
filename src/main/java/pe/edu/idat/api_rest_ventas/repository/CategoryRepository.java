package pe.edu.idat.api_rest_ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pe.edu.idat.api_rest_ventas.model.Category;

@Repository
public interface CategoryRepository
        extends JpaRepository<Category, Integer> {

}
