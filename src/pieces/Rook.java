package pieces;

public class Rook extends Piece{

	public Rook(boolean isWhite) {
		super(isWhite);
	}

	@Override
	public char getPieceVal() {
		if(this.isItWhite()) return 'r';
		return 'R';
	}

	@Override
	public String getPieceName() {
		if(this.isItWhite()) return "White Rook";
		return "Black Rook";
	}

}
