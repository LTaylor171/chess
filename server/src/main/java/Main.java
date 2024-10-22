import chess.*;
import server.Server;

public class Main {
    public static void main(String[] args) {
        // create a server object
        try {
            var port = 8080;
            if (args.length > 0) {
                port = Integer.parseInt(args[0]);
            }
            var server = new Server();
            server.run(port);
            System.out.println("Server started on port " + port);
        } catch  (Throwable e) {
            System.out.println("Unable to start server: " + e.getMessage());
        }

        var piece = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.PAWN);
        System.out.println("♕ 240 Chess Server: " + piece);
    }
}