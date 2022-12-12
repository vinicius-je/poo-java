package entities;

public class Product {
    //Atributos
    private String name;
    private Double price;
    private Integer quantity;

    //Construtor
    public Product(String name, Double price, Integer quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    //Métodos
    public Double totalValueStock(){
        return price * quantity;
    }

    public void updatePrice(Double newPrice){
        this.price = newPrice;
    }

    public void updateQuantity(Integer newQnt){
        this.quantity = newQnt;
    }

    //Getters
    public String getName(){
        return name;
    }

    public String toString(){
        return "Product: " + name + "\n" +
                "Price: $" + String.format("%.2f", price) +  "\n" +
                "Quantity in stock: " + quantity + "\n" +
                "Total value in stock: " + totalValueStock() + "\n";
    }
}
