package pe.edu.idat.api_rest_ventas.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.idat.api_rest_ventas.dto.DtoEntity;
import pe.edu.idat.api_rest_ventas.dto.GenericResponseDto;
import pe.edu.idat.api_rest_ventas.dto.ProductDto;
import pe.edu.idat.api_rest_ventas.model.Category;
import pe.edu.idat.api_rest_ventas.model.Product;
import pe.edu.idat.api_rest_ventas.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping
    public ResponseEntity<GenericResponseDto<List<DtoEntity>>>
    listarCategorias(){
        List<DtoEntity> productList = productService
                .listarProductos();
        if(productList.isEmpty()){
            return new ResponseEntity<>(
                    HttpStatus.NO_CONTENT);
        }
        GenericResponseDto<List<DtoEntity>> responseDto
                = new GenericResponseDto<>();
        responseDto.setRespuesta(productList);
        responseDto.setStatusCode(200);
        return new ResponseEntity<>(responseDto,
                HttpStatus.OK);
    }
}
