import java.util.ArrayList;
import java.util.List;

public class StoreEmulation {


    private List<Buyers> buyers;
    private List<Product> products;
    private List<Order> orders;

    public StoreEmulation() {
        this.buyers = new ArrayList<>();
        this.products = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public void addBuyers(Buyers buyer) {
        buyers.add(buyer);

    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void createOrder(Buyers buyer, Product product, int quanit) throws CustomerException, ProductException, AmountException {

        if (!buyers.contains(buyer)) {
            throw new CustomerException("Нет такого покупателя " + buyer.getSurname());
        }
        if (!products.contains(product)) {
            throw new ProductException("Нет такого продукта " + product.getTitleProduct());
        }

        if ((quanit <= 0) || quanit > 100) {
            throw new AmountException("Нет такого количества " + quanit);
        }

        Order order = new Order(buyer, product, quanit);
        orders.add(order);

    }

    public void printOrder() {
        for (Order order : orders) {
            Buyers buyer = order.getBuyer();
            Product product = order.getProduct();
            int quanit = order.getQuantity();
            double totalPrice = order.getTotalPrice();
            System.out.println("----------------------------------------");
            System.out.println("Информация о заказе : ");
            System.out.println("Buyers " + buyer.getSurname());
            System.out.println("Product : " + product.getTitleProduct());
            System.out.println("Quanity : " + quanit);
            System.out.println("Total price : " + totalPrice);
            System.out.println("Age :" + buyer.getAge() + "лет");

            System.out.println("----------------------------------------");


        }

    }

    public static void main(String[] args) {

        StoreEmulation storeEmulation = new StoreEmulation();

        Buyers buyer_1 = new Buyers("Ivan", "Ivanovich", "Ivanov", 34, 123);
        Buyers buyer_2 = new Buyers("Sergej", "Sergeevich", "Sergeev", 25, 234);

        storeEmulation.addBuyers(buyer_1);
        storeEmulation.addBuyers(buyer_2);


        Product product_1 = new Product("Iphone", 160000);
        Product product_2 = new Product("Samsung", 55000);
        Product product_3 = new Product("Huavey", 43000);
        Product product_4 = new Product("Nokia", 53000);
        Product product_5 = new Product("HTS", 33000);

        storeEmulation.addProduct(product_1);
        storeEmulation.addProduct(product_2);
        storeEmulation.addProduct(product_3);
        storeEmulation.addProduct(product_4);
        storeEmulation.addProduct(product_5);

        try {
            storeEmulation.createOrder(buyer_1, product_4, 1);
            storeEmulation.createOrder(buyer_2, product_3, 2);
            storeEmulation.createOrder(buyer_1, product_5, 2);
        } catch (CustomerException | ProductException | AmountException exception) {
            System.out.println("Ошибка : " + exception.getMessage());
        }


        storeEmulation.printOrder();


    }
}