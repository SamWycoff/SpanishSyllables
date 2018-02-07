package separator;

public class Syllable {
	private String syllable;
	private boolean stressed;
	
	public Syllable (String syllable) {
		this.syllable = syllable;
		this.stressed = false;
	}
	
	public String getSyllable() {
		return syllable;
	}
	
	public boolean isStressed() {
		return stressed;
	}
	
	public void setStressed() {
		stressed = true;
	}
}
