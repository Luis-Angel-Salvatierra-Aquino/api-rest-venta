package pe.edu.idat.api_rest_ventas.dto;

public class ProductDto implements DtoEntity {
    private Integer productid;
    private String productname;
    private Integer unitsinstock;
    private Double unitprice;

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public Integer getUnitsinstock() {
        return unitsinstock;
    }

    public void setUnitsinstock(Integer unitsinstock) {
        this.unitsinstock = unitsinstock;
    }

    public Double getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(Double unitprice) {
        this.unitprice = unitprice;
    }
}
