package main;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Controller {
	
	private static List<Piece> pieces = new ArrayList<Piece>();
	private static Board board = new Board();

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
				System.out.println(board.printBoard());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			Scanner scan = new Scanner(System.in);
			String input = "";
			while(true){
				input = scan.nextLine();
				if(input.toLowerCase().trim().equalsIgnoreCase("exit")){
					scan.close();
					System.exit(0);
				}
				pieceOrder(input);
				System.out.println(board.printBoard());
			}
		}
	}
	
	public static void pieceOrder(String command){
		command = command.replaceAll(" ", "").toLowerCase();
		Pattern placePattern = Pattern.compile("[kqbnrp][ld][a-h][1-8]");
		Pattern singleMovePattern = Pattern.compile("[a-h][1-8][a-h][1-8]\\*?");
		Pattern doubleMovePattern = Pattern.compile("[a-h][1-8][a-h][1-8][a-h][1-8][a-h][1-8]");
		if(placePattern.matcher(command).matches()){
			System.out.println(board.convertPiecePlace(command));
		}else if(singleMovePattern.matcher(command).matches()){
			System.out.println(board.convertSingleMove(command));
		}else if(doubleMovePattern.matcher(command).matches()){
			System.out.println(board.convertDoubleMove(command));
		}else{
			System.out.println("Invalid input: " + command);
		}
	}
}