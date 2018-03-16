package diff;

public class SingleCharDiff {
	
	char value;
	char behaviour;
	
	public SingleCharDiff(char value) {
		this.value = value;
	}
	public void setBehaviour(char behaviour) {
		this.behaviour = behaviour;
	}
	
	public char getValue() {
		return value;
	}
	public char getBehaviour() {
		return behaviour;
	}
}
