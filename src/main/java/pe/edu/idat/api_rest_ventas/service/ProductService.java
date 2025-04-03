package pe.edu.idat.api_rest_ventas.service;

import org.springframework.stereotype.Service;
import pe.edu.idat.api_rest_ventas.dto.DtoEntity;
import pe.edu.idat.api_rest_ventas.dto.ProductDto;
import pe.edu.idat.api_rest_ventas.dto.ResumenProductDto;
import pe.edu.idat.api_rest_ventas.dto.UpdateProductDto;
import pe.edu.idat.api_rest_ventas.model.Product;
import pe.edu.idat.api_rest_ventas.repository.ProductRepository;
import pe.edu.idat.api_rest_ventas.util.ConvertDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ConvertDto convertDto;

    public ProductService(ProductRepository productRepository, ConvertDto convertDto) {
        this.productRepository = productRepository;
        this.convertDto = convertDto;
    }

    public List<DtoEntity> listarProductos(){
        List<DtoEntity> productDtoList = new ArrayList<>();
        productDtoList = productRepository.findAll()
                .stream()
                .map(p -> convertDto.convertirADto(p,
                new ProductDto()))
                .collect(Collectors.toList());
        return productDtoList;
    }

    public void actualizarProducto(
            UpdateProductDto productDto){
        productRepository.actualizarPrecioStockProducto(
                productDto.getPreciounitario(),
                productDto.getStock(),
                productDto.getDescontinuado(),
                productDto.getId());
    }

    public Optional<Product> obtenerProductoXid(
            Integer productid){
        return productRepository.findById(productid);
    }
    //Buscando productos por un valor al productame
    // y el valor descontinuado
    public List<Product> obtenerProductosFiltros(
            Boolean descontinuado,
            String nombreProducto){
        return productRepository
                .findByDiscontinuedAndProductnameContaining(
                        descontinuado, nombreProducto);
    }

    public List<ResumenProductDto> obtenerProductosXStock(
            Integer stock
    ){
        return productRepository
                .obtenerProductosXStockMinimo(stock)
                .stream()
                .map(prod -> {
                    ResumenProductDto dto = new ResumenProductDto();
                    dto.setProductid(prod.getProductId());
                    dto.setProductname(prod.getProductName());
                    dto.setCategoryname(prod.getCategoryName());
                    dto.setUnitsinstock(prod.getUnitsInStock());
                    dto.setContactname(prod.getContactName());
                    dto.setAddress(prod.getAddress());
                    return dto;
                }).collect(Collectors.toList());
    }

}
