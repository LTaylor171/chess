package service;

import dataAccess.AuthDAO;
import dataAccess.GameDAO;
import dataAccess.UserDAO;
import dataAccess.DataAccessException;
import exception.ResponseError;

public class ClearService {
    private AuthDAO authDAO;
    private GameDAO gameDAO;
    private UserDAO userDAO;

    public ClearService(AuthDAO authDAO, GameDAO gameDAO, UserDAO userDAO) {
        this.authDAO = authDAO;
        this.gameDAO = gameDAO;
        this.userDAO = userDAO;
    }

    // deletes all data from the database
    public void clear() throws DataAccessException, ResponseError {
        authDAO.clear();
        gameDAO.clear();
        userDAO.clear();
    }
    
}
