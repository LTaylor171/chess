package dataAccess;

import model.AuthData;
import model.UserData;

public interface AuthDAO {
    // clear all data from the DAO
    void clear() throws DataAccessException;

    // create a new user
    AuthData createAuth(UserData userData) throws DataAccessException;

    // check if a user exists
    boolean existsAuth(String authToken) throws DataAccessException;

    // get the user data
    AuthData getAuth(String authToken) throws DataAccessException;

    // delete a user
    boolean deleteAuth(String username) throws DataAccessException;

}