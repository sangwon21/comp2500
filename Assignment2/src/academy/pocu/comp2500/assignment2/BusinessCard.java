package academy.pocu.comp2500.assignment2;

public class BusinessCard extends ProductWithAperture {
    private BusinessCardSides businessCardSides;
    private BusinessCardType businessCardType;

    // registerLandscapeBusinessCardCreator
    // registerPortraitBusinessCardCreator
    // registerIvoryBusinessCardCreator
    // registerGrayBusinessCardCreator
    // registerWhiteBusinessCardCreator
    // registerLaidBusinessCardCreator
    // registerLinenBusinessCardCreator
    // registerSmoothBusinessCardCreator
    // registerSingleSidedBusinessCardCreator
    // registerDoubleSidedBusinessCardCreator
    public BusinessCard(BusinessCardType businessCardType, BusinessCardSides businessCardSides, BusinessCardColor businessCardColor, Orientation businessCardOrientation, ShippingMethod shippingMethod) {
        this.orientation = businessCardOrientation;
        this.businessCardSides = businessCardSides;
        this.businessCardType = businessCardType;
        this.shippingMethod = shippingMethod;

        setPrice(100);
        setDisplayName("Smooth Business Card");

        if (businessCardSides == BusinessCardSides.DOUBLE) {
            setPrice(this.price + 30);
        }

        if (businessCardType == BusinessCardType.LINEN) {
            setPrice(this.price + 10);
            setDisplayName("Linen Business Card");
        }

        if (businessCardType == BusinessCardType.LAID) {
            setPrice(this.price + 20);
            setDisplayName("Laid Business Card");
        }

        setWidth(900);
        setHeight(500);

        switch (businessCardColor) {
            case WHITE:
                this.color = new Color(0xFF, 0xFF, 0xFF);
                break;
            case IVORY:
                this.color = new Color(0xFF, 0xFF, 0xF0);
                break;
            case GRAY:
                this.color = new Color(0xE6, 0xE6, 0xE6);
                break;
        }
    }


    public BusinessCardType getBusinessCardType() {
        return this.businessCardType;
    }

    public BusinessCardSides getBusinessCardSides() {
        return this.businessCardSides;
    }
}
