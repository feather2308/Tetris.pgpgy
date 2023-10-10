package Tetris;

public class Square extends Piece {
	public Square(TetrisData data) {
		  super(data, 5);
		  c[0] = 0;		 r[0] = 1;
		  c[1] = 0;	 	r[1] = 0;
		  c[2] = -1;		 r[2] = 1;
		  c[3] = -1;		 r[3] = 0;
	}
	public int getType() { //블럭의 색깔
		return 5;
	}
	public int roteType() { //블럭의 회전방식
		return 0;
	}
}
