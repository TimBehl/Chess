package pieces;

public class Queen extends Piece{

	public Queen(boolean isWhite) {
		super(isWhite);
	}

	@Override
	public char getPieceVal() {
		if(this.isItWhite()) return 'q';
		return 'Q';
	}

	@Override
	public String getPieceName() {
		if(this.isItWhite()) return "White Queen";
		return "Black Queen";
	}

}
