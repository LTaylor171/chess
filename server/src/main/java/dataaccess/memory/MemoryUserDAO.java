package dataAccess.memory;

import dataAccess.UserDAO;
import model.UserData;
import java.util.HashMap;

public class MemoryUserDAO implements UserDAO {
    private final HashMap<String, UserData> users = new HashMap<>();
    // clear the database
    public void clear(){
        users.clear();
    }

    // create a new user
    @Override
    public void createUser(UserData userData) {
        users.put(userData.username(), userData);
    }

    // return user data
    @Override
    public UserData getUser(String username) {
        return users.get(username);
    }

    // check if user exists
    @Override
    public boolean existsUser(String username) {
        return users.containsKey(username);
    }
    
}
