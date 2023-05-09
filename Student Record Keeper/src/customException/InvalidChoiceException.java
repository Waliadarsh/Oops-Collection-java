package customException;

public class InvalidChoiceException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public InvalidChoiceException(String message){
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}

}
