package pieces;

public class King extends Piece{

	public King(boolean isWhite) {
		super(isWhite);
	}

	@Override
	public char getPieceVal() {
		if(this.isItWhite()) return 'k';
		return 'K';
	}

	@Override
	public String getPieceName() {
		if(this.isItWhite()) return "White King";
		return "Black King";
	}

}
