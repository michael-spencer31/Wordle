public enum Ansi{

	GREEN ("\033[38;5;15;48;5;22m"),
    YELLOW ("\u001B[33m"),
    GRAY ("\033[37;48;5;234m"),
    RED ("\033[38;5;15;48;5;88m"),
    ORANGE("\033[38;5;15;48;5;88m"),
    RESET ("\033[0m");

    private final String esc;

    Ansi(String esc){
    	this.esc = esc;
    }
    public String toString(){
    	return esc;
    }
}
