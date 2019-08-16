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
import java.util.Optional;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping(path = "/categories")
    public ResponseEntity<List<Category>> getList(){
        return new ResponseEntity<List<Category>> (categoryService.getList(),HttpStatus.OK);
    }

    @PostMapping(path = "/categories")
    public ResponseEntity<Category> create(@RequestBody Category category){
        return new ResponseEntity<Category> (categoryService.save(category), HttpStatus.OK);

    }



     @GetMapping (path = "categories/{id}")
     //Devuelve una categoria por ID
     public ResponseEntity<Category> devolverCategoriaPorID(@PathVariable Long id){
        Optional opt = categoryService.findById(id);
        if (opt.isEmpty()){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }else{
            return new ResponseEntity<Category>((Category)opt.get(), HttpStatus.OK);
        }


     }





}
