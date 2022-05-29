package academy.pocu.comp2500.assignment2;

public class Calendar extends Product {
    private CalendarType calendarType;
    private CalendarColor calendarColor;

    // registerWallCalendarCreator
    // registerMagnetCalendarCreator
    // registerDeskCalendarCreator
    public Calendar(final CalendarType calendarType, ShippingMethod shippingMethod) {
        this.calendarColor = CalendarColor.WHITE;
        this.calendarType = calendarType;
        this.shippingMethod = shippingMethod;

        switch (calendarType) {
            case DESK:
                this.setHeight(15);
                this.setWidth(20);
                this.setPrice(1000);
                this.setDisplayName("Desk Calendar");
                break;
            case WALL:
                this.setHeight(40);
                this.setWidth(40);
                this.setPrice(1000);
                this.setDisplayName("Wall Calendar");
                break;
            case MAGNET:
                this.setHeight(20);
                this.setWidth(10);
                this.setPrice(1500);
                this.setDisplayName("Magnet Calendar");
                break;
        }
    }

    public CalendarType getCalendarType() {
        return this.calendarType;
    }

    public CalendarColor getCalendarColor() {
        return this.calendarColor;
    }
}
