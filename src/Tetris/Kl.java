package Tetris;

public class Kl extends Piece {
	public Kl(TetrisData data) {
		super(data, 6, 2);
        c[0] = 0;   r[0] = 1;
        c[1] = -1;   r[1] = 1;
        c[2] = 0;  r[2] = 0;
        c[3] = 1;   r[3] = 0;
	}
		 

}
