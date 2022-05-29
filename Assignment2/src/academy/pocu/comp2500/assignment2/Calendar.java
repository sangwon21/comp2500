package academy.pocu.comp2500.assignment2;

public class Calendar extends Product {
    private CalendarType calendarType;
    private CalendarColor calendarColor;

    // registerWallCalendarCreator
    // registerMagnetCalendarCreator
    // registerDeskCalendarCreator
    public Calendar(final CalendarType calendarType) {
        this.calendarColor = CalendarColor.WHITE;
        this.calendarType = calendarType;

        switch (calendarType) {
            case DESK:
                this.setHeight(150);
                this.setWidth(200);
                this.setPrice(1000);
                this.setDisplayName("Desk Calendar");
                break;
            case WALL:
                this.setHeight(400);
                this.setWidth(400);
                this.setPrice(1000);
                this.setDisplayName("Wall Calendar");
                break;
            case MAGNET:
                this.setHeight(200);
                this.setWidth(100);
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
