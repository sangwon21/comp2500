package academy.pocu.comp2500.assignment2;

public class Stamp extends Product {
    private String text;
    private StampSize stampSize;

    // registerRedStampCreator
    // registerBlueStampCreator
    // registerGreenStampCreator
    public Stamp(final String text, final StampSize stampSize, final StampColor stampColor, final ShippingMethod shippingMethod) {
        this.text = text;
        this.stampSize = stampSize;

        setShippingMethod(shippingMethod);
        setStampSize(stampSize);
        setDisplayName("Stamp");

        switch (stampColor) {
            case GREEN:
                setColor(new Color(0, 0x80, 0));
                break;
            case BLUE:
                setColor(new Color(0, 0, 0xFF));
                break;
            case RED:
                setColor(new Color(0xFF, 0, 0));
                break;
        }
    }

    private void setStampSize(final StampSize stampSize) {
        switch (stampSize) {
            case W40H30:
                setHeight(30);
                setWidth(40);
                setPrice(2300);
                break;
            case W50H20:
                setHeight(20);
                setWidth(50);
                setPrice(2300);
                break;
            case W70H40:
                setHeight(40);
                setWidth(70);
                setPrice(2600);
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
