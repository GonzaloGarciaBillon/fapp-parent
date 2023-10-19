/**
 * WsDTECorreoServiceCallbackHandler.java
 *
 * <p>This file was auto-generated from WSDL by the Apache Axis2 version: 1.8.1 Built on : Jun 07,
 * 2022 (03:46:59 EDT)
 */
package cl.fapp.siiclient.axis.wsdtecorreo;

/**
 * WsDTECorreoServiceCallbackHandler Callback class, Users can extend this class and implement their
 * own receiveResult and receiveError methods.
 */
public abstract class WsDTECorreoServiceCallbackHandler {

  protected Object clientData;

  /**
   * User can pass in any object that needs to be accessed once the NonBlocking Web service call is
   * finished and appropriate method of this CallBack is called.
   *
   * @param clientData Object mechanism by which the user can pass in user data that will be
   *     avilable at the time this callback is called.
   */
  public WsDTECorreoServiceCallbackHandler(Object clientData) {
    this.clientData = clientData;
  }

  /** Please use this constructor if you don't want to set any clientData */
  public WsDTECorreoServiceCallbackHandler() {
    this.clientData = null;
  }

  /** Get the client data */
  public Object getClientData() {
    return clientData;
  }

  /**
   * auto generated Axis2 call back method for getVersionMayor method override this method for
   * handling normal response from getVersionMayor operation
   */
  public void receiveResultgetVersionMayor(
      cl.fapp.siiclient.axis.wsdtecorreo.WsDTECorreoServiceStub.GetVersionMayorResponse result) {}

  /**
   * auto generated Axis2 Error handler override this method for handling error response from
   * getVersionMayor operation
   */
  public void receiveErrorgetVersionMayor(java.lang.Exception e) {}

  /**
   * auto generated Axis2 call back method for getVersionMenor method override this method for
   * handling normal response from getVersionMenor operation
   */
  public void receiveResultgetVersionMenor(
      cl.fapp.siiclient.axis.wsdtecorreo.WsDTECorreoServiceStub.GetVersionMenorResponse result) {}

  /**
   * auto generated Axis2 Error handler override this method for handling error response from
   * getVersionMenor operation
   */
  public void receiveErrorgetVersionMenor(java.lang.Exception e) {}

  /**
   * auto generated Axis2 call back method for getState method override this method for handling
   * normal response from getState operation
   */
  public void receiveResultgetState(
      cl.fapp.siiclient.axis.wsdtecorreo.WsDTECorreoServiceStub.GetStateResponse result) {}

  /**
   * auto generated Axis2 Error handler override this method for handling error response from
   * getState operation
   */
  public void receiveErrorgetState(java.lang.Exception e) {}

  /**
   * auto generated Axis2 call back method for getVersion method override this method for handling
   * normal response from getVersion operation
   */
  public void receiveResultgetVersion(
      cl.fapp.siiclient.axis.wsdtecorreo.WsDTECorreoServiceStub.GetVersionResponse result) {}

  /**
   * auto generated Axis2 Error handler override this method for handling error response from
   * getVersion operation
   */
  public void receiveErrorgetVersion(java.lang.Exception e) {}

  /**
   * auto generated Axis2 call back method for reenvioCorreo method override this method for
   * handling normal response from reenvioCorreo operation
   */
  public void receiveResultreenvioCorreo(
      cl.fapp.siiclient.axis.wsdtecorreo.WsDTECorreoServiceStub.ReenvioCorreoResponse result) {}

  /**
   * auto generated Axis2 Error handler override this method for handling error response from
   * reenvioCorreo operation
   */
  public void receiveErrorreenvioCorreo(java.lang.Exception e) {}

  /**
   * auto generated Axis2 call back method for getEnv method override this method for handling
   * normal response from getEnv operation
   */
  public void receiveResultgetEnv(
      cl.fapp.siiclient.axis.wsdtecorreo.WsDTECorreoServiceStub.GetEnvResponse result) {}

  /**
   * auto generated Axis2 Error handler override this method for handling error response from getEnv
   * operation
   */
  public void receiveErrorgetEnv(java.lang.Exception e) {}

  /**
   * auto generated Axis2 call back method for getVersionPatch method override this method for
   * handling normal response from getVersionPatch operation
   */
  public void receiveResultgetVersionPatch(
      cl.fapp.siiclient.axis.wsdtecorreo.WsDTECorreoServiceStub.GetVersionPatchResponse result) {}

  /**
   * auto generated Axis2 Error handler override this method for handling error response from
   * getVersionPatch operation
   */
  public void receiveErrorgetVersionPatch(java.lang.Exception e) {}
}
