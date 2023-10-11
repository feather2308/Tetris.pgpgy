package Tetris;
import java.awt.Graphics;

import javax.swing.JPanel;

public class TetrisPreview extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TetrisData data;
	private Piece newBlock = null, save = null;
	
	public TetrisPreview(TetrisData data) {
		this.data = data;
		repaint();
	}
	
	public void setCurrentBlock(Piece current) {
		this.newBlock = current;
		//System.out.println(current);
		repaint();
	}
	
	public void setSaveBlock(Piece save) {
		this.save = save;
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		//블럭 틀 그리기
		for(int i = 0; i < 4; i++) {
			for(int k = 0; k < 4; k++) {
				if(data.getAt(i, k) == 0) {
					g.setColor(Constant.getColor(0));
					g.draw3DRect(Constant.margin/2 + Constant.w * k,
							Constant.margin/2 + Constant.w * i, 
							Constant.w, Constant.w, true);
				}
			}
		}
		//세이브 블럭 틀 그리기
		for(int i = 0; i < 4; i++) {
			for(int k = 0; k < 4; k++) {
				if(data.getAt(i, k) == 0) {
					g.setColor(Constant.getColor(0));
					g.draw3DRect(Constant.margin/2 + Constant.w * k,
							Constant.margin/2 + Constant.w * i + 200, 
							Constant.w, Constant.w, true);
				}
			}
		}
		
		//System.out.println(current);
		// 현재 내려오고 있는 테트리스 조각 그리
		if(newBlock != null){
			for(int i = 0; i < 4; i++) {
				g.setColor(Constant.getColor(newBlock.getType()));
				g.fill3DRect(Constant.margin/2 + Constant.w * (1+newBlock.c[i]), 
						Constant.margin/2 + Constant.w * (0+newBlock.r[i]), 
						Constant.w, Constant.w, true);
			}
		}
		if(save != null){
			for(int i = 0; i < 4; i++) {
				g.setColor(Constant.getColor(save.getType()));
				g.fill3DRect(Constant.margin/2 + Constant.w * (1+save.c[i]), 
						Constant.margin/2 + Constant.w * (0+save.r[i]) + 200, 
						Constant.w, Constant.w, true);
			}
		}
	}
}
