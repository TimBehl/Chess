package pieces;

public class Bishop extends Piece{

	public Bishop(boolean isWhite) {
		super(isWhite);
	}

	@Override
	public char getPieceVal() {
		if(this.isItWhite()) return 'b';
		return 'B';
	}

	@Override
	public String getPieceName() {
		if(this.isItWhite()) return "White Bishop";
		return "Black Bishop";
	}

}
