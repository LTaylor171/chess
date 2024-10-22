package dataAccess.memory;

import dataAccess.GameDAO;
import model.GameData;

import java.util.ArrayList;
import java.util.HashMap;


public class MemoryGameDAO implements GameDAO {
    private final HashMap<Integer, GameData> games = new HashMap<>();
    // clear the database
    public void clear(){
        games.clear();
    }

    // create a new game
    public void createGame(GameData gameData) {
        games.put(gameData.gameID(), gameData);
    }

    // get the game data
    public GameData getGame(int gameID) {
        return games.get(gameID);
    }

    // get all the games
    public ArrayList<GameData> getAllGames() {
        return new ArrayList<>(games.values());
    }

    // update the game
    public void updateGame(GameData newGame) {
        games.put(newGame.gameID(), newGame);
    }

}
