/**
 * RegistroReclamoDteServiceEndpointServiceCallbackHandler.java
 *
 * <p>This file was auto-generated from WSDL by the Apache Axis2 version: 1.8.1 Built on : Jun 07,
 * 2022 (03:46:59 EDT)
 */
package cl.fapp.siiclient.axis.registroreclamodte;

/**
 * RegistroReclamoDteServiceEndpointServiceCallbackHandler Callback class, Users can extend this
 * class and implement their own receiveResult and receiveError methods.
 */
public abstract class RegistroReclamoDteServiceEndpointServiceCallbackHandler {

  protected Object clientData;

  /**
   * User can pass in any object that needs to be accessed once the NonBlocking Web service call is
   * finished and appropriate method of this CallBack is called.
   *
   * @param clientData Object mechanism by which the user can pass in user data that will be
   *     avilable at the time this callback is called.
   */
  public RegistroReclamoDteServiceEndpointServiceCallbackHandler(Object clientData) {
    this.clientData = clientData;
  }

  /** Please use this constructor if you don't want to set any clientData */
  public RegistroReclamoDteServiceEndpointServiceCallbackHandler() {
    this.clientData = null;
  }

  /** Get the client data */
  public Object getClientData() {
    return clientData;
  }

  /**
   * auto generated Axis2 call back method for ingresarAceptacionReclamoDoc method override this
   * method for handling normal response from ingresarAceptacionReclamoDoc operation
   */
  public void receiveResultingresarAceptacionReclamoDoc(
      cl.fapp.siiclient.axis.registroreclamodte.RegistroReclamoDteServiceEndpointServiceStub
              .IngresarAceptacionReclamoDocResponse
          result) {}

  /**
   * auto generated Axis2 Error handler override this method for handling error response from
   * ingresarAceptacionReclamoDoc operation
   */
  public void receiveErroringresarAceptacionReclamoDoc(java.lang.Exception e) {}

  /**
   * auto generated Axis2 call back method for getVersion method override this method for handling
   * normal response from getVersion operation
   */
  public void receiveResultgetVersion(
      cl.fapp.siiclient.axis.registroreclamodte.RegistroReclamoDteServiceEndpointServiceStub
              .GetVersionResponse
          result) {}

  /**
   * auto generated Axis2 Error handler override this method for handling error response from
   * getVersion operation
   */
  public void receiveErrorgetVersion(java.lang.Exception e) {}

  /**
   * auto generated Axis2 call back method for consultarFechaRecepcionSii method override this
   * method for handling normal response from consultarFechaRecepcionSii operation
   */
  public void receiveResultconsultarFechaRecepcionSii(
      cl.fapp.siiclient.axis.registroreclamodte.RegistroReclamoDteServiceEndpointServiceStub
              .ConsultarFechaRecepcionSiiResponse
          result) {}

  /**
   * auto generated Axis2 Error handler override this method for handling error response from
   * consultarFechaRecepcionSii operation
   */
  public void receiveErrorconsultarFechaRecepcionSii(java.lang.Exception e) {}

  /**
   * auto generated Axis2 call back method for consultarDocDteCedible method override this method
   * for handling normal response from consultarDocDteCedible operation
   */
  public void receiveResultconsultarDocDteCedible(
      cl.fapp.siiclient.axis.registroreclamodte.RegistroReclamoDteServiceEndpointServiceStub
              .ConsultarDocDteCedibleResponse
          result) {}

  /**
   * auto generated Axis2 Error handler override this method for handling error response from
   * consultarDocDteCedible operation
   */
  public void receiveErrorconsultarDocDteCedible(java.lang.Exception e) {}

  /**
   * auto generated Axis2 call back method for listarEventosHistDoc method override this method for
   * handling normal response from listarEventosHistDoc operation
   */
  public void receiveResultlistarEventosHistDoc(
      cl.fapp.siiclient.axis.registroreclamodte.RegistroReclamoDteServiceEndpointServiceStub
              .ListarEventosHistDocResponse
          result) {}

  /**
   * auto generated Axis2 Error handler override this method for handling error response from
   * listarEventosHistDoc operation
   */
  public void receiveErrorlistarEventosHistDoc(java.lang.Exception e) {}
}
