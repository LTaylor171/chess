package dataAccess;

import java.util.ArrayList;

import model.GameData;

public interface GameDAO {
    // clear the game
    public void clear() throws DataAccessException;

    // create a new game
    void createGame(GameData gameData) throws DataAccessException;

    // get the game data
    GameData getGame(int gameID) throws DataAccessException;

    // get all the games
    ArrayList<GameData> getAllGames() throws DataAccessException;

    // update the game
    void updateGame(GameData newGame) throws DataAccessException;

}
