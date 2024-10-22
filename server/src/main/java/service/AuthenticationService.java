package service;

import dataAccess.AuthDAO;
import dataAccess.DataAccessException;
import exception.ResponseError;
import model.AuthData;

public class AuthenticationService {
    private AuthDAO authDAO;

    public AuthenticationService(AuthDAO authDAO) {
        this.authDAO = authDAO;
    }

    // returns the object associated with the authToken
    public AuthData getAuthData(String authToken) throws DataAccessException {
        return authDAO.getAuth(authToken);
    }

    // checks if the authToken exists. If it does not exist, it throws a ResponseError
    public boolean isAuthorized(String authToken) throws DataAccessException, ResponseError {
        if (!authDAO.existsAuth(authToken)) {
            throw new ResponseError(401, "Error: Unauthorized");
        }
        return true;
    }

    
}
