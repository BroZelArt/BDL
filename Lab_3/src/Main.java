import java.util.*;

/*
9. Система Интернет-магазин. Администратор добавляет информацию о Товаре. Клиент делает и оплачивает Заказ на Товары.
 Администратор регистрирует Продажу и может занести неплательщиков в «черный список».
 */

class Client{
    private String name;
    private String sost;
    public Client(){}
    private ArrayList<Order> orders;
    public Client(String name){
        this.name = name;
        ArrayList<Order> Order1 = new ArrayList<Order>(1);
        this.orders=Order1;
        this.sost = "Плательщик";
    }

   public void addOrder (Order ord){
       orders.add(ord);
   }

    public void setOrder (Order ord,String  s){
        this.orders.get( this.orders.indexOf(ord)).setSost(s);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSost() {
        return sost;
    }

    public void setSost(String sost) {
        this.sost = sost;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", sost='" + sost + '\'' +
                ", orders=" + orders +
                '}';
    }
}

class Order{
    private  int orderID;
    private String sost;
    int price;

    private ArrayList<Product> products;
    public Order(){}

    public Order(int id){
        ArrayList<Product> Product1 = new ArrayList<Product>(1);
        this.products=Product1;
        this.orderID=id;
       this.sost="Создан";
       this.price=0;
    }

    public void addProduct(Product prod){
        products.add(prod);
        this.price=this.price+prod.getCost();
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getSost() {
        return sost;
    }

    public void setSost(String sost) {
        this.sost = sost;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", sost='" + sost + '\'' +
                ", price=" + price +
                ", products=" + products +
                '}';
    }
}

class Product {
    int cost;
    String name;

    public Product (){}
    public Product (int c, String name){
        this.name=name;
        this.cost=c;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "cost=" + cost +
                ", name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;


    }
}

class Administrator{
    private ArrayList<Order> orders;
    private ArrayList<Product> products;
    private ArrayList<Client> clients;

    @Override
    public String toString() {
        return "Administrator{" +
                "Order=" + orders +
                ", Product=" + products +
                ", Client=" + clients +
                '}';
    }

    public void renameProduct(Product p, String s){
        Product pr=p;
        this.products.remove(pr);
        pr.setName(s);
        this.products.add(pr);
    }

    public void setBL(Client c){
        this.clients.remove(c);
        c.setSost("В бане");
        System.out.println("Клиент " + c.getName() + " попадает в черный список");
    }

    public void setSELL(Client c, Order o){
        this.clients.get( this.clients.indexOf(c)).setOrder(o,"Оплачен");
        System.out.println("Заказ " + o.getOrderID() + " оплачен клиентом " +c.getName());
    }


}




public class Main {

    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in);
        Client client = new Client();
        ArrayList<Client> clients = new ArrayList<Client>(1);
        Order order = new Order();
        ArrayList<Order> orders = new ArrayList<Order>(1);
        Product product= new Product();
        ArrayList<Product> products= new ArrayList<Product>(1);
        Administrator administrator= new Administrator();
        String client_name = "";
        String order_name = "";
        String product_name = "";
        System.out.println("Добро пожаловать! Выберите действие:\n" +
                "1) Добавить заказ\n" +
                "2) Добавить клиента\n" +
                "3) Изменить название товара\n" +
                "4) Добавить клиента в черный список\n" +
                "5) Оформить заказ\n" +
                "0) Выход");
        while (true){
            System.out.println("Выберете действие: ");
            int tmp = myObj.nextInt();
            switch (tmp) {
                case 1:
                    System.out.print("Введите номер заказа: ");
                    int or_n = myObj.nextInt();
                    order = new Order(or_n);
                    orders.add(order);
                    System.out.println("Заказ создан");
                    break;


                case 0:
                    break;
            }
            if (tmp == 0){
                break;
            }
        }
    }
}

