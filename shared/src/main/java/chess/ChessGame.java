package chess;

import java.util.Collection;
import java.util.Objects;
import java.util.ArrayList;

/**
 * For a class that can manage a chess game, making moves on a board
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessGame {
    private ChessGame.TeamColor turn;
    // create a new reset chess board
    private ChessBoard board = new ChessBoard();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessGame chessGame = (ChessGame) o;
        return turn == chessGame.turn && Objects.deepEquals(board, chessGame.board);
    }

    @Override
    public int hashCode() {
        return Objects.hash(turn, board);
    }

    @Override
    public String toString() {
        return "ChessGame{" +
                "turn=" + turn +
                ", board=" + board +
                '}';
    }

    public ChessGame() {
        turn = ChessGame.TeamColor.WHITE;
        board.resetBoard();
    }

    /**
     * @return Which team's turn it is
     */
    public TeamColor getTeamTurn() {
        return turn;
    }

    /**
     * Set's which teams turn it is
     *
     * @param team the team whose turn it is
     */
    public void setTeamTurn(TeamColor team) {
        turn = team;
    }

    /**
     * Enum identifying the 2 possible teams in a chess game
     */
    public enum TeamColor {
        WHITE,
        BLACK
    }

    /**
     * Gets a valid moves for a piece at the given location
     *
     * @param startPosition the piece to get valid moves for
     * @return Set of valid moves for requested piece, or null if no piece at
     * startPosition
     */
    public Collection<ChessMove> validMoves(ChessPosition startPosition) {
        Collection<ChessMove> allMoves = new ArrayList<>();
        ChessPiece piece = board.getPiece(startPosition);
        Collection<ChessMove> pieceMoves = (Collection<ChessMove>) piece.pieceMoves(board, startPosition);

        for (ChessMove move : pieceMoves) {
            ChessGame newBoard = new ChessGame();
            newBoard.copyBoard(board);
            newBoard.board.addPiece(move.getEndPosition(), piece);
            newBoard.board.addPiece(move.getStartPosition(), null);
            if (!newBoard.isInCheck(piece.getTeamColor())) {
                allMoves.add(move);
            }
        }
        System.out.println("Piece: " + piece);
        System.out.println("Valid moves: " + allMoves);

        return allMoves;
    }

    /**
     * Makes a move in a chess game
     *
     * @param move chess move to preform
     * @throws InvalidMoveException if move is invalid
     */
    public void makeMove(ChessMove move) throws InvalidMoveException {
        ChessPiece movingPiece = board.getPiece(move.getStartPosition());
        boolean isValid = false;
        if (movingPiece != null){
            if (movingPiece.getTeamColor() != turn) {
                throw new InvalidMoveException();
            }

            Collection<ChessMove> validMoves = (Collection<ChessMove>) validMoves(move.getStartPosition());
            for (ChessMove validMove : validMoves) {
                if (move.equals(validMove)) {
                    isValid = true;
                    // if it is a pawn and moved to the end, promote
                    if (move.getPromotionPiece() != null){
                        ChessPiece newPiece = new ChessPiece(turn, move.getPromotionPiece());
                        board.addPiece(move.getEndPosition(), newPiece);
                    }
                    else {
                        board.addPiece(move.getEndPosition(), movingPiece);
                    }
                    // delete the piece from the old position

                    board.addPiece(move.getStartPosition(), null);

                    // change the turn
                    if (turn == TeamColor.WHITE) {
                        turn = TeamColor.BLACK;
                    }
                    else {
                        turn = TeamColor.WHITE;
                    }
                    // exit for loop
                    break;
                }
            }
        }
        if (!isValid) {
            throw new InvalidMoveException();
        }
    }

    /**
     * Determines if the given team is in check
     *
     * @param teamColor which team to check for check
     * @return True if the specified team is in check
     */
    public boolean isInCheck(TeamColor teamColor) {
        // for each tile on the board, if the tile has a piece of the opposite team, check if the piece can move to the king
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                ChessPosition position = new ChessPosition(i, j);
                ChessPiece piece = board.getPiece(position);
                if (piece != null && piece.getTeamColor() != teamColor) {
                    Collection<ChessMove> pieceMoves = piece.pieceMoves(board, position);
                    for (ChessMove move : pieceMoves) {
                        ChessPiece targetPiece = board.getPiece(move.getEndPosition());
                        if (targetPiece != null && targetPiece.getTeamColor() == teamColor && targetPiece.getPieceType() == ChessPiece.PieceType.KING) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * Determines if the given team is in checkmate
     *
     * @param teamColor which team to check for checkmate
     * @return True if the specified team is in checkmate
     */
    public boolean isInCheckmate(TeamColor teamColor) {
        return isInCheck(teamColor) && noMoves(teamColor);
    }

    /**
     * Determines if the given team is in stalemate, which here is defined as having
     * no valid moves
     *
     * @param teamColor which team to check for stalemate
     * @return True if the specified team is in stalemate, otherwise false
     */
    public boolean isInStalemate(TeamColor teamColor) {

        return !isInCheck(teamColor) && noMoves(teamColor);
    }

    /**
     * Sets this game's chessboard with a given board
     *
     * @param board the new board to use
     */
    public void setBoard(ChessBoard board) {
        this.board = board;
    }

    /**
     * Gets the current chessboard
     *
     * @return the chessboard
     */
    public ChessBoard getBoard() {
        return board;
    }
    public void copyBoard(ChessBoard currentBoard) {
        // completely copy the board. This is to check moves without placing them on the real board
        for (int row = 1; row < 9; row++) {
            for (int col = 1; col < 9; col++) {
                ChessPosition currentPosition = new ChessPosition(row, col);
                if (currentBoard.getPiece(currentPosition) != null) {
                    this.board.addPiece(currentPosition, currentBoard.getPiece(currentPosition));
                }
                else {
                    this.board.addPiece(currentPosition, null);
                }
            }
        }
    }

    public boolean noMoves(TeamColor teamColor){
        for (int i = 1; i < 9; i++) {
            // Loop through each column (1 to 8)
            for (int j = 1; j < 9; j++) {
                // Create a ChessPosition object for the current position
                ChessPosition position = new ChessPosition(i, j);
                // Get the piece at the current position
                ChessPiece piece = board.getPiece(position);
                // Check if there is a piece and if it belongs to the specified team
                if (piece != null && piece.getTeamColor() == teamColor) {
                    // Get all valid moves for the piece at the current position
                    Collection<ChessMove> pieceMoves = (Collection<ChessMove>) validMoves(position);
                    // If the piece has no valid moves, return true indicating stalemate
                    if (!pieceMoves.isEmpty()) {
                        return false;
                    }
                }
            }
        }
        // If no pieces of the specified team are in stalemate, return false
        return true;
    }
}


