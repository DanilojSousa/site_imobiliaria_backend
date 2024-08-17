package br.com.tecnologia.sistema.geral.controller;

import br.com.tecnologia.sistema.geral.dto.MenuDTO;
import br.com.tecnologia.sistema.geral.service.MenuService;
import br.com.tecnologia.sistema.util.UrlFrontEnd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = UrlFrontEnd.URL_FRONTEND)
@RequestMapping(path="/menu")
public class MenuController {

    @Autowired
    private MenuService dao;

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<MenuDTO>> getAll(){
        return ResponseEntity.ok(dao.getAll());
    }

}
