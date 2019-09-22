package board;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import chess.chess;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import pieces.Bishopaa;
import pieces.Bishopab;
import pieces.Bishopba;
import pieces.Bishopbb;
import pieces.Kinga;
import pieces.Kingb;
import pieces.Knightaa;
import pieces.Knightab;
import pieces.Knightba;
import pieces.Knightbb;
import pieces.Pawnaa;
import pieces.Pawnab;
import pieces.Pawnac;
import pieces.Pawnad;
import pieces.Pawnae;
import pieces.Pawnaf;
import pieces.Pawnag;
import pieces.Pawnah;
import pieces.Pawnba;
import pieces.Pawnbb;
import pieces.Pawnbc;
import pieces.Pawnbd;
import pieces.Pawnbe;
import pieces.Pawnbf;
import pieces.Pawnbg;
import pieces.Pawnbh;
import pieces.Piece;
import pieces.Queena;
import pieces.Queenb;
import pieces.Rookaa;
import pieces.Rookab;
import pieces.Rookba;
import pieces.Rookbb;

public class Square extends Group {
	public  static int i;
    public int n;
	public static final double SIZE = 100;//�����С
	private Rectangle bg;//����
	private Color originalColor;//��ɫ
	private Piece piece;//piece��
	
	
	public static Square active;//square��,����this,piece��active.piece������
	private static int turnCounter = 0;//������,��¼��ǰ�ǵڼ���
	int a = 1;
	public static ArrayList<Square> marked = new ArrayList<Square>();//square����
public 	Piece b = piece;
	
