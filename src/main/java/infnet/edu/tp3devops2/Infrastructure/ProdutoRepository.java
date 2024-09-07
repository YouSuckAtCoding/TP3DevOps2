package infnet.edu.tp3devops2.Infrastructure;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import infnet.edu.tp3devops2.Domain.Models.Produto;

@Repository
public interface ProdutoRepository extends ReactiveCrudRepository<Produto, Long>{

}
