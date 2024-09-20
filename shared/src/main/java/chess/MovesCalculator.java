package chess;

import java.util.ArrayList;
import java.util.Collection;

public class MovesCalculator {    //list possible moves here

    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        ChessPiece piece = board.getPiece(myPosition);

        if (piece.getPieceType() == ChessPiece.PieceType.BISHOP){
            return bishopMoves(board, myPosition);
        }
        else if (piece.getPieceType() == ChessPiece.PieceType.KING){
            return kingMoves(board, myPosition);
        }
//        else if (piece.getPieceType() == ChessPiece.PieceType.PAWN){
//            return pawnMoves(board, myPosition);
//        }
//        else if (piece.getPieceType() == ChessPiece.PieceType.QUEEN){
//            return queenMoves(board, myPosition);
//        }
//        else if (piece.getPieceType() == ChessPiece.PieceType.ROOK){
//            return rookMoves(board, myPosition

        return kingMoves(board, myPosition);

    }

    private Collection<ChessMove> bishopMoves(ChessBoard board, ChessPosition myPosition) {
        Collection<ChessMove> moves = new ArrayList<>();
        int row = myPosition.getRow();
        int col = myPosition.getColumn();
        ChessPiece.PieceType promotionPiece = null;

        // Top-right diagonal
        for (int i = 1; i < 9; i++) {
            if (row+i < 9 && col+i < 9) {
                moves.add(new ChessMove(myPosition, new ChessPosition(row + i, col + i), promotionPiece));
            }
        }

        // Top-left diagonal
        for (int i = 1; i < 9; i++) {
            if (row+i < 9 && col-i > 0) {
                moves.add(new ChessMove(myPosition, new ChessPosition(row + i, col - i), promotionPiece));
            }
        }

        // Bottom-right diagonal
        for (int i = 8; i > 0; i--) {
            if (row-i > 0 && col+i < 9) {
                moves.add(new ChessMove(myPosition, new ChessPosition(row - i, col + i), promotionPiece));
            }
        }

        // Bottom-left diagonal
        for (int i = 8; i > 0; i--) {
            if (row-i > 0 && col-i > 0) {
                moves.add(new ChessMove(myPosition, new ChessPosition(row + i, col + i), promotionPiece));
            }
        }

        return moves;
    }

    private Collection<ChessMove> kingMoves(ChessBoard board, ChessPosition myPosition) {
        Collection<ChessMove> moves = new ArrayList<>();
        int row = myPosition.getRow();
        int col = myPosition.getColumn();
        ChessPiece.PieceType promotionPiece = null;

        // if the space is not occupied by a friendly piece, add the move

        // Top
        if (row+1 < 9){
            // if the board position is already taken by a piece, check if it is an enemy piece
            if (board.getPiece(new ChessPosition(row + 1, col)) != null){
                if (board.getPiece(new ChessPosition(row + 1, col)).getTeamColor() != board.getPiece(myPosition).getTeamColor()) {
                    moves.add(new ChessMove(myPosition, new ChessPosition(row + 1, col), promotionPiece));
                }
            }
            else {
                moves.add(new ChessMove(myPosition, new ChessPosition(row + 1, col), promotionPiece));
            }
        }

        // Top-right
        if (row+1 < 9 && col+1 < 9){
            if (board.getPiece(new ChessPosition(row + 1, col + 1)) != null){
                if (board.getPiece(new ChessPosition(row + 1, col + 1)).getTeamColor() != board.getPiece(myPosition).getTeamColor()) {
                    moves.add(new ChessMove(myPosition, new ChessPosition(row + 1, col + 1), promotionPiece));
                }
            }
            else {
                moves.add(new ChessMove(myPosition, new ChessPosition(row + 1, col + 1), promotionPiece));
            }
        }

        // Right
        if (col+1 < 9){
            if (board.getPiece(new ChessPosition(row, col + 1)) != null){
                if (board.getPiece(new ChessPosition(row, col + 1)).getTeamColor() != board.getPiece(myPosition).getTeamColor()) {
                    moves.add(new ChessMove(myPosition, new ChessPosition(row, col + 1), promotionPiece));
                }
            }
            else {
                moves.add(new ChessMove(myPosition, new ChessPosition(row, col + 1), promotionPiece));
            }
        }

        // Bottom-right
        if (row-1 > 0 && col+1 < 9){
            if (board.getPiece(new ChessPosition(row - 1, col + 1)) != null){
                if (board.getPiece(new ChessPosition(row - 1, col + 1)).getTeamColor() != board.getPiece(myPosition).getTeamColor()) {
                    moves.add(new ChessMove(myPosition, new ChessPosition(row - 1, col + 1), promotionPiece));
                }
            }
            else {
                moves.add(new ChessMove(myPosition, new ChessPosition(row - 1, col + 1), promotionPiece));
            }
        }


        // Bottom
        if (row-1 > 0){
            if (board.getPiece(new ChessPosition(row - 1, col)) != null){
                if (board.getPiece(new ChessPosition(row - 1, col)).getTeamColor() != board.getPiece(myPosition).getTeamColor()) {
                    moves.add(new ChessMove(myPosition, new ChessPosition(row - 1, col), promotionPiece));
                }
            }
            else {
                moves.add(new ChessMove(myPosition, new ChessPosition(row - 1, col), promotionPiece));
            }
        }

        // Bottom-left
        if (row-1 > 0 && col-1 > 0){
            if (board.getPiece(new ChessPosition(row - 1, col - 1)) != null){
                if (board.getPiece(new ChessPosition(row - 1, col - 1)).getTeamColor() != board.getPiece(myPosition).getTeamColor()) {
                    moves.add(new ChessMove(myPosition, new ChessPosition(row - 1, col - 1), promotionPiece));
                }
            }
            else {
                moves.add(new ChessMove(myPosition, new ChessPosition(row - 1, col - 1), promotionPiece));
            }
        }

        // Left
        if (col-1 > 0){
            if (board.getPiece(new ChessPosition(row, col - 1)) != null){
                if (board.getPiece(new ChessPosition(row, col - 1)).getTeamColor() != board.getPiece(myPosition).getTeamColor()) {
                    moves.add(new ChessMove(myPosition, new ChessPosition(row, col - 1), promotionPiece));
                }
            }
            else {
                moves.add(new ChessMove(myPosition, new ChessPosition(row, col - 1), promotionPiece));
            }
        }

        // Top-left
        if (row+1 < 9 && col-1 > 0){
            if (board.getPiece(new ChessPosition(row + 1, col - 1)) != null){
                if (board.getPiece(new ChessPosition(row + 1, col - 1)).getTeamColor() != board.getPiece(myPosition).getTeamColor()) {
                    moves.add(new ChessMove(myPosition, new ChessPosition(row + 1, col - 1), promotionPiece));
                }
            }
            else {
                moves.add(new ChessMove(myPosition, new ChessPosition(row + 1, col - 1), promotionPiece));
            }
        }

        return moves;

    }

}