	public Square(Color c) {//���췽��������Ϊcolor
		originalColor = c;//����ɫ��ֵ����color
		bg = new Rectangle(SIZE, SIZE, c);//80*80�ķ��飬cΪ��ɫ
		this.getChildren().add(bg);//��Ӿ��Σ�

		this.setOnMouseClicked(event -> {//����¼�
		
			if (marked.contains(this)) {//�����ǰsquare��marked��
				System.out.println(marked.size());
			 Piece p = active.piece;//square active ���������Ϊp;
				System.out.println(p);//
				System.out.println(this.piece);
				b=p;
				@SuppressWarnings("unused")
				int row = row();
				@SuppressWarnings("unused")
				int col = col();
             
				System.out.println("��ǰ���������Ϊ��("+ (row+1)+"," +(col+1)+")");
              
				chess.note.appendText("  to��("+ (row+1)+"," +(col+1)+")");
				try {
					File file =new File("D:\\2.txt");
					Writer out =new FileWriter(file, true);//FileWriter(file);
				
					out.write("  to��("+ (row+1)+"," +(col+1)+")/");
					out.close();
				}
				catch(IOException ex){
					
				}
				
//				
//			if(p instanceof Pawnaa && this.row() ==0) {
//				this.getChildren().remove(this.getChildren().size() - 1);
//				
//				this.addPiece(new Queena(Color.WHITE));
//				
//			}

				if (this.piece instanceof Kinga) {//�����ǰ��square��kinga�Ļ�
					if (this.piece.getColor() == Color.WHITE ) {//�����ǰ���ӵ���ɫ�ǰ�ɫ
						chess.gameOver();//����gameover
						System.out.println("GAME OVER");
					}
					
					//return;
				}
				if (this.piece instanceof Kingb ) {{//�����ǰsquare�е�piece��kingb
					chess.win();//��ʾwin����
					System.out.println("Congratulations! You won in "+ Square.turnCounter + " turns!");
				}
				}
//
//				active.piece = null;//��active�����pieceΪnull
//				this.makeInactive();//
//				turnCounter++;//��������һ
				
				//stem.out.println("Turn #"+ turnCounter);
				if(active.piece instanceof Pawnaa && this.row() ==0) {
					chess.pawnUp();
					if(i == 1) {
					active.piece = null;//��active�����pieceΪnull
					
				//	this.getChildren().remove(this.getChildren().size() - 1);
					this.makeInactive();//
					
					
					turnCounter++;//��������һ
					
					//this.getChildren().remove(this.getChildren().size() - 1);
					
					this.addPiece(new Queena(Color.WHITE));}
					
				}
				else {
					active.piece = null;//��active�����pieceΪnull
				this.makeInactive();//
				turnCounter++;//��������һ
				
				this.addPiece(p);}
				
				
				
		//p.move();
				//return;
			}

			if (!hasPiece()) {
				return;
			}

			if (hasPiece()) {
				if (turnCounter % 2 == 0 && piece.getColor() == Color.BLACK) { // White
					return;
				}
				if (turnCounter % 2 == 1 && piece.getColor() == Color.WHITE) { // Black
					return;
				}
				makeActive();
				@SuppressWarnings("unused")
				int row = row();
				@SuppressWarnings("unused")
				int col = col();
//				if(this.piece instanceof Pawnaa&&row==0) {
//					this.getChildren().remove(this.getChildren().size() - 1);
//				
//					this.addPiece(new Queena(Color.WHITE));}    
//					
						
						
					
				
				
				
			//	System.out.println(b.getClass().getSimpleName().toUpperCase());
				System.out.println("��ǰ���ӵ�����Ϊ��"+ (row+1) +"��ǰ���ӵ�����Ϊ��"+ (col+1));
				
				if(this.piece instanceof Pawnaa) {
				chess.note.appendText(" Pawnaa from ("+ (row+1)+"," +(col+1)+")");
				//a=" Pawnaa from ("+ (row+1)+"," +(col+1)+")";
				try {
					File file =new File("D:\\2.txt");
					Writer out =new FileWriter(file, true);//FileWriter(file);
				
					out.write(" Pawnaa from ("+ (row+1)+"," +(col+1)+")");
					out.close();
				}
				catch(IOException ex){
					
				}
				    }
				
				if(this.piece instanceof Pawnab) {
					
					a=2;
					if(a == 2 && row==0 && col>=0 && col<=7) {
						this.addPiece(new Queena(Color.WHITE));
					}
					chess.note.appendText(" Pawnab from ("+ (row+1)+"," +(col+1)+")");
				
				
					try {
						File file =new File("D:\\2.txt");
						Writer out =new FileWriter(file, true);//FileWriter(file);
					
						out.write(" Pawnab from ("+ (row+1)+"," +(col+1)+")");
						out.close();
					}
					catch(IOException ex){
						
					}
					}
				
				if(this.piece instanceof Pawnac) {
					chess.note.appendText(" Pawnac from ("+ (row+1)+"," +(col+1)+")");
					//a =	" Pawnac from ("+ (row+1)+"," +(col+1)+")";
					
					try {
						File file =new File("D:\\2.txt");
						Writer out =new FileWriter(file, true);//FileWriter(file);
					
						out.write(" Pawnac from ("+ (row+1)+"," +(col+1)+")");
						out.close();
					}
					catch(IOException ex){
						
					}
					}
				
				if(this.piece instanceof Pawnad) {
					chess.note.appendText(" Pawnad from ("+ (row+1)+"," +(col+1)+")");
					//a =	" Pawnad from ("+ (row+1)+"," +(col+1)+")";
					try {
						File file =new File("D:\\2.txt");
						Writer out =new FileWriter(file, true);//FileWriter(file);
					
						out.write(" Pawnad from ("+ (row+1)+"," +(col+1)+")");
						out.close();
					}
					catch(IOException ex){
						
					}
					}
				
				if(this.piece instanceof Pawnae) {
					chess.note.appendText(" Pawnae from ("+ (row+1)+"," +(col+1)+")");
					//a =	" Pawnae from ("+ (row+1)+"," +(col+1)+")";
					try {
						File file =new File("D:\\2.txt");
						Writer out =new FileWriter(file, true);//FileWriter(file);
					
						out.write(" Pawnae from ("+ (row+1)+"," +(col+1)+")");
						out.close();
					}
					catch(IOException ex){
						
					}
					}
				
				if(this.piece instanceof Pawnaf) {
					chess.note.appendText(" Pawnaf from ("+ (row+1)+"," +(col+1)+")");
					//a =	" Pawnaf from ("+ (row+1)+"," +(col+1)+")";
					try {
						File file =new File("D:\\2.txt");
						Writer out =new FileWriter(file, true);//FileWriter(file);
					
						out.write(" Pawnaf from ("+ (row+1)+"," +(col+1)+")");
						out.close();
					}
					catch(IOException ex){
						
					}
					}
				
				if(this.piece instanceof Pawnag) {
					chess.note.appendText(" Pawnag from ("+ (row+1)+"," +(col+1)+")");
					//a =	" Pawnag from ("+ (row+1)+"," +(col+1)+")";
					try {
						File file =new File("D:\\2.txt");
						Writer out =new FileWriter(file, true);//FileWriter(file);
					
						out.write(" Pawnag from ("+ (row+1)+"," +(col+1)+")");
						out.close();
					}
					catch(IOException ex){
						
					}
					}
				
				if(this.piece instanceof Pawnah) {
					chess.note.appendText(" Pawnah from ("+ (row+1)+"," +(col+1)+")");
					//a =	" Pawnah from ("+ (row+1)+"," +(col+1)+")";
					try {
						File file =new File("D:\\2.txt");
						Writer out =new FileWriter(file, true);//FileWriter(file);
					
						out.write(" Pawnah from ("+ (row+1)+"," +(col+1)+")");
						out.close();
					}
					catch(IOException ex){
						
					}
					}
				
				if(this.piece instanceof Pawnba) {
					chess.note.appendText(" Pawnba from ("+ (row+1)+"," +(col+1)+")");
				//a=	" Pawnba from ("+ (row+1)+"," +(col+1)+")";
					try {
						File file =new File("D:\\2.txt");
						Writer out =new FileWriter(file, true);//FileWriter(file);
					
						out.write(" Pawnba from ("+ (row+1)+"," +(col+1)+")");
						out.close();
					}
					catch(IOException ex){
						
					}
					}
				
				if(this.piece instanceof Pawnbb) {
					chess.note.appendText(" Pawnbb from ("+ (row+1)+"," +(col+1)+")");
					//a=	" Pawnbb from ("+ (row+1)+"," +(col+1)+")";
					try {
						File file =new File("D:\\2.txt");
						Writer out =new FileWriter(file, true);//FileWriter(file);
					
						out.write(" Pawnbb from ("+ (row+1)+"," +(col+1)+")");
						out.close();
					}
					catch(IOException ex){
						
					}
					}
				
				if(this.piece instanceof Pawnbc) {
					chess.note.appendText(" Pawnbc from ("+ (row+1)+"," +(col+1)+")");
					//a=	" Pawnbc from ("+ (row+1)+"," +(col+1)+")";
					try {
						File file =new File("D:\\2.txt");
						Writer out =new FileWriter(file, true);//FileWriter(file);
					
						out.write(" Pawnbc from ("+ (row+1)+"," +(col+1)+")");
						out.close();
					}
					catch(IOException ex){
						
					}
					}
				    
				if(this.piece instanceof Pawnbd) {
					chess.note.appendText(" Pawnbd from ("+ (row+1)+"," +(col+1)+")");
					//a=	" Pawnbd from ("+ (row+1)+"," +(col+1)+")";
					try {
						File file =new File("D:\\2.txt");
						Writer out =new FileWriter(file, true);//FileWriter(file);
					
						out.write(" Pawnbd from ("+ (row+1)+"," +(col+1)+")");
						out.close();
					}
					catch(IOException ex){
						
					}
					}
				
				if(this.piece instanceof Pawnbe) {
					chess.note.appendText(" Pawnbe from ("+ (row+1)+"," +(col+1)+")");
					//a=	" Pawnbe from ("+ (row+1)+"," +(col+1)+")";
					try {
						File file =new File("D:\\2.txt");
						Writer out =new FileWriter(file, true);//FileWriter(file);
					
						out.write(" Pawnbe from ("+ (row+1)+"," +(col+1)+")");
						out.close();
					}
					catch(IOException ex){
						
					}
					}
				
				if(this.piece instanceof Pawnbf) {
					chess.note.appendText(" Pawnbf from ("+ (row+1)+"," +(col+1)+")");
					//a=	" Pawnbf from ("+ (row+1)+"," +(col+1)+")";
					try {
						File file =new File("D:\\2.txt");
						Writer out =new FileWriter(file, true);//FileWriter(file);
					
						out.write(" Pawnbf from ("+ (row+1)+"," +(col+1)+")");
						out.close();
					}
					catch(IOException ex){
						
					}
					}
				
				if(this.piece instanceof Pawnbg) {
					chess.note.appendText(" Pawnbg from ("+ (row+1)+"," +(col+1)+")");
					//a=	" Pawnbg from ("+ (row+1)+"," +(col+1)+")";
					try {
						File file =new File("D:\\2.txt");
						Writer out =new FileWriter(file, true);//FileWriter(file);
					
						out.write(" Pawnbg from ("+ (row+1)+"," +(col+1)+")");
						out.close();
					}
					catch(IOException ex){
						
					}
					}
				
				if(this.piece instanceof Pawnbh) {
					chess.note.appendText(" Pawnbh from ("+ (row+1)+"," +(col+1)+")");
					//a=	" Pawnbh from ("+ (row+1)+"," +(col+1)+")";
					try {
						File file =new File("D:\\2.txt");
						Writer out =new FileWriter(file, true);//FileWriter(file);
					
						out.write(" Pawnbh from ("+ (row+1)+"," +(col+1)+")");
						out.close();
					}
					catch(IOException ex){
						
					}
					}
				
				if(this.piece instanceof Bishopba) {
					chess.note.appendText(" Bishopba from ("+ (row+1)+"," +(col+1)+")");
					//a=	" Pawnbh from ("+ (row+1)+"," +(col+1)+")";
					try {
						File file =new File("D:\\2.txt");
						Writer out =new FileWriter(file, true);//FileWriter(file);
					
						out.write(" Bishopba from ("+ (row+1)+"," +(col+1)+")");
						out.close();
					}
					catch(IOException ex){
						
					}
					}
				
				if(this.piece instanceof Bishopbb) {
					chess.note.appendText(" Bishopbb from ("+ (row+1)+"," +(col+1)+")");
					//a=	" Pawnbh from ("+ (row+1)+"," +(col+1)+")";
					try {
						File file =new File("D:\\2.txt");
						Writer out =new FileWriter(file, true);//FileWriter(file);
					
						out.write(" Bishopbb from ("+ (row+1)+"," +(col+1)+")");
						out.close();
					}
					catch(IOException ex){
						
					}
					}
				
				if(this.piece instanceof Bishopaa) {
					chess.note.appendText(" Bishopaa from ("+ (row+1)+"," +(col+1)+")");
					//a=	" Pawnbh from ("+ (row+1)+"," +(col+1)+")";
					try {
						File file =new File("D:\\2.txt");
						Writer out =new FileWriter(file, true);//FileWriter(file);
					
						out.write(" Bishopaa from ("+ (row+1)+"," +(col+1)+")");
						out.close();
					}
					catch(IOException ex){
						
					}
					}
				
				if(this.piece instanceof Bishopab) {
					chess.note.appendText(" Bishopab from ("+ (row+1)+"," +(col+1)+")");
					//a=	" Pawnbh from ("+ (row+1)+"," +(col+1)+")";
					try {
						File file =new File("D:\\2.txt");
						Writer out =new FileWriter(file, true);//FileWriter(file);
					
						out.write(" Bishopab from ("+ (row+1)+"," +(col+1)+")");
						out.close();
					}
					catch(IOException ex){
						
					}
					}
				
				if(this.piece instanceof Kinga) {
					chess.note.appendText(" Kinga from ("+ (row+1)+"," +(col+1)+")");
					//a=	" Pawnbh from ("+ (row+1)+"," +(col+1)+")";
					try {
						File file =new File("D:\\2.txt");
						Writer out =new FileWriter(file, true);//FileWriter(file);
					
						out.write(" Kinga from ("+ (row+1)+"," +(col+1)+")");
						out.close();
					}
					catch(IOException ex){
						
					}
					}
				
				if(this.piece instanceof Kingb) {
					chess.note.appendText(" Kingb from ("+ (row+1)+"," +(col+1)+")");
					//a=	" Pawnbh from ("+ (row+1)+"," +(col+1)+")";
					try {
						File file =new File("D:\\2.txt");
						Writer out =new FileWriter(file, true);//FileWriter(file);
					
						out.write(" Kingb from ("+ (row+1)+"," +(col+1)+")");
						out.close();
					}
					catch(IOException ex){
						
					}
					}
				
				if(this.piece instanceof Knightaa) {
					chess.note.appendText(" Knightaa from ("+ (row+1)+"," +(col+1)+")");
					//a=	" Pawnbh from ("+ (row+1)+"," +(col+1)+")";
					try {
						File file =new File("D:\\2.txt");
						Writer out =new FileWriter(file, true);//FileWriter(file);
					
						out.write(" Knightaa from ("+ (row+1)+"," +(col+1)+")");
						out.close();
					}
					catch(IOException ex){
						
					}
					}
				
				if(this.piece instanceof Knightab) {
					chess.note.appendText(" Knightab from ("+ (row+1)+"," +(col+1)+")");
					//a=	" Pawnbh from ("+ (row+1)+"," +(col+1)+")";
					try {
						File file =new File("D:\\2.txt");
						Writer out =new FileWriter(file, true);//FileWriter(file);
					
						out.write(" Knightab from ("+ (row+1)+"," +(col+1)+")");
						out.close();
					}
					catch(IOException ex){
						
					}
					}
				
				if(this.piece instanceof Knightba) {
					chess.note.appendText(" Knightba from ("+ (row+1)+"," +(col+1)+")");
					//a=	" Pawnbh from ("+ (row+1)+"," +(col+1)+")";
					try {
						File file =new File("D:\\2.txt");
						Writer out =new FileWriter(file, true);//FileWriter(file);
					
						out.write(" Knightba from ("+ (row+1)+"," +(col+1)+")");
						out.close();
					}
					catch(IOException ex){
						
					}
					}
				
				if(this.piece instanceof Knightbb) {
					chess.note.appendText(" Knightbb from ("+ (row+1)+"," +(col+1)+")");
					//a=	" Pawnbh from ("+ (row+1)+"," +(col+1)+")";
					try {
						File file =new File("D:\\2.txt");
						Writer out =new FileWriter(file, true);//FileWriter(file);
					
						out.write(" Knightbb from ("+ (row+1)+"," +(col+1)+")");
						out.close();
					}
					catch(IOException ex){
						
					}
					}
				
				if(this.piece instanceof Queena) {
					chess.note.appendText(" Queena from ("+ (row+1)+"," +(col+1)+")");
					//a=	" Pawnbh from ("+ (row+1)+"," +(col+1)+")";
					try {
						File file =new File("D:\\2.txt");
						Writer out =new FileWriter(file, true);//FileWriter(file);
					
						out.write(" Queena from ("+ (row+1)+"," +(col+1)+")");
						out.close();
					}
					catch(IOException ex){
						
					}
					}
				
				if(this.piece instanceof Queenb) {
					chess.note.appendText(" Queenb from ("+ (row+1)+"," +(col+1)+")");
					//a=	" Pawnbh from ("+ (row+1)+"," +(col+1)+")";
					try {
						File file =new File("D:\\2.txt");
						Writer out =new FileWriter(file, true);//FileWriter(file);
					
						out.write(" Queenb from ("+ (row+1)+"," +(col+1)+")");
						out.close();
					}
					catch(IOException ex){
						
					}
					}
				
				if(this.piece instanceof Rookaa) {
					chess.note.appendText(" Rookaa from ("+ (row+1)+"," +(col+1)+")");
					//a=	" Pawnbh from ("+ (row+1)+"," +(col+1)+")";
					try {
						File file =new File("D:\\2.txt");
						Writer out =new FileWriter(file, true);//FileWriter(file);
					
						out.write(" Rookaa from ("+ (row+1)+"," +(col+1)+")");
						out.close();
					}
					catch(IOException ex){
						
					}
					}
				
				if(this.piece instanceof Rookab) {
					chess.note.appendText(" Rookab from ("+ (row+1)+"," +(col+1)+")");
					//a=	" Pawnbh from ("+ (row+1)+"," +(col+1)+")";
					try {
						File file =new File("D:\\2.txt");
						Writer out =new FileWriter(file, true);//FileWriter(file);
					
						out.write(" Rookab from ("+ (row+1)+"," +(col+1)+")");
						out.close();
					}
					catch(IOException ex){
						
					}
					}
				
				if(this.piece instanceof Rookba) {
					chess.note.appendText(" Rookba from ("+ (row+1)+"," +(col+1)+")");
					//a=	" Pawnbh from ("+ (row+1)+"," +(col+1)+")";
					try {
						File file =new File("D:\\2.txt");
						Writer out =new FileWriter(file, true);//FileWriter(file);
					
						out.write(" Rookba from ("+ (row+1)+"," +(col+1)+")");
						out.close();
					}
					catch(IOException ex){
						
					}
					}
				
				if(this.piece instanceof Rookbb) {
					chess.note.appendText(" Rookbb from ("+ (row+1)+"," +(col+1)+")");
					//a=	" Pawnbh from ("+ (row+1)+"," +(col+1)+")";
					try {
						File file =new File("D:\\2.txt");
						Writer out =new FileWriter(file, true);//FileWriter(file);
					
						out.write(" Rookbb from ("+ (row+1)+"," +(col+1)+")");
						out.close();
					}
					catch(IOException ex){
						
					}
					}
			} 

			 
//			else {
//				if (active != null) {
//					active.makeInactive();
//				}
//				mark(this.piece.getColor());
//			}
		});
	}

