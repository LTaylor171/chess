package dataAccess.memory;

import dataAccess.AuthDAO;
import model.AuthData;
import model.UserData;

import java.util.HashMap;
import java.util.UUID;

public class MemoryAuthDAO implements AuthDAO{
    private final HashMap<String, AuthData> authTokens = new HashMap<>();
    // clear the database
    public void clear(){
        authTokens.clear();
    }

    // create a new user autherization
    @Override
    public AuthData createAuth(UserData userData) {
        AuthData authData = new AuthData(userData.username(), UUID.randomUUID().toString());
        authTokens.put(authData.authToken(), authData);
        return authData;
    }

    // return user autherization
    @Override
    public AuthData getAuth(String authToken) {
        return authTokens.get(authToken);
    }

    // check if user exists if it exists
    @Override
    public boolean existsAuth(String authToken) {
        return authTokens.containsKey(authToken);
    }

    // delete user autherization
    @Override
    public boolean deleteAuth(String username){
        if (authTokens.containsKey(username)){
            authTokens.remove(username);
            return true;
        }
        return false;
    }
}
