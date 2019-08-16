package edu.tallerjava.controladores;

import edu.tallerjava.modelo.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    @GetMapping(path = "/isAlive")
    public String smoke(){
        return "Funcione y soy re pro";
    }





}
