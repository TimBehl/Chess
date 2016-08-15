
public class Piece {
	private PieceType type;
	private char column;
	private int row;
	private boolean isWhite;
	
	public Piece(PieceType type, boolean isWhite){
		this.type = type;
		this.isWhite = isWhite;
	}
	
	public void placePiece(char column, int row){
		this.column = column;
		this.row = row;
	}
	
	public PieceType getType() {
		return type;
	}

	public void setType(PieceType type) {
		this.type = type;
	}

	public boolean isWhite() {
		return isWhite;
	}

	public void setWhite(boolean isWhite) {
		this.isWhite = isWhite;
	}
	
	public char getPieceVal(){
		char returnVal = '0';
		switch (this.type) {
		case KING:
			returnVal = 'K';
			break;
		case QUEEN:
			returnVal = 'Q';
			break;
		case BISHOP:
			returnVal = 'B';
			break;
		case KNIGHT:
			returnVal = 'N';
			break;
		case ROOK:
			returnVal = 'R';
			break;
		case PAWN:
			returnVal = 'P';
			break;
		default:
			break;
		}
		if(this.isWhite){
			String parsingString = "" + returnVal;
			returnVal = parsingString.toLowerCase().charAt(0);
		}
		return returnVal;
	}

	public String getPieceName(){
		if(this.isWhite){
			return "White " + this.type.toString().toLowerCase();
		}else{
			return "Black " + this.type.toString().toLowerCase();
		}
	}
}