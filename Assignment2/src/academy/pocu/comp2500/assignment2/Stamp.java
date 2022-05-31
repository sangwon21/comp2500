package academy.pocu.comp2500.assignment2;

public class Stamp extends Product {
    private String text;
    private StampSize stampSize;

    // registerRedStampCreator
    // registerBlueStampCreator
    // registerGreenStampCreator
    public Stamp(final String text, final StampSize stampSize, final StampColor stampColor, ShippingMethod shippingMethod) {
        this.text = text;
        this.stampSize = stampSize;
        this.shippingMethod = shippingMethod;

        switch (stampColor) {
            case GREEN:
                this.color = new Color(0, 0x80, 0);
                break;
            case BLUE:
                this.color = new Color(0, 0, 0xFF);
                break;
            case RED:
                this.color = new Color(0xFF, 0, 0);
                break;
        }

        setStampSize(stampSize);
        setDisplayName("Stamp");
    }

    private void setStampSize(StampSize stampSize) {
        switch (stampSize) {
            case W40H30:
                this.setHeight(30);
                this.setWidth(40);
                this.setPrice(2300);
                break;
            case W50H20:
                this.setHeight(20);
                this.setWidth(50);
                this.setPrice(2300);
                break;
            case W70H40:
                this.setHeight(40);
                this.setWidth(70);
                this.setPrice(2600);
                break;
        }
    }

    public String getText() {
        return this.text;
    }

    public StampSize getStampSize() {
        return this.stampSize;
    }
}
