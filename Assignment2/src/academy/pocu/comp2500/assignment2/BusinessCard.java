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
    public BusinessCard(final BusinessCardType businessCardType, final BusinessCardSides businessCardSides, final BusinessCardColor businessCardColor, final Orientation businessCardOrientation, final ShippingMethod shippingMethod) {
        this.businessCardSides = businessCardSides;
        this.businessCardType = businessCardType;

        setPrice(100);
        setDisplayName("Smooth Business Card");
        setOrientation(businessCardOrientation);
        setShippingMethod(shippingMethod);

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

        setWidth(90);
        setHeight(50);

        switch (businessCardColor) {
            case WHITE:
                setColor(new Color(0xFF, 0xFF, 0xFF));
                break;
            case IVORY:
                setColor(new Color(0xFF, 0xFF, 0xF0));
                break;
            case GRAY:
                setColor(new Color(0xE6, 0xE6, 0xE6));
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
