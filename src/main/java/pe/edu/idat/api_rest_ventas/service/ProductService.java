package pe.edu.idat.api_rest_ventas.service;

import org.springframework.stereotype.Service;
import pe.edu.idat.api_rest_ventas.model.Product;
import pe.edu.idat.api_rest_ventas.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> listarProductos(){
        return productRepository.findAll();
    }

}
