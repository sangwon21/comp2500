package academy.pocu.comp2500.assignment2.app;

import academy.pocu.comp2500.assignment2.BusinessCardColor;
import academy.pocu.comp2500.assignment2.BusinessCard;
import academy.pocu.comp2500.assignment2.BusinessCardSides;
import academy.pocu.comp2500.assignment2.BusinessCardType;
import academy.pocu.comp2500.assignment2.Orientation;

public class Program {

    public static void main(String[] args) {
        // write your code here
        BusinessCard businessCard = new BusinessCard(BusinessCardType.LAID, BusinessCardSides.DOUBLE, BusinessCardColor.GRAY, Orientation.LANDSCAPE);
        businessCard.getPrice();
    }
}
