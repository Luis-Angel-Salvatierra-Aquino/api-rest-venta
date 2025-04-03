package pe.edu.idat.api_rest_ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.idat.api_rest_ventas.model.GeneralEntity;
import pe.edu.idat.api_rest_ventas.repository.projection.OrderDatesProjection;

import java.util.Date;
import java.util.List;

public interface ConsultasOrderRepository
        extends JpaRepository<GeneralEntity, Long> {

    @Query(value = "CALL ObtenerOrdenesPorFecha(:fechaInicio, :fechaFin)",
    nativeQuery = true)
    List<OrderDatesProjection> obtenerOrdenesXFecha(
            @Param("fechaInicio")Date fechaInicio,
            @Param("fechaFin") Date fechaFin);


}
