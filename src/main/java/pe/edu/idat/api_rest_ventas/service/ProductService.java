package pe.edu.idat.api_rest_ventas.service;

import org.springframework.stereotype.Service;
import pe.edu.idat.api_rest_ventas.dto.DtoEntity;
import pe.edu.idat.api_rest_ventas.dto.ProductDto;
import pe.edu.idat.api_rest_ventas.dto.UpdateProductDto;
import pe.edu.idat.api_rest_ventas.model.Product;
import pe.edu.idat.api_rest_ventas.repository.ProductRepository;
import pe.edu.idat.api_rest_ventas.util.ConvertDto;

import java.util.ArrayList;
import java.util.List;
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
        Product product = new Product();
        product.setProductid(productDto.getId());
        product.setUnitprice(productDto.getPreciounitario());
        product.setUnitsinstock(productDto.getStock());
        product.setDiscontinued(productDto.getDescontinuado());
        productRepository.save(product);
    }

}
