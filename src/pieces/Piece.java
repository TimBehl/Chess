package pieces;

import main.Location;

public abstract class Piece {
	private Location location;
	private boolean isWhite;
	
	public Piece(boolean isWhite){
		this.isWhite = isWhite;
	}
	
	public void placePiece(Location placeSpace){
		this.location = placeSpace;
	}
	
	public Location getLocation() {
		return location;
	}

	public boolean isItWhite(){
		return this.isWhite;
	}
	
	public abstract char getPieceVal();
	
	public abstract String getPieceName();
}