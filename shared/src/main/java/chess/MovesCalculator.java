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
        else if (piece.getPieceType() == ChessPiece.PieceType.PAWN){
            return pawnMoves(board, myPosition);
        }
        else if (piece.getPieceType() == ChessPiece.PieceType.QUEEN){
            return queenMoves(board, myPosition);
        }
        else if (piece.getPieceType() == ChessPiece.PieceType.ROOK){
            return rookMoves(board, myPosition);
        }
        else if (piece.getPieceType() == ChessPiece.PieceType.KNIGHT){
            return knightMoves(board, myPosition);
        }

        return null;

    }

    private Collection<ChessMove> bishopMoves(ChessBoard board, ChessPosition myPosition) {
        Collection<ChessMove> moves = new ArrayList<>();
        int row = myPosition.getRow();
        int col = myPosition.getColumn();
        ChessPiece.PieceType promotionPiece = null;

        int newRow = row;
        int newCol = col;

        // Top-right diagonal
        for (int i = 1; i < 9; i++) {
            newRow = row + i;
            newCol = col + i;
            if (newRow < 9 && newCol < 9) {
                if (board.getPiece(new ChessPosition(newRow, newCol)) != null){
                    if (board.getPiece(new ChessPosition(newRow, newCol)).getTeamColor() != board.getPiece(myPosition).getTeamColor()) {
                        moves.add(new ChessMove(myPosition, new ChessPosition(newRow, newCol), promotionPiece));
                    }
                    break;
                }
                else {
                    moves.add(new ChessMove(myPosition, new ChessPosition(newRow, newCol), promotionPiece));
                }
            }
        }

        // Top-left diagonal
        for (int i = 1; i < 9; i++) {
            newRow = row + i;
            newCol = col - i;
            if (newRow < 9 && newCol > 0) {
                if (board.getPiece(new ChessPosition(newRow, newCol)) != null){
                    if (board.getPiece(new ChessPosition(newRow, newCol)).getTeamColor() != board.getPiece(myPosition).getTeamColor()) {
                        moves.add(new ChessMove(myPosition, new ChessPosition(newRow, newCol), promotionPiece));
                    }
                    break;
                }
                else {
                    moves.add(new ChessMove(myPosition, new ChessPosition(newRow, newCol), promotionPiece));
                }
            }
        }

        // Bottom-right diagonal
        for (int i = 1; i < 9; i++) {
            newRow = row - i;
            newCol = col + i;
            if (newRow > 0 && newCol < 9) {
                if (board.getPiece(new ChessPosition(newRow, newCol)) != null){
                    if (board.getPiece(new ChessPosition(newRow, newCol)).getTeamColor() != board.getPiece(myPosition).getTeamColor()) {
                        moves.add(new ChessMove(myPosition, new ChessPosition(newRow, newCol), promotionPiece));
                    }
                    break;
                }
                else {
                    moves.add(new ChessMove(myPosition, new ChessPosition(newRow, newCol), promotionPiece));
                }
            }
        }

        // Bottom-left diagonal
        for (int i = 1; i < 9; i++) {
            newRow = row - i;
            newCol = col - i;
            if (newRow > 0 && newCol > 0) {
                if (board.getPiece(new ChessPosition(newRow, newCol)) != null){
                    if (board.getPiece(new ChessPosition(newRow, newCol)).getTeamColor() != board.getPiece(myPosition).getTeamColor()) {
                        moves.add(new ChessMove(myPosition, new ChessPosition(newRow, newCol), promotionPiece));
                    }
                    break;
                }
                else {
                    moves.add(new ChessMove(myPosition, new ChessPosition(newRow, newCol), promotionPiece));
                }
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

    private Collection<ChessMove> rookMoves(ChessBoard board, ChessPosition myPosition) {
        Collection<ChessMove> moves = new ArrayList<>();
        int row = myPosition.getRow();
        int col = myPosition.getColumn();
        ChessPiece.PieceType promotionPiece = null;

        int newRow = row;
        int newCol = col;

        // Top
        for (int i = 1; i < 9; i++) {
            newRow = row + i;
            if (newRow < 9) {
                if (board.getPiece(new ChessPosition(newRow, col)) != null){
                    if (board.getPiece(new ChessPosition(newRow, col)).getTeamColor() != board.getPiece(myPosition).getTeamColor()) {
                        moves.add(new ChessMove(myPosition, new ChessPosition(newRow, col), promotionPiece));
                    }
                    break;
                }
                else {
                    moves.add(new ChessMove(myPosition, new ChessPosition(newRow, col), promotionPiece));
                }
            }
        }

        // Right
        for (int i = 1; i < 9; i++) {
            newCol = col + i;
            if (newCol < 9) {
                if (board.getPiece(new ChessPosition(row, newCol)) != null){
                    if (board.getPiece(new ChessPosition(row, newCol)).getTeamColor() != board.getPiece(myPosition).getTeamColor()) {
                        moves.add(new ChessMove(myPosition, new ChessPosition(row, newCol), promotionPiece));
                    }
                    break;
                }
                else {
                    moves.add(new ChessMove(myPosition, new ChessPosition(row, newCol), promotionPiece));
                }
            }
        }

        // Bottom
        for (int i = 1; i < 9; i++) {
            newRow = row - i;
            if (newRow > 0) {
                if (board.getPiece(new ChessPosition(newRow, col)) != null){
                    if (board.getPiece(new ChessPosition(newRow, col)).getTeamColor() != board.getPiece(myPosition).getTeamColor()) {
                        moves.add(new ChessMove(myPosition, new ChessPosition(newRow, col), promotionPiece));
                    }
                    break;
                }
                else {
                    moves.add(new ChessMove(myPosition, new ChessPosition(newRow, col), promotionPiece));
                }
            }
        }

        // Left
        for (int i = 1; i < 9; i++) {
            newCol = col - i;
            if (newCol > 0) {
                if (board.getPiece(new ChessPosition(row, newCol)) != null){
                    if (board.getPiece(new ChessPosition(row, newCol)).getTeamColor() != board.getPiece(myPosition).getTeamColor()) {
                        moves.add(new ChessMove(myPosition, new ChessPosition(row, newCol), promotionPiece));
                    }
                    break;
                }
                else {
                    moves.add(new ChessMove(myPosition, new ChessPosition(row, newCol), promotionPiece));
                }
            }
        }

        return moves;
    }

    private Collection<ChessMove> queenMoves(ChessBoard board, ChessPosition myPosition) {
        Collection<ChessMove> moves = new ArrayList<>();
        int row = myPosition.getRow();
        int col = myPosition.getColumn();
        ChessPiece.PieceType promotionPiece = null;

        int newRow = row;
        int newCol = col;

        // Top
        for (int i = 1; i < 9; i++) {
            newRow = row + i;
            if (newRow < 9) {
                if (board.getPiece(new ChessPosition(newRow, col)) != null){
                    if (board.getPiece(new ChessPosition(newRow, col)).getTeamColor() != board.getPiece(myPosition).getTeamColor()) {
                        moves.add(new ChessMove(myPosition, new ChessPosition(newRow, col), promotionPiece));
                    }
                    break;
                }
                else {
                    moves.add(new ChessMove(myPosition, new ChessPosition(newRow, col), promotionPiece));
                }
            }
        }

        // Right
        for (int i = 1; i < 9; i++) {
            newCol = col + i;
            if (newCol < 9) {
                if (board.getPiece(new ChessPosition(row, newCol)) != null){
                    if (board.getPiece(new ChessPosition(row, newCol)).getTeamColor() != board.getPiece(myPosition).getTeamColor()) {
                        moves.add(new ChessMove(myPosition, new ChessPosition(row, newCol), promotionPiece));
                    }
                    break;
                }
                else {
                    moves.add(new ChessMove(myPosition, new ChessPosition(row, newCol), promotionPiece));
                }
            }
        }

        // Bottom
        for (int i = 1; i < 9; i++) {
            newRow = row - i;
            if (newRow > 0) {
                if (board.getPiece(new ChessPosition(newRow, col)) != null){
                    if (board.getPiece(new ChessPosition(newRow, col)).getTeamColor() != board.getPiece(myPosition).getTeamColor()) {
                        moves.add(new ChessMove(myPosition, new ChessPosition(newRow, col), promotionPiece));
                    }
                    break;
                }
                else {
                    moves.add(new ChessMove(myPosition, new ChessPosition(newRow, col), promotionPiece));
                }
            }
        }

        // Left
        for (int i = 1; i < 9; i++) {
            newCol = col - i;
            if (newCol > 0) {
                if (board.getPiece(new ChessPosition(row, newCol)) != null){
                    if (board.getPiece(new ChessPosition(row, newCol)).getTeamColor() != board.getPiece(myPosition).getTeamColor()) {
                        moves.add(new ChessMove(myPosition, new ChessPosition(row, newCol), promotionPiece));
                    }
                    break;
                }
                else {
                    moves.add(new ChessMove(myPosition, new ChessPosition(row, newCol), promotionPiece));
                }
            }
        }

        // Top-right diagonal
        for (int i = 1; i < 9; i++) {
            newRow = row + i;
            newCol = col + i;
            if (newRow < 9 && newCol < 9) {
                if (board.getPiece(new ChessPosition(newRow, newCol)) != null){
                    if (board.getPiece(new ChessPosition(newRow, newCol)).getTeamColor() != board.getPiece(myPosition).getTeamColor()) {
                        moves.add(new ChessMove(myPosition, new ChessPosition(newRow, newCol), promotionPiece));
                    }
                    break;
                }
                else {
                    moves.add(new ChessMove(myPosition, new ChessPosition(newRow, newCol), promotionPiece));
                }
            }
        }

        // Top-left diagonal
        for (int i = 1; i < 9; i++) {
            newRow = row + i;
            newCol = col - i;
            if (newRow < 9 && newCol > 0) {
                if (board.getPiece(new ChessPosition(newRow, newCol)) != null){
                    if (board.getPiece(new ChessPosition(newRow, newCol)).getTeamColor() != board.getPiece(myPosition).getTeamColor()) {
                        moves.add(new ChessMove(myPosition, new ChessPosition(newRow, newCol), promotionPiece));
                    }
                    break;
                }
                else {
                    moves.add(new ChessMove(myPosition, new ChessPosition(newRow, newCol), promotionPiece));
                }
            }
        }

        // Bottom-right diagonal
        for (int i = 1; i < 9; i++) {
            newRow = row - i;
            newCol = col + i;
            if (newRow > 0 && newCol < 9) {
                if (board.getPiece(new ChessPosition(newRow, newCol)) != null){
                    if (board.getPiece(new ChessPosition(newRow, newCol)).getTeamColor() != board.getPiece(myPosition).getTeamColor()) {
                        moves.add(new ChessMove(myPosition, new ChessPosition(newRow, newCol), promotionPiece));
                    }
                    break;
                }
                else {
                    moves.add(new ChessMove(myPosition, new ChessPosition(newRow, newCol), promotionPiece));
                }
            }
        }

        // Bottom-left diagonal
        for (int i = 1; i < 9; i++) {
            newRow = row - i;
            newCol = col - i;
            if (newRow > 0 && newCol > 0) {
                if (board.getPiece(new ChessPosition(newRow, newCol)) != null){
                    if (board.getPiece(new ChessPosition(newRow, newCol)).getTeamColor() != board.getPiece(myPosition).getTeamColor()) {
                        moves.add(new ChessMove(myPosition, new ChessPosition(newRow, newCol), promotionPiece));
                    }
                    break;
                }
                else {
                    moves.add(new ChessMove(myPosition, new ChessPosition(newRow, newCol), promotionPiece));
                }
            }
        }

        return moves;

    }

    private Collection<ChessMove> knightMoves(ChessBoard board, ChessPosition myPosition) {
        Collection<ChessMove> moves = new ArrayList<>();
        int row = myPosition.getRow();
        int col = myPosition.getColumn();
        ChessPiece.PieceType promotionPiece = null;

        if (row + 2 < 9 && col + 1 < 9){
            if (board.getPiece(new ChessPosition(row + 2, col + 1)) == null || board.getPiece(new ChessPosition(row + 2, col + 1)).getTeamColor() != board.getPiece(myPosition).getTeamColor()){
                moves.add(new ChessMove(myPosition, new ChessPosition(row + 2, col + 1), promotionPiece));
            }
        }

        if (row + 2 < 9 && col - 1 > 0){
            if (board.getPiece(new ChessPosition(row + 2, col - 1)) == null || board.getPiece(new ChessPosition(row + 2, col - 1)).getTeamColor() != board.getPiece(myPosition).getTeamColor()){
                moves.add(new ChessMove(myPosition, new ChessPosition(row + 2, col - 1), promotionPiece));
            }
        }

        if (row - 2 > 0 && col + 1 < 9){
            if (board.getPiece(new ChessPosition(row - 2, col + 1)) == null || board.getPiece(new ChessPosition(row - 2, col + 1)).getTeamColor() != board.getPiece(myPosition).getTeamColor()){
                moves.add(new ChessMove(myPosition, new ChessPosition(row - 2, col + 1), promotionPiece));
            }
        }

        if (row - 2 > 0 && col - 1 > 0){
            if (board.getPiece(new ChessPosition(row - 2, col - 1)) == null || board.getPiece(new ChessPosition(row - 2, col - 1)).getTeamColor() != board.getPiece(myPosition).getTeamColor()){
                moves.add(new ChessMove(myPosition, new ChessPosition(row - 2, col - 1), promotionPiece));
            }
        }

        if (row + 1 < 9 && col + 2 < 9){
            if (board.getPiece(new ChessPosition(row + 1, col + 2)) == null || board.getPiece(new ChessPosition(row + 1, col + 2)).getTeamColor() != board.getPiece(myPosition).getTeamColor()){
                moves.add(new ChessMove(myPosition, new ChessPosition(row + 1, col + 2), promotionPiece));
            }
        }

        if (row + 1 < 9 && col - 2 > 0){
            if (board.getPiece(new ChessPosition(row + 1, col - 2)) == null || board.getPiece(new ChessPosition(row + 1, col - 2)).getTeamColor() != board.getPiece(myPosition).getTeamColor()){
                moves.add(new ChessMove(myPosition, new ChessPosition(row + 1, col - 2), promotionPiece));
            }
        }

        if (row - 1 > 0 && col + 2 < 9){
            if (board.getPiece(new ChessPosition(row - 1, col + 2)) == null || board.getPiece(new ChessPosition(row - 1, col + 2)).getTeamColor() != board.getPiece(myPosition).getTeamColor()){
                moves.add(new ChessMove(myPosition, new ChessPosition(row - 1, col + 2), promotionPiece));
            }
        }

        if (row - 1 > 0 && col - 2 > 0){
            if (board.getPiece(new ChessPosition(row - 1, col - 2)) == null || board.getPiece(new ChessPosition(row - 1, col - 2)).getTeamColor() != board.getPiece(myPosition).getTeamColor()){
                moves.add(new ChessMove(myPosition, new ChessPosition(row - 1, col - 2), promotionPiece));
            }
        }



        return moves;
    }

    private Collection<ChessMove> pawnMoves(ChessBoard board, ChessPosition myPosition) {
        Collection<ChessMove> moves = new ArrayList<>();
        int row = myPosition.getRow();
        int col = myPosition.getColumn();
        ChessPiece.PieceType promotionPiece = null;

        // white pawn
        if (board.getPiece(myPosition).getTeamColor() == ChessGame.TeamColor.WHITE){
            // if the pawn is in the starting position, it can move one or two spaces
            if (row == 2){
                if (board.getPiece(new ChessPosition(row + 1, col)) == null){
                    moves.add(new ChessMove(myPosition, new ChessPosition(row + 1, col), promotionPiece));
                    if (board.getPiece(new ChessPosition(row + 2, col)) == null){
                        moves.add(new ChessMove(myPosition, new ChessPosition(row + 2, col), promotionPiece));
                    }
                }
            }

            // if the pawn is not in the starting position, it can only move one space
            else if (row != 7){
                if (board.getPiece(new ChessPosition(row + 1, col)) == null){
                    moves.add(new ChessMove(myPosition, new ChessPosition(row + 1, col), promotionPiece));
                }
            }

            // if there is an enemy piece in the diagonal, the pawn can take it
            if (col - 1 > 0 && col + 1 < 9) {
                if (board.getPiece(new ChessPosition(row + 1, col + 1)) != null && board.getPiece(new ChessPosition(row + 1, col + 1)).getTeamColor() != board.getPiece(myPosition).getTeamColor()) {
                    if (row == 7) {
                        promotionPiece = ChessPiece.PieceType.QUEEN;
                        moves.add(new ChessMove(myPosition, new ChessPosition(row + 1, col + 1), promotionPiece));
                        promotionPiece = ChessPiece.PieceType.ROOK;
                        moves.add(new ChessMove(myPosition, new ChessPosition(row + 1, col + 1), promotionPiece));
                        promotionPiece = ChessPiece.PieceType.BISHOP;
                        moves.add(new ChessMove(myPosition, new ChessPosition(row + 1, col + 1), promotionPiece));
                        promotionPiece = ChessPiece.PieceType.KNIGHT;
                        moves.add(new ChessMove(myPosition, new ChessPosition(row + 1, col + 1), promotionPiece));
                    } else {
                        moves.add(new ChessMove(myPosition, new ChessPosition(row + 1, col + 1), promotionPiece));
                    }
                } else if (board.getPiece(new ChessPosition(row + 1, col - 1)) != null && board.getPiece(new ChessPosition(row + 1, col - 1)).getTeamColor() != board.getPiece(myPosition).getTeamColor()) {
                    if (row == 7) {
                        promotionPiece = ChessPiece.PieceType.QUEEN;
                        moves.add(new ChessMove(myPosition, new ChessPosition(row + 1, col - 1), promotionPiece));
                        promotionPiece = ChessPiece.PieceType.ROOK;
                        moves.add(new ChessMove(myPosition, new ChessPosition(row + 1, col - 1), promotionPiece));
                        promotionPiece = ChessPiece.PieceType.BISHOP;
                        moves.add(new ChessMove(myPosition, new ChessPosition(row + 1, col - 1), promotionPiece));
                        promotionPiece = ChessPiece.PieceType.KNIGHT;
                        moves.add(new ChessMove(myPosition, new ChessPosition(row + 1, col - 1), promotionPiece));
                    } else {
                        moves.add(new ChessMove(myPosition, new ChessPosition(row + 1, col - 1), promotionPiece));
                    }
                }
            }

            // if the pawn reaches the end of the board, it can be promoted
            if (row == 7){
                promotionPiece = ChessPiece.PieceType.QUEEN;
                moves.add(new ChessMove(myPosition, new ChessPosition(row + 1, col), promotionPiece));
                promotionPiece = ChessPiece.PieceType.ROOK;
                moves.add(new ChessMove(myPosition, new ChessPosition(row + 1, col), promotionPiece));
                promotionPiece = ChessPiece.PieceType.BISHOP;
                moves.add(new ChessMove(myPosition, new ChessPosition(row + 1, col), promotionPiece));
                promotionPiece = ChessPiece.PieceType.KNIGHT;
                moves.add(new ChessMove(myPosition, new ChessPosition(row + 1, col), promotionPiece));
            }
        }

        // now all the same for the black piece headed in the opposite direction
        else {
            // if the pawn is in the starting position, it can move one or two spaces
            if (row == 7){
                if (board.getPiece(new ChessPosition(row - 1, col)) == null){
                    moves.add(new ChessMove(myPosition, new ChessPosition(row - 1, col), promotionPiece));
                    if (board.getPiece(new ChessPosition(row - 2, col)) == null){
                        moves.add(new ChessMove(myPosition, new ChessPosition(row - 2, col), promotionPiece));
                    }
                }
            }

            // if the pawn is not in the starting position, it can only move one space
            else if (row != 2){
                if (board.getPiece(new ChessPosition(row - 1, col)) == null){
                    moves.add(new ChessMove(myPosition, new ChessPosition(row - 1, col), promotionPiece));
                }
            }

            // if there is an enemy piece in the diagonal, the pawn can take it
            if (col - 1 > 0 && col + 1 < 9) {
                if (board.getPiece(new ChessPosition(row - 1, col + 1)) != null && board.getPiece(new ChessPosition(row - 1, col + 1)).getTeamColor() != board.getPiece(myPosition).getTeamColor()) {
                    moves.add(new ChessMove(myPosition, new ChessPosition(row - 1, col + 1), promotionPiece));
                    if (row == 2) {
                        promotionPiece = ChessPiece.PieceType.QUEEN;
                        moves.add(new ChessMove(myPosition, new ChessPosition(row - 1, col + 1), promotionPiece));
                        promotionPiece = ChessPiece.PieceType.ROOK;
                        moves.add(new ChessMove(myPosition, new ChessPosition(row - 1, col + 1), promotionPiece));
                        promotionPiece = ChessPiece.PieceType.BISHOP;
                        moves.add(new ChessMove(myPosition, new ChessPosition(row - 1, col + 1), promotionPiece));
                        promotionPiece = ChessPiece.PieceType.KNIGHT;
                        moves.add(new ChessMove(myPosition, new ChessPosition(row - 1, col + 1), promotionPiece));
                    } else {
                        moves.add(new ChessMove(myPosition, new ChessPosition(row - 1, col + 1), promotionPiece));
                    }
                } else if (board.getPiece(new ChessPosition(row - 1, col - 1)) != null && board.getPiece(new ChessPosition(row - 1, col - 1)).getTeamColor() != board.getPiece(myPosition).getTeamColor()) {
                    if (row == 2) {
                        promotionPiece = ChessPiece.PieceType.QUEEN;
                        moves.add(new ChessMove(myPosition, new ChessPosition(row - 1, col - 1), promotionPiece));
                        promotionPiece = ChessPiece.PieceType.ROOK;
                        moves.add(new ChessMove(myPosition, new ChessPosition(row - 1, col - 1), promotionPiece));
                        promotionPiece = ChessPiece.PieceType.BISHOP;
                        moves.add(new ChessMove(myPosition, new ChessPosition(row - 1, col - 1), promotionPiece));
                        promotionPiece = ChessPiece.PieceType.KNIGHT;
                        moves.add(new ChessMove(myPosition, new ChessPosition(row - 1, col - 1), promotionPiece));
                    } else {
                        moves.add(new ChessMove(myPosition, new ChessPosition(row - 1, col - 1), promotionPiece));
                    }
                }
            }

            // if the pawn reaches the end of the board, it can be promoted
            if (row == 2){
                promotionPiece = ChessPiece.PieceType.QUEEN;
                moves.add(new ChessMove(myPosition, new ChessPosition(row - 1, col), promotionPiece));
                promotionPiece = ChessPiece.PieceType.ROOK;
                moves.add(new ChessMove(myPosition, new ChessPosition(row - 1, col), promotionPiece));
                promotionPiece = ChessPiece.PieceType.BISHOP;
                moves.add(new ChessMove(myPosition, new ChessPosition(row - 1, col), promotionPiece));
                promotionPiece = ChessPiece.PieceType.KNIGHT;
                moves.add(new ChessMove(myPosition, new ChessPosition(row - 1, col), promotionPiece));
            }
            // if there is an enemy piece in the diagonal and last line, the pawn can take it and promote
        }

        return moves;
    }
}