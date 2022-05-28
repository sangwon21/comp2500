package academy.pocu.comp2500.assignment2;

public class BusinessCard extends ProductWithAperture {
    private BusinessCardColor businessCardColor;
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
    public BusinessCard(BusinessCardType businessCardType, BusinessCardSides businessCardSides, BusinessCardColor businessCardColor, Orientation businessCardOrientation) {
        this.orientation = businessCardOrientation;
        this.businessCardSides = businessCardSides;
        this.businessCardType = businessCardType;

        setPrice(100);

        if (businessCardSides == BusinessCardSides.DOUBLE) {
            setPrice(this.price + 30);
        }

        if (businessCardType == BusinessCardType.LINEN) {
            setPrice(this.price + 10);
        }

        if (businessCardType == BusinessCardType.LAID) {
            setPrice(this.price + 20);
        }

        switch (businessCardColor) {
            case GRAY:
                setColor(0xE6E6E6);
                break;
            case IVORY:
                setColor(0xFFFFF0);
                break;
            case WHITE:
                setColor(0xFFFFFF);
                break;
        }

        setWidth(900);
        setHeight(500);
    }


    public BusinessCardType getBusinessCardType() {
        return this.businessCardType;
    }

    public BusinessCardSides getBusinessCardSides() {
        return this.businessCardSides;
    }
}
