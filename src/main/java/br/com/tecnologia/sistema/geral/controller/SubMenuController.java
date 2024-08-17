package br.com.tecnologia.sistema.geral.controller;

import br.com.tecnologia.sistema.geral.dto.SubMenuDTO;
import br.com.tecnologia.sistema.geral.service.SubMenuService;
import br.com.tecnologia.sistema.util.UrlFrontEnd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = UrlFrontEnd.URL_FRONTEND)
@RequestMapping(path="/subMenu")
public class SubMenuController {
    @Autowired
    private SubMenuService dao;

    @GetMapping(path = "/getAllPorMenCodigo")
    public ResponseEntity<List<SubMenuDTO>> getAllPorMenCodigo(@RequestParam Long menCodigo){
        return ResponseEntity.ok(dao.getAllPorMenCodigo(menCodigo));
    }
}
