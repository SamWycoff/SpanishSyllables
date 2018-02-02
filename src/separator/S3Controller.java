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
		result.setEditable(false);
	}
	
	@FXML
	public void separate() {
		String text = original.getText();
		if (text.length() > 500) {
			result.setText("This text is too long to separate.");
		}
		else {
			text = text.replace(".", "");
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
}
