package infnet.edu.tp3devops2.Contracts;

import infnet.edu.tp3devops2.Domain.Models.Produto;

public class UpdateProdutoRequest {

    private long id;
    private String name;
    private double price;
    private String description;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
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

       public static Produto MapToProduto(UpdateProdutoRequest request) {
        return new Produto(request.getId(), request.getName(), request.getPrice(), request.getDescription());
    }

}