	private int col() {
		int y = row();
		for (int i = 0; i < 8; i++) {
			if (ChessBoard.all_squares.get(y).get(i) == this) {
				return i;
			}
		}
		return -1;
		
	}
	
	public int row() {
		for (int i = 0; i < 8; i++) {
			if (ChessBoard.all_squares.get(i).contains(this)) {
				return i;
			}
		}
		return -1;
	}

	public void moveMark() {
		Circle cir = new Circle(SIZE / 2, SIZE / 2, SIZE / 10, Color.YELLOW);
		this.getChildren().add(cir);
		marked.add(this);
	}

	public void mark(Color c) {
		if (!this.hasPiece()) {
			moveMark();
		} else {
			if (this.piece.getColor() != c) {
				attackMark();
			}
		}
	}

	public void attackMark() {
		Circle cir = new Circle(SIZE / 2, SIZE / 2, SIZE / 10, Color.RED);
		this.getChildren().add(cir);
		marked.add(this);
	}

	private void removeMoveMark() {
		for (Square square : marked) {
			square.getChildren().remove(square.getChildren().size() - 1);//
			//System.out.print(square.getChildren().size() - 1+"/n");
		}
		
		marked.clear();//��list��ɾ������Ԫ��
	}

	private void makeActive() {
		if (active != null) {
			active.makeInactive();
		}
		active = this;
		this.piece.showMove(col(), row());
		//this.getBackground().setFill(Color.GREEN);
	}

	private void makeInactive() {
		removeMoveMark();
		active = null;
		this.getBackground().setFill(originalColor);
	}

	public void addPiece(Piece p) {
		if (hasPiece()) {
			this.getChildren().remove(piece);//remove ���Դ�����
		}
		this.piece = p;
		this.getChildren().add(p);
	}

	
	public boolean hasPiece() {
		return this.piece != null;
	}

	public Rectangle getBackground() {
		return this.bg;
	}

	public Boolean turn(int i) {
		boolean whiteTurn =true;		
		if (i % 2 == 0) {
			return whiteTurn = false;
		} else {
			return whiteTurn;
		}		
	}	
}
