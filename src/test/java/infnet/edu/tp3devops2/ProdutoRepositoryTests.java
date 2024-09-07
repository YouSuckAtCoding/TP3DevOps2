package infnet.edu.tp3devops2;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import infnet.edu.tp3devops2.Domain.Models.Produto;
import infnet.edu.tp3devops2.Infrastructure.ProdutoRepository;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
public class ProdutoRepositoryTests {

    @Autowired
    private ProdutoRepository _ProdutoRepository;

    @Test
    void Should_Create_Produto_And_Insert_On_Database()
    {
        Produto prod = new Produto(0, "Teste", 1000, "This is a test product");
        StepVerifier
        .create(_ProdutoRepository.save(prod))
        .expectNextCount(1)
        .verifyComplete();

    }

    @Test
    void Should_Return_All_Produos_From_Database()
    {
        StepVerifier
        .create(_ProdutoRepository.findAll().collectList())
        .consumeNextWith(produtos -> {
            assertTrue(produtos.size() > 0);
        })
        .verifyComplete();
    }

    @Test
    void Should_Return_Produto_With_Spcified_Id_From_Database()
    {
        long id = 1;
        StepVerifier
        .create(_ProdutoRepository.findById(id))
        .consumeNextWith(x -> x.id = id)
        .verifyComplete();
        
    }

    @Test
    void SHould_Update_Produto_From_Database()
    {

        Produto last = getLast();

        last.name = "Updated";

        StepVerifier
        .create(_ProdutoRepository.save(last))
        .consumeNextWith(x -> x.id = last.id)
        .verifyComplete();
        
    }


    @Test   
    void Should_Delete_Produto_From_Database()
    {
        Produto prod = new Produto(0, "Teste", 1000, "This is a test product");
        Produto result = _ProdutoRepository.save(prod).block();

        StepVerifier
        .create(_ProdutoRepository.delete(result))
        .verifyComplete();

    }
    private Produto getLast() {
        List<Produto> list = _ProdutoRepository.findAll().collectList().block();

        Produto last = list.get(list.size() - 1);
        return last;
    }

}
