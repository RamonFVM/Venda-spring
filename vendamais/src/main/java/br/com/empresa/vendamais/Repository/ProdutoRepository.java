package br.com.empresa.vendamais.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.empresa.vendamais.Model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long> {

}
