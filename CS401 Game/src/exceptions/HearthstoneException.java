package exceptions;

abstract public class HearthstoneException extends Exception { //Generic exception class. No Objects can be created.
	public HearthstoneException(){
		super();
	}
	public HearthstoneException(String s){
		super(s);
	}
}
