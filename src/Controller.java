import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {

	public static void main(String[] args) {
		if(args.length != 0){
			try {
				InputStream inStream = new FileInputStream(args[0]);
				BufferedReader br = new BufferedReader(new InputStreamReader(inStream));
				String line;
				while((line = br.readLine()) != null){
					pieceOrder(line);
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			Scanner scan = new Scanner(System.in);
			String input = "";
			while(true){
				input = scan.nextLine();
				if(input.toLowerCase().trim() == "exit"){
					scan.close();
					System.exit(0);
				}
				pieceOrder(input);
			}
		}
	}
	
	public static void pieceOrder(String command){
		command = command.replaceAll(" ", "").toLowerCase();
		Pattern placePattern = Pattern.compile("[kqbnrp][ld][a-h][1-8]");
		Pattern singleMovePattern = Pattern.compile("[a-h][1-8][a-h][1-8]\\*?");
		Pattern doubleMovePattern = Pattern.compile("[a-h][1-8][a-h][1-8][a-h][1-8][a-h][1-8]");
		if(placePattern.matcher(command).matches()){
			System.out.println(convertPiecePlace(command));
		}else if(singleMovePattern.matcher(command).matches()){
			System.out.println(convertSingleMove(command));
		}else if(doubleMovePattern.matcher(command).matches()){
			System.out.println(convertDoubleMove(command));
		}else{
			System.out.println("Invalid input: " + command);
		}
	}
	
	public static String convertSingleMove(String command){
		String output = "";
		Pattern movePattern = Pattern.compile("([a-h])([1-8])([a-h])([1-8])(\\*?)");
		Matcher matcher = movePattern.matcher(command);
		//System.out.println(matcher.matches());
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
		return output;
	}
	
	public static String convertDoubleMove(String command){
		String output = "";
		Pattern doubleMove = Pattern.compile("([a-h][1-8][a-h][1-8])([a-h][1-8][a-h][1-8])");
		Matcher matcher = doubleMove.matcher(command);
		//System.out.println(matcher.matches());
		output = convertSingleMove(matcher.group(1)) + ", and " +
				convertSingleMove(matcher.group(2));
		return output;
	}
	
	public static String convertPiecePlace(String command){
		String output = "";
		Pattern placePattern = Pattern.compile("([kqbnrp])([ld])([a-h])([1-8])");
		Matcher matcher = placePattern.matcher(command);
		//System.out.println(matcher.matches());
		switch (matcher.group(2)) {
		case "l":
			output += "White ";
			break;
		case "d":
			output += "Black ";
			break;
		default:
			break;
		}
		switch (matcher.group(1)) {
		case "k":
			output += "King ";
			break;
		case "q":
			output += "Queen ";
			break;
		case "b":
			output += "Bishop ";
			break;
		case "n":
			output += "Knight ";
			break;
		case "r":
			output += "Rook ";
			break;
		case "p":
			output += "Pawn ";
			break;
		default:
			break;
		}
		output += "placed at " + matcher.group(3).toUpperCase()
				+ matcher.group(4);
		return output;
	}
	
}