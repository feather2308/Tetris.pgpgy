package Tetris;

public class El extends Piece {
	public El(TetrisData data) {
		super(data, 3, 4);
		c[0] = 0;		r[0] = 1;
		c[1] = -1;		r[1] = 1;
		c[2] = -1;		r[2] = 0;
		c[3] = 1;		r[3] = 1;
	}
}
