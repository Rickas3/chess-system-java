package Chess;

import Boardgame.BoardExcepition;

public class ChessException extends BoardExcepition {
    private  static final long seriaLVersionUID = 1L;

    public ChessException(String msg){
        super(msg);
    }
}
