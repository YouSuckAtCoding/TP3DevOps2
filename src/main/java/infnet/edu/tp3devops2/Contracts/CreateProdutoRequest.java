package infnet.edu.tp3devops2.Contracts;

import infnet.edu.tp3devops2.Domain.Models.Produto;

public class CreateProdutoRequest {

    private String name;
    private double price;
    private String description;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public static Produto MapToProduto(CreateProdutoRequest request) {
        return new Produto(0, request.getName(), request.getPrice(), request.getDescription());
    }
  
}
