package academy.pocu.comp2500.assignment2;

public class Stamp extends Product {
    private String text;
    private StampSize stampSize;
    private StampColor stampColor;

    // registerRedStampCreator
    // registerBlueStampCreator
    // registerGreenStampCreator
    public Stamp(final String text, final StampSize stampSize, final StampColor stampColor) {
        this.text = text;
        this.stampSize = stampSize;
        this.stampColor = stampColor;
        setStampSize(stampSize);
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

    public StampColor getStampColor() {
        return this.stampColor;
    }
}
