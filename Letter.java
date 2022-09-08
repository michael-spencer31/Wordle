public class Letter{

	private final char value;
	private State state;

	public Letter(char value){
		this.value = value;
		this.state = null;
	}
	public char getValue(){
		return value;
	}
	public void setState(State state){
		this.state = state;
	}
	public State getState(){
		return state;
	}
}
