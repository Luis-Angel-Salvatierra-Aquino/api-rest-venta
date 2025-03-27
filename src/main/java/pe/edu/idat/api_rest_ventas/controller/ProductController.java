package pe.edu.idat.api_rest_ventas.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.idat.api_rest_ventas.dto.DtoEntity;
import pe.edu.idat.api_rest_ventas.dto.GenericResponseDto;
import pe.edu.idat.api_rest_ventas.dto.ProductDto;
import pe.edu.idat.api_rest_ventas.dto.UpdateProductDto;
import pe.edu.idat.api_rest_ventas.exception.ResourceNotFoundException;
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
    listarProductos(){
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

    @PatchMapping("/{id}")
    public ResponseEntity<GenericResponseDto<String>>
        actualizarProducto(@PathVariable Integer id,
                           @RequestBody UpdateProductDto
                                   productDto){
        GenericResponseDto<String> response =
                new GenericResponseDto<>();
        try {
            Product currentProduct = productService
                    .obtenerProductoXid(id)
                    .orElseThrow(() ->
                            new ResourceNotFoundException("El producto no existe"));
            productDto.setId(id);
            productService.actualizarProducto(productDto);
            response.setRespuesta("Producto actualizado correctamente");
            response.setStatusCode(200);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setRespuesta("Error al actualizar producto");
            response.setStatusCode(500);
            return new ResponseEntity<>(response,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //localhost:8080/api/v1/product/busqueda?descontinuado=true&nombreproducto=a
    @GetMapping("/busqueda")
    public ResponseEntity<List<Product>> obtenerProductosFiltros(
            @RequestParam Boolean descontinuado,
            @RequestParam String nombreproducto
    ){
        return new ResponseEntity<>(
                productService.obtenerProductosFiltros(
                        descontinuado, nombreproducto),
                HttpStatus.OK);
    }

}
