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
        else if (piece.getPieceType() == ChessPiece.PieceType.KNIGHT){
            return bishopMoves(board, myPosition);
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

        return bishopMoves(board, myPosition);

    }

    private Collection<ChessMove> bishopMoves(ChessBoard board, ChessPosition myPosition){
        //logic for bishop moves here
        Collection<ChessMove> moves = new ArrayList<>();
        //from the initial position, calculate the possible moves that keep the piece on the board, and do not hop over another piece
        int i = myPosition.getRow();
        int j = myPosition.getColumn();
        int itr = 0;

        for(itr = 0; i < 8; i++){
            if (i < 8 && i >=0){
                moves.add([i+itr][i+itr])
            }
        }
        //moves.add() when the move is possible based on logic
        return moves;
    }

}


