package pe.edu.idat.api_rest_ventas.dto;

public class ResumenProductDto {
    private Integer productid;
    private String productname;
    private Integer unitsinstock;
    private String categoryname;
    private String contactname;
    private String address;

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

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public String getContactname() {
        return contactname;
    }

    public void setContactname(String contactname) {
        this.contactname = contactname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
