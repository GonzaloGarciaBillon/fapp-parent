/**
 * ExceptionException.java
 *
 * <p>This file was auto-generated from WSDL by the Apache Axis2 version: 1.8.1 Built on : Jun 07,
 * 2022 (03:46:59 EDT)
 */
package cl.fapp.siiclient.axis.registroreclamodte;

public class ExceptionException extends java.lang.Exception {

  private static final long serialVersionUID = 1661531253090L;

  private cl.fapp.siiclient.axis.registroreclamodte.RegistroReclamoDteServiceEndpointServiceStub
          .ExceptionE
      faultMessage;

  public ExceptionException() {
    super("ExceptionException");
  }

  public ExceptionException(java.lang.String s) {
    super(s);
  }

  public ExceptionException(java.lang.String s, java.lang.Throwable ex) {
    super(s, ex);
  }

  public ExceptionException(java.lang.Throwable cause) {
    super(cause);
  }

  public void setFaultMessage(
      cl.fapp.siiclient.axis.registroreclamodte.RegistroReclamoDteServiceEndpointServiceStub
              .ExceptionE
          msg) {
    faultMessage = msg;
  }

  public cl.fapp.siiclient.axis.registroreclamodte.RegistroReclamoDteServiceEndpointServiceStub
          .ExceptionE
      getFaultMessage() {
    return faultMessage;
  }
}
