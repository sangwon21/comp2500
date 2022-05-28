package academy.pocu.comp2500.assignment2;

public class Calendar extends Product {
    private CalendarType calendarType;

    // registerWallCalendarCreator
    // registerMagnetCalendarCreator
    // registerDeskCalendarCreator
    public Calendar(final CalendarType calendarType) {
        setColor(0xFFFFFF);
        this.calendarType = calendarType;

        switch (calendarType) {
            case DESK:
                this.setHeight(150);
                this.setWidth(200);
                this.setPrice(1000);
                break;
            case WALL:
                this.setHeight(400);
                this.setWidth(400);
                this.setPrice(1000);
                break;
            case MAGNET:
                this.setHeight(200);
                this.setWidth(100);
                this.setPrice(1500);
                break;
        }
    }

    public CalendarType getCalendarType() {
        return this.calendarType;
    }
}
