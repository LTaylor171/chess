package service;

import java.util.Random;

import chess.ChessGame;
import handler.CreateGameRequest;
import dataAccess.GameDAO;
import dataAccess.DataAccessException;
import exception.ResponseError;

public class GameService {
    private GameDAO gameDAO;


    public GameService(GameDAO gameDAO) {
        this.gameDAO = gameDAO;
        this.userDAO = userDAO;
    }

    // deletes all data from the database
    public void clear() throws DataAccessException, ResponseError {
        gameDAO.clear();
        userDAO.clear();
    }
    
}
