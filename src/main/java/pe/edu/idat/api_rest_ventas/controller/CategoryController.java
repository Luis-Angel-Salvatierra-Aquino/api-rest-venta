package pe.edu.idat.api_rest_ventas.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.idat.api_rest_ventas.exception.ResourceNotFoundException;
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
    //localhost:8080/api/v1/category/1
    @GetMapping("/{categoryid}")
    public ResponseEntity<Category> obtenerCategoriaXid(
            @PathVariable Integer categoryid
            //@PathVariable("categoryid") Integer id
    ){
        Category category = categoryService
                .obtenerCategoriaXid(categoryid)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "La categoría buscada no existe"));
        return new ResponseEntity<>(category, HttpStatus.OK);
    }


    @PutMapping("/{categoryid}")
    public ResponseEntity<Category> actualizarCategoria(
        @PathVariable Integer categoryid,
        @RequestBody Category category
    ){
        Category currentCategory = categoryService
                .obtenerCategoriaXid(categoryid)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "La categoría buscada no existe"));
        currentCategory.setCategoryname(category.getCategoryname());
        currentCategory.setDescription(category.getDescription());
        return new ResponseEntity<>(
                categoryService.guardarCategoria(currentCategory),
                HttpStatus.OK);
    }
}
