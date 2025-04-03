package pe.edu.idat.api_rest_ventas.repository.projection;

import java.util.Date;

public interface OrderDatesProjection {
    Integer getOrderId();
    String getCustumerId();
    Integer getEmployeeId();
    Date getOrderDate();
    Integer getProductId();
    Integer getUnitPrice();
    Integer getQuantity();
    Double getDiscount();
    Double getTotalLinea();
}
