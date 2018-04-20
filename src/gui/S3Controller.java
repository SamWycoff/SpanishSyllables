package gui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import separator.*;

public class S3Controller {
	@FXML
	TextArea original;
	
	@FXML
	TextArea result;
	
	@FXML
	TextField fileName;
	
	@FXML
	public void initialize() {
		original.setEditable(true);
		original.setWrapText(true);
		result.setEditable(true);
		result.setWrapText(true);
		fileName.setEditable(true);
		fileName.setText(".txt");
	}
	
	@FXML
	public void separate() {
		String text = original.getText();
		ArrayList<Word> originalWords = new ArrayList<Word>();
		String finalResult = "";
		if (text.length() > 500) {
			result.setText("This text is too long to separate.");
		}
		else {
			separateHelper(text, originalWords, finalResult);
		}
	}
	
	//Copied from example during Wednesday's lecture
	@FXML
	public void save() {
		try {
			File copy = new File(fileName.getText());
			Scanner fileIn = new Scanner(result.getText());
			PrintStream fileOut = new PrintStream(copy);

			while (fileIn.hasNextLine()) {
				fileOut.print(fileIn.nextLine());
			}

			fileIn.close();
			fileOut.close();
		}
		catch (FileNotFoundException e) {
			e.getMessage();
		}
	}
	
	public void separateHelper(String text, ArrayList<Word> originalWords, String finalResult) {
		char[] characters = text.toCharArray();
		for (int i = 0; i < characters.length; i++) {
			addSlashes(characters, i);
		}
		text = String.valueOf(characters);
		String[] tempWords = text.split(" ");
		for (int i = 0; i < tempWords.length; i++) {
			originalWords.add(new Word(tempWords[i]));
		}
		for (int i = 0; i < originalWords.size(); i++) {
			finalResult = resyllabification(finalResult, originalWords.get(i).getSeparated());
		}
		result.setText(String.format(finalResult));
	}
	
	public void addSlashes(char[] characters, int i) {
		if (!Letter.isLetter(characters[i]) && characters[i] != ' ') {
			characters[i] = '/';
			if (i + 1 != characters.length && !Letter.isLetter(characters[i + 1]) 
					&& characters[i + 1] != ' ') {
				characters[i] = Character.MIN_VALUE;
			}
		}
	}
	
	public String resyllabification(String previous, String present) {
		if (previous.length() == 0) {
			return present;
		}
		else if (present.length() == 0) {
			return previous;
		}
		else if (previous.charAt(previous.length() - 1) == '/' || Letter.accent(present.charAt(0)) 
				|| (!Letter.isLetter(present.charAt(0)) && Letter.accent(present.charAt(1)))) {
			return previous + present;
		}
		else if (Letter.consonant(previous.charAt(previous.length() - 2)) && (Letter.vowel(present.charAt(0)) 
				|| (!Letter.isLetter(present.charAt(0)) && Letter.vowel(present.charAt(1))))) {
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
		else {
			return previous + present;
		}
	}
}
