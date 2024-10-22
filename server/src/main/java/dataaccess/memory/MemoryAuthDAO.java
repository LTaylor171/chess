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

    // create a new user
    AuthData
}
