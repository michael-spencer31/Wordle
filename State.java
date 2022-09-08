public enum State{
	GREEN(Ansi.GREEN),
	ORANGE(Ansi.ORANGE),
	GRAY(Ansi.GRAY);

	private final Ansi ansi;

	State(Ansi ansi){
		this.ansi = ansi;
	}
	public String getAnsiCode(){
		return ansi.toString();
	}
}
