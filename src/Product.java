
public class Product {

    String titleProduct;
    double price;

    public Product(String titleProduct, int price) {
        this.titleProduct = titleProduct;
        this.price = price;
    }

    public String getTitleProduct() {
        return titleProduct;
    }

    public void setTitleProduct(String titleProduct) {
        this.titleProduct = titleProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
