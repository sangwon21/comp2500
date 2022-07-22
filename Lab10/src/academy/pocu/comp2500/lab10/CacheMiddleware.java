package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.ResultCode;

import java.util.HashMap;

public class CacheMiddleware implements IRequestHandler {
    private IRequestHandler requestHandler;
    private HashMap<Request, Integer> cacheUsedCountMap;
    private int expiryCount;

    public CacheMiddleware(IRequestHandler requestHandler, int expiryCount) {
        this.requestHandler = requestHandler;
        this.cacheUsedCountMap = new HashMap<>();
        this.expiryCount = expiryCount;
    }


    @Override
    public ResultBase handle(Request request) {
        if (this.cacheUsedCountMap.containsKey(request)) {
            int usedCount = this.cacheUsedCountMap.get(request) + 1;


            if (usedCount <= this.expiryCount) {
                this.cacheUsedCountMap.put(request, usedCount);
                return new CachedResult(this.expiryCount - usedCount);
            }

            this.cacheUsedCountMap.remove(request);
        }

        ResultBase resultBase = this.requestHandler.handle(request);
        ResultValidator validator = new ResultValidator(resultBase);

        if (validator.isValid(ResultCode.OK)) {
            this.cacheUsedCountMap.put(request, 0);
        }

        return resultBase;
    }
}
