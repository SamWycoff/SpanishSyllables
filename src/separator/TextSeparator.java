package separator;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class TextSeparator {
	static char[] characters;
	
	public static String separate(String text) {
		if (text.length() > 1000) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("This text is over 1000 characters and, therefore, too long to separate.");
			alert.setContentText("The current provided text contains " + text.length() + " characters.");
			alert.show();
			return "";
		}
		else {
			return separateHelper(text);
		}
	}
	
	private static String separateHelper(String text) {
		characters = text.toCharArray();
		for (int i = characters.length - 1; i >= 0; i--) {
			addSlashes(i);
		}
		text = String.valueOf(characters);
		String[] tempWords = text.split(" ");
		String finalResult = "";
		for (int i = 0; i < tempWords.length; i++) {
			finalResult = resyllabification(finalResult, new Word(tempWords[i]).getSeparated());
		}
		return finalResult;
	}
	
	private static void addSlashes(int i) {
		if (!Letter.isLetter(characters[i]) && characters[i] != ' ') {
			characters[i] = '/';
			avoidTwoSlashes(i);
		}
	}
	
	private static void avoidTwoSlashes(int i) {
		if (i - 1 != 0 && !Letter.isLetter(characters[i - 1]) 
				&& characters[i - 1] != ' ' && !Letter.isLetter(characters[i])) {
			String tempString = String.valueOf(characters);
			tempString = tempString.substring(0, i) + tempString.substring(i + 1);
			characters = tempString.toCharArray();
		}
		if (i - 1 != 0 && i + 1 != characters.length && Letter.isLetter(characters[i - 1]) && Letter.isLetter(characters[i + 1])) {
			String tempString = String.valueOf(characters);
			tempString = tempString.substring(0, i) + " "+ tempString.substring(i);
			characters = tempString.toCharArray();
		}
	}
	
	protected static String resyllabification(String previous, String present) {
		if (previous.length() == 0) {
			return present;
		}
		else if (present.length() == 0) {
			return previous;
		}
		else if (previous.charAt(previous.length() - 1) == '.' && present.charAt(0) == '/') {
			return previous.substring(0, previous.length() - 1) + present;
		}
		else if (previous.charAt(previous.length() - 1) == '/' || Letter.accent(present.charAt(0)) 
				|| (!Letter.isLetter(present.charAt(0)) && Letter.accent(present.charAt(1)))) {
			return previous + present;
		}
		else if (Letter.consonant(previous.charAt(previous.length() - 2)) && (Letter.vowel(present.charAt(0)) 
				|| (!Letter.isLetter(present.charAt(0)) && Letter.vowel(present.charAt(1))))) {
			return resyllabificationHelper(previous, present);
		}
		else {
			return previous + present;
		}
	}
	
	private static String resyllabificationHelper(String previous, String present) {
		if (!Letter.isLetter(present.charAt(0))) {
			return previous.substring(0, previous.length() - 2) + ".'" 
			+ previous.substring(previous.length() - 2, previous.length() - 1) 
			+ present.substring(1);
		}
		else {
			return previous.substring(0, previous.length() - 2) + "." 
					+ previous.substring(previous.length() - 2, previous.length() - 1) 
					+ present;
		}
	}
}
