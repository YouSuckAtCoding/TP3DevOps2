package infnet.edu.tp3devops2.Domain.Models;

import infnet.edu.tp3devops2.Domain.Primtives.EntityRoot;

public class Produto extends EntityRoot{

    public String name;
    public double price;
    public String description;
  
    
    public Produto(long id, String name, double price, String description) {
        super(id);
        this.name = name;
        this.price = price;
        this.description = description;
    }

}
