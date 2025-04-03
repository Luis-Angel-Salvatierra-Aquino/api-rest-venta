package pe.edu.idat.api_rest_ventas.service;

import org.springframework.stereotype.Service;
import pe.edu.idat.api_rest_ventas.dto.OrderDatesDto;
import pe.edu.idat.api_rest_ventas.repository.ConsultasOrderRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsultasOrderService {
    private final ConsultasOrderRepository consultasOrderRepository;

    public ConsultasOrderService(ConsultasOrderRepository consultasOrderRepository) {
        this.consultasOrderRepository = consultasOrderRepository;
    }

    public List<OrderDatesDto> obtenerOrdenesXFecha(
            Date fechaInicio, Date fechaFin){
        return consultasOrderRepository
                .obtenerOrdenesXFecha(fechaInicio, fechaFin)
                .stream()
                .map(ord -> {
                    OrderDatesDto dto = new OrderDatesDto();
                    dto.setProductId(ord.getProductId());
                    dto.setCustumerId(ord.getCustumerId());
                    dto.setEmployeeId(ord.getEmployeeId());
                    dto.setOrderDate(ord.getOrderDate());
                    dto.setOrderId(ord.getOrderId());
                    dto.setUnitPrice(ord.getUnitPrice());
                    dto.setDiscount(ord.getDiscount());
                    dto.setQuantity(ord.getQuantity());
                    dto.setTotalLinea(ord.getTotalLinea());
                    return dto;
                }).collect(Collectors.toList());
    }
}
