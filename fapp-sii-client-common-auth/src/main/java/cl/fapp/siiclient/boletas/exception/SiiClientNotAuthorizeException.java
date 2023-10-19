package cl.fapp.siiclient.boletas.exception;


public class SiiClientNotAuthorizeException extends RuntimeException {
    private static final long serialVersionUID = 8817992551929171347L;

	public SiiClientNotAuthorizeException(String msg) {
        super(msg);
    }
}
