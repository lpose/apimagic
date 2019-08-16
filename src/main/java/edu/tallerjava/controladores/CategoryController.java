package edu.tallerjava.controladores;

import edu.tallerjava.modelo.Category;
import edu.tallerjava.services.CategoryService;
import edu.tallerjava.services.imp.CategoryServiceImp;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping(path = "/categories")
    public ResponseEntity<List<Category>> list(){
        ArrayList<Category> listaCategorias = new ArrayList<Category>();

        Category catTest = new Category();
        catTest.setId(4L);
        listaCategorias.add(new Category());
        listaCategorias.add(new Category());
        listaCategorias.add(new Category());
        listaCategorias.add(new Category());
        listaCategorias.add(new Category());
        listaCategorias.add(new Category());
        listaCategorias.add(new Category());
        listaCategorias.add(catTest);
        return new ResponseEntity<List<Category>> (listaCategorias,HttpStatus.OK);
    }

    @PostMapping(path = "/categories")
    public ResponseEntity<Category> create(@RequestBody Category category){
        return new ResponseEntity<Category> (categoryService.save(category), HttpStatus.OK);

    }



     @GetMapping (path = "categories/{id}")
     //Devuelve una categoria por ID
     public ResponseEntity<Category> devolverCategoriaPorID(@PathVariable Long id){
         ArrayList<Category> listaCategorias = new ArrayList<Category>();
         Category catTest = new Category();
         catTest.setId(4L);
         listaCategorias.add(catTest);

         for (Category category: listaCategorias) {
             if (category.getId().equals(id)){
                 return new ResponseEntity<Category> (category,HttpStatus.OK);
             }
         }
         return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);


     }





}
