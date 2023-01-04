package entities;

import java.io.Console;
import java.util.LinkedList;

public class Menu {
    LinkedList <Product> productList = new LinkedList<Product>();
    Console c = System.console();

    public void displayOptions(){
        int option = 0;
        while(option != 6){
            System.out.println("\t1 - Cadastrar produto\n"
                               +"\t2 - Atualizar preço do produto\n"
                               +"\t3 - Atualizar quantidade do produto\n"
                               +"\t4 - Exibir produtos\n"
                               +"\t5 - Exluir produto\n"
                               +"\t6 - Sair\n");
            
            option = Integer.parseInt(c.readLine("Selecione uma opção: "));
           
            if(option != 6) controller(option);
        }
    }

    public void controller(int option){
        if(option == 1){
            registerProduct();
        }else if(option == 2){
            updateProductPrice();
        }else if(option == 3){
            updateProductQuantity();
        }else if(option == 4){
            displayProducts();
        }else if(option == 5){
            deleteProduct();
        }else{
            System.out.println("Opção inválida!");
        }
    }

    public void registerProduct(){
        String name = c.readLine("Nome do produto: ");
        Double price = Double.parseDouble(c.readLine("Preço do produto: "));
        Integer quantity = Integer.parseInt((c.readLine("Quantidade do produto: ")));

        Product prod = new Product(name, price, quantity);
        productList.add(prod);
    }

    public void updateProductPrice(){
        String prodName = c.readLine("Nome do produto: ");
        Double prodPrice = Double.parseDouble(c.readLine("Novo preço do produto: "));

        for(int i = 0; i < productList.size(); i++){
            if(productList.get(i).getName().equals(prodName)){
                productList.get(i).updatePrice(prodPrice);
            }
        }
    }
    
    public void updateProductQuantity(){
        String prodName = c.readLine("Nome do produto: ");
        Integer prodQnt = Integer.parseInt(c.readLine("Nova quantidade do produto: "));

        for(int i = 0; i < productList.size(); i++){
            if(productList.get(i).getName().equals(prodName)){
                productList.get(i).updateQuantity(prodQnt);
            }
        }
    }

    public void deleteProduct(){
        String prodName = c.readLine("Nome do produto: ");

        for(int i = 0; i < productList.size(); i++){
            if(productList.get(i).getName().equals(prodName)){
                System.out.println("Produto: " + productList.get(i) + " deletado");
                productList.remove(i);
            }
        }
    }

    public void displayProducts(){
        if(!productList.isEmpty()){
            for(Product prod : productList){
                System.out.println(prod);
            }
        }else{
            System.out.println("Não há produtos cadastrados!");
        }
    }
}
