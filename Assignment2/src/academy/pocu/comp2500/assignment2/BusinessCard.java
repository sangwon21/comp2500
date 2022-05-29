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
        this.businessCardColor = businessCardColor;

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
    }


    public BusinessCardType getBusinessCardType() {
        return this.businessCardType;
    }

    public BusinessCardSides getBusinessCardSides() {
        return this.businessCardSides;
    }

    public BusinessCardColor getBusinessCardColor() {
        return this.businessCardColor;
    }
}
