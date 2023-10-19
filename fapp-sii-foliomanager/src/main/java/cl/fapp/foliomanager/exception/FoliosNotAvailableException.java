package cl.fapp.foliomanager.exception;


public class FoliosNotAvailableException extends RuntimeException {
    private static final long serialVersionUID = -5217124615222194657L;

	public FoliosNotAvailableException(String msg) {
        super(msg);
    }
}