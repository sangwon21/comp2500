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

        this.businessCardColor = businessCardColor;
        setWidth(900);
        setHeight(500);
    }

    public BusinessCardColor getBusinessCardColor() {
        return this.businessCardColor;
    }

    public BusinessCardType getBusinessCardType() {
        return this.businessCardType;
    }

    public BusinessCardSides getBusinessCardSides() {
        return this.businessCardSides;
    }
}
