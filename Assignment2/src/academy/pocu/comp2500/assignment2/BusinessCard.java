package academy.pocu.comp2500.assignment2;

import academy.pocu.comp2500.BusinessCardColor;

public class BusinessCard extends Product {
    private BusinessCardColor businessCardColor;

    public BusinessCard(BusinessCardType businessCardType, BusinessCardSide businessCardSide, BusinessCardColor businessCardColor) {
        setPrice(100);
        if (businessCardSide == BusinessCardSide.DOUBLE) {
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
}
