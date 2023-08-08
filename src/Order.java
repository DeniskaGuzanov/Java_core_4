
public class Order {

    private Buyers buyer;
    private Product product;


    private int quantity;
    private double totalPrice;

    public Order(Buyers buyer, Product product, int quantity) {
        this.buyer = buyer;
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = sumTotalPrice();
    }

    public Buyers getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyers buyer) {
        this.buyer = buyer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    private double sumTotalPrice(){

        double sumPrice = product.getPrice();

        return sumPrice * quantity;
    }
}
