package dataAccess;

import model.UserData;

public interface UserDAO {
    // clear the user
    void clear() throws DataAccessException;

    // create a new user
    void createUser(UserData userData) throws DataAccessException;

    // get the user data
    UserData getUser(String username) throws DataAccessException;

    // check is user exists
    boolean existsUser(String username) throws DataAccessException;
}