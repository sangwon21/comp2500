package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;

import java.time.Duration;
import java.time.OffsetDateTime;

public final class MaintenanceMiddleware implements IRequestHandler {
    private static final Duration MAINTENANCE_TIME = Duration.ofHours(1);
    private IRequestHandler requestHandler;
    private OffsetDateTime startDateTime;
    private  OffsetDateTime endDateTime;

    public MaintenanceMiddleware(final IRequestHandler requestHandler, final OffsetDateTime startDateTime) {
        this.requestHandler = requestHandler;
        this.startDateTime = startDateTime;
        this.endDateTime = startDateTime.plus(MAINTENANCE_TIME);
    }

    @Override
    public ResultBase handle(final Request request) {
        OffsetDateTime now = OffsetDateTime.now();

        if (this.startDateTime.isBefore(now) && now.isBefore(this.endDateTime)) {
            return new ServiceUnavailableResult(this.startDateTime, this.endDateTime);
        }

        return requestHandler.handle(request);
    }
}
