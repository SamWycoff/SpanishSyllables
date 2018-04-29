package gui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
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
		String separated = TextSeparator.separate(original.getText());
		result.setText(separated);
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
}
