package pieces;

public class Knight extends Piece{

	public Knight(boolean isWhite) {
		super(isWhite);
	}

	@Override
	public char getPieceVal() {
		if(this.isItWhite()) return 'n';
		return 'N';
	}

	@Override
	public String getPieceName() {
		if(this.isItWhite()) return "White Knight";
		return "Black Knight";
	}

}
