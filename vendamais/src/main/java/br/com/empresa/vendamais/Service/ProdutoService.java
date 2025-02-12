package br.com.empresa.vendamais.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.empresa.vendamais.Model.Produto;
import br.com.empresa.vendamais.Repository.ProdutoRepository;

@Service

public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }

    public Produto findbyid(Long id){

        return produtoRepository.findById(id).orElse(null);

    }

    public Produto insernew(Produto produto){

        return produtoRepository.save(produto);

    }

    public Produto update(Long id, Produto ProdutoAlterado){
         
        Produto Produtoatual= findbyid(id);
        Produtoatual.setNome(ProdutoAlterado.getNome());
        Produtoatual.setQuantidade(ProdutoAlterado.getQuantidade());
        return produtoRepository.save(Produtoatual);

    }

    public boolean delete(Long id){

        Produto produto=findbyid(id);
        if(produto==null){

            return false;

        }else{
            produtoRepository.deleteById(id);
            return true;
        }

    }

}
