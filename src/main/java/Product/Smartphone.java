package Product;

public class Smartphone extends Product {
    protected String smartphoneName;
    protected String manufacturer;

    public Smartphone(int id, String name, int price, String smartphoneName, String manufacturer) {
        super(id, name, price);
        this.smartphoneName = smartphoneName;
        this.manufacturer = manufacturer;
    }
}
