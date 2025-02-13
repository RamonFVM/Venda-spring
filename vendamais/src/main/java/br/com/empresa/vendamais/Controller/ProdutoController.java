package br.com.empresa.vendamais.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.empresa.vendamais.Model.Produto;
import br.com.empresa.vendamais.Service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;
    

    @GetMapping("/listar")
    public ResponseEntity<List<Produto>>findAll(){
        List<Produto> produtos = produtoService.findAll();
        return ResponseEntity.ok(produtos);


    }
     @GetMapping("/{id}")
    public ResponseEntity<Produto>findByid(@PathVariable Long id){
        Produto produto= produtoService.findbyid(id);
        return ResponseEntity.ok().body(produto); 

    }

    @PostMapping("/inserir")
    public ResponseEntity<Produto> insertnew(@RequestBody Produto produto){
         Produto produtoinserido= produtoService.insernew(produto);
         return ResponseEntity.ok().body(produtoinserido);  
    }


   
    
}
