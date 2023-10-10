package Tetris;

public class Er extends Piece {
	public Er(TetrisData data) {
		super(data, 4);
        c[0] = 0;   r[0] = 1;
        c[1] = -1;  r[1] = 1;
        c[2] = 1;   r[2] = 1;
        c[3] = 1;  	r[3] = 0;
	}
		 
	public int getType() {
		return 4;
	}
	public int roteType() {
		return 4;
	}
}
