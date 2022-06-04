package academy.pocu.comp2500.assignment2;

public class Calendar extends Product {
    private CalendarType calendarType;

    // registerWallCalendarCreator
    // registerMagnetCalendarCreator
    // registerDeskCalendarCreator
    public Calendar(final CalendarType calendarType, final ShippingMethod shippingMethod) {
        this.calendarType = calendarType;

        setShippingMethod(shippingMethod);
        setColor(new Color(0xFF, 0xFF, 0xFF));

        switch (calendarType) {
            case DESK:
                setHeight(150);
                setWidth(200);
                setPrice(1000);
                setDisplayName("Desk Calendar");
                break;
            case WALL:
                setHeight(400);
                setWidth(400);
                setPrice(1000);
                setDisplayName("Wall Calendar");
                break;
            case MAGNET:
                setHeight(200);
                setWidth(100);
                setPrice(1500);
                setDisplayName("Magnet Calendar");
                break;
        }
    }

    public CalendarType getCalendarType() {
        return this.calendarType;
    }

}
