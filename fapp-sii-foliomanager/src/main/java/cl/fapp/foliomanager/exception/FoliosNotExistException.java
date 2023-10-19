package cl.fapp.foliomanager.exception;


public class FoliosNotExistException extends RuntimeException {
    private static final long serialVersionUID = 5029727154494910643L;

	public FoliosNotExistException(String msg) {
        super(msg);
    }
}