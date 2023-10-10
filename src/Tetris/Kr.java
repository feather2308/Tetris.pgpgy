package Tetris;

public class Kr extends Piece {
	public Kr(TetrisData data) {
		super(data, 7);
        c[0] = 0;   r[0] = 1;
        c[1] = 0;  r[1] = 0;
        c[2] = -1;  r[2] = 0;
        c[3] = 1;   r[3] = 1;
	}
		 
	public int getType() {
		return 7;
	}
	public int roteType() {
		return 2;
	}
}
