package Tetris;

public class Square extends Piece {
	public Square(TetrisData data) {
		  super(data, 5, 0);
		  c[0] = 0;		 r[0] = 1;
		  c[1] = 0;	 	r[1] = 0;
		  c[2] = -1;		 r[2] = 1;
		  c[3] = -1;		 r[3] = 0;
	}


}
