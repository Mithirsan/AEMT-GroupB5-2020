package be.helha.aemt.exception;

public class IDNotFoundException extends Exception{
	
	public IDNotFoundException() {
		// TODO Auto-generated constructor stub
		super("L'objet n'as pas �t� retrouver dans la db");
	}

}
