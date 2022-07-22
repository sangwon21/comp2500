package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.User;

import java.util.HashSet;

public class AuthorizationMiddleware implements IRequestHandler {
    private IRequestHandler requestHandler;
    private HashSet<User> authorizedUsers;

    public AuthorizationMiddleware(IRequestHandler requestHandler, HashSet<User> authorizedUsers) {
        this.requestHandler = requestHandler;
        this.authorizedUsers = authorizedUsers;
    }

    @Override
    public ResultBase handle(Request request) {
        if (authorizedUsers.contains(request.getUser())) {
            return requestHandler.handle(request);
        }

        return new UnauthorizedResult();
    }
}
