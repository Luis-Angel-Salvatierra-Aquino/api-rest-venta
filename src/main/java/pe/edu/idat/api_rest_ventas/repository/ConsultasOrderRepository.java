package pe.edu.idat.api_rest_ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.idat.api_rest_ventas.model.GeneralEntity;

public interface ConsultasOrderRepository
        extends JpaRepository<GeneralEntity, Long> {

    


}
