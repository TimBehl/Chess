package main;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Board {
	private final int SPACES_NUMBER = 8;
	private char[][] boardSpaces = new char[8][8];
	
	public String printBoard(){
		String returnVal = "  | A | B | C | D | E | F | G | H |  \n";
		for(int i = 0; i < SPACES_NUMBER; i++){
			returnVal += "  ---------------------------------  \n" + (i+1) + " ";
			for(int j = 0; j < boardSpaces[i].length; j++){
				returnVal += "| " + boardSpaces[i][j] + " ";
			}
			returnVal += "| " + (i+1) + "\n";
		}
		returnVal += "  ---------------------------------  \n  | A | B | C | D | E | F | G | H |  \n";
		return returnVal;
	}
	
	public int changeCharToNum(String input){
		int returnVal = -1;
		switch (input) {
		case "a":
			returnVal = 0;
			break;
		case "b":
			returnVal = 1;
			break;
		case "c":
			returnVal = 2;
			break;
		case "d":
			returnVal = 3;
			break;
		case "e":
			returnVal = 4;
			break;
		case "f":
			returnVal = 5;
			break;
		case "g":
			returnVal = 6;
			break;
		case "h":
			returnVal = 7;
			break;
		default:
			break;
		}
		return returnVal;
	}
	
	public String convertSingleMove(String command){
		String output = "";
		Pattern movePattern = Pattern.compile("([a-h])([1-8])([a-h])([1-8])(\\*?)");
		Matcher matcher = movePattern.matcher(command);
		//System.out.println(matcher.matches());
		if(matcher.matches()){
			if(matcher.group(5).equals("*")){
				output = "Piece at " + matcher.group(1).toUpperCase()
						+ matcher.group(2) + " moves to " + 
						matcher.group(3).toUpperCase() + 
						matcher.group(4) + ", and captures the piece there.";
			}else{
				output = "Piece at " + matcher.group(1).toUpperCase()
						+ matcher.group(2) + " moves to " + 
						matcher.group(3).toUpperCase() + 
						matcher.group(4);
			}
		}
		return output;
	}
	
	public String convertDoubleMove(String command){
		String output = "";
		Pattern doubleMove = Pattern.compile("([a-h][1-8][a-h][1-8])([a-h][1-8][a-h][1-8])");
		Matcher matcher = doubleMove.matcher(command);
		//System.out.println(matcher.matches());
		if(matcher.matches()){
			output = convertSingleMove(matcher.group(1)) + ", and " +
					convertSingleMove(matcher.group(2));
		}
		return output;
	}
	
	public String convertPiecePlace(String command){
		Piece newPiece = new Piece(null, false);
		String output = "";
		Pattern placePattern = Pattern.compile("([kqbnrp])([ld])([a-h])([1-8])");
		Matcher matcher = placePattern.matcher(command);
		//System.out.println(matcher.matches());
		if(matcher.matches()){
			switch (matcher.group(2)) {
			case "l":
				output += "White ";
				newPiece.setWhite(true);
				break;
			case "d":
				output += "Black ";
				newPiece.setWhite(false);
				break;
			default:
				break;
			}
			switch (matcher.group(1)) {
			case "k":
				output += "King ";
				newPiece.setType(PieceType.KING);
				break;
			case "q":
				output += "Queen ";
				newPiece.setType(PieceType.QUEEN);
				break;
			case "b":
				output += "Bishop ";
				newPiece.setType(PieceType.BISHOP);
				break;
			case "n":
				output += "Knight ";
				newPiece.setType(PieceType.KNIGHT);
				break;
			case "r":
				output += "Rook ";
				newPiece.setType(PieceType.ROOK);
				break;
			case "p":
				output += "Pawn ";
				newPiece.setType(PieceType.PAWN);
				break;
			default:
				break;
			}
			output += "placed at " + matcher.group(3).toUpperCase()
					+ matcher.group(4);
			this.boardSpaces[Integer.parseInt(matcher.group(4))-1][changeCharToNum(matcher.group(3))]
					= newPiece.getPieceVal();
		}
		return output;
	}
}
