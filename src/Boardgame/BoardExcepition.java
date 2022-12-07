package Boardgame;

public class BoardExcepition extends RuntimeException{
    private  static final long seriaLVersionUID = 1L;

    public BoardExcepition(String msg){
        super(msg);
    }

}
