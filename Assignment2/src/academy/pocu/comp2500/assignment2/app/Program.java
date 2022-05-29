package academy.pocu.comp2500.assignment2.app;

import academy.pocu.comp2500.assignment2.*;

public class Program {

    public static void main(String[] args) {
        // write your code here
        BusinessCard businessCard = new BusinessCard(BusinessCardType.LAID, BusinessCardSides.DOUBLE, BusinessCardColor.GRAY, Orientation.LANDSCAPE);
        businessCard.addAperture(new ImageAperture(0, 0, 3, 3, "hello"));
        System.out.println(businessCard.getPrice());
    }
}
