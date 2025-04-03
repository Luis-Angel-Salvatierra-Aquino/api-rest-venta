package pe.edu.idat.api_rest_ventas.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.idat.api_rest_ventas.dto.OrderDatesDto;
import pe.edu.idat.api_rest_ventas.service.ConsultasOrderService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/orden")
public class OrderController {

    private final ConsultasOrderService consultasOrderService;

    public OrderController(ConsultasOrderService consultasOrderService) {
        this.consultasOrderService = consultasOrderService;
    }

    @GetMapping
    public ResponseEntity<List<OrderDatesDto>>
        obtenerOrdenesXFecha(
                @RequestParam("fechaInicio")
                @DateTimeFormat(pattern = "dd-MM-yyyy") Date fechaInicio,
                @RequestParam("fechaFin")
                @DateTimeFormat(pattern = "dd-MM-yyyy") Date fechaFin){
        return ResponseEntity.ok(
                consultasOrderService
                        .obtenerOrdenesXFecha(fechaInicio, fechaFin));

    }


}
