package separator;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class S3Controller {
	@FXML
	TextArea original;
	
	@FXML
	TextArea result;
	
	private ArrayList<Word> originalWords = new ArrayList<Word>();
	private String finalResult = "";
	
	@FXML
	public void initialize() {
		original.setEditable(true);
		original.setWrapText(true);
		result.setEditable(false);
		result.setWrapText(true);
	}
	
	@FXML
	public void separate() {
		String text = original.getText();
		if (text.length() > 500) {
			result.setText("This text is too long to separate.");
		}
		else {
			char[] characters = text.toCharArray();
			for (int i = 0; i < characters.length; i++) {
				if (!isLetter(characters[i]) && characters[i] != ' ') {
					characters[i] = '/';
					if (i + 1 != characters.length && !isLetter(characters[i + 1]) 
							&& characters[i + 1] != ' ') {
						characters[i] = Character.MIN_VALUE;
					}
				}
			}
			text = String.valueOf(characters);
			String[] tempWords = text.split(" ");
			for (int i = 0; i < tempWords.length; i++) {
				originalWords.add(new Word(tempWords[i]));
			}
			for (int i = 0; i < originalWords.size(); i++) {
				finalResult = finalResult + originalWords.get(i).stressedSyllable();
			}
			result.setText(String.format(finalResult));
		}
	}
	
	public boolean isLetter(char c) {
		String letters = "�����AEIOU�����aeiouBCDFGHJKLMN�PQRSTVWXYZbcdfghjklmn�pqrstvwxyz0123456789";
		return letters.contains(Character.toString(c));
	}
}
