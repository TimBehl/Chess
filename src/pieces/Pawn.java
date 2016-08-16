package pieces;

public class Pawn extends Piece{

	public Pawn(boolean isWhite) {
		super(isWhite);
	}

	@Override
	public char getPieceVal() {
		if(this.isItWhite()) return 'p';
		return 'P';
	}

	@Override
	public String getPieceName() {
		if(this.isItWhite()) return "White Pawn";
		return "Black Pawn";
	}

}
