package infnet.edu.tp3devops2.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import infnet.edu.tp3devops2.Contracts.CreateProdutoRequest;
import infnet.edu.tp3devops2.Contracts.UpdateProdutoRequest;
import infnet.edu.tp3devops2.Domain.Models.Produto;
import infnet.edu.tp3devops2.Infrastructure.ProdutoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoRepository _ProdutoRepository;

    @GetMapping("api/getall")
    public Flux<Produto> getAll() {
        return _ProdutoRepository.findAll();
    }

    @PostMapping("api/create")
    public Mono<Produto> create(@RequestBody CreateProdutoRequest request) {

        Produto prod = CreateProdutoRequest.MapToProduto(request);
        return _ProdutoRepository.save(prod);
    }

    @DeleteMapping("api/delete")
    public Mono<Void> Delete(@RequestParam long id) {
        return _ProdutoRepository.deleteById(id);
    }

    @PutMapping("api/update")
    public Mono<Produto> Update(@RequestBody UpdateProdutoRequest request) {

        Produto prod = UpdateProdutoRequest.MapToProduto(request);
        return _ProdutoRepository.save(prod);
    }

}
