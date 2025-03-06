package pe.edu.idat.api_rest_ventas.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.idat.api_rest_ventas.model.Category;
import pe.edu.idat.api_rest_ventas.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<Category>> listarCategorias(){
        List<Category> categoryList = categoryService
                .listarCategorias();
        if(categoryList.isEmpty()){
            return new ResponseEntity<>(
                    HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList,
                HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Category> registrarCategoria
            (@RequestBody Category category){
        return new ResponseEntity<>(
                categoryService.guardarCategoria(category),
                HttpStatus.CREATED);
    }
}
