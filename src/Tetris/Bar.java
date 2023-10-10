package Tetris;

public class Bar extends Piece {
	public Bar(TetrisData data) {
		  super(data, 1);
		  c[0] = 0;		 r[0] = 0;
		  c[1] = -1;	 r[1] = 0;
		  c[2] = 1;		 r[2] = 0;
		  c[3] = 2;		 r[3] = 0;
	}
	public int getType() { //블럭의 색깔
		return 1;
	}
	public int roteType() { //블럭의 회전방식
		return 2;
	}
}
