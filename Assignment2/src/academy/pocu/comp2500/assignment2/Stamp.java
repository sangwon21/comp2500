package academy.pocu.comp2500.assignment2;

public class Stamp extends Product {
    private String text;
    private StampSize stampSize;
    private StampColor stampColor;

    // registerRedStampCreator
    // registerBlueStampCreator
    // registerGreenStampCreator
    public Stamp(final String text, final StampSize stampSize, final StampColor stampColor, ShippingMethod shippingMethod) {
        this.text = text;
        this.stampSize = stampSize;
        this.stampColor = stampColor;
        this.shippingMethod = shippingMethod;

        setStampSize(stampSize);
        setDisplayName("Stamp");
    }

    private void setStampSize(StampSize stampSize) {
        switch (stampSize) {
            case W40H30:
                this.setHeight(3);
                this.setWidth(4);
                this.setPrice(2300);
                break;
            case W50H20:
                this.setHeight(2);
                this.setWidth(5);
                this.setPrice(2300);
                break;
            case W70H40:
                this.setHeight(4);
                this.setWidth(7);
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

    public StampColor getStampColor() {
        return this.stampColor;
    }
}
