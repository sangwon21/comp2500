package academy.pocu.comp2500.assignment2;

public class Product {
    protected int width;
    protected int height;
    protected int price;
    protected ShippingMethod shippingMethod;
    protected String displayName;
    protected Color color;

    protected Product() {

    }

    protected void setWidth(final int width) {
        this.width = width;
    }

    protected void setHeight(final int height) {
        this.height = height;
    }

    protected void setPrice(final int price) {
        this.price = price;
    }

    protected void setDisplayName(final String displayName) {
        this.displayName = displayName;
    }

    protected void setColor(final Color color) {
        this.color = color;
    }

    public void setShippingMethod(final ShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getPrice() {
        return this.price;
    }

    public ShippingMethod getShippingMethod() {
        return this.shippingMethod;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public Color getColor() {
        return color;
    }
}
