
public class Piece {
	private PieceType type;
	
	private boolean isWhite;
	
	public Piece(PieceType type, boolean isWhite){
		this.type = type;
		this.isWhite = isWhite;
	}
	
	public String getPieceName(){
		if(this.isWhite){
			return "White " + this.type.toString().toLowerCase();
		}else{
			return "Black " + this.type.toString().toLowerCase();
		}
	}
}