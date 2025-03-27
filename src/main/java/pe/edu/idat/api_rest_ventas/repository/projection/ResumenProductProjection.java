package pe.edu.idat.api_rest_ventas.repository.projection;

import org.springframework.beans.factory.annotation.Value;

public interface ResumenProductProjection {
    @Value("#{target.ProductID}")
    Integer getProductId();
    @Value("#{target.ProductName}")
    String getProductName();
    @Value("#{target.UnitsInStock}")
    Integer getUnitsInStock();
    @Value("#{target.CategoryName}")
    String getCategoryName();
    @Value("#{target.ContactName}")
    String getContactName();
    @Value("#{target.Address}")
    String getAddress();
}
