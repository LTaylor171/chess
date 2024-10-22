package model;

import chess.ChessGame;

public record GameFullData(Integer gameId, String wUsername, String bUsername, String gameName) {
    public boolean isUsed(ChessGame.TeamColor teamColor) {
        if (teamColor == ChessGame.TeamColor.WHITE && wUsername != null) {
            return true;
        } else if (teamColor == ChessGame.TeamColor.BLACK && bUsername != null) {
            return true;
        }
        return false;
    }    
}
