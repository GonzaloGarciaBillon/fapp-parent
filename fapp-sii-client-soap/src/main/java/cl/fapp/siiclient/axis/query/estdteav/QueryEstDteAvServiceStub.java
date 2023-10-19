/**
 * QueryEstDteAvServiceStub.java
 *
 * <p>This file was auto-generated from WSDL by the Apache Axis2 version: 1.8.1 Built on : Jun 07,
 * 2022 (03:46:59 EDT)
 */
package cl.fapp.siiclient.axis.query.estdteav;

/*
 *  QueryEstDteAvServiceStub java implementation
 */

public class QueryEstDteAvServiceStub extends org.apache.axis2.client.Stub {
  protected org.apache.axis2.description.AxisOperation[] _operations;

  // hashmaps to keep the fault mapping
  private java.util.Map<org.apache.axis2.client.FaultMapKey, java.lang.String>
      faultExceptionNameMap =
          new java.util.HashMap<org.apache.axis2.client.FaultMapKey, java.lang.String>();
  private java.util.Map<org.apache.axis2.client.FaultMapKey, java.lang.String>
      faultExceptionClassNameMap =
          new java.util.HashMap<org.apache.axis2.client.FaultMapKey, java.lang.String>();
  private java.util.Map<org.apache.axis2.client.FaultMapKey, java.lang.String> faultMessageMap =
      new java.util.HashMap<org.apache.axis2.client.FaultMapKey, java.lang.String>();

  private static int counter = 0;

  private static synchronized java.lang.String getUniqueSuffix() {
    // reset the counter if it is greater than 99999
    if (counter > 99999) {
      counter = 0;
    }
    counter = counter + 1;
    return java.lang.Long.toString(java.lang.System.currentTimeMillis()) + "_" + counter;
  }

  private void populateAxisService() throws org.apache.axis2.AxisFault {

    // creating the Service with a unique name
    _service =
        new org.apache.axis2.description.AxisService("QueryEstDteAvService" + getUniqueSuffix());
    addAnonymousOperations();

    // creating the operations
    org.apache.axis2.description.AxisOperation __operation;

    _operations = new org.apache.axis2.description.AxisOperation[6];

    __operation = new org.apache.axis2.description.OutInAxisOperation();

    __operation.setName(
        new javax.xml.namespace.QName("http://DefaultNamespace", "getVersionMayor"));
    _service.addOperation(__operation);

    _operations[0] = __operation;

    __operation = new org.apache.axis2.description.OutInAxisOperation();

    __operation.setName(
        new javax.xml.namespace.QName("http://DefaultNamespace", "getVersionMenor"));
    _service.addOperation(__operation);

    _operations[1] = __operation;

    __operation = new org.apache.axis2.description.OutInAxisOperation();

    __operation.setName(new javax.xml.namespace.QName("http://DefaultNamespace", "getState"));
    _service.addOperation(__operation);

    _operations[2] = __operation;

    __operation = new org.apache.axis2.description.OutInAxisOperation();

    __operation.setName(new javax.xml.namespace.QName("http://DefaultNamespace", "getVersion"));
    _service.addOperation(__operation);

    _operations[3] = __operation;

    __operation = new org.apache.axis2.description.OutInAxisOperation();

    __operation.setName(new javax.xml.namespace.QName("http://DefaultNamespace", "getEstDteAv"));
    _service.addOperation(__operation);

    _operations[4] = __operation;

    __operation = new org.apache.axis2.description.OutInAxisOperation();

    __operation.setName(
        new javax.xml.namespace.QName("http://DefaultNamespace", "getVersionPatch"));
    _service.addOperation(__operation);

    _operations[5] = __operation;
  }

  // populates the faults
  private void populateFaults() {}

  /** Constructor that takes in a configContext */
  public QueryEstDteAvServiceStub(
      org.apache.axis2.context.ConfigurationContext configurationContext,
      java.lang.String targetEndpoint)
      throws org.apache.axis2.AxisFault {
    this(configurationContext, targetEndpoint, false);
  }

  /** Constructor that takes in a configContext and useseperate listner */
  public QueryEstDteAvServiceStub(
      org.apache.axis2.context.ConfigurationContext configurationContext,
      java.lang.String targetEndpoint,
      boolean useSeparateListener)
      throws org.apache.axis2.AxisFault {
    // To populate AxisService
    populateAxisService();
    populateFaults();

    _serviceClient = new org.apache.axis2.client.ServiceClient(configurationContext, _service);

    _serviceClient
        .getOptions()
        .setTo(new org.apache.axis2.addressing.EndpointReference(targetEndpoint));
    _serviceClient.getOptions().setUseSeparateListener(useSeparateListener);
  }

  /** Default Constructor */
  public QueryEstDteAvServiceStub(
      org.apache.axis2.context.ConfigurationContext configurationContext)
      throws org.apache.axis2.AxisFault {

    this(configurationContext, "https://maullin.sii.cl/DTEWS/services/QueryEstDteAv");
  }

  /** Default Constructor */
  public QueryEstDteAvServiceStub() throws org.apache.axis2.AxisFault {

    this("https://maullin.sii.cl/DTEWS/services/QueryEstDteAv");
  }

  /** Constructor taking the target endpoint */
  public QueryEstDteAvServiceStub(java.lang.String targetEndpoint)
      throws org.apache.axis2.AxisFault {
    this(null, targetEndpoint);
  }

  /**
   * Auto generated method signature
   *
   * @see cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvService#getVersionMayor
   * @param getVersionMayor0
   */
  public cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersionMayorResponse
      getVersionMayor(
          cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersionMayor
              getVersionMayor0)
          throws java.rmi.RemoteException {

    org.apache.axis2.context.MessageContext _messageContext =
        new org.apache.axis2.context.MessageContext();
    try {
      org.apache.axis2.client.OperationClient _operationClient =
          _serviceClient.createClient(_operations[0].getName());
      _operationClient
          .getOptions()
          .setAction("http://DefaultNamespace/QueryEstDteAv/getVersionMayorRequest");
      _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

      addPropertyToOperationClient(
          _operationClient,
          org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
          "&");

      // create SOAP envelope with that payload
      org.apache.axiom.soap.SOAPEnvelope env = null;

      env =
          toEnvelope(
              getFactory(_operationClient.getOptions().getSoapVersionURI()),
              getVersionMayor0,
              optimizeContent(
                  new javax.xml.namespace.QName("http://DefaultNamespace", "getVersionMayor")),
              new javax.xml.namespace.QName("http://DefaultNamespace", "getVersionMayor"));

      // adding SOAP soap_headers
      _serviceClient.addHeadersToEnvelope(env);
      // set the message context with that soap envelope
      _messageContext.setEnvelope(env);

      // add the message contxt to the operation client
      _operationClient.addMessageContext(_messageContext);

      // execute the operation client
      _operationClient.execute(true);

      org.apache.axis2.context.MessageContext _returnMessageContext =
          _operationClient.getMessageContext(
              org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
      org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
      _returnEnv.buildWithAttachments();

      java.lang.Object object =
          fromOM(
              _returnEnv.getBody().getFirstElement(),
              cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersionMayorResponse
                  .class);
      org.apache.axis2.kernel.TransportUtils.detachInputStream(_returnMessageContext);

      return (cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub
              .GetVersionMayorResponse)
          object;

    } catch (org.apache.axis2.AxisFault f) {

      org.apache.axiom.om.OMElement faultElt = f.getDetail();
      if (faultElt != null) {
        if (faultExceptionNameMap.containsKey(
            new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "getVersionMayor"))) {
          // make the fault by reflection
          try {
            java.lang.String exceptionClassName =
                faultExceptionClassNameMap.get(
                    new org.apache.axis2.client.FaultMapKey(
                        faultElt.getQName(), "getVersionMayor"));
            java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
            java.lang.reflect.Constructor constructor =
                exceptionClass.getConstructor(java.lang.String.class);
            java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
            // message class
            java.lang.String messageClassName =
                faultMessageMap.get(
                    new org.apache.axis2.client.FaultMapKey(
                        faultElt.getQName(), "getVersionMayor"));
            java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
            java.lang.Object messageObject = fromOM(faultElt, messageClass);
            java.lang.reflect.Method m =
                exceptionClass.getMethod("setFaultMessage", new java.lang.Class[] {messageClass});
            m.invoke(ex, new java.lang.Object[] {messageObject});

            throw new java.rmi.RemoteException(ex.getMessage(), ex);
          } catch (java.lang.ClassCastException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (java.lang.ClassNotFoundException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (java.lang.NoSuchMethodException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (java.lang.reflect.InvocationTargetException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (java.lang.IllegalAccessException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (java.lang.InstantiationException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          }
        } else {
          throw f;
        }
      } else {
        throw f;
      }
    } finally {
      if (_messageContext.getTransportOut() != null) {
        _messageContext.getTransportOut().getSender().cleanup(_messageContext);
      }
    }
  }

  /**
   * Auto generated method signature for Asynchronous Invocations
   *
   * @see cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvService#startgetVersionMayor
   * @param getVersionMayor0
   */
  public void startgetVersionMayor(
      cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersionMayor
          getVersionMayor0,
      final cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceCallbackHandler callback)
      throws java.rmi.RemoteException {

    org.apache.axis2.client.OperationClient _operationClient =
        _serviceClient.createClient(_operations[0].getName());
    _operationClient
        .getOptions()
        .setAction("http://DefaultNamespace/QueryEstDteAv/getVersionMayorRequest");
    _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

    addPropertyToOperationClient(
        _operationClient,
        org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
        "&");

    // create SOAP envelope with that payload
    org.apache.axiom.soap.SOAPEnvelope env = null;
    final org.apache.axis2.context.MessageContext _messageContext =
        new org.apache.axis2.context.MessageContext();

    // Style is Doc.

    env =
        toEnvelope(
            getFactory(_operationClient.getOptions().getSoapVersionURI()),
            getVersionMayor0,
            optimizeContent(
                new javax.xml.namespace.QName("http://DefaultNamespace", "getVersionMayor")),
            new javax.xml.namespace.QName("http://DefaultNamespace", "getVersionMayor"));

    // adding SOAP soap_headers
    _serviceClient.addHeadersToEnvelope(env);
    // create message context with that soap envelope
    _messageContext.setEnvelope(env);

    // add the message context to the operation client
    _operationClient.addMessageContext(_messageContext);

    _operationClient.setCallback(
        new org.apache.axis2.client.async.AxisCallback() {
          public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
            try {
              org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

              java.lang.Object object =
                  fromOM(
                      resultEnv.getBody().getFirstElement(),
                      cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub
                          .GetVersionMayorResponse.class);
              callback.receiveResultgetVersionMayor(
                  (cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub
                          .GetVersionMayorResponse)
                      object);

            } catch (org.apache.axis2.AxisFault e) {
              callback.receiveErrorgetVersionMayor(e);
            }
          }

          public void onError(java.lang.Exception error) {
            if (error instanceof org.apache.axis2.AxisFault) {
              org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
              org.apache.axiom.om.OMElement faultElt = f.getDetail();
              if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                    new org.apache.axis2.client.FaultMapKey(
                        faultElt.getQName(), "getVersionMayor"))) {
                  // make the fault by reflection
                  try {
                    java.lang.String exceptionClassName =
                        faultExceptionClassNameMap.get(
                            new org.apache.axis2.client.FaultMapKey(
                                faultElt.getQName(), "getVersionMayor"));
                    java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                    java.lang.reflect.Constructor constructor =
                        exceptionClass.getConstructor(java.lang.String.class);
                    java.lang.Exception ex =
                        (java.lang.Exception) constructor.newInstance(f.getMessage());
                    // message class
                    java.lang.String messageClassName =
                        faultMessageMap.get(
                            new org.apache.axis2.client.FaultMapKey(
                                faultElt.getQName(), "getVersionMayor"));
                    java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                    java.lang.Object messageObject = fromOM(faultElt, messageClass);
                    java.lang.reflect.Method m =
                        exceptionClass.getMethod(
                            "setFaultMessage", new java.lang.Class[] {messageClass});
                    m.invoke(ex, new java.lang.Object[] {messageObject});

                    callback.receiveErrorgetVersionMayor(
                        new java.rmi.RemoteException(ex.getMessage(), ex));
                  } catch (java.lang.ClassCastException e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorgetVersionMayor(f);
                  } catch (java.lang.ClassNotFoundException e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorgetVersionMayor(f);
                  } catch (java.lang.NoSuchMethodException e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorgetVersionMayor(f);
                  } catch (java.lang.reflect.InvocationTargetException e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorgetVersionMayor(f);
                  } catch (java.lang.IllegalAccessException e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorgetVersionMayor(f);
                  } catch (java.lang.InstantiationException e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorgetVersionMayor(f);
                  } catch (org.apache.axis2.AxisFault e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorgetVersionMayor(f);
                  }
                } else {
                  callback.receiveErrorgetVersionMayor(f);
                }
              } else {
                callback.receiveErrorgetVersionMayor(f);
              }
            } else {
              callback.receiveErrorgetVersionMayor(error);
            }
          }

          public void onFault(org.apache.axis2.context.MessageContext faultContext) {
            org.apache.axis2.AxisFault fault =
                org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
            onError(fault);
          }

          public void onComplete() {
            try {
              _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            } catch (org.apache.axis2.AxisFault axisFault) {
              callback.receiveErrorgetVersionMayor(axisFault);
            }
          }
        });

    org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
    if (_operations[0].getMessageReceiver() == null
        && _operationClient.getOptions().isUseSeparateListener()) {
      _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
      _operations[0].setMessageReceiver(_callbackReceiver);
    }

    // execute the operation client
    _operationClient.execute(false);
  }

  /**
   * Auto generated method signature
   *
   * @see cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvService#getVersionMenor
   * @param getVersionMenor2
   */
  public cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersionMenorResponse
      getVersionMenor(
          cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersionMenor
              getVersionMenor2)
          throws java.rmi.RemoteException {

    org.apache.axis2.context.MessageContext _messageContext =
        new org.apache.axis2.context.MessageContext();
    try {
      org.apache.axis2.client.OperationClient _operationClient =
          _serviceClient.createClient(_operations[1].getName());
      _operationClient
          .getOptions()
          .setAction("http://DefaultNamespace/QueryEstDteAv/getVersionMenorRequest");
      _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

      addPropertyToOperationClient(
          _operationClient,
          org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
          "&");

      // create SOAP envelope with that payload
      org.apache.axiom.soap.SOAPEnvelope env = null;

      env =
          toEnvelope(
              getFactory(_operationClient.getOptions().getSoapVersionURI()),
              getVersionMenor2,
              optimizeContent(
                  new javax.xml.namespace.QName("http://DefaultNamespace", "getVersionMenor")),
              new javax.xml.namespace.QName("http://DefaultNamespace", "getVersionMenor"));

      // adding SOAP soap_headers
      _serviceClient.addHeadersToEnvelope(env);
      // set the message context with that soap envelope
      _messageContext.setEnvelope(env);

      // add the message contxt to the operation client
      _operationClient.addMessageContext(_messageContext);

      // execute the operation client
      _operationClient.execute(true);

      org.apache.axis2.context.MessageContext _returnMessageContext =
          _operationClient.getMessageContext(
              org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
      org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
      _returnEnv.buildWithAttachments();

      java.lang.Object object =
          fromOM(
              _returnEnv.getBody().getFirstElement(),
              cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersionMenorResponse
                  .class);
      org.apache.axis2.kernel.TransportUtils.detachInputStream(_returnMessageContext);

      return (cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub
              .GetVersionMenorResponse)
          object;

    } catch (org.apache.axis2.AxisFault f) {

      org.apache.axiom.om.OMElement faultElt = f.getDetail();
      if (faultElt != null) {
        if (faultExceptionNameMap.containsKey(
            new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "getVersionMenor"))) {
          // make the fault by reflection
          try {
            java.lang.String exceptionClassName =
                faultExceptionClassNameMap.get(
                    new org.apache.axis2.client.FaultMapKey(
                        faultElt.getQName(), "getVersionMenor"));
            java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
            java.lang.reflect.Constructor constructor =
                exceptionClass.getConstructor(java.lang.String.class);
            java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
            // message class
            java.lang.String messageClassName =
                faultMessageMap.get(
                    new org.apache.axis2.client.FaultMapKey(
                        faultElt.getQName(), "getVersionMenor"));
            java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
            java.lang.Object messageObject = fromOM(faultElt, messageClass);
            java.lang.reflect.Method m =
                exceptionClass.getMethod("setFaultMessage", new java.lang.Class[] {messageClass});
            m.invoke(ex, new java.lang.Object[] {messageObject});

            throw new java.rmi.RemoteException(ex.getMessage(), ex);
          } catch (java.lang.ClassCastException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (java.lang.ClassNotFoundException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (java.lang.NoSuchMethodException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (java.lang.reflect.InvocationTargetException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (java.lang.IllegalAccessException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (java.lang.InstantiationException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          }
        } else {
          throw f;
        }
      } else {
        throw f;
      }
    } finally {
      if (_messageContext.getTransportOut() != null) {
        _messageContext.getTransportOut().getSender().cleanup(_messageContext);
      }
    }
  }

  /**
   * Auto generated method signature for Asynchronous Invocations
   *
   * @see cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvService#startgetVersionMenor
   * @param getVersionMenor2
   */
  public void startgetVersionMenor(
      cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersionMenor
          getVersionMenor2,
      final cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceCallbackHandler callback)
      throws java.rmi.RemoteException {

    org.apache.axis2.client.OperationClient _operationClient =
        _serviceClient.createClient(_operations[1].getName());
    _operationClient
        .getOptions()
        .setAction("http://DefaultNamespace/QueryEstDteAv/getVersionMenorRequest");
    _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

    addPropertyToOperationClient(
        _operationClient,
        org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
        "&");

    // create SOAP envelope with that payload
    org.apache.axiom.soap.SOAPEnvelope env = null;
    final org.apache.axis2.context.MessageContext _messageContext =
        new org.apache.axis2.context.MessageContext();

    // Style is Doc.

    env =
        toEnvelope(
            getFactory(_operationClient.getOptions().getSoapVersionURI()),
            getVersionMenor2,
            optimizeContent(
                new javax.xml.namespace.QName("http://DefaultNamespace", "getVersionMenor")),
            new javax.xml.namespace.QName("http://DefaultNamespace", "getVersionMenor"));

    // adding SOAP soap_headers
    _serviceClient.addHeadersToEnvelope(env);
    // create message context with that soap envelope
    _messageContext.setEnvelope(env);

    // add the message context to the operation client
    _operationClient.addMessageContext(_messageContext);

    _operationClient.setCallback(
        new org.apache.axis2.client.async.AxisCallback() {
          public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
            try {
              org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

              java.lang.Object object =
                  fromOM(
                      resultEnv.getBody().getFirstElement(),
                      cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub
                          .GetVersionMenorResponse.class);
              callback.receiveResultgetVersionMenor(
                  (cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub
                          .GetVersionMenorResponse)
                      object);

            } catch (org.apache.axis2.AxisFault e) {
              callback.receiveErrorgetVersionMenor(e);
            }
          }

          public void onError(java.lang.Exception error) {
            if (error instanceof org.apache.axis2.AxisFault) {
              org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
              org.apache.axiom.om.OMElement faultElt = f.getDetail();
              if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                    new org.apache.axis2.client.FaultMapKey(
                        faultElt.getQName(), "getVersionMenor"))) {
                  // make the fault by reflection
                  try {
                    java.lang.String exceptionClassName =
                        faultExceptionClassNameMap.get(
                            new org.apache.axis2.client.FaultMapKey(
                                faultElt.getQName(), "getVersionMenor"));
                    java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                    java.lang.reflect.Constructor constructor =
                        exceptionClass.getConstructor(java.lang.String.class);
                    java.lang.Exception ex =
                        (java.lang.Exception) constructor.newInstance(f.getMessage());
                    // message class
                    java.lang.String messageClassName =
                        faultMessageMap.get(
                            new org.apache.axis2.client.FaultMapKey(
                                faultElt.getQName(), "getVersionMenor"));
                    java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                    java.lang.Object messageObject = fromOM(faultElt, messageClass);
                    java.lang.reflect.Method m =
                        exceptionClass.getMethod(
                            "setFaultMessage", new java.lang.Class[] {messageClass});
                    m.invoke(ex, new java.lang.Object[] {messageObject});

                    callback.receiveErrorgetVersionMenor(
                        new java.rmi.RemoteException(ex.getMessage(), ex));
                  } catch (java.lang.ClassCastException e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorgetVersionMenor(f);
                  } catch (java.lang.ClassNotFoundException e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorgetVersionMenor(f);
                  } catch (java.lang.NoSuchMethodException e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorgetVersionMenor(f);
                  } catch (java.lang.reflect.InvocationTargetException e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorgetVersionMenor(f);
                  } catch (java.lang.IllegalAccessException e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorgetVersionMenor(f);
                  } catch (java.lang.InstantiationException e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorgetVersionMenor(f);
                  } catch (org.apache.axis2.AxisFault e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorgetVersionMenor(f);
                  }
                } else {
                  callback.receiveErrorgetVersionMenor(f);
                }
              } else {
                callback.receiveErrorgetVersionMenor(f);
              }
            } else {
              callback.receiveErrorgetVersionMenor(error);
            }
          }

          public void onFault(org.apache.axis2.context.MessageContext faultContext) {
            org.apache.axis2.AxisFault fault =
                org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
            onError(fault);
          }

          public void onComplete() {
            try {
              _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            } catch (org.apache.axis2.AxisFault axisFault) {
              callback.receiveErrorgetVersionMenor(axisFault);
            }
          }
        });

    org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
    if (_operations[1].getMessageReceiver() == null
        && _operationClient.getOptions().isUseSeparateListener()) {
      _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
      _operations[1].setMessageReceiver(_callbackReceiver);
    }

    // execute the operation client
    _operationClient.execute(false);
  }

  /**
   * Auto generated method signature
   *
   * @see cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvService#getState
   * @param getState4
   */
  public cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetStateResponse getState(
      cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetState getState4)
      throws java.rmi.RemoteException {

    org.apache.axis2.context.MessageContext _messageContext =
        new org.apache.axis2.context.MessageContext();
    try {
      org.apache.axis2.client.OperationClient _operationClient =
          _serviceClient.createClient(_operations[2].getName());
      _operationClient
          .getOptions()
          .setAction("http://DefaultNamespace/QueryEstDteAv/getStateRequest");
      _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

      addPropertyToOperationClient(
          _operationClient,
          org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
          "&");

      // create SOAP envelope with that payload
      org.apache.axiom.soap.SOAPEnvelope env = null;

      env =
          toEnvelope(
              getFactory(_operationClient.getOptions().getSoapVersionURI()),
              getState4,
              optimizeContent(new javax.xml.namespace.QName("http://DefaultNamespace", "getState")),
              new javax.xml.namespace.QName("http://DefaultNamespace", "getState"));

      // adding SOAP soap_headers
      _serviceClient.addHeadersToEnvelope(env);
      // set the message context with that soap envelope
      _messageContext.setEnvelope(env);

      // add the message contxt to the operation client
      _operationClient.addMessageContext(_messageContext);

      // execute the operation client
      _operationClient.execute(true);

      org.apache.axis2.context.MessageContext _returnMessageContext =
          _operationClient.getMessageContext(
              org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
      org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
      _returnEnv.buildWithAttachments();

      java.lang.Object object =
          fromOM(
              _returnEnv.getBody().getFirstElement(),
              cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetStateResponse
                  .class);
      org.apache.axis2.kernel.TransportUtils.detachInputStream(_returnMessageContext);

      return (cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetStateResponse)
          object;

    } catch (org.apache.axis2.AxisFault f) {

      org.apache.axiom.om.OMElement faultElt = f.getDetail();
      if (faultElt != null) {
        if (faultExceptionNameMap.containsKey(
            new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "getState"))) {
          // make the fault by reflection
          try {
            java.lang.String exceptionClassName =
                faultExceptionClassNameMap.get(
                    new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "getState"));
            java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
            java.lang.reflect.Constructor constructor =
                exceptionClass.getConstructor(java.lang.String.class);
            java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
            // message class
            java.lang.String messageClassName =
                faultMessageMap.get(
                    new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "getState"));
            java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
            java.lang.Object messageObject = fromOM(faultElt, messageClass);
            java.lang.reflect.Method m =
                exceptionClass.getMethod("setFaultMessage", new java.lang.Class[] {messageClass});
            m.invoke(ex, new java.lang.Object[] {messageObject});

            throw new java.rmi.RemoteException(ex.getMessage(), ex);
          } catch (java.lang.ClassCastException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (java.lang.ClassNotFoundException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (java.lang.NoSuchMethodException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (java.lang.reflect.InvocationTargetException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (java.lang.IllegalAccessException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (java.lang.InstantiationException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          }
        } else {
          throw f;
        }
      } else {
        throw f;
      }
    } finally {
      if (_messageContext.getTransportOut() != null) {
        _messageContext.getTransportOut().getSender().cleanup(_messageContext);
      }
    }
  }

  /**
   * Auto generated method signature for Asynchronous Invocations
   *
   * @see cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvService#startgetState
   * @param getState4
   */
  public void startgetState(
      cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetState getState4,
      final cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceCallbackHandler callback)
      throws java.rmi.RemoteException {

    org.apache.axis2.client.OperationClient _operationClient =
        _serviceClient.createClient(_operations[2].getName());
    _operationClient
        .getOptions()
        .setAction("http://DefaultNamespace/QueryEstDteAv/getStateRequest");
    _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

    addPropertyToOperationClient(
        _operationClient,
        org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
        "&");

    // create SOAP envelope with that payload
    org.apache.axiom.soap.SOAPEnvelope env = null;
    final org.apache.axis2.context.MessageContext _messageContext =
        new org.apache.axis2.context.MessageContext();

    // Style is Doc.

    env =
        toEnvelope(
            getFactory(_operationClient.getOptions().getSoapVersionURI()),
            getState4,
            optimizeContent(new javax.xml.namespace.QName("http://DefaultNamespace", "getState")),
            new javax.xml.namespace.QName("http://DefaultNamespace", "getState"));

    // adding SOAP soap_headers
    _serviceClient.addHeadersToEnvelope(env);
    // create message context with that soap envelope
    _messageContext.setEnvelope(env);

    // add the message context to the operation client
    _operationClient.addMessageContext(_messageContext);

    _operationClient.setCallback(
        new org.apache.axis2.client.async.AxisCallback() {
          public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
            try {
              org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

              java.lang.Object object =
                  fromOM(
                      resultEnv.getBody().getFirstElement(),
                      cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub
                          .GetStateResponse.class);
              callback.receiveResultgetState(
                  (cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetStateResponse)
                      object);

            } catch (org.apache.axis2.AxisFault e) {
              callback.receiveErrorgetState(e);
            }
          }

          public void onError(java.lang.Exception error) {
            if (error instanceof org.apache.axis2.AxisFault) {
              org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
              org.apache.axiom.om.OMElement faultElt = f.getDetail();
              if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                    new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "getState"))) {
                  // make the fault by reflection
                  try {
                    java.lang.String exceptionClassName =
                        faultExceptionClassNameMap.get(
                            new org.apache.axis2.client.FaultMapKey(
                                faultElt.getQName(), "getState"));
                    java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                    java.lang.reflect.Constructor constructor =
                        exceptionClass.getConstructor(java.lang.String.class);
                    java.lang.Exception ex =
                        (java.lang.Exception) constructor.newInstance(f.getMessage());
                    // message class
                    java.lang.String messageClassName =
                        faultMessageMap.get(
                            new org.apache.axis2.client.FaultMapKey(
                                faultElt.getQName(), "getState"));
                    java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                    java.lang.Object messageObject = fromOM(faultElt, messageClass);
                    java.lang.reflect.Method m =
                        exceptionClass.getMethod(
                            "setFaultMessage", new java.lang.Class[] {messageClass});
                    m.invoke(ex, new java.lang.Object[] {messageObject});

                    callback.receiveErrorgetState(
                        new java.rmi.RemoteException(ex.getMessage(), ex));
                  } catch (java.lang.ClassCastException e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorgetState(f);
                  } catch (java.lang.ClassNotFoundException e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorgetState(f);
                  } catch (java.lang.NoSuchMethodException e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorgetState(f);
                  } catch (java.lang.reflect.InvocationTargetException e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorgetState(f);
                  } catch (java.lang.IllegalAccessException e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorgetState(f);
                  } catch (java.lang.InstantiationException e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorgetState(f);
                  } catch (org.apache.axis2.AxisFault e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorgetState(f);
                  }
                } else {
                  callback.receiveErrorgetState(f);
                }
              } else {
                callback.receiveErrorgetState(f);
              }
            } else {
              callback.receiveErrorgetState(error);
            }
          }

          public void onFault(org.apache.axis2.context.MessageContext faultContext) {
            org.apache.axis2.AxisFault fault =
                org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
            onError(fault);
          }

          public void onComplete() {
            try {
              _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            } catch (org.apache.axis2.AxisFault axisFault) {
              callback.receiveErrorgetState(axisFault);
            }
          }
        });

    org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
    if (_operations[2].getMessageReceiver() == null
        && _operationClient.getOptions().isUseSeparateListener()) {
      _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
      _operations[2].setMessageReceiver(_callbackReceiver);
    }

    // execute the operation client
    _operationClient.execute(false);
  }

  /**
   * Auto generated method signature
   *
   * @see cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvService#getVersion
   * @param getVersion6
   */
  public cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersionResponse
      getVersion(
          cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersion getVersion6)
          throws java.rmi.RemoteException {

    org.apache.axis2.context.MessageContext _messageContext =
        new org.apache.axis2.context.MessageContext();
    try {
      org.apache.axis2.client.OperationClient _operationClient =
          _serviceClient.createClient(_operations[3].getName());
      _operationClient
          .getOptions()
          .setAction("http://DefaultNamespace/QueryEstDteAv/getVersionRequest");
      _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

      addPropertyToOperationClient(
          _operationClient,
          org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
          "&");

      // create SOAP envelope with that payload
      org.apache.axiom.soap.SOAPEnvelope env = null;

      env =
          toEnvelope(
              getFactory(_operationClient.getOptions().getSoapVersionURI()),
              getVersion6,
              optimizeContent(
                  new javax.xml.namespace.QName("http://DefaultNamespace", "getVersion")),
              new javax.xml.namespace.QName("http://DefaultNamespace", "getVersion"));

      // adding SOAP soap_headers
      _serviceClient.addHeadersToEnvelope(env);
      // set the message context with that soap envelope
      _messageContext.setEnvelope(env);

      // add the message contxt to the operation client
      _operationClient.addMessageContext(_messageContext);

      // execute the operation client
      _operationClient.execute(true);

      org.apache.axis2.context.MessageContext _returnMessageContext =
          _operationClient.getMessageContext(
              org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
      org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
      _returnEnv.buildWithAttachments();

      java.lang.Object object =
          fromOM(
              _returnEnv.getBody().getFirstElement(),
              cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersionResponse
                  .class);
      org.apache.axis2.kernel.TransportUtils.detachInputStream(_returnMessageContext);

      return (cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersionResponse)
          object;

    } catch (org.apache.axis2.AxisFault f) {

      org.apache.axiom.om.OMElement faultElt = f.getDetail();
      if (faultElt != null) {
        if (faultExceptionNameMap.containsKey(
            new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "getVersion"))) {
          // make the fault by reflection
          try {
            java.lang.String exceptionClassName =
                faultExceptionClassNameMap.get(
                    new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "getVersion"));
            java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
            java.lang.reflect.Constructor constructor =
                exceptionClass.getConstructor(java.lang.String.class);
            java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
            // message class
            java.lang.String messageClassName =
                faultMessageMap.get(
                    new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "getVersion"));
            java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
            java.lang.Object messageObject = fromOM(faultElt, messageClass);
            java.lang.reflect.Method m =
                exceptionClass.getMethod("setFaultMessage", new java.lang.Class[] {messageClass});
            m.invoke(ex, new java.lang.Object[] {messageObject});

            throw new java.rmi.RemoteException(ex.getMessage(), ex);
          } catch (java.lang.ClassCastException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (java.lang.ClassNotFoundException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (java.lang.NoSuchMethodException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (java.lang.reflect.InvocationTargetException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (java.lang.IllegalAccessException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (java.lang.InstantiationException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          }
        } else {
          throw f;
        }
      } else {
        throw f;
      }
    } finally {
      if (_messageContext.getTransportOut() != null) {
        _messageContext.getTransportOut().getSender().cleanup(_messageContext);
      }
    }
  }

  /**
   * Auto generated method signature for Asynchronous Invocations
   *
   * @see cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvService#startgetVersion
   * @param getVersion6
   */
  public void startgetVersion(
      cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersion getVersion6,
      final cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceCallbackHandler callback)
      throws java.rmi.RemoteException {

    org.apache.axis2.client.OperationClient _operationClient =
        _serviceClient.createClient(_operations[3].getName());
    _operationClient
        .getOptions()
        .setAction("http://DefaultNamespace/QueryEstDteAv/getVersionRequest");
    _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

    addPropertyToOperationClient(
        _operationClient,
        org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
        "&");

    // create SOAP envelope with that payload
    org.apache.axiom.soap.SOAPEnvelope env = null;
    final org.apache.axis2.context.MessageContext _messageContext =
        new org.apache.axis2.context.MessageContext();

    // Style is Doc.

    env =
        toEnvelope(
            getFactory(_operationClient.getOptions().getSoapVersionURI()),
            getVersion6,
            optimizeContent(new javax.xml.namespace.QName("http://DefaultNamespace", "getVersion")),
            new javax.xml.namespace.QName("http://DefaultNamespace", "getVersion"));

    // adding SOAP soap_headers
    _serviceClient.addHeadersToEnvelope(env);
    // create message context with that soap envelope
    _messageContext.setEnvelope(env);

    // add the message context to the operation client
    _operationClient.addMessageContext(_messageContext);

    _operationClient.setCallback(
        new org.apache.axis2.client.async.AxisCallback() {
          public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
            try {
              org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

              java.lang.Object object =
                  fromOM(
                      resultEnv.getBody().getFirstElement(),
                      cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub
                          .GetVersionResponse.class);
              callback.receiveResultgetVersion(
                  (cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub
                          .GetVersionResponse)
                      object);

            } catch (org.apache.axis2.AxisFault e) {
              callback.receiveErrorgetVersion(e);
            }
          }

          public void onError(java.lang.Exception error) {
            if (error instanceof org.apache.axis2.AxisFault) {
              org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
              org.apache.axiom.om.OMElement faultElt = f.getDetail();
              if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                    new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "getVersion"))) {
                  // make the fault by reflection
                  try {
                    java.lang.String exceptionClassName =
                        faultExceptionClassNameMap.get(
                            new org.apache.axis2.client.FaultMapKey(
                                faultElt.getQName(), "getVersion"));
                    java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                    java.lang.reflect.Constructor constructor =
                        exceptionClass.getConstructor(java.lang.String.class);
                    java.lang.Exception ex =
                        (java.lang.Exception) constructor.newInstance(f.getMessage());
                    // message class
                    java.lang.String messageClassName =
                        faultMessageMap.get(
                            new org.apache.axis2.client.FaultMapKey(
                                faultElt.getQName(), "getVersion"));
                    java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                    java.lang.Object messageObject = fromOM(faultElt, messageClass);
                    java.lang.reflect.Method m =
                        exceptionClass.getMethod(
                            "setFaultMessage", new java.lang.Class[] {messageClass});
                    m.invoke(ex, new java.lang.Object[] {messageObject});

                    callback.receiveErrorgetVersion(
                        new java.rmi.RemoteException(ex.getMessage(), ex));
                  } catch (java.lang.ClassCastException e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorgetVersion(f);
                  } catch (java.lang.ClassNotFoundException e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorgetVersion(f);
                  } catch (java.lang.NoSuchMethodException e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorgetVersion(f);
                  } catch (java.lang.reflect.InvocationTargetException e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorgetVersion(f);
                  } catch (java.lang.IllegalAccessException e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorgetVersion(f);
                  } catch (java.lang.InstantiationException e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorgetVersion(f);
                  } catch (org.apache.axis2.AxisFault e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorgetVersion(f);
                  }
                } else {
                  callback.receiveErrorgetVersion(f);
                }
              } else {
                callback.receiveErrorgetVersion(f);
              }
            } else {
              callback.receiveErrorgetVersion(error);
            }
          }

          public void onFault(org.apache.axis2.context.MessageContext faultContext) {
            org.apache.axis2.AxisFault fault =
                org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
            onError(fault);
          }

          public void onComplete() {
            try {
              _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            } catch (org.apache.axis2.AxisFault axisFault) {
              callback.receiveErrorgetVersion(axisFault);
            }
          }
        });

    org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
    if (_operations[3].getMessageReceiver() == null
        && _operationClient.getOptions().isUseSeparateListener()) {
      _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
      _operations[3].setMessageReceiver(_callbackReceiver);
    }

    // execute the operation client
    _operationClient.execute(false);
  }

  /**
   * Auto generated method signature
   *
   * @see cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvService#getEstDteAv
   * @param getEstDteAv8
   */
  public cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetEstDteAvResponse
      getEstDteAv(
          cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetEstDteAv getEstDteAv8)
          throws java.rmi.RemoteException {

    org.apache.axis2.context.MessageContext _messageContext =
        new org.apache.axis2.context.MessageContext();
    try {
      org.apache.axis2.client.OperationClient _operationClient =
          _serviceClient.createClient(_operations[4].getName());
      _operationClient
          .getOptions()
          .setAction("http://DefaultNamespace/QueryEstDteAv/getEstDteAvRequest");
      _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

      addPropertyToOperationClient(
          _operationClient,
          org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
          "&");

      // create SOAP envelope with that payload
      org.apache.axiom.soap.SOAPEnvelope env = null;

      env =
          toEnvelope(
              getFactory(_operationClient.getOptions().getSoapVersionURI()),
              getEstDteAv8,
              optimizeContent(
                  new javax.xml.namespace.QName("http://DefaultNamespace", "getEstDteAv")),
              new javax.xml.namespace.QName("http://DefaultNamespace", "getEstDteAv"));

      // adding SOAP soap_headers
      _serviceClient.addHeadersToEnvelope(env);
      // set the message context with that soap envelope
      _messageContext.setEnvelope(env);

      // add the message contxt to the operation client
      _operationClient.addMessageContext(_messageContext);

      // execute the operation client
      _operationClient.execute(true);

      org.apache.axis2.context.MessageContext _returnMessageContext =
          _operationClient.getMessageContext(
              org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
      org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
      _returnEnv.buildWithAttachments();

      java.lang.Object object =
          fromOM(
              _returnEnv.getBody().getFirstElement(),
              cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetEstDteAvResponse
                  .class);
      org.apache.axis2.kernel.TransportUtils.detachInputStream(_returnMessageContext);

      return (cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetEstDteAvResponse)
          object;

    } catch (org.apache.axis2.AxisFault f) {

      org.apache.axiom.om.OMElement faultElt = f.getDetail();
      if (faultElt != null) {
        if (faultExceptionNameMap.containsKey(
            new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "getEstDteAv"))) {
          // make the fault by reflection
          try {
            java.lang.String exceptionClassName =
                faultExceptionClassNameMap.get(
                    new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "getEstDteAv"));
            java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
            java.lang.reflect.Constructor constructor =
                exceptionClass.getConstructor(java.lang.String.class);
            java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
            // message class
            java.lang.String messageClassName =
                faultMessageMap.get(
                    new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "getEstDteAv"));
            java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
            java.lang.Object messageObject = fromOM(faultElt, messageClass);
            java.lang.reflect.Method m =
                exceptionClass.getMethod("setFaultMessage", new java.lang.Class[] {messageClass});
            m.invoke(ex, new java.lang.Object[] {messageObject});

            throw new java.rmi.RemoteException(ex.getMessage(), ex);
          } catch (java.lang.ClassCastException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (java.lang.ClassNotFoundException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (java.lang.NoSuchMethodException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (java.lang.reflect.InvocationTargetException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (java.lang.IllegalAccessException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (java.lang.InstantiationException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          }
        } else {
          throw f;
        }
      } else {
        throw f;
      }
    } finally {
      if (_messageContext.getTransportOut() != null) {
        _messageContext.getTransportOut().getSender().cleanup(_messageContext);
      }
    }
  }

  /**
   * Auto generated method signature for Asynchronous Invocations
   *
   * @see cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvService#startgetEstDteAv
   * @param getEstDteAv8
   */
  public void startgetEstDteAv(
      cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetEstDteAv getEstDteAv8,
      final cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceCallbackHandler callback)
      throws java.rmi.RemoteException {

    org.apache.axis2.client.OperationClient _operationClient =
        _serviceClient.createClient(_operations[4].getName());
    _operationClient
        .getOptions()
        .setAction("http://DefaultNamespace/QueryEstDteAv/getEstDteAvRequest");
    _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

    addPropertyToOperationClient(
        _operationClient,
        org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
        "&");

    // create SOAP envelope with that payload
    org.apache.axiom.soap.SOAPEnvelope env = null;
    final org.apache.axis2.context.MessageContext _messageContext =
        new org.apache.axis2.context.MessageContext();

    // Style is Doc.

    env =
        toEnvelope(
            getFactory(_operationClient.getOptions().getSoapVersionURI()),
            getEstDteAv8,
            optimizeContent(
                new javax.xml.namespace.QName("http://DefaultNamespace", "getEstDteAv")),
            new javax.xml.namespace.QName("http://DefaultNamespace", "getEstDteAv"));

    // adding SOAP soap_headers
    _serviceClient.addHeadersToEnvelope(env);
    // create message context with that soap envelope
    _messageContext.setEnvelope(env);

    // add the message context to the operation client
    _operationClient.addMessageContext(_messageContext);

    _operationClient.setCallback(
        new org.apache.axis2.client.async.AxisCallback() {
          public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
            try {
              org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

              java.lang.Object object =
                  fromOM(
                      resultEnv.getBody().getFirstElement(),
                      cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub
                          .GetEstDteAvResponse.class);
              callback.receiveResultgetEstDteAv(
                  (cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub
                          .GetEstDteAvResponse)
                      object);

            } catch (org.apache.axis2.AxisFault e) {
              callback.receiveErrorgetEstDteAv(e);
            }
          }

          public void onError(java.lang.Exception error) {
            if (error instanceof org.apache.axis2.AxisFault) {
              org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
              org.apache.axiom.om.OMElement faultElt = f.getDetail();
              if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                    new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "getEstDteAv"))) {
                  // make the fault by reflection
                  try {
                    java.lang.String exceptionClassName =
                        faultExceptionClassNameMap.get(
                            new org.apache.axis2.client.FaultMapKey(
                                faultElt.getQName(), "getEstDteAv"));
                    java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                    java.lang.reflect.Constructor constructor =
                        exceptionClass.getConstructor(java.lang.String.class);
                    java.lang.Exception ex =
                        (java.lang.Exception) constructor.newInstance(f.getMessage());
                    // message class
                    java.lang.String messageClassName =
                        faultMessageMap.get(
                            new org.apache.axis2.client.FaultMapKey(
                                faultElt.getQName(), "getEstDteAv"));
                    java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                    java.lang.Object messageObject = fromOM(faultElt, messageClass);
                    java.lang.reflect.Method m =
                        exceptionClass.getMethod(
                            "setFaultMessage", new java.lang.Class[] {messageClass});
                    m.invoke(ex, new java.lang.Object[] {messageObject});

                    callback.receiveErrorgetEstDteAv(
                        new java.rmi.RemoteException(ex.getMessage(), ex));
                  } catch (java.lang.ClassCastException e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorgetEstDteAv(f);
                  } catch (java.lang.ClassNotFoundException e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorgetEstDteAv(f);
                  } catch (java.lang.NoSuchMethodException e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorgetEstDteAv(f);
                  } catch (java.lang.reflect.InvocationTargetException e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorgetEstDteAv(f);
                  } catch (java.lang.IllegalAccessException e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorgetEstDteAv(f);
                  } catch (java.lang.InstantiationException e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorgetEstDteAv(f);
                  } catch (org.apache.axis2.AxisFault e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorgetEstDteAv(f);
                  }
                } else {
                  callback.receiveErrorgetEstDteAv(f);
                }
              } else {
                callback.receiveErrorgetEstDteAv(f);
              }
            } else {
              callback.receiveErrorgetEstDteAv(error);
            }
          }

          public void onFault(org.apache.axis2.context.MessageContext faultContext) {
            org.apache.axis2.AxisFault fault =
                org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
            onError(fault);
          }

          public void onComplete() {
            try {
              _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            } catch (org.apache.axis2.AxisFault axisFault) {
              callback.receiveErrorgetEstDteAv(axisFault);
            }
          }
        });

    org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
    if (_operations[4].getMessageReceiver() == null
        && _operationClient.getOptions().isUseSeparateListener()) {
      _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
      _operations[4].setMessageReceiver(_callbackReceiver);
    }

    // execute the operation client
    _operationClient.execute(false);
  }

  /**
   * Auto generated method signature
   *
   * @see cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvService#getVersionPatch
   * @param getVersionPatch10
   */
  public cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersionPatchResponse
      getVersionPatch(
          cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersionPatch
              getVersionPatch10)
          throws java.rmi.RemoteException {

    org.apache.axis2.context.MessageContext _messageContext =
        new org.apache.axis2.context.MessageContext();
    try {
      org.apache.axis2.client.OperationClient _operationClient =
          _serviceClient.createClient(_operations[5].getName());
      _operationClient
          .getOptions()
          .setAction("http://DefaultNamespace/QueryEstDteAv/getVersionPatchRequest");
      _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

      addPropertyToOperationClient(
          _operationClient,
          org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
          "&");

      // create SOAP envelope with that payload
      org.apache.axiom.soap.SOAPEnvelope env = null;

      env =
          toEnvelope(
              getFactory(_operationClient.getOptions().getSoapVersionURI()),
              getVersionPatch10,
              optimizeContent(
                  new javax.xml.namespace.QName("http://DefaultNamespace", "getVersionPatch")),
              new javax.xml.namespace.QName("http://DefaultNamespace", "getVersionPatch"));

      // adding SOAP soap_headers
      _serviceClient.addHeadersToEnvelope(env);
      // set the message context with that soap envelope
      _messageContext.setEnvelope(env);

      // add the message contxt to the operation client
      _operationClient.addMessageContext(_messageContext);

      // execute the operation client
      _operationClient.execute(true);

      org.apache.axis2.context.MessageContext _returnMessageContext =
          _operationClient.getMessageContext(
              org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
      org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
      _returnEnv.buildWithAttachments();

      java.lang.Object object =
          fromOM(
              _returnEnv.getBody().getFirstElement(),
              cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersionPatchResponse
                  .class);
      org.apache.axis2.kernel.TransportUtils.detachInputStream(_returnMessageContext);

      return (cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub
              .GetVersionPatchResponse)
          object;

    } catch (org.apache.axis2.AxisFault f) {

      org.apache.axiom.om.OMElement faultElt = f.getDetail();
      if (faultElt != null) {
        if (faultExceptionNameMap.containsKey(
            new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "getVersionPatch"))) {
          // make the fault by reflection
          try {
            java.lang.String exceptionClassName =
                faultExceptionClassNameMap.get(
                    new org.apache.axis2.client.FaultMapKey(
                        faultElt.getQName(), "getVersionPatch"));
            java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
            java.lang.reflect.Constructor constructor =
                exceptionClass.getConstructor(java.lang.String.class);
            java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
            // message class
            java.lang.String messageClassName =
                faultMessageMap.get(
                    new org.apache.axis2.client.FaultMapKey(
                        faultElt.getQName(), "getVersionPatch"));
            java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
            java.lang.Object messageObject = fromOM(faultElt, messageClass);
            java.lang.reflect.Method m =
                exceptionClass.getMethod("setFaultMessage", new java.lang.Class[] {messageClass});
            m.invoke(ex, new java.lang.Object[] {messageObject});

            throw new java.rmi.RemoteException(ex.getMessage(), ex);
          } catch (java.lang.ClassCastException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (java.lang.ClassNotFoundException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (java.lang.NoSuchMethodException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (java.lang.reflect.InvocationTargetException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (java.lang.IllegalAccessException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (java.lang.InstantiationException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          }
        } else {
          throw f;
        }
      } else {
        throw f;
      }
    } finally {
      if (_messageContext.getTransportOut() != null) {
        _messageContext.getTransportOut().getSender().cleanup(_messageContext);
      }
    }
  }

  /**
   * Auto generated method signature for Asynchronous Invocations
   *
   * @see cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvService#startgetVersionPatch
   * @param getVersionPatch10
   */
  public void startgetVersionPatch(
      cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersionPatch
          getVersionPatch10,
      final cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceCallbackHandler callback)
      throws java.rmi.RemoteException {

    org.apache.axis2.client.OperationClient _operationClient =
        _serviceClient.createClient(_operations[5].getName());
    _operationClient
        .getOptions()
        .setAction("http://DefaultNamespace/QueryEstDteAv/getVersionPatchRequest");
    _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

    addPropertyToOperationClient(
        _operationClient,
        org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
        "&");

    // create SOAP envelope with that payload
    org.apache.axiom.soap.SOAPEnvelope env = null;
    final org.apache.axis2.context.MessageContext _messageContext =
        new org.apache.axis2.context.MessageContext();

    // Style is Doc.

    env =
        toEnvelope(
            getFactory(_operationClient.getOptions().getSoapVersionURI()),
            getVersionPatch10,
            optimizeContent(
                new javax.xml.namespace.QName("http://DefaultNamespace", "getVersionPatch")),
            new javax.xml.namespace.QName("http://DefaultNamespace", "getVersionPatch"));

    // adding SOAP soap_headers
    _serviceClient.addHeadersToEnvelope(env);
    // create message context with that soap envelope
    _messageContext.setEnvelope(env);

    // add the message context to the operation client
    _operationClient.addMessageContext(_messageContext);

    _operationClient.setCallback(
        new org.apache.axis2.client.async.AxisCallback() {
          public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
            try {
              org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

              java.lang.Object object =
                  fromOM(
                      resultEnv.getBody().getFirstElement(),
                      cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub
                          .GetVersionPatchResponse.class);
              callback.receiveResultgetVersionPatch(
                  (cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub
                          .GetVersionPatchResponse)
                      object);

            } catch (org.apache.axis2.AxisFault e) {
              callback.receiveErrorgetVersionPatch(e);
            }
          }

          public void onError(java.lang.Exception error) {
            if (error instanceof org.apache.axis2.AxisFault) {
              org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
              org.apache.axiom.om.OMElement faultElt = f.getDetail();
              if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                    new org.apache.axis2.client.FaultMapKey(
                        faultElt.getQName(), "getVersionPatch"))) {
                  // make the fault by reflection
                  try {
                    java.lang.String exceptionClassName =
                        faultExceptionClassNameMap.get(
                            new org.apache.axis2.client.FaultMapKey(
                                faultElt.getQName(), "getVersionPatch"));
                    java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                    java.lang.reflect.Constructor constructor =
                        exceptionClass.getConstructor(java.lang.String.class);
                    java.lang.Exception ex =
                        (java.lang.Exception) constructor.newInstance(f.getMessage());
                    // message class
                    java.lang.String messageClassName =
                        faultMessageMap.get(
                            new org.apache.axis2.client.FaultMapKey(
                                faultElt.getQName(), "getVersionPatch"));
                    java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                    java.lang.Object messageObject = fromOM(faultElt, messageClass);
                    java.lang.reflect.Method m =
                        exceptionClass.getMethod(
                            "setFaultMessage", new java.lang.Class[] {messageClass});
                    m.invoke(ex, new java.lang.Object[] {messageObject});

                    callback.receiveErrorgetVersionPatch(
                        new java.rmi.RemoteException(ex.getMessage(), ex));
                  } catch (java.lang.ClassCastException e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorgetVersionPatch(f);
                  } catch (java.lang.ClassNotFoundException e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorgetVersionPatch(f);
                  } catch (java.lang.NoSuchMethodException e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorgetVersionPatch(f);
                  } catch (java.lang.reflect.InvocationTargetException e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorgetVersionPatch(f);
                  } catch (java.lang.IllegalAccessException e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorgetVersionPatch(f);
                  } catch (java.lang.InstantiationException e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorgetVersionPatch(f);
                  } catch (org.apache.axis2.AxisFault e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorgetVersionPatch(f);
                  }
                } else {
                  callback.receiveErrorgetVersionPatch(f);
                }
              } else {
                callback.receiveErrorgetVersionPatch(f);
              }
            } else {
              callback.receiveErrorgetVersionPatch(error);
            }
          }

          public void onFault(org.apache.axis2.context.MessageContext faultContext) {
            org.apache.axis2.AxisFault fault =
                org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
            onError(fault);
          }

          public void onComplete() {
            try {
              _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            } catch (org.apache.axis2.AxisFault axisFault) {
              callback.receiveErrorgetVersionPatch(axisFault);
            }
          }
        });

    org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
    if (_operations[5].getMessageReceiver() == null
        && _operationClient.getOptions().isUseSeparateListener()) {
      _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
      _operations[5].setMessageReceiver(_callbackReceiver);
    }

    // execute the operation client
    _operationClient.execute(false);
  }

  private javax.xml.namespace.QName[] opNameArray = null;

  private boolean optimizeContent(javax.xml.namespace.QName opName) {

    if (opNameArray == null) {
      return false;
    }
    for (int i = 0; i < opNameArray.length; i++) {
      if (opName.equals(opNameArray[i])) {
        return true;
      }
    }
    return false;
  }
  // https://maullin.sii.cl/DTEWS/services/QueryEstDteAv
  public static class GetVersionMayor implements org.apache.axis2.databinding.ADBBean {

    public static final javax.xml.namespace.QName MY_QNAME =
        new javax.xml.namespace.QName("http://DefaultNamespace", "getVersionMayor", "ns1");

    /**
     * @param parentQName
     * @param factory
     * @return org.apache.axiom.om.OMElement
     */
    public org.apache.axiom.om.OMElement getOMElement(
        final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory)
        throws org.apache.axis2.databinding.ADBException {

      return factory.createOMElement(
          new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME));
    }

    public void serialize(
        final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
      serialize(parentQName, xmlWriter, false);
    }

    public void serialize(
        final javax.xml.namespace.QName parentQName,
        javax.xml.stream.XMLStreamWriter xmlWriter,
        boolean serializeType)
        throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

      java.lang.String prefix = null;
      java.lang.String namespace = null;

      prefix = parentQName.getPrefix();
      namespace = parentQName.getNamespaceURI();
      writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

      if (serializeType) {

        java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://DefaultNamespace");
        if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
          writeAttribute(
              "xsi",
              "http://www.w3.org/2001/XMLSchema-instance",
              "type",
              namespacePrefix + ":getVersionMayor",
              xmlWriter);
        } else {
          writeAttribute(
              "xsi",
              "http://www.w3.org/2001/XMLSchema-instance",
              "type",
              "getVersionMayor",
              xmlWriter);
        }
      }

      xmlWriter.writeEndElement();
    }

    private static java.lang.String generatePrefix(java.lang.String namespace) {
      if (namespace.equals("http://DefaultNamespace")) {
        return "ns1";
      }
      return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
    }

    /** Utility method to write an element start tag. */
    private void writeStartElement(
        java.lang.String prefix,
        java.lang.String namespace,
        java.lang.String localPart,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
      if (writerPrefix != null) {
        xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
      } else {
        if (namespace.length() == 0) {
          prefix = "";
        } else if (prefix == null) {
          prefix = generatePrefix(namespace);
        }

        xmlWriter.writeStartElement(prefix, localPart, namespace);
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
    }

    /** Util method to write an attribute with the ns prefix */
    private void writeAttribute(
        java.lang.String prefix,
        java.lang.String namespace,
        java.lang.String attName,
        java.lang.String attValue,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
      if (writerPrefix != null) {
        xmlWriter.writeAttribute(writerPrefix, namespace, attName, attValue);
      } else {
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
        xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
      }
    }

    /** Util method to write an attribute without the ns prefix */
    private void writeAttribute(
        java.lang.String namespace,
        java.lang.String attName,
        java.lang.String attValue,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      if (namespace.equals("")) {
        xmlWriter.writeAttribute(attName, attValue);
      } else {
        xmlWriter.writeAttribute(
            registerPrefix(xmlWriter, namespace), namespace, attName, attValue);
      }
    }

    /** Util method to write an attribute without the ns prefix */
    private void writeQNameAttribute(
        java.lang.String namespace,
        java.lang.String attName,
        javax.xml.namespace.QName qname,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {

      java.lang.String attributeNamespace = qname.getNamespaceURI();
      java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
      if (attributePrefix == null) {
        attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
      }
      java.lang.String attributeValue;
      if (attributePrefix.trim().length() > 0) {
        attributeValue = attributePrefix + ":" + qname.getLocalPart();
      } else {
        attributeValue = qname.getLocalPart();
      }

      if (namespace.equals("")) {
        xmlWriter.writeAttribute(attName, attributeValue);
      } else {
        registerPrefix(xmlWriter, namespace);
        xmlWriter.writeAttribute(attributePrefix, namespace, attName, attributeValue);
      }
    }
    /** method to handle Qnames */
    private void writeQName(
        javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String namespaceURI = qname.getNamespaceURI();
      if (namespaceURI != null) {
        java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
        if (prefix == null) {
          prefix = generatePrefix(namespaceURI);
          xmlWriter.writeNamespace(prefix, namespaceURI);
          xmlWriter.setPrefix(prefix, namespaceURI);
        }

        if (prefix.trim().length() > 0) {
          xmlWriter.writeCharacters(
              prefix
                  + ":"
                  + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
        } else {
          // i.e this is the default namespace
          xmlWriter.writeCharacters(
              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
        }

      } else {
        xmlWriter.writeCharacters(
            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
      }
    }

    private void writeQNames(
        javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {

      if (qnames != null) {
        // we have to store this data until last moment since it is not possible to write any
        // namespace data after writing the charactor data
        java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
        java.lang.String namespaceURI = null;
        java.lang.String prefix = null;

        for (int i = 0; i < qnames.length; i++) {
          if (i > 0) {
            stringToWrite.append(" ");
          }
          namespaceURI = qnames[i].getNamespaceURI();
          if (namespaceURI != null) {
            prefix = xmlWriter.getPrefix(namespaceURI);
            if ((prefix == null) || (prefix.length() == 0)) {
              prefix = generatePrefix(namespaceURI);
              xmlWriter.writeNamespace(prefix, namespaceURI);
              xmlWriter.setPrefix(prefix, namespaceURI);
            }

            if (prefix.trim().length() > 0) {
              stringToWrite
                  .append(prefix)
                  .append(":")
                  .append(
                      org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
            } else {
              stringToWrite.append(
                  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
            }
          } else {
            stringToWrite.append(
                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
          }
        }
        xmlWriter.writeCharacters(stringToWrite.toString());
      }
    }

    /** Register a namespace prefix */
    private java.lang.String registerPrefix(
        javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String prefix = xmlWriter.getPrefix(namespace);
      if (prefix == null) {
        prefix = generatePrefix(namespace);
        javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
        while (true) {
          java.lang.String uri = nsContext.getNamespaceURI(prefix);
          if (uri == null || uri.length() == 0) {
            break;
          }
          prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
      return prefix;
    }

    /** Factory class that keeps the parse method */
    public static class Factory {
      private static org.apache.commons.logging.Log log =
          org.apache.commons.logging.LogFactory.getLog(Factory.class);

      /**
       * static method to create the object Precondition: If this object is an element, the current
       * or next start element starts this object and any intervening reader events are ignorable If
       * this object is not an element, it is a complex type and the reader is at the event just
       * after the outer start element Postcondition: If this object is an element, the reader is
       * positioned at its end element If this object is a complex type, the reader is positioned at
       * the end element of its outer element
       */
      public static GetVersionMayor parse(javax.xml.stream.XMLStreamReader reader)
          throws java.lang.Exception {
        GetVersionMayor object = new GetVersionMayor();

        int event;
        javax.xml.namespace.QName currentQName = null;
        java.lang.String nillableValue = null;
        java.lang.String prefix = "";
        java.lang.String namespaceuri = "";
        try {

          while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

          currentQName = reader.getName();

          if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type")
              != null) {
            java.lang.String fullTypeName =
                reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
            if (fullTypeName != null) {
              java.lang.String nsPrefix = null;
              if (fullTypeName.indexOf(":") > -1) {
                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
              }
              nsPrefix = nsPrefix == null ? "" : nsPrefix;

              java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

              if (!"getVersionMayor".equals(type)) {
                // find namespace for the prefix
                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                return (GetVersionMayor) ExtensionMapper.getTypeObject(nsUri, type, reader);
              }
            }
          }

          // Note all attributes that were handled. Used to differ normal attributes
          // from anyAttributes.
          java.util.Vector handledAttributes = new java.util.Vector();

          reader.next();

          while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

          if (reader.isStartElement())
            // 2 - A start element we are not expecting indicates a trailing invalid property

            throw new org.apache.axis2.databinding.ADBException(
                "Unexpected subelement " + reader.getName());

        } catch (javax.xml.stream.XMLStreamException e) {
          throw new java.lang.Exception(e);
        }

        return object;
      }
    } // end of factory class
  }

  public static class GetVersionMenorResponse implements org.apache.axis2.databinding.ADBBean {

    public static final javax.xml.namespace.QName MY_QNAME =
        new javax.xml.namespace.QName("http://DefaultNamespace", "getVersionMenorResponse", "ns1");

    /** field for GetVersionMenorReturn */
    protected java.lang.String localGetVersionMenorReturn;

    /**
     * Auto generated getter method
     *
     * @return java.lang.String
     */
    public java.lang.String getGetVersionMenorReturn() {
      return localGetVersionMenorReturn;
    }

    /**
     * Auto generated setter method
     *
     * @param param GetVersionMenorReturn
     */
    public void setGetVersionMenorReturn(java.lang.String param) {

      this.localGetVersionMenorReturn = param;
    }

    /**
     * @param parentQName
     * @param factory
     * @return org.apache.axiom.om.OMElement
     */
    public org.apache.axiom.om.OMElement getOMElement(
        final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory)
        throws org.apache.axis2.databinding.ADBException {

      return factory.createOMElement(
          new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME));
    }

    public void serialize(
        final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
      serialize(parentQName, xmlWriter, false);
    }

    public void serialize(
        final javax.xml.namespace.QName parentQName,
        javax.xml.stream.XMLStreamWriter xmlWriter,
        boolean serializeType)
        throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

      java.lang.String prefix = null;
      java.lang.String namespace = null;

      prefix = parentQName.getPrefix();
      namespace = parentQName.getNamespaceURI();
      writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

      if (serializeType) {

        java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://DefaultNamespace");
        if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
          writeAttribute(
              "xsi",
              "http://www.w3.org/2001/XMLSchema-instance",
              "type",
              namespacePrefix + ":getVersionMenorResponse",
              xmlWriter);
        } else {
          writeAttribute(
              "xsi",
              "http://www.w3.org/2001/XMLSchema-instance",
              "type",
              "getVersionMenorResponse",
              xmlWriter);
        }
      }

      namespace = "";
      writeStartElement(null, namespace, "getVersionMenorReturn", xmlWriter);

      if (localGetVersionMenorReturn == null) {
        // write the nil attribute

        writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

      } else {

        xmlWriter.writeCharacters(localGetVersionMenorReturn);
      }

      xmlWriter.writeEndElement();

      xmlWriter.writeEndElement();
    }

    private static java.lang.String generatePrefix(java.lang.String namespace) {
      if (namespace.equals("http://DefaultNamespace")) {
        return "ns1";
      }
      return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
    }

    /** Utility method to write an element start tag. */
    private void writeStartElement(
        java.lang.String prefix,
        java.lang.String namespace,
        java.lang.String localPart,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
      if (writerPrefix != null) {
        xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
      } else {
        if (namespace.length() == 0) {
          prefix = "";
        } else if (prefix == null) {
          prefix = generatePrefix(namespace);
        }

        xmlWriter.writeStartElement(prefix, localPart, namespace);
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
    }

    /** Util method to write an attribute with the ns prefix */
    private void writeAttribute(
        java.lang.String prefix,
        java.lang.String namespace,
        java.lang.String attName,
        java.lang.String attValue,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
      if (writerPrefix != null) {
        xmlWriter.writeAttribute(writerPrefix, namespace, attName, attValue);
      } else {
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
        xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
      }
    }

    /** Util method to write an attribute without the ns prefix */
    private void writeAttribute(
        java.lang.String namespace,
        java.lang.String attName,
        java.lang.String attValue,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      if (namespace.equals("")) {
        xmlWriter.writeAttribute(attName, attValue);
      } else {
        xmlWriter.writeAttribute(
            registerPrefix(xmlWriter, namespace), namespace, attName, attValue);
      }
    }

    /** Util method to write an attribute without the ns prefix */
    private void writeQNameAttribute(
        java.lang.String namespace,
        java.lang.String attName,
        javax.xml.namespace.QName qname,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {

      java.lang.String attributeNamespace = qname.getNamespaceURI();
      java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
      if (attributePrefix == null) {
        attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
      }
      java.lang.String attributeValue;
      if (attributePrefix.trim().length() > 0) {
        attributeValue = attributePrefix + ":" + qname.getLocalPart();
      } else {
        attributeValue = qname.getLocalPart();
      }

      if (namespace.equals("")) {
        xmlWriter.writeAttribute(attName, attributeValue);
      } else {
        registerPrefix(xmlWriter, namespace);
        xmlWriter.writeAttribute(attributePrefix, namespace, attName, attributeValue);
      }
    }
    /** method to handle Qnames */
    private void writeQName(
        javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String namespaceURI = qname.getNamespaceURI();
      if (namespaceURI != null) {
        java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
        if (prefix == null) {
          prefix = generatePrefix(namespaceURI);
          xmlWriter.writeNamespace(prefix, namespaceURI);
          xmlWriter.setPrefix(prefix, namespaceURI);
        }

        if (prefix.trim().length() > 0) {
          xmlWriter.writeCharacters(
              prefix
                  + ":"
                  + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
        } else {
          // i.e this is the default namespace
          xmlWriter.writeCharacters(
              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
        }

      } else {
        xmlWriter.writeCharacters(
            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
      }
    }

    private void writeQNames(
        javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {

      if (qnames != null) {
        // we have to store this data until last moment since it is not possible to write any
        // namespace data after writing the charactor data
        java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
        java.lang.String namespaceURI = null;
        java.lang.String prefix = null;

        for (int i = 0; i < qnames.length; i++) {
          if (i > 0) {
            stringToWrite.append(" ");
          }
          namespaceURI = qnames[i].getNamespaceURI();
          if (namespaceURI != null) {
            prefix = xmlWriter.getPrefix(namespaceURI);
            if ((prefix == null) || (prefix.length() == 0)) {
              prefix = generatePrefix(namespaceURI);
              xmlWriter.writeNamespace(prefix, namespaceURI);
              xmlWriter.setPrefix(prefix, namespaceURI);
            }

            if (prefix.trim().length() > 0) {
              stringToWrite
                  .append(prefix)
                  .append(":")
                  .append(
                      org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
            } else {
              stringToWrite.append(
                  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
            }
          } else {
            stringToWrite.append(
                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
          }
        }
        xmlWriter.writeCharacters(stringToWrite.toString());
      }
    }

    /** Register a namespace prefix */
    private java.lang.String registerPrefix(
        javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String prefix = xmlWriter.getPrefix(namespace);
      if (prefix == null) {
        prefix = generatePrefix(namespace);
        javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
        while (true) {
          java.lang.String uri = nsContext.getNamespaceURI(prefix);
          if (uri == null || uri.length() == 0) {
            break;
          }
          prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
      return prefix;
    }

    /** Factory class that keeps the parse method */
    public static class Factory {
      private static org.apache.commons.logging.Log log =
          org.apache.commons.logging.LogFactory.getLog(Factory.class);

      /**
       * static method to create the object Precondition: If this object is an element, the current
       * or next start element starts this object and any intervening reader events are ignorable If
       * this object is not an element, it is a complex type and the reader is at the event just
       * after the outer start element Postcondition: If this object is an element, the reader is
       * positioned at its end element If this object is a complex type, the reader is positioned at
       * the end element of its outer element
       */
      public static GetVersionMenorResponse parse(javax.xml.stream.XMLStreamReader reader)
          throws java.lang.Exception {
        GetVersionMenorResponse object = new GetVersionMenorResponse();

        int event;
        javax.xml.namespace.QName currentQName = null;
        java.lang.String nillableValue = null;
        java.lang.String prefix = "";
        java.lang.String namespaceuri = "";
        try {

          while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

          currentQName = reader.getName();

          if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type")
              != null) {
            java.lang.String fullTypeName =
                reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
            if (fullTypeName != null) {
              java.lang.String nsPrefix = null;
              if (fullTypeName.indexOf(":") > -1) {
                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
              }
              nsPrefix = nsPrefix == null ? "" : nsPrefix;

              java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

              if (!"getVersionMenorResponse".equals(type)) {
                // find namespace for the prefix
                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                return (GetVersionMenorResponse) ExtensionMapper.getTypeObject(nsUri, type, reader);
              }
            }
          }

          // Note all attributes that were handled. Used to differ normal attributes
          // from anyAttributes.
          java.util.Vector handledAttributes = new java.util.Vector();

          reader.next();

          while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

          if (reader.isStartElement()
              && new javax.xml.namespace.QName("", "getVersionMenorReturn")
                  .equals(reader.getName())) {

            nillableValue =
                reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
            if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

              java.lang.String content = reader.getElementText();

              object.setGetVersionMenorReturn(
                  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

            } else {

              reader.getElementText(); // throw away text nodes if any.
            }

            reader.next();

          } // End of if for expected property start element
          else {
            // 1 - A start element we are not expecting indicates an invalid parameter was passed
            throw new org.apache.axis2.databinding.ADBException(
                "Unexpected subelement " + reader.getName());
          }

          while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

          if (reader.isStartElement())
            // 2 - A start element we are not expecting indicates a trailing invalid property

            throw new org.apache.axis2.databinding.ADBException(
                "Unexpected subelement " + reader.getName());

        } catch (javax.xml.stream.XMLStreamException e) {
          throw new java.lang.Exception(e);
        }

        return object;
      }
    } // end of factory class
  }

  public static class ExtensionMapper {

    public static java.lang.Object getTypeObject(
        java.lang.String namespaceURI,
        java.lang.String typeName,
        javax.xml.stream.XMLStreamReader reader)
        throws java.lang.Exception {

      throw new org.apache.axis2.databinding.ADBException(
          "Unsupported type " + namespaceURI + " " + typeName);
    }
  }

  public static class GetStateResponse implements org.apache.axis2.databinding.ADBBean {

    public static final javax.xml.namespace.QName MY_QNAME =
        new javax.xml.namespace.QName("http://DefaultNamespace", "getStateResponse", "ns1");

    /** field for GetStateReturn */
    protected java.lang.String localGetStateReturn;

    /**
     * Auto generated getter method
     *
     * @return java.lang.String
     */
    public java.lang.String getGetStateReturn() {
      return localGetStateReturn;
    }

    /**
     * Auto generated setter method
     *
     * @param param GetStateReturn
     */
    public void setGetStateReturn(java.lang.String param) {

      this.localGetStateReturn = param;
    }

    /**
     * @param parentQName
     * @param factory
     * @return org.apache.axiom.om.OMElement
     */
    public org.apache.axiom.om.OMElement getOMElement(
        final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory)
        throws org.apache.axis2.databinding.ADBException {

      return factory.createOMElement(
          new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME));
    }

    public void serialize(
        final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
      serialize(parentQName, xmlWriter, false);
    }

    public void serialize(
        final javax.xml.namespace.QName parentQName,
        javax.xml.stream.XMLStreamWriter xmlWriter,
        boolean serializeType)
        throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

      java.lang.String prefix = null;
      java.lang.String namespace = null;

      prefix = parentQName.getPrefix();
      namespace = parentQName.getNamespaceURI();
      writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

      if (serializeType) {

        java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://DefaultNamespace");
        if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
          writeAttribute(
              "xsi",
              "http://www.w3.org/2001/XMLSchema-instance",
              "type",
              namespacePrefix + ":getStateResponse",
              xmlWriter);
        } else {
          writeAttribute(
              "xsi",
              "http://www.w3.org/2001/XMLSchema-instance",
              "type",
              "getStateResponse",
              xmlWriter);
        }
      }

      namespace = "";
      writeStartElement(null, namespace, "getStateReturn", xmlWriter);

      if (localGetStateReturn == null) {
        // write the nil attribute

        writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

      } else {

        xmlWriter.writeCharacters(localGetStateReturn);
      }

      xmlWriter.writeEndElement();

      xmlWriter.writeEndElement();
    }

    private static java.lang.String generatePrefix(java.lang.String namespace) {
      if (namespace.equals("http://DefaultNamespace")) {
        return "ns1";
      }
      return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
    }

    /** Utility method to write an element start tag. */
    private void writeStartElement(
        java.lang.String prefix,
        java.lang.String namespace,
        java.lang.String localPart,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
      if (writerPrefix != null) {
        xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
      } else {
        if (namespace.length() == 0) {
          prefix = "";
        } else if (prefix == null) {
          prefix = generatePrefix(namespace);
        }

        xmlWriter.writeStartElement(prefix, localPart, namespace);
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
    }

    /** Util method to write an attribute with the ns prefix */
    private void writeAttribute(
        java.lang.String prefix,
        java.lang.String namespace,
        java.lang.String attName,
        java.lang.String attValue,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
      if (writerPrefix != null) {
        xmlWriter.writeAttribute(writerPrefix, namespace, attName, attValue);
      } else {
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
        xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
      }
    }

    /** Util method to write an attribute without the ns prefix */
    private void writeAttribute(
        java.lang.String namespace,
        java.lang.String attName,
        java.lang.String attValue,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      if (namespace.equals("")) {
        xmlWriter.writeAttribute(attName, attValue);
      } else {
        xmlWriter.writeAttribute(
            registerPrefix(xmlWriter, namespace), namespace, attName, attValue);
      }
    }

    /** Util method to write an attribute without the ns prefix */
    private void writeQNameAttribute(
        java.lang.String namespace,
        java.lang.String attName,
        javax.xml.namespace.QName qname,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {

      java.lang.String attributeNamespace = qname.getNamespaceURI();
      java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
      if (attributePrefix == null) {
        attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
      }
      java.lang.String attributeValue;
      if (attributePrefix.trim().length() > 0) {
        attributeValue = attributePrefix + ":" + qname.getLocalPart();
      } else {
        attributeValue = qname.getLocalPart();
      }

      if (namespace.equals("")) {
        xmlWriter.writeAttribute(attName, attributeValue);
      } else {
        registerPrefix(xmlWriter, namespace);
        xmlWriter.writeAttribute(attributePrefix, namespace, attName, attributeValue);
      }
    }
    /** method to handle Qnames */
    private void writeQName(
        javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String namespaceURI = qname.getNamespaceURI();
      if (namespaceURI != null) {
        java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
        if (prefix == null) {
          prefix = generatePrefix(namespaceURI);
          xmlWriter.writeNamespace(prefix, namespaceURI);
          xmlWriter.setPrefix(prefix, namespaceURI);
        }

        if (prefix.trim().length() > 0) {
          xmlWriter.writeCharacters(
              prefix
                  + ":"
                  + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
        } else {
          // i.e this is the default namespace
          xmlWriter.writeCharacters(
              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
        }

      } else {
        xmlWriter.writeCharacters(
            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
      }
    }

    private void writeQNames(
        javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {

      if (qnames != null) {
        // we have to store this data until last moment since it is not possible to write any
        // namespace data after writing the charactor data
        java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
        java.lang.String namespaceURI = null;
        java.lang.String prefix = null;

        for (int i = 0; i < qnames.length; i++) {
          if (i > 0) {
            stringToWrite.append(" ");
          }
          namespaceURI = qnames[i].getNamespaceURI();
          if (namespaceURI != null) {
            prefix = xmlWriter.getPrefix(namespaceURI);
            if ((prefix == null) || (prefix.length() == 0)) {
              prefix = generatePrefix(namespaceURI);
              xmlWriter.writeNamespace(prefix, namespaceURI);
              xmlWriter.setPrefix(prefix, namespaceURI);
            }

            if (prefix.trim().length() > 0) {
              stringToWrite
                  .append(prefix)
                  .append(":")
                  .append(
                      org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
            } else {
              stringToWrite.append(
                  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
            }
          } else {
            stringToWrite.append(
                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
          }
        }
        xmlWriter.writeCharacters(stringToWrite.toString());
      }
    }

    /** Register a namespace prefix */
    private java.lang.String registerPrefix(
        javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String prefix = xmlWriter.getPrefix(namespace);
      if (prefix == null) {
        prefix = generatePrefix(namespace);
        javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
        while (true) {
          java.lang.String uri = nsContext.getNamespaceURI(prefix);
          if (uri == null || uri.length() == 0) {
            break;
          }
          prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
      return prefix;
    }

    /** Factory class that keeps the parse method */
    public static class Factory {
      private static org.apache.commons.logging.Log log =
          org.apache.commons.logging.LogFactory.getLog(Factory.class);

      /**
       * static method to create the object Precondition: If this object is an element, the current
       * or next start element starts this object and any intervening reader events are ignorable If
       * this object is not an element, it is a complex type and the reader is at the event just
       * after the outer start element Postcondition: If this object is an element, the reader is
       * positioned at its end element If this object is a complex type, the reader is positioned at
       * the end element of its outer element
       */
      public static GetStateResponse parse(javax.xml.stream.XMLStreamReader reader)
          throws java.lang.Exception {
        GetStateResponse object = new GetStateResponse();

        int event;
        javax.xml.namespace.QName currentQName = null;
        java.lang.String nillableValue = null;
        java.lang.String prefix = "";
        java.lang.String namespaceuri = "";
        try {

          while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

          currentQName = reader.getName();

          if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type")
              != null) {
            java.lang.String fullTypeName =
                reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
            if (fullTypeName != null) {
              java.lang.String nsPrefix = null;
              if (fullTypeName.indexOf(":") > -1) {
                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
              }
              nsPrefix = nsPrefix == null ? "" : nsPrefix;

              java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

              if (!"getStateResponse".equals(type)) {
                // find namespace for the prefix
                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                return (GetStateResponse) ExtensionMapper.getTypeObject(nsUri, type, reader);
              }
            }
          }

          // Note all attributes that were handled. Used to differ normal attributes
          // from anyAttributes.
          java.util.Vector handledAttributes = new java.util.Vector();

          reader.next();

          while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

          if (reader.isStartElement()
              && new javax.xml.namespace.QName("", "getStateReturn").equals(reader.getName())) {

            nillableValue =
                reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
            if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

              java.lang.String content = reader.getElementText();

              object.setGetStateReturn(
                  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

            } else {

              reader.getElementText(); // throw away text nodes if any.
            }

            reader.next();

          } // End of if for expected property start element
          else {
            // 1 - A start element we are not expecting indicates an invalid parameter was passed
            throw new org.apache.axis2.databinding.ADBException(
                "Unexpected subelement " + reader.getName());
          }

          while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

          if (reader.isStartElement())
            // 2 - A start element we are not expecting indicates a trailing invalid property

            throw new org.apache.axis2.databinding.ADBException(
                "Unexpected subelement " + reader.getName());

        } catch (javax.xml.stream.XMLStreamException e) {
          throw new java.lang.Exception(e);
        }

        return object;
      }
    } // end of factory class
  }

  public static class GetVersionMayorResponse implements org.apache.axis2.databinding.ADBBean {

    public static final javax.xml.namespace.QName MY_QNAME =
        new javax.xml.namespace.QName("http://DefaultNamespace", "getVersionMayorResponse", "ns1");

    /** field for GetVersionMayorReturn */
    protected java.lang.String localGetVersionMayorReturn;

    /**
     * Auto generated getter method
     *
     * @return java.lang.String
     */
    public java.lang.String getGetVersionMayorReturn() {
      return localGetVersionMayorReturn;
    }

    /**
     * Auto generated setter method
     *
     * @param param GetVersionMayorReturn
     */
    public void setGetVersionMayorReturn(java.lang.String param) {

      this.localGetVersionMayorReturn = param;
    }

    /**
     * @param parentQName
     * @param factory
     * @return org.apache.axiom.om.OMElement
     */
    public org.apache.axiom.om.OMElement getOMElement(
        final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory)
        throws org.apache.axis2.databinding.ADBException {

      return factory.createOMElement(
          new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME));
    }

    public void serialize(
        final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
      serialize(parentQName, xmlWriter, false);
    }

    public void serialize(
        final javax.xml.namespace.QName parentQName,
        javax.xml.stream.XMLStreamWriter xmlWriter,
        boolean serializeType)
        throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

      java.lang.String prefix = null;
      java.lang.String namespace = null;

      prefix = parentQName.getPrefix();
      namespace = parentQName.getNamespaceURI();
      writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

      if (serializeType) {

        java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://DefaultNamespace");
        if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
          writeAttribute(
              "xsi",
              "http://www.w3.org/2001/XMLSchema-instance",
              "type",
              namespacePrefix + ":getVersionMayorResponse",
              xmlWriter);
        } else {
          writeAttribute(
              "xsi",
              "http://www.w3.org/2001/XMLSchema-instance",
              "type",
              "getVersionMayorResponse",
              xmlWriter);
        }
      }

      namespace = "";
      writeStartElement(null, namespace, "getVersionMayorReturn", xmlWriter);

      if (localGetVersionMayorReturn == null) {
        // write the nil attribute

        writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

      } else {

        xmlWriter.writeCharacters(localGetVersionMayorReturn);
      }

      xmlWriter.writeEndElement();

      xmlWriter.writeEndElement();
    }

    private static java.lang.String generatePrefix(java.lang.String namespace) {
      if (namespace.equals("http://DefaultNamespace")) {
        return "ns1";
      }
      return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
    }

    /** Utility method to write an element start tag. */
    private void writeStartElement(
        java.lang.String prefix,
        java.lang.String namespace,
        java.lang.String localPart,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
      if (writerPrefix != null) {
        xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
      } else {
        if (namespace.length() == 0) {
          prefix = "";
        } else if (prefix == null) {
          prefix = generatePrefix(namespace);
        }

        xmlWriter.writeStartElement(prefix, localPart, namespace);
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
    }

    /** Util method to write an attribute with the ns prefix */
    private void writeAttribute(
        java.lang.String prefix,
        java.lang.String namespace,
        java.lang.String attName,
        java.lang.String attValue,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
      if (writerPrefix != null) {
        xmlWriter.writeAttribute(writerPrefix, namespace, attName, attValue);
      } else {
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
        xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
      }
    }

    /** Util method to write an attribute without the ns prefix */
    private void writeAttribute(
        java.lang.String namespace,
        java.lang.String attName,
        java.lang.String attValue,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      if (namespace.equals("")) {
        xmlWriter.writeAttribute(attName, attValue);
      } else {
        xmlWriter.writeAttribute(
            registerPrefix(xmlWriter, namespace), namespace, attName, attValue);
      }
    }

    /** Util method to write an attribute without the ns prefix */
    private void writeQNameAttribute(
        java.lang.String namespace,
        java.lang.String attName,
        javax.xml.namespace.QName qname,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {

      java.lang.String attributeNamespace = qname.getNamespaceURI();
      java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
      if (attributePrefix == null) {
        attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
      }
      java.lang.String attributeValue;
      if (attributePrefix.trim().length() > 0) {
        attributeValue = attributePrefix + ":" + qname.getLocalPart();
      } else {
        attributeValue = qname.getLocalPart();
      }

      if (namespace.equals("")) {
        xmlWriter.writeAttribute(attName, attributeValue);
      } else {
        registerPrefix(xmlWriter, namespace);
        xmlWriter.writeAttribute(attributePrefix, namespace, attName, attributeValue);
      }
    }
    /** method to handle Qnames */
    private void writeQName(
        javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String namespaceURI = qname.getNamespaceURI();
      if (namespaceURI != null) {
        java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
        if (prefix == null) {
          prefix = generatePrefix(namespaceURI);
          xmlWriter.writeNamespace(prefix, namespaceURI);
          xmlWriter.setPrefix(prefix, namespaceURI);
        }

        if (prefix.trim().length() > 0) {
          xmlWriter.writeCharacters(
              prefix
                  + ":"
                  + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
        } else {
          // i.e this is the default namespace
          xmlWriter.writeCharacters(
              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
        }

      } else {
        xmlWriter.writeCharacters(
            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
      }
    }

    private void writeQNames(
        javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {

      if (qnames != null) {
        // we have to store this data until last moment since it is not possible to write any
        // namespace data after writing the charactor data
        java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
        java.lang.String namespaceURI = null;
        java.lang.String prefix = null;

        for (int i = 0; i < qnames.length; i++) {
          if (i > 0) {
            stringToWrite.append(" ");
          }
          namespaceURI = qnames[i].getNamespaceURI();
          if (namespaceURI != null) {
            prefix = xmlWriter.getPrefix(namespaceURI);
            if ((prefix == null) || (prefix.length() == 0)) {
              prefix = generatePrefix(namespaceURI);
              xmlWriter.writeNamespace(prefix, namespaceURI);
              xmlWriter.setPrefix(prefix, namespaceURI);
            }

            if (prefix.trim().length() > 0) {
              stringToWrite
                  .append(prefix)
                  .append(":")
                  .append(
                      org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
            } else {
              stringToWrite.append(
                  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
            }
          } else {
            stringToWrite.append(
                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
          }
        }
        xmlWriter.writeCharacters(stringToWrite.toString());
      }
    }

    /** Register a namespace prefix */
    private java.lang.String registerPrefix(
        javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String prefix = xmlWriter.getPrefix(namespace);
      if (prefix == null) {
        prefix = generatePrefix(namespace);
        javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
        while (true) {
          java.lang.String uri = nsContext.getNamespaceURI(prefix);
          if (uri == null || uri.length() == 0) {
            break;
          }
          prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
      return prefix;
    }

    /** Factory class that keeps the parse method */
    public static class Factory {
      private static org.apache.commons.logging.Log log =
          org.apache.commons.logging.LogFactory.getLog(Factory.class);

      /**
       * static method to create the object Precondition: If this object is an element, the current
       * or next start element starts this object and any intervening reader events are ignorable If
       * this object is not an element, it is a complex type and the reader is at the event just
       * after the outer start element Postcondition: If this object is an element, the reader is
       * positioned at its end element If this object is a complex type, the reader is positioned at
       * the end element of its outer element
       */
      public static GetVersionMayorResponse parse(javax.xml.stream.XMLStreamReader reader)
          throws java.lang.Exception {
        GetVersionMayorResponse object = new GetVersionMayorResponse();

        int event;
        javax.xml.namespace.QName currentQName = null;
        java.lang.String nillableValue = null;
        java.lang.String prefix = "";
        java.lang.String namespaceuri = "";
        try {

          while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

          currentQName = reader.getName();

          if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type")
              != null) {
            java.lang.String fullTypeName =
                reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
            if (fullTypeName != null) {
              java.lang.String nsPrefix = null;
              if (fullTypeName.indexOf(":") > -1) {
                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
              }
              nsPrefix = nsPrefix == null ? "" : nsPrefix;

              java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

              if (!"getVersionMayorResponse".equals(type)) {
                // find namespace for the prefix
                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                return (GetVersionMayorResponse) ExtensionMapper.getTypeObject(nsUri, type, reader);
              }
            }
          }

          // Note all attributes that were handled. Used to differ normal attributes
          // from anyAttributes.
          java.util.Vector handledAttributes = new java.util.Vector();

          reader.next();

          while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

          if (reader.isStartElement()
              && new javax.xml.namespace.QName("", "getVersionMayorReturn")
                  .equals(reader.getName())) {

            nillableValue =
                reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
            if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

              java.lang.String content = reader.getElementText();

              object.setGetVersionMayorReturn(
                  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

            } else {

              reader.getElementText(); // throw away text nodes if any.
            }

            reader.next();

          } // End of if for expected property start element
          else {
            // 1 - A start element we are not expecting indicates an invalid parameter was passed
            throw new org.apache.axis2.databinding.ADBException(
                "Unexpected subelement " + reader.getName());
          }

          while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

          if (reader.isStartElement())
            // 2 - A start element we are not expecting indicates a trailing invalid property

            throw new org.apache.axis2.databinding.ADBException(
                "Unexpected subelement " + reader.getName());

        } catch (javax.xml.stream.XMLStreamException e) {
          throw new java.lang.Exception(e);
        }

        return object;
      }
    } // end of factory class
  }

  public static class GetVersionResponse implements org.apache.axis2.databinding.ADBBean {

    public static final javax.xml.namespace.QName MY_QNAME =
        new javax.xml.namespace.QName("http://DefaultNamespace", "getVersionResponse", "ns1");

    /** field for GetVersionReturn */
    protected java.lang.String localGetVersionReturn;

    /**
     * Auto generated getter method
     *
     * @return java.lang.String
     */
    public java.lang.String getGetVersionReturn() {
      return localGetVersionReturn;
    }

    /**
     * Auto generated setter method
     *
     * @param param GetVersionReturn
     */
    public void setGetVersionReturn(java.lang.String param) {

      this.localGetVersionReturn = param;
    }

    /**
     * @param parentQName
     * @param factory
     * @return org.apache.axiom.om.OMElement
     */
    public org.apache.axiom.om.OMElement getOMElement(
        final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory)
        throws org.apache.axis2.databinding.ADBException {

      return factory.createOMElement(
          new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME));
    }

    public void serialize(
        final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
      serialize(parentQName, xmlWriter, false);
    }

    public void serialize(
        final javax.xml.namespace.QName parentQName,
        javax.xml.stream.XMLStreamWriter xmlWriter,
        boolean serializeType)
        throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

      java.lang.String prefix = null;
      java.lang.String namespace = null;

      prefix = parentQName.getPrefix();
      namespace = parentQName.getNamespaceURI();
      writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

      if (serializeType) {

        java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://DefaultNamespace");
        if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
          writeAttribute(
              "xsi",
              "http://www.w3.org/2001/XMLSchema-instance",
              "type",
              namespacePrefix + ":getVersionResponse",
              xmlWriter);
        } else {
          writeAttribute(
              "xsi",
              "http://www.w3.org/2001/XMLSchema-instance",
              "type",
              "getVersionResponse",
              xmlWriter);
        }
      }

      namespace = "";
      writeStartElement(null, namespace, "getVersionReturn", xmlWriter);

      if (localGetVersionReturn == null) {
        // write the nil attribute

        writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

      } else {

        xmlWriter.writeCharacters(localGetVersionReturn);
      }

      xmlWriter.writeEndElement();

      xmlWriter.writeEndElement();
    }

    private static java.lang.String generatePrefix(java.lang.String namespace) {
      if (namespace.equals("http://DefaultNamespace")) {
        return "ns1";
      }
      return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
    }

    /** Utility method to write an element start tag. */
    private void writeStartElement(
        java.lang.String prefix,
        java.lang.String namespace,
        java.lang.String localPart,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
      if (writerPrefix != null) {
        xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
      } else {
        if (namespace.length() == 0) {
          prefix = "";
        } else if (prefix == null) {
          prefix = generatePrefix(namespace);
        }

        xmlWriter.writeStartElement(prefix, localPart, namespace);
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
    }

    /** Util method to write an attribute with the ns prefix */
    private void writeAttribute(
        java.lang.String prefix,
        java.lang.String namespace,
        java.lang.String attName,
        java.lang.String attValue,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
      if (writerPrefix != null) {
        xmlWriter.writeAttribute(writerPrefix, namespace, attName, attValue);
      } else {
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
        xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
      }
    }

    /** Util method to write an attribute without the ns prefix */
    private void writeAttribute(
        java.lang.String namespace,
        java.lang.String attName,
        java.lang.String attValue,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      if (namespace.equals("")) {
        xmlWriter.writeAttribute(attName, attValue);
      } else {
        xmlWriter.writeAttribute(
            registerPrefix(xmlWriter, namespace), namespace, attName, attValue);
      }
    }

    /** Util method to write an attribute without the ns prefix */
    private void writeQNameAttribute(
        java.lang.String namespace,
        java.lang.String attName,
        javax.xml.namespace.QName qname,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {

      java.lang.String attributeNamespace = qname.getNamespaceURI();
      java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
      if (attributePrefix == null) {
        attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
      }
      java.lang.String attributeValue;
      if (attributePrefix.trim().length() > 0) {
        attributeValue = attributePrefix + ":" + qname.getLocalPart();
      } else {
        attributeValue = qname.getLocalPart();
      }

      if (namespace.equals("")) {
        xmlWriter.writeAttribute(attName, attributeValue);
      } else {
        registerPrefix(xmlWriter, namespace);
        xmlWriter.writeAttribute(attributePrefix, namespace, attName, attributeValue);
      }
    }
    /** method to handle Qnames */
    private void writeQName(
        javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String namespaceURI = qname.getNamespaceURI();
      if (namespaceURI != null) {
        java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
        if (prefix == null) {
          prefix = generatePrefix(namespaceURI);
          xmlWriter.writeNamespace(prefix, namespaceURI);
          xmlWriter.setPrefix(prefix, namespaceURI);
        }

        if (prefix.trim().length() > 0) {
          xmlWriter.writeCharacters(
              prefix
                  + ":"
                  + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
        } else {
          // i.e this is the default namespace
          xmlWriter.writeCharacters(
              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
        }

      } else {
        xmlWriter.writeCharacters(
            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
      }
    }

    private void writeQNames(
        javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {

      if (qnames != null) {
        // we have to store this data until last moment since it is not possible to write any
        // namespace data after writing the charactor data
        java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
        java.lang.String namespaceURI = null;
        java.lang.String prefix = null;

        for (int i = 0; i < qnames.length; i++) {
          if (i > 0) {
            stringToWrite.append(" ");
          }
          namespaceURI = qnames[i].getNamespaceURI();
          if (namespaceURI != null) {
            prefix = xmlWriter.getPrefix(namespaceURI);
            if ((prefix == null) || (prefix.length() == 0)) {
              prefix = generatePrefix(namespaceURI);
              xmlWriter.writeNamespace(prefix, namespaceURI);
              xmlWriter.setPrefix(prefix, namespaceURI);
            }

            if (prefix.trim().length() > 0) {
              stringToWrite
                  .append(prefix)
                  .append(":")
                  .append(
                      org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
            } else {
              stringToWrite.append(
                  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
            }
          } else {
            stringToWrite.append(
                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
          }
        }
        xmlWriter.writeCharacters(stringToWrite.toString());
      }
    }

    /** Register a namespace prefix */
    private java.lang.String registerPrefix(
        javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String prefix = xmlWriter.getPrefix(namespace);
      if (prefix == null) {
        prefix = generatePrefix(namespace);
        javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
        while (true) {
          java.lang.String uri = nsContext.getNamespaceURI(prefix);
          if (uri == null || uri.length() == 0) {
            break;
          }
          prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
      return prefix;
    }

    /** Factory class that keeps the parse method */
    public static class Factory {
      private static org.apache.commons.logging.Log log =
          org.apache.commons.logging.LogFactory.getLog(Factory.class);

      /**
       * static method to create the object Precondition: If this object is an element, the current
       * or next start element starts this object and any intervening reader events are ignorable If
       * this object is not an element, it is a complex type and the reader is at the event just
       * after the outer start element Postcondition: If this object is an element, the reader is
       * positioned at its end element If this object is a complex type, the reader is positioned at
       * the end element of its outer element
       */
      public static GetVersionResponse parse(javax.xml.stream.XMLStreamReader reader)
          throws java.lang.Exception {
        GetVersionResponse object = new GetVersionResponse();

        int event;
        javax.xml.namespace.QName currentQName = null;
        java.lang.String nillableValue = null;
        java.lang.String prefix = "";
        java.lang.String namespaceuri = "";
        try {

          while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

          currentQName = reader.getName();

          if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type")
              != null) {
            java.lang.String fullTypeName =
                reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
            if (fullTypeName != null) {
              java.lang.String nsPrefix = null;
              if (fullTypeName.indexOf(":") > -1) {
                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
              }
              nsPrefix = nsPrefix == null ? "" : nsPrefix;

              java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

              if (!"getVersionResponse".equals(type)) {
                // find namespace for the prefix
                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                return (GetVersionResponse) ExtensionMapper.getTypeObject(nsUri, type, reader);
              }
            }
          }

          // Note all attributes that were handled. Used to differ normal attributes
          // from anyAttributes.
          java.util.Vector handledAttributes = new java.util.Vector();

          reader.next();

          while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

          if (reader.isStartElement()
              && new javax.xml.namespace.QName("", "getVersionReturn").equals(reader.getName())) {

            nillableValue =
                reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
            if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

              java.lang.String content = reader.getElementText();

              object.setGetVersionReturn(
                  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

            } else {

              reader.getElementText(); // throw away text nodes if any.
            }

            reader.next();

          } // End of if for expected property start element
          else {
            // 1 - A start element we are not expecting indicates an invalid parameter was passed
            throw new org.apache.axis2.databinding.ADBException(
                "Unexpected subelement " + reader.getName());
          }

          while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

          if (reader.isStartElement())
            // 2 - A start element we are not expecting indicates a trailing invalid property

            throw new org.apache.axis2.databinding.ADBException(
                "Unexpected subelement " + reader.getName());

        } catch (javax.xml.stream.XMLStreamException e) {
          throw new java.lang.Exception(e);
        }

        return object;
      }
    } // end of factory class
  }

  public static class GetVersionPatch implements org.apache.axis2.databinding.ADBBean {

    public static final javax.xml.namespace.QName MY_QNAME =
        new javax.xml.namespace.QName("http://DefaultNamespace", "getVersionPatch", "ns1");

    /**
     * @param parentQName
     * @param factory
     * @return org.apache.axiom.om.OMElement
     */
    public org.apache.axiom.om.OMElement getOMElement(
        final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory)
        throws org.apache.axis2.databinding.ADBException {

      return factory.createOMElement(
          new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME));
    }

    public void serialize(
        final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
      serialize(parentQName, xmlWriter, false);
    }

    public void serialize(
        final javax.xml.namespace.QName parentQName,
        javax.xml.stream.XMLStreamWriter xmlWriter,
        boolean serializeType)
        throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

      java.lang.String prefix = null;
      java.lang.String namespace = null;

      prefix = parentQName.getPrefix();
      namespace = parentQName.getNamespaceURI();
      writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

      if (serializeType) {

        java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://DefaultNamespace");
        if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
          writeAttribute(
              "xsi",
              "http://www.w3.org/2001/XMLSchema-instance",
              "type",
              namespacePrefix + ":getVersionPatch",
              xmlWriter);
        } else {
          writeAttribute(
              "xsi",
              "http://www.w3.org/2001/XMLSchema-instance",
              "type",
              "getVersionPatch",
              xmlWriter);
        }
      }

      xmlWriter.writeEndElement();
    }

    private static java.lang.String generatePrefix(java.lang.String namespace) {
      if (namespace.equals("http://DefaultNamespace")) {
        return "ns1";
      }
      return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
    }

    /** Utility method to write an element start tag. */
    private void writeStartElement(
        java.lang.String prefix,
        java.lang.String namespace,
        java.lang.String localPart,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
      if (writerPrefix != null) {
        xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
      } else {
        if (namespace.length() == 0) {
          prefix = "";
        } else if (prefix == null) {
          prefix = generatePrefix(namespace);
        }

        xmlWriter.writeStartElement(prefix, localPart, namespace);
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
    }

    /** Util method to write an attribute with the ns prefix */
    private void writeAttribute(
        java.lang.String prefix,
        java.lang.String namespace,
        java.lang.String attName,
        java.lang.String attValue,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
      if (writerPrefix != null) {
        xmlWriter.writeAttribute(writerPrefix, namespace, attName, attValue);
      } else {
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
        xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
      }
    }

    /** Util method to write an attribute without the ns prefix */
    private void writeAttribute(
        java.lang.String namespace,
        java.lang.String attName,
        java.lang.String attValue,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      if (namespace.equals("")) {
        xmlWriter.writeAttribute(attName, attValue);
      } else {
        xmlWriter.writeAttribute(
            registerPrefix(xmlWriter, namespace), namespace, attName, attValue);
      }
    }

    /** Util method to write an attribute without the ns prefix */
    private void writeQNameAttribute(
        java.lang.String namespace,
        java.lang.String attName,
        javax.xml.namespace.QName qname,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {

      java.lang.String attributeNamespace = qname.getNamespaceURI();
      java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
      if (attributePrefix == null) {
        attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
      }
      java.lang.String attributeValue;
      if (attributePrefix.trim().length() > 0) {
        attributeValue = attributePrefix + ":" + qname.getLocalPart();
      } else {
        attributeValue = qname.getLocalPart();
      }

      if (namespace.equals("")) {
        xmlWriter.writeAttribute(attName, attributeValue);
      } else {
        registerPrefix(xmlWriter, namespace);
        xmlWriter.writeAttribute(attributePrefix, namespace, attName, attributeValue);
      }
    }
    /** method to handle Qnames */
    private void writeQName(
        javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String namespaceURI = qname.getNamespaceURI();
      if (namespaceURI != null) {
        java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
        if (prefix == null) {
          prefix = generatePrefix(namespaceURI);
          xmlWriter.writeNamespace(prefix, namespaceURI);
          xmlWriter.setPrefix(prefix, namespaceURI);
        }

        if (prefix.trim().length() > 0) {
          xmlWriter.writeCharacters(
              prefix
                  + ":"
                  + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
        } else {
          // i.e this is the default namespace
          xmlWriter.writeCharacters(
              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
        }

      } else {
        xmlWriter.writeCharacters(
            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
      }
    }

    private void writeQNames(
        javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {

      if (qnames != null) {
        // we have to store this data until last moment since it is not possible to write any
        // namespace data after writing the charactor data
        java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
        java.lang.String namespaceURI = null;
        java.lang.String prefix = null;

        for (int i = 0; i < qnames.length; i++) {
          if (i > 0) {
            stringToWrite.append(" ");
          }
          namespaceURI = qnames[i].getNamespaceURI();
          if (namespaceURI != null) {
            prefix = xmlWriter.getPrefix(namespaceURI);
            if ((prefix == null) || (prefix.length() == 0)) {
              prefix = generatePrefix(namespaceURI);
              xmlWriter.writeNamespace(prefix, namespaceURI);
              xmlWriter.setPrefix(prefix, namespaceURI);
            }

            if (prefix.trim().length() > 0) {
              stringToWrite
                  .append(prefix)
                  .append(":")
                  .append(
                      org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
            } else {
              stringToWrite.append(
                  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
            }
          } else {
            stringToWrite.append(
                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
          }
        }
        xmlWriter.writeCharacters(stringToWrite.toString());
      }
    }

    /** Register a namespace prefix */
    private java.lang.String registerPrefix(
        javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String prefix = xmlWriter.getPrefix(namespace);
      if (prefix == null) {
        prefix = generatePrefix(namespace);
        javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
        while (true) {
          java.lang.String uri = nsContext.getNamespaceURI(prefix);
          if (uri == null || uri.length() == 0) {
            break;
          }
          prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
      return prefix;
    }

    /** Factory class that keeps the parse method */
    public static class Factory {
      private static org.apache.commons.logging.Log log =
          org.apache.commons.logging.LogFactory.getLog(Factory.class);

      /**
       * static method to create the object Precondition: If this object is an element, the current
       * or next start element starts this object and any intervening reader events are ignorable If
       * this object is not an element, it is a complex type and the reader is at the event just
       * after the outer start element Postcondition: If this object is an element, the reader is
       * positioned at its end element If this object is a complex type, the reader is positioned at
       * the end element of its outer element
       */
      public static GetVersionPatch parse(javax.xml.stream.XMLStreamReader reader)
          throws java.lang.Exception {
        GetVersionPatch object = new GetVersionPatch();

        int event;
        javax.xml.namespace.QName currentQName = null;
        java.lang.String nillableValue = null;
        java.lang.String prefix = "";
        java.lang.String namespaceuri = "";
        try {

          while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

          currentQName = reader.getName();

          if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type")
              != null) {
            java.lang.String fullTypeName =
                reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
            if (fullTypeName != null) {
              java.lang.String nsPrefix = null;
              if (fullTypeName.indexOf(":") > -1) {
                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
              }
              nsPrefix = nsPrefix == null ? "" : nsPrefix;

              java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

              if (!"getVersionPatch".equals(type)) {
                // find namespace for the prefix
                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                return (GetVersionPatch) ExtensionMapper.getTypeObject(nsUri, type, reader);
              }
            }
          }

          // Note all attributes that were handled. Used to differ normal attributes
          // from anyAttributes.
          java.util.Vector handledAttributes = new java.util.Vector();

          reader.next();

          while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

          if (reader.isStartElement())
            // 2 - A start element we are not expecting indicates a trailing invalid property

            throw new org.apache.axis2.databinding.ADBException(
                "Unexpected subelement " + reader.getName());

        } catch (javax.xml.stream.XMLStreamException e) {
          throw new java.lang.Exception(e);
        }

        return object;
      }
    } // end of factory class
  }

  public static class GetEstDteAvResponse implements org.apache.axis2.databinding.ADBBean {

    public static final javax.xml.namespace.QName MY_QNAME =
        new javax.xml.namespace.QName("http://DefaultNamespace", "getEstDteAvResponse", "ns1");

    /** field for GetEstDteAvReturn */
    protected java.lang.String localGetEstDteAvReturn;

    /**
     * Auto generated getter method
     *
     * @return java.lang.String
     */
    public java.lang.String getGetEstDteAvReturn() {
      return localGetEstDteAvReturn;
    }

    /**
     * Auto generated setter method
     *
     * @param param GetEstDteAvReturn
     */
    public void setGetEstDteAvReturn(java.lang.String param) {

      this.localGetEstDteAvReturn = param;
    }

    /**
     * @param parentQName
     * @param factory
     * @return org.apache.axiom.om.OMElement
     */
    public org.apache.axiom.om.OMElement getOMElement(
        final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory)
        throws org.apache.axis2.databinding.ADBException {

      return factory.createOMElement(
          new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME));
    }

    public void serialize(
        final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
      serialize(parentQName, xmlWriter, false);
    }

    public void serialize(
        final javax.xml.namespace.QName parentQName,
        javax.xml.stream.XMLStreamWriter xmlWriter,
        boolean serializeType)
        throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

      java.lang.String prefix = null;
      java.lang.String namespace = null;

      prefix = parentQName.getPrefix();
      namespace = parentQName.getNamespaceURI();
      writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

      if (serializeType) {

        java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://DefaultNamespace");
        if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
          writeAttribute(
              "xsi",
              "http://www.w3.org/2001/XMLSchema-instance",
              "type",
              namespacePrefix + ":getEstDteAvResponse",
              xmlWriter);
        } else {
          writeAttribute(
              "xsi",
              "http://www.w3.org/2001/XMLSchema-instance",
              "type",
              "getEstDteAvResponse",
              xmlWriter);
        }
      }

      namespace = "";
      writeStartElement(null, namespace, "getEstDteAvReturn", xmlWriter);

      if (localGetEstDteAvReturn == null) {
        // write the nil attribute

        writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

      } else {

        xmlWriter.writeCharacters(localGetEstDteAvReturn);
      }

      xmlWriter.writeEndElement();

      xmlWriter.writeEndElement();
    }

    private static java.lang.String generatePrefix(java.lang.String namespace) {
      if (namespace.equals("http://DefaultNamespace")) {
        return "ns1";
      }
      return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
    }

    /** Utility method to write an element start tag. */
    private void writeStartElement(
        java.lang.String prefix,
        java.lang.String namespace,
        java.lang.String localPart,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
      if (writerPrefix != null) {
        xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
      } else {
        if (namespace.length() == 0) {
          prefix = "";
        } else if (prefix == null) {
          prefix = generatePrefix(namespace);
        }

        xmlWriter.writeStartElement(prefix, localPart, namespace);
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
    }

    /** Util method to write an attribute with the ns prefix */
    private void writeAttribute(
        java.lang.String prefix,
        java.lang.String namespace,
        java.lang.String attName,
        java.lang.String attValue,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
      if (writerPrefix != null) {
        xmlWriter.writeAttribute(writerPrefix, namespace, attName, attValue);
      } else {
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
        xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
      }
    }

    /** Util method to write an attribute without the ns prefix */
    private void writeAttribute(
        java.lang.String namespace,
        java.lang.String attName,
        java.lang.String attValue,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      if (namespace.equals("")) {
        xmlWriter.writeAttribute(attName, attValue);
      } else {
        xmlWriter.writeAttribute(
            registerPrefix(xmlWriter, namespace), namespace, attName, attValue);
      }
    }

    /** Util method to write an attribute without the ns prefix */
    private void writeQNameAttribute(
        java.lang.String namespace,
        java.lang.String attName,
        javax.xml.namespace.QName qname,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {

      java.lang.String attributeNamespace = qname.getNamespaceURI();
      java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
      if (attributePrefix == null) {
        attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
      }
      java.lang.String attributeValue;
      if (attributePrefix.trim().length() > 0) {
        attributeValue = attributePrefix + ":" + qname.getLocalPart();
      } else {
        attributeValue = qname.getLocalPart();
      }

      if (namespace.equals("")) {
        xmlWriter.writeAttribute(attName, attributeValue);
      } else {
        registerPrefix(xmlWriter, namespace);
        xmlWriter.writeAttribute(attributePrefix, namespace, attName, attributeValue);
      }
    }
    /** method to handle Qnames */
    private void writeQName(
        javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String namespaceURI = qname.getNamespaceURI();
      if (namespaceURI != null) {
        java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
        if (prefix == null) {
          prefix = generatePrefix(namespaceURI);
          xmlWriter.writeNamespace(prefix, namespaceURI);
          xmlWriter.setPrefix(prefix, namespaceURI);
        }

        if (prefix.trim().length() > 0) {
          xmlWriter.writeCharacters(
              prefix
                  + ":"
                  + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
        } else {
          // i.e this is the default namespace
          xmlWriter.writeCharacters(
              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
        }

      } else {
        xmlWriter.writeCharacters(
            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
      }
    }

    private void writeQNames(
        javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {

      if (qnames != null) {
        // we have to store this data until last moment since it is not possible to write any
        // namespace data after writing the charactor data
        java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
        java.lang.String namespaceURI = null;
        java.lang.String prefix = null;

        for (int i = 0; i < qnames.length; i++) {
          if (i > 0) {
            stringToWrite.append(" ");
          }
          namespaceURI = qnames[i].getNamespaceURI();
          if (namespaceURI != null) {
            prefix = xmlWriter.getPrefix(namespaceURI);
            if ((prefix == null) || (prefix.length() == 0)) {
              prefix = generatePrefix(namespaceURI);
              xmlWriter.writeNamespace(prefix, namespaceURI);
              xmlWriter.setPrefix(prefix, namespaceURI);
            }

            if (prefix.trim().length() > 0) {
              stringToWrite
                  .append(prefix)
                  .append(":")
                  .append(
                      org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
            } else {
              stringToWrite.append(
                  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
            }
          } else {
            stringToWrite.append(
                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
          }
        }
        xmlWriter.writeCharacters(stringToWrite.toString());
      }
    }

    /** Register a namespace prefix */
    private java.lang.String registerPrefix(
        javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String prefix = xmlWriter.getPrefix(namespace);
      if (prefix == null) {
        prefix = generatePrefix(namespace);
        javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
        while (true) {
          java.lang.String uri = nsContext.getNamespaceURI(prefix);
          if (uri == null || uri.length() == 0) {
            break;
          }
          prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
      return prefix;
    }

    /** Factory class that keeps the parse method */
    public static class Factory {
      private static org.apache.commons.logging.Log log =
          org.apache.commons.logging.LogFactory.getLog(Factory.class);

      /**
       * static method to create the object Precondition: If this object is an element, the current
       * or next start element starts this object and any intervening reader events are ignorable If
       * this object is not an element, it is a complex type and the reader is at the event just
       * after the outer start element Postcondition: If this object is an element, the reader is
       * positioned at its end element If this object is a complex type, the reader is positioned at
       * the end element of its outer element
       */
      public static GetEstDteAvResponse parse(javax.xml.stream.XMLStreamReader reader)
          throws java.lang.Exception {
        GetEstDteAvResponse object = new GetEstDteAvResponse();

        int event;
        javax.xml.namespace.QName currentQName = null;
        java.lang.String nillableValue = null;
        java.lang.String prefix = "";
        java.lang.String namespaceuri = "";
        try {

          while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

          currentQName = reader.getName();

          if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type")
              != null) {
            java.lang.String fullTypeName =
                reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
            if (fullTypeName != null) {
              java.lang.String nsPrefix = null;
              if (fullTypeName.indexOf(":") > -1) {
                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
              }
              nsPrefix = nsPrefix == null ? "" : nsPrefix;

              java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

              if (!"getEstDteAvResponse".equals(type)) {
                // find namespace for the prefix
                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                return (GetEstDteAvResponse) ExtensionMapper.getTypeObject(nsUri, type, reader);
              }
            }
          }

          // Note all attributes that were handled. Used to differ normal attributes
          // from anyAttributes.
          java.util.Vector handledAttributes = new java.util.Vector();

          reader.next();

          while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

          if (reader.isStartElement()
              && new javax.xml.namespace.QName("", "getEstDteAvReturn").equals(reader.getName())) {

            nillableValue =
                reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
            if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

              java.lang.String content = reader.getElementText();

              object.setGetEstDteAvReturn(
                  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

            } else {

              reader.getElementText(); // throw away text nodes if any.
            }

            reader.next();

          } // End of if for expected property start element
          else {
            // 1 - A start element we are not expecting indicates an invalid parameter was passed
            throw new org.apache.axis2.databinding.ADBException(
                "Unexpected subelement " + reader.getName());
          }

          while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

          if (reader.isStartElement())
            // 2 - A start element we are not expecting indicates a trailing invalid property

            throw new org.apache.axis2.databinding.ADBException(
                "Unexpected subelement " + reader.getName());

        } catch (javax.xml.stream.XMLStreamException e) {
          throw new java.lang.Exception(e);
        }

        return object;
      }
    } // end of factory class
  }

  public static class GetVersion implements org.apache.axis2.databinding.ADBBean {

    public static final javax.xml.namespace.QName MY_QNAME =
        new javax.xml.namespace.QName("http://DefaultNamespace", "getVersion", "ns1");

    /**
     * @param parentQName
     * @param factory
     * @return org.apache.axiom.om.OMElement
     */
    public org.apache.axiom.om.OMElement getOMElement(
        final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory)
        throws org.apache.axis2.databinding.ADBException {

      return factory.createOMElement(
          new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME));
    }

    public void serialize(
        final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
      serialize(parentQName, xmlWriter, false);
    }

    public void serialize(
        final javax.xml.namespace.QName parentQName,
        javax.xml.stream.XMLStreamWriter xmlWriter,
        boolean serializeType)
        throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

      java.lang.String prefix = null;
      java.lang.String namespace = null;

      prefix = parentQName.getPrefix();
      namespace = parentQName.getNamespaceURI();
      writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

      if (serializeType) {

        java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://DefaultNamespace");
        if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
          writeAttribute(
              "xsi",
              "http://www.w3.org/2001/XMLSchema-instance",
              "type",
              namespacePrefix + ":getVersion",
              xmlWriter);
        } else {
          writeAttribute(
              "xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "getVersion", xmlWriter);
        }
      }

      xmlWriter.writeEndElement();
    }

    private static java.lang.String generatePrefix(java.lang.String namespace) {
      if (namespace.equals("http://DefaultNamespace")) {
        return "ns1";
      }
      return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
    }

    /** Utility method to write an element start tag. */
    private void writeStartElement(
        java.lang.String prefix,
        java.lang.String namespace,
        java.lang.String localPart,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
      if (writerPrefix != null) {
        xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
      } else {
        if (namespace.length() == 0) {
          prefix = "";
        } else if (prefix == null) {
          prefix = generatePrefix(namespace);
        }

        xmlWriter.writeStartElement(prefix, localPart, namespace);
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
    }

    /** Util method to write an attribute with the ns prefix */
    private void writeAttribute(
        java.lang.String prefix,
        java.lang.String namespace,
        java.lang.String attName,
        java.lang.String attValue,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
      if (writerPrefix != null) {
        xmlWriter.writeAttribute(writerPrefix, namespace, attName, attValue);
      } else {
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
        xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
      }
    }

    /** Util method to write an attribute without the ns prefix */
    private void writeAttribute(
        java.lang.String namespace,
        java.lang.String attName,
        java.lang.String attValue,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      if (namespace.equals("")) {
        xmlWriter.writeAttribute(attName, attValue);
      } else {
        xmlWriter.writeAttribute(
            registerPrefix(xmlWriter, namespace), namespace, attName, attValue);
      }
    }

    /** Util method to write an attribute without the ns prefix */
    private void writeQNameAttribute(
        java.lang.String namespace,
        java.lang.String attName,
        javax.xml.namespace.QName qname,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {

      java.lang.String attributeNamespace = qname.getNamespaceURI();
      java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
      if (attributePrefix == null) {
        attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
      }
      java.lang.String attributeValue;
      if (attributePrefix.trim().length() > 0) {
        attributeValue = attributePrefix + ":" + qname.getLocalPart();
      } else {
        attributeValue = qname.getLocalPart();
      }

      if (namespace.equals("")) {
        xmlWriter.writeAttribute(attName, attributeValue);
      } else {
        registerPrefix(xmlWriter, namespace);
        xmlWriter.writeAttribute(attributePrefix, namespace, attName, attributeValue);
      }
    }
    /** method to handle Qnames */
    private void writeQName(
        javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String namespaceURI = qname.getNamespaceURI();
      if (namespaceURI != null) {
        java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
        if (prefix == null) {
          prefix = generatePrefix(namespaceURI);
          xmlWriter.writeNamespace(prefix, namespaceURI);
          xmlWriter.setPrefix(prefix, namespaceURI);
        }

        if (prefix.trim().length() > 0) {
          xmlWriter.writeCharacters(
              prefix
                  + ":"
                  + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
        } else {
          // i.e this is the default namespace
          xmlWriter.writeCharacters(
              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
        }

      } else {
        xmlWriter.writeCharacters(
            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
      }
    }

    private void writeQNames(
        javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {

      if (qnames != null) {
        // we have to store this data until last moment since it is not possible to write any
        // namespace data after writing the charactor data
        java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
        java.lang.String namespaceURI = null;
        java.lang.String prefix = null;

        for (int i = 0; i < qnames.length; i++) {
          if (i > 0) {
            stringToWrite.append(" ");
          }
          namespaceURI = qnames[i].getNamespaceURI();
          if (namespaceURI != null) {
            prefix = xmlWriter.getPrefix(namespaceURI);
            if ((prefix == null) || (prefix.length() == 0)) {
              prefix = generatePrefix(namespaceURI);
              xmlWriter.writeNamespace(prefix, namespaceURI);
              xmlWriter.setPrefix(prefix, namespaceURI);
            }

            if (prefix.trim().length() > 0) {
              stringToWrite
                  .append(prefix)
                  .append(":")
                  .append(
                      org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
            } else {
              stringToWrite.append(
                  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
            }
          } else {
            stringToWrite.append(
                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
          }
        }
        xmlWriter.writeCharacters(stringToWrite.toString());
      }
    }

    /** Register a namespace prefix */
    private java.lang.String registerPrefix(
        javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String prefix = xmlWriter.getPrefix(namespace);
      if (prefix == null) {
        prefix = generatePrefix(namespace);
        javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
        while (true) {
          java.lang.String uri = nsContext.getNamespaceURI(prefix);
          if (uri == null || uri.length() == 0) {
            break;
          }
          prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
      return prefix;
    }

    /** Factory class that keeps the parse method */
    public static class Factory {
      private static org.apache.commons.logging.Log log =
          org.apache.commons.logging.LogFactory.getLog(Factory.class);

      /**
       * static method to create the object Precondition: If this object is an element, the current
       * or next start element starts this object and any intervening reader events are ignorable If
       * this object is not an element, it is a complex type and the reader is at the event just
       * after the outer start element Postcondition: If this object is an element, the reader is
       * positioned at its end element If this object is a complex type, the reader is positioned at
       * the end element of its outer element
       */
      public static GetVersion parse(javax.xml.stream.XMLStreamReader reader)
          throws java.lang.Exception {
        GetVersion object = new GetVersion();

        int event;
        javax.xml.namespace.QName currentQName = null;
        java.lang.String nillableValue = null;
        java.lang.String prefix = "";
        java.lang.String namespaceuri = "";
        try {

          while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

          currentQName = reader.getName();

          if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type")
              != null) {
            java.lang.String fullTypeName =
                reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
            if (fullTypeName != null) {
              java.lang.String nsPrefix = null;
              if (fullTypeName.indexOf(":") > -1) {
                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
              }
              nsPrefix = nsPrefix == null ? "" : nsPrefix;

              java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

              if (!"getVersion".equals(type)) {
                // find namespace for the prefix
                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                return (GetVersion) ExtensionMapper.getTypeObject(nsUri, type, reader);
              }
            }
          }

          // Note all attributes that were handled. Used to differ normal attributes
          // from anyAttributes.
          java.util.Vector handledAttributes = new java.util.Vector();

          reader.next();

          while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

          if (reader.isStartElement())
            // 2 - A start element we are not expecting indicates a trailing invalid property

            throw new org.apache.axis2.databinding.ADBException(
                "Unexpected subelement " + reader.getName());

        } catch (javax.xml.stream.XMLStreamException e) {
          throw new java.lang.Exception(e);
        }

        return object;
      }
    } // end of factory class
  }

  public static class GetEstDteAv implements org.apache.axis2.databinding.ADBBean {

    public static final javax.xml.namespace.QName MY_QNAME =
        new javax.xml.namespace.QName("http://DefaultNamespace", "getEstDteAv", "ns1");

    /** field for RutEmpresa */
    protected java.lang.String localRutEmpresa;

    /**
     * Auto generated getter method
     *
     * @return java.lang.String
     */
    public java.lang.String getRutEmpresa() {
      return localRutEmpresa;
    }

    /**
     * Auto generated setter method
     *
     * @param param RutEmpresa
     */
    public void setRutEmpresa(java.lang.String param) {

      this.localRutEmpresa = param;
    }

    /** field for DvEmpresa */
    protected java.lang.String localDvEmpresa;

    /**
     * Auto generated getter method
     *
     * @return java.lang.String
     */
    public java.lang.String getDvEmpresa() {
      return localDvEmpresa;
    }

    /**
     * Auto generated setter method
     *
     * @param param DvEmpresa
     */
    public void setDvEmpresa(java.lang.String param) {

      this.localDvEmpresa = param;
    }

    /** field for RutReceptor */
    protected java.lang.String localRutReceptor;

    /**
     * Auto generated getter method
     *
     * @return java.lang.String
     */
    public java.lang.String getRutReceptor() {
      return localRutReceptor;
    }

    /**
     * Auto generated setter method
     *
     * @param param RutReceptor
     */
    public void setRutReceptor(java.lang.String param) {

      this.localRutReceptor = param;
    }

    /** field for DvReceptor */
    protected java.lang.String localDvReceptor;

    /**
     * Auto generated getter method
     *
     * @return java.lang.String
     */
    public java.lang.String getDvReceptor() {
      return localDvReceptor;
    }

    /**
     * Auto generated setter method
     *
     * @param param DvReceptor
     */
    public void setDvReceptor(java.lang.String param) {

      this.localDvReceptor = param;
    }

    /** field for TipoDte */
    protected java.lang.String localTipoDte;

    /**
     * Auto generated getter method
     *
     * @return java.lang.String
     */
    public java.lang.String getTipoDte() {
      return localTipoDte;
    }

    /**
     * Auto generated setter method
     *
     * @param param TipoDte
     */
    public void setTipoDte(java.lang.String param) {

      this.localTipoDte = param;
    }

    /** field for FolioDte */
    protected java.lang.String localFolioDte;

    /**
     * Auto generated getter method
     *
     * @return java.lang.String
     */
    public java.lang.String getFolioDte() {
      return localFolioDte;
    }

    /**
     * Auto generated setter method
     *
     * @param param FolioDte
     */
    public void setFolioDte(java.lang.String param) {

      this.localFolioDte = param;
    }

    /** field for FechaEmisionDte */
    protected java.lang.String localFechaEmisionDte;

    /**
     * Auto generated getter method
     *
     * @return java.lang.String
     */
    public java.lang.String getFechaEmisionDte() {
      return localFechaEmisionDte;
    }

    /**
     * Auto generated setter method
     *
     * @param param FechaEmisionDte
     */
    public void setFechaEmisionDte(java.lang.String param) {

      this.localFechaEmisionDte = param;
    }

    /** field for MontoDte */
    protected java.lang.String localMontoDte;

    /**
     * Auto generated getter method
     *
     * @return java.lang.String
     */
    public java.lang.String getMontoDte() {
      return localMontoDte;
    }

    /**
     * Auto generated setter method
     *
     * @param param MontoDte
     */
    public void setMontoDte(java.lang.String param) {

      this.localMontoDte = param;
    }

    /** field for FirmaDte */
    protected java.lang.String localFirmaDte;

    /**
     * Auto generated getter method
     *
     * @return java.lang.String
     */
    public java.lang.String getFirmaDte() {
      return localFirmaDte;
    }

    /**
     * Auto generated setter method
     *
     * @param param FirmaDte
     */
    public void setFirmaDte(java.lang.String param) {

      this.localFirmaDte = param;
    }

    /** field for Token */
    protected java.lang.String localToken;

    /**
     * Auto generated getter method
     *
     * @return java.lang.String
     */
    public java.lang.String getToken() {
      return localToken;
    }

    /**
     * Auto generated setter method
     *
     * @param param Token
     */
    public void setToken(java.lang.String param) {

      this.localToken = param;
    }

    /**
     * @param parentQName
     * @param factory
     * @return org.apache.axiom.om.OMElement
     */
    public org.apache.axiom.om.OMElement getOMElement(
        final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory)
        throws org.apache.axis2.databinding.ADBException {

      return factory.createOMElement(
          new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME));
    }

    public void serialize(
        final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
      serialize(parentQName, xmlWriter, false);
    }

    public void serialize(
        final javax.xml.namespace.QName parentQName,
        javax.xml.stream.XMLStreamWriter xmlWriter,
        boolean serializeType)
        throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

      java.lang.String prefix = null;
      java.lang.String namespace = null;

      prefix = parentQName.getPrefix();
      namespace = parentQName.getNamespaceURI();
      writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

      if (serializeType) {

        java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://DefaultNamespace");
        if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
          writeAttribute(
              "xsi",
              "http://www.w3.org/2001/XMLSchema-instance",
              "type",
              namespacePrefix + ":getEstDteAv",
              xmlWriter);
        } else {
          writeAttribute(
              "xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "getEstDteAv", xmlWriter);
        }
      }

      namespace = "";
      writeStartElement(null, namespace, "RutEmpresa", xmlWriter);

      if (localRutEmpresa == null) {
        // write the nil attribute

        writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

      } else {

        xmlWriter.writeCharacters(localRutEmpresa);
      }

      xmlWriter.writeEndElement();

      namespace = "";
      writeStartElement(null, namespace, "DvEmpresa", xmlWriter);

      if (localDvEmpresa == null) {
        // write the nil attribute

        writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

      } else {

        xmlWriter.writeCharacters(localDvEmpresa);
      }

      xmlWriter.writeEndElement();

      namespace = "";
      writeStartElement(null, namespace, "RutReceptor", xmlWriter);

      if (localRutReceptor == null) {
        // write the nil attribute

        writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

      } else {

        xmlWriter.writeCharacters(localRutReceptor);
      }

      xmlWriter.writeEndElement();

      namespace = "";
      writeStartElement(null, namespace, "DvReceptor", xmlWriter);

      if (localDvReceptor == null) {
        // write the nil attribute

        writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

      } else {

        xmlWriter.writeCharacters(localDvReceptor);
      }

      xmlWriter.writeEndElement();

      namespace = "";
      writeStartElement(null, namespace, "TipoDte", xmlWriter);

      if (localTipoDte == null) {
        // write the nil attribute

        writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

      } else {

        xmlWriter.writeCharacters(localTipoDte);
      }

      xmlWriter.writeEndElement();

      namespace = "";
      writeStartElement(null, namespace, "FolioDte", xmlWriter);

      if (localFolioDte == null) {
        // write the nil attribute

        writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

      } else {

        xmlWriter.writeCharacters(localFolioDte);
      }

      xmlWriter.writeEndElement();

      namespace = "";
      writeStartElement(null, namespace, "FechaEmisionDte", xmlWriter);

      if (localFechaEmisionDte == null) {
        // write the nil attribute

        writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

      } else {

        xmlWriter.writeCharacters(localFechaEmisionDte);
      }

      xmlWriter.writeEndElement();

      namespace = "";
      writeStartElement(null, namespace, "MontoDte", xmlWriter);

      if (localMontoDte == null) {
        // write the nil attribute

        writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

      } else {

        xmlWriter.writeCharacters(localMontoDte);
      }

      xmlWriter.writeEndElement();

      namespace = "";
      writeStartElement(null, namespace, "FirmaDte", xmlWriter);

      if (localFirmaDte == null) {
        // write the nil attribute

        writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

      } else {

        xmlWriter.writeCharacters(localFirmaDte);
      }

      xmlWriter.writeEndElement();

      namespace = "";
      writeStartElement(null, namespace, "Token", xmlWriter);

      if (localToken == null) {
        // write the nil attribute

        writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

      } else {

        xmlWriter.writeCharacters(localToken);
      }

      xmlWriter.writeEndElement();

      xmlWriter.writeEndElement();
    }

    private static java.lang.String generatePrefix(java.lang.String namespace) {
      if (namespace.equals("http://DefaultNamespace")) {
        return "ns1";
      }
      return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
    }

    /** Utility method to write an element start tag. */
    private void writeStartElement(
        java.lang.String prefix,
        java.lang.String namespace,
        java.lang.String localPart,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
      if (writerPrefix != null) {
        xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
      } else {
        if (namespace.length() == 0) {
          prefix = "";
        } else if (prefix == null) {
          prefix = generatePrefix(namespace);
        }

        xmlWriter.writeStartElement(prefix, localPart, namespace);
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
    }

    /** Util method to write an attribute with the ns prefix */
    private void writeAttribute(
        java.lang.String prefix,
        java.lang.String namespace,
        java.lang.String attName,
        java.lang.String attValue,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
      if (writerPrefix != null) {
        xmlWriter.writeAttribute(writerPrefix, namespace, attName, attValue);
      } else {
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
        xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
      }
    }

    /** Util method to write an attribute without the ns prefix */
    private void writeAttribute(
        java.lang.String namespace,
        java.lang.String attName,
        java.lang.String attValue,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      if (namespace.equals("")) {
        xmlWriter.writeAttribute(attName, attValue);
      } else {
        xmlWriter.writeAttribute(
            registerPrefix(xmlWriter, namespace), namespace, attName, attValue);
      }
    }

    /** Util method to write an attribute without the ns prefix */
    private void writeQNameAttribute(
        java.lang.String namespace,
        java.lang.String attName,
        javax.xml.namespace.QName qname,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {

      java.lang.String attributeNamespace = qname.getNamespaceURI();
      java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
      if (attributePrefix == null) {
        attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
      }
      java.lang.String attributeValue;
      if (attributePrefix.trim().length() > 0) {
        attributeValue = attributePrefix + ":" + qname.getLocalPart();
      } else {
        attributeValue = qname.getLocalPart();
      }

      if (namespace.equals("")) {
        xmlWriter.writeAttribute(attName, attributeValue);
      } else {
        registerPrefix(xmlWriter, namespace);
        xmlWriter.writeAttribute(attributePrefix, namespace, attName, attributeValue);
      }
    }
    /** method to handle Qnames */
    private void writeQName(
        javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String namespaceURI = qname.getNamespaceURI();
      if (namespaceURI != null) {
        java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
        if (prefix == null) {
          prefix = generatePrefix(namespaceURI);
          xmlWriter.writeNamespace(prefix, namespaceURI);
          xmlWriter.setPrefix(prefix, namespaceURI);
        }

        if (prefix.trim().length() > 0) {
          xmlWriter.writeCharacters(
              prefix
                  + ":"
                  + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
        } else {
          // i.e this is the default namespace
          xmlWriter.writeCharacters(
              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
        }

      } else {
        xmlWriter.writeCharacters(
            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
      }
    }

    private void writeQNames(
        javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {

      if (qnames != null) {
        // we have to store this data until last moment since it is not possible to write any
        // namespace data after writing the charactor data
        java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
        java.lang.String namespaceURI = null;
        java.lang.String prefix = null;

        for (int i = 0; i < qnames.length; i++) {
          if (i > 0) {
            stringToWrite.append(" ");
          }
          namespaceURI = qnames[i].getNamespaceURI();
          if (namespaceURI != null) {
            prefix = xmlWriter.getPrefix(namespaceURI);
            if ((prefix == null) || (prefix.length() == 0)) {
              prefix = generatePrefix(namespaceURI);
              xmlWriter.writeNamespace(prefix, namespaceURI);
              xmlWriter.setPrefix(prefix, namespaceURI);
            }

            if (prefix.trim().length() > 0) {
              stringToWrite
                  .append(prefix)
                  .append(":")
                  .append(
                      org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
            } else {
              stringToWrite.append(
                  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
            }
          } else {
            stringToWrite.append(
                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
          }
        }
        xmlWriter.writeCharacters(stringToWrite.toString());
      }
    }

    /** Register a namespace prefix */
    private java.lang.String registerPrefix(
        javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String prefix = xmlWriter.getPrefix(namespace);
      if (prefix == null) {
        prefix = generatePrefix(namespace);
        javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
        while (true) {
          java.lang.String uri = nsContext.getNamespaceURI(prefix);
          if (uri == null || uri.length() == 0) {
            break;
          }
          prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
      return prefix;
    }

    /** Factory class that keeps the parse method */
    public static class Factory {
      private static org.apache.commons.logging.Log log =
          org.apache.commons.logging.LogFactory.getLog(Factory.class);

      /**
       * static method to create the object Precondition: If this object is an element, the current
       * or next start element starts this object and any intervening reader events are ignorable If
       * this object is not an element, it is a complex type and the reader is at the event just
       * after the outer start element Postcondition: If this object is an element, the reader is
       * positioned at its end element If this object is a complex type, the reader is positioned at
       * the end element of its outer element
       */
      public static GetEstDteAv parse(javax.xml.stream.XMLStreamReader reader)
          throws java.lang.Exception {
        GetEstDteAv object = new GetEstDteAv();

        int event;
        javax.xml.namespace.QName currentQName = null;
        java.lang.String nillableValue = null;
        java.lang.String prefix = "";
        java.lang.String namespaceuri = "";
        try {

          while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

          currentQName = reader.getName();

          if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type")
              != null) {
            java.lang.String fullTypeName =
                reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
            if (fullTypeName != null) {
              java.lang.String nsPrefix = null;
              if (fullTypeName.indexOf(":") > -1) {
                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
              }
              nsPrefix = nsPrefix == null ? "" : nsPrefix;

              java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

              if (!"getEstDteAv".equals(type)) {
                // find namespace for the prefix
                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                return (GetEstDteAv) ExtensionMapper.getTypeObject(nsUri, type, reader);
              }
            }
          }

          // Note all attributes that were handled. Used to differ normal attributes
          // from anyAttributes.
          java.util.Vector handledAttributes = new java.util.Vector();

          reader.next();

          while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

          if (reader.isStartElement()
              && new javax.xml.namespace.QName("", "RutEmpresa").equals(reader.getName())) {

            nillableValue =
                reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
            if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

              java.lang.String content = reader.getElementText();

              object.setRutEmpresa(
                  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

            } else {

              reader.getElementText(); // throw away text nodes if any.
            }

            reader.next();

          } // End of if for expected property start element
          else {
            // 1 - A start element we are not expecting indicates an invalid parameter was passed
            throw new org.apache.axis2.databinding.ADBException(
                "Unexpected subelement " + reader.getName());
          }

          while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

          if (reader.isStartElement()
              && new javax.xml.namespace.QName("", "DvEmpresa").equals(reader.getName())) {

            nillableValue =
                reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
            if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

              java.lang.String content = reader.getElementText();

              object.setDvEmpresa(
                  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

            } else {

              reader.getElementText(); // throw away text nodes if any.
            }

            reader.next();

          } // End of if for expected property start element
          else {
            // 1 - A start element we are not expecting indicates an invalid parameter was passed
            throw new org.apache.axis2.databinding.ADBException(
                "Unexpected subelement " + reader.getName());
          }

          while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

          if (reader.isStartElement()
              && new javax.xml.namespace.QName("", "RutReceptor").equals(reader.getName())) {

            nillableValue =
                reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
            if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

              java.lang.String content = reader.getElementText();

              object.setRutReceptor(
                  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

            } else {

              reader.getElementText(); // throw away text nodes if any.
            }

            reader.next();

          } // End of if for expected property start element
          else {
            // 1 - A start element we are not expecting indicates an invalid parameter was passed
            throw new org.apache.axis2.databinding.ADBException(
                "Unexpected subelement " + reader.getName());
          }

          while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

          if (reader.isStartElement()
              && new javax.xml.namespace.QName("", "DvReceptor").equals(reader.getName())) {

            nillableValue =
                reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
            if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

              java.lang.String content = reader.getElementText();

              object.setDvReceptor(
                  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

            } else {

              reader.getElementText(); // throw away text nodes if any.
            }

            reader.next();

          } // End of if for expected property start element
          else {
            // 1 - A start element we are not expecting indicates an invalid parameter was passed
            throw new org.apache.axis2.databinding.ADBException(
                "Unexpected subelement " + reader.getName());
          }

          while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

          if (reader.isStartElement()
              && new javax.xml.namespace.QName("", "TipoDte").equals(reader.getName())) {

            nillableValue =
                reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
            if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

              java.lang.String content = reader.getElementText();

              object.setTipoDte(
                  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

            } else {

              reader.getElementText(); // throw away text nodes if any.
            }

            reader.next();

          } // End of if for expected property start element
          else {
            // 1 - A start element we are not expecting indicates an invalid parameter was passed
            throw new org.apache.axis2.databinding.ADBException(
                "Unexpected subelement " + reader.getName());
          }

          while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

          if (reader.isStartElement()
              && new javax.xml.namespace.QName("", "FolioDte").equals(reader.getName())) {

            nillableValue =
                reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
            if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

              java.lang.String content = reader.getElementText();

              object.setFolioDte(
                  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

            } else {

              reader.getElementText(); // throw away text nodes if any.
            }

            reader.next();

          } // End of if for expected property start element
          else {
            // 1 - A start element we are not expecting indicates an invalid parameter was passed
            throw new org.apache.axis2.databinding.ADBException(
                "Unexpected subelement " + reader.getName());
          }

          while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

          if (reader.isStartElement()
              && new javax.xml.namespace.QName("", "FechaEmisionDte").equals(reader.getName())) {

            nillableValue =
                reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
            if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

              java.lang.String content = reader.getElementText();

              object.setFechaEmisionDte(
                  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

            } else {

              reader.getElementText(); // throw away text nodes if any.
            }

            reader.next();

          } // End of if for expected property start element
          else {
            // 1 - A start element we are not expecting indicates an invalid parameter was passed
            throw new org.apache.axis2.databinding.ADBException(
                "Unexpected subelement " + reader.getName());
          }

          while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

          if (reader.isStartElement()
              && new javax.xml.namespace.QName("", "MontoDte").equals(reader.getName())) {

            nillableValue =
                reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
            if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

              java.lang.String content = reader.getElementText();

              object.setMontoDte(
                  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

            } else {

              reader.getElementText(); // throw away text nodes if any.
            }

            reader.next();

          } // End of if for expected property start element
          else {
            // 1 - A start element we are not expecting indicates an invalid parameter was passed
            throw new org.apache.axis2.databinding.ADBException(
                "Unexpected subelement " + reader.getName());
          }

          while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

          if (reader.isStartElement()
              && new javax.xml.namespace.QName("", "FirmaDte").equals(reader.getName())) {

            nillableValue =
                reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
            if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

              java.lang.String content = reader.getElementText();

              object.setFirmaDte(
                  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

            } else {

              reader.getElementText(); // throw away text nodes if any.
            }

            reader.next();

          } // End of if for expected property start element
          else {
            // 1 - A start element we are not expecting indicates an invalid parameter was passed
            throw new org.apache.axis2.databinding.ADBException(
                "Unexpected subelement " + reader.getName());
          }

          while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

          if (reader.isStartElement()
              && new javax.xml.namespace.QName("", "Token").equals(reader.getName())) {

            nillableValue =
                reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
            if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

              java.lang.String content = reader.getElementText();

              object.setToken(
                  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

            } else {

              reader.getElementText(); // throw away text nodes if any.
            }

            reader.next();

          } // End of if for expected property start element
          else {
            // 1 - A start element we are not expecting indicates an invalid parameter was passed
            throw new org.apache.axis2.databinding.ADBException(
                "Unexpected subelement " + reader.getName());
          }

          while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

          if (reader.isStartElement())
            // 2 - A start element we are not expecting indicates a trailing invalid property

            throw new org.apache.axis2.databinding.ADBException(
                "Unexpected subelement " + reader.getName());

        } catch (javax.xml.stream.XMLStreamException e) {
          throw new java.lang.Exception(e);
        }

        return object;
      }
    } // end of factory class
  }

  public static class GetVersionMenor implements org.apache.axis2.databinding.ADBBean {

    public static final javax.xml.namespace.QName MY_QNAME =
        new javax.xml.namespace.QName("http://DefaultNamespace", "getVersionMenor", "ns1");

    /**
     * @param parentQName
     * @param factory
     * @return org.apache.axiom.om.OMElement
     */
    public org.apache.axiom.om.OMElement getOMElement(
        final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory)
        throws org.apache.axis2.databinding.ADBException {

      return factory.createOMElement(
          new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME));
    }

    public void serialize(
        final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
      serialize(parentQName, xmlWriter, false);
    }

    public void serialize(
        final javax.xml.namespace.QName parentQName,
        javax.xml.stream.XMLStreamWriter xmlWriter,
        boolean serializeType)
        throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

      java.lang.String prefix = null;
      java.lang.String namespace = null;

      prefix = parentQName.getPrefix();
      namespace = parentQName.getNamespaceURI();
      writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

      if (serializeType) {

        java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://DefaultNamespace");
        if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
          writeAttribute(
              "xsi",
              "http://www.w3.org/2001/XMLSchema-instance",
              "type",
              namespacePrefix + ":getVersionMenor",
              xmlWriter);
        } else {
          writeAttribute(
              "xsi",
              "http://www.w3.org/2001/XMLSchema-instance",
              "type",
              "getVersionMenor",
              xmlWriter);
        }
      }

      xmlWriter.writeEndElement();
    }

    private static java.lang.String generatePrefix(java.lang.String namespace) {
      if (namespace.equals("http://DefaultNamespace")) {
        return "ns1";
      }
      return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
    }

    /** Utility method to write an element start tag. */
    private void writeStartElement(
        java.lang.String prefix,
        java.lang.String namespace,
        java.lang.String localPart,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
      if (writerPrefix != null) {
        xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
      } else {
        if (namespace.length() == 0) {
          prefix = "";
        } else if (prefix == null) {
          prefix = generatePrefix(namespace);
        }

        xmlWriter.writeStartElement(prefix, localPart, namespace);
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
    }

    /** Util method to write an attribute with the ns prefix */
    private void writeAttribute(
        java.lang.String prefix,
        java.lang.String namespace,
        java.lang.String attName,
        java.lang.String attValue,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
      if (writerPrefix != null) {
        xmlWriter.writeAttribute(writerPrefix, namespace, attName, attValue);
      } else {
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
        xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
      }
    }

    /** Util method to write an attribute without the ns prefix */
    private void writeAttribute(
        java.lang.String namespace,
        java.lang.String attName,
        java.lang.String attValue,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      if (namespace.equals("")) {
        xmlWriter.writeAttribute(attName, attValue);
      } else {
        xmlWriter.writeAttribute(
            registerPrefix(xmlWriter, namespace), namespace, attName, attValue);
      }
    }

    /** Util method to write an attribute without the ns prefix */
    private void writeQNameAttribute(
        java.lang.String namespace,
        java.lang.String attName,
        javax.xml.namespace.QName qname,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {

      java.lang.String attributeNamespace = qname.getNamespaceURI();
      java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
      if (attributePrefix == null) {
        attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
      }
      java.lang.String attributeValue;
      if (attributePrefix.trim().length() > 0) {
        attributeValue = attributePrefix + ":" + qname.getLocalPart();
      } else {
        attributeValue = qname.getLocalPart();
      }

      if (namespace.equals("")) {
        xmlWriter.writeAttribute(attName, attributeValue);
      } else {
        registerPrefix(xmlWriter, namespace);
        xmlWriter.writeAttribute(attributePrefix, namespace, attName, attributeValue);
      }
    }
    /** method to handle Qnames */
    private void writeQName(
        javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String namespaceURI = qname.getNamespaceURI();
      if (namespaceURI != null) {
        java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
        if (prefix == null) {
          prefix = generatePrefix(namespaceURI);
          xmlWriter.writeNamespace(prefix, namespaceURI);
          xmlWriter.setPrefix(prefix, namespaceURI);
        }

        if (prefix.trim().length() > 0) {
          xmlWriter.writeCharacters(
              prefix
                  + ":"
                  + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
        } else {
          // i.e this is the default namespace
          xmlWriter.writeCharacters(
              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
        }

      } else {
        xmlWriter.writeCharacters(
            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
      }
    }

    private void writeQNames(
        javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {

      if (qnames != null) {
        // we have to store this data until last moment since it is not possible to write any
        // namespace data after writing the charactor data
        java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
        java.lang.String namespaceURI = null;
        java.lang.String prefix = null;

        for (int i = 0; i < qnames.length; i++) {
          if (i > 0) {
            stringToWrite.append(" ");
          }
          namespaceURI = qnames[i].getNamespaceURI();
          if (namespaceURI != null) {
            prefix = xmlWriter.getPrefix(namespaceURI);
            if ((prefix == null) || (prefix.length() == 0)) {
              prefix = generatePrefix(namespaceURI);
              xmlWriter.writeNamespace(prefix, namespaceURI);
              xmlWriter.setPrefix(prefix, namespaceURI);
            }

            if (prefix.trim().length() > 0) {
              stringToWrite
                  .append(prefix)
                  .append(":")
                  .append(
                      org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
            } else {
              stringToWrite.append(
                  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
            }
          } else {
            stringToWrite.append(
                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
          }
        }
        xmlWriter.writeCharacters(stringToWrite.toString());
      }
    }

    /** Register a namespace prefix */
    private java.lang.String registerPrefix(
        javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String prefix = xmlWriter.getPrefix(namespace);
      if (prefix == null) {
        prefix = generatePrefix(namespace);
        javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
        while (true) {
          java.lang.String uri = nsContext.getNamespaceURI(prefix);
          if (uri == null || uri.length() == 0) {
            break;
          }
          prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
      return prefix;
    }

    /** Factory class that keeps the parse method */
    public static class Factory {
      private static org.apache.commons.logging.Log log =
          org.apache.commons.logging.LogFactory.getLog(Factory.class);

      /**
       * static method to create the object Precondition: If this object is an element, the current
       * or next start element starts this object and any intervening reader events are ignorable If
       * this object is not an element, it is a complex type and the reader is at the event just
       * after the outer start element Postcondition: If this object is an element, the reader is
       * positioned at its end element If this object is a complex type, the reader is positioned at
       * the end element of its outer element
       */
      public static GetVersionMenor parse(javax.xml.stream.XMLStreamReader reader)
          throws java.lang.Exception {
        GetVersionMenor object = new GetVersionMenor();

        int event;
        javax.xml.namespace.QName currentQName = null;
        java.lang.String nillableValue = null;
        java.lang.String prefix = "";
        java.lang.String namespaceuri = "";
        try {

          while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

          currentQName = reader.getName();

          if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type")
              != null) {
            java.lang.String fullTypeName =
                reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
            if (fullTypeName != null) {
              java.lang.String nsPrefix = null;
              if (fullTypeName.indexOf(":") > -1) {
                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
              }
              nsPrefix = nsPrefix == null ? "" : nsPrefix;

              java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

              if (!"getVersionMenor".equals(type)) {
                // find namespace for the prefix
                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                return (GetVersionMenor) ExtensionMapper.getTypeObject(nsUri, type, reader);
              }
            }
          }

          // Note all attributes that were handled. Used to differ normal attributes
          // from anyAttributes.
          java.util.Vector handledAttributes = new java.util.Vector();

          reader.next();

          while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

          if (reader.isStartElement())
            // 2 - A start element we are not expecting indicates a trailing invalid property

            throw new org.apache.axis2.databinding.ADBException(
                "Unexpected subelement " + reader.getName());

        } catch (javax.xml.stream.XMLStreamException e) {
          throw new java.lang.Exception(e);
        }

        return object;
      }
    } // end of factory class
  }

  public static class GetVersionPatchResponse implements org.apache.axis2.databinding.ADBBean {

    public static final javax.xml.namespace.QName MY_QNAME =
        new javax.xml.namespace.QName("http://DefaultNamespace", "getVersionPatchResponse", "ns1");

    /** field for GetVersionPatchReturn */
    protected java.lang.String localGetVersionPatchReturn;

    /**
     * Auto generated getter method
     *
     * @return java.lang.String
     */
    public java.lang.String getGetVersionPatchReturn() {
      return localGetVersionPatchReturn;
    }

    /**
     * Auto generated setter method
     *
     * @param param GetVersionPatchReturn
     */
    public void setGetVersionPatchReturn(java.lang.String param) {

      this.localGetVersionPatchReturn = param;
    }

    /**
     * @param parentQName
     * @param factory
     * @return org.apache.axiom.om.OMElement
     */
    public org.apache.axiom.om.OMElement getOMElement(
        final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory)
        throws org.apache.axis2.databinding.ADBException {

      return factory.createOMElement(
          new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME));
    }

    public void serialize(
        final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
      serialize(parentQName, xmlWriter, false);
    }

    public void serialize(
        final javax.xml.namespace.QName parentQName,
        javax.xml.stream.XMLStreamWriter xmlWriter,
        boolean serializeType)
        throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

      java.lang.String prefix = null;
      java.lang.String namespace = null;

      prefix = parentQName.getPrefix();
      namespace = parentQName.getNamespaceURI();
      writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

      if (serializeType) {

        java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://DefaultNamespace");
        if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
          writeAttribute(
              "xsi",
              "http://www.w3.org/2001/XMLSchema-instance",
              "type",
              namespacePrefix + ":getVersionPatchResponse",
              xmlWriter);
        } else {
          writeAttribute(
              "xsi",
              "http://www.w3.org/2001/XMLSchema-instance",
              "type",
              "getVersionPatchResponse",
              xmlWriter);
        }
      }

      namespace = "";
      writeStartElement(null, namespace, "getVersionPatchReturn", xmlWriter);

      if (localGetVersionPatchReturn == null) {
        // write the nil attribute

        writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

      } else {

        xmlWriter.writeCharacters(localGetVersionPatchReturn);
      }

      xmlWriter.writeEndElement();

      xmlWriter.writeEndElement();
    }

    private static java.lang.String generatePrefix(java.lang.String namespace) {
      if (namespace.equals("http://DefaultNamespace")) {
        return "ns1";
      }
      return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
    }

    /** Utility method to write an element start tag. */
    private void writeStartElement(
        java.lang.String prefix,
        java.lang.String namespace,
        java.lang.String localPart,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
      if (writerPrefix != null) {
        xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
      } else {
        if (namespace.length() == 0) {
          prefix = "";
        } else if (prefix == null) {
          prefix = generatePrefix(namespace);
        }

        xmlWriter.writeStartElement(prefix, localPart, namespace);
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
    }

    /** Util method to write an attribute with the ns prefix */
    private void writeAttribute(
        java.lang.String prefix,
        java.lang.String namespace,
        java.lang.String attName,
        java.lang.String attValue,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
      if (writerPrefix != null) {
        xmlWriter.writeAttribute(writerPrefix, namespace, attName, attValue);
      } else {
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
        xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
      }
    }

    /** Util method to write an attribute without the ns prefix */
    private void writeAttribute(
        java.lang.String namespace,
        java.lang.String attName,
        java.lang.String attValue,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      if (namespace.equals("")) {
        xmlWriter.writeAttribute(attName, attValue);
      } else {
        xmlWriter.writeAttribute(
            registerPrefix(xmlWriter, namespace), namespace, attName, attValue);
      }
    }

    /** Util method to write an attribute without the ns prefix */
    private void writeQNameAttribute(
        java.lang.String namespace,
        java.lang.String attName,
        javax.xml.namespace.QName qname,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {

      java.lang.String attributeNamespace = qname.getNamespaceURI();
      java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
      if (attributePrefix == null) {
        attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
      }
      java.lang.String attributeValue;
      if (attributePrefix.trim().length() > 0) {
        attributeValue = attributePrefix + ":" + qname.getLocalPart();
      } else {
        attributeValue = qname.getLocalPart();
      }

      if (namespace.equals("")) {
        xmlWriter.writeAttribute(attName, attributeValue);
      } else {
        registerPrefix(xmlWriter, namespace);
        xmlWriter.writeAttribute(attributePrefix, namespace, attName, attributeValue);
      }
    }
    /** method to handle Qnames */
    private void writeQName(
        javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String namespaceURI = qname.getNamespaceURI();
      if (namespaceURI != null) {
        java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
        if (prefix == null) {
          prefix = generatePrefix(namespaceURI);
          xmlWriter.writeNamespace(prefix, namespaceURI);
          xmlWriter.setPrefix(prefix, namespaceURI);
        }

        if (prefix.trim().length() > 0) {
          xmlWriter.writeCharacters(
              prefix
                  + ":"
                  + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
        } else {
          // i.e this is the default namespace
          xmlWriter.writeCharacters(
              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
        }

      } else {
        xmlWriter.writeCharacters(
            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
      }
    }

    private void writeQNames(
        javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {

      if (qnames != null) {
        // we have to store this data until last moment since it is not possible to write any
        // namespace data after writing the charactor data
        java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
        java.lang.String namespaceURI = null;
        java.lang.String prefix = null;

        for (int i = 0; i < qnames.length; i++) {
          if (i > 0) {
            stringToWrite.append(" ");
          }
          namespaceURI = qnames[i].getNamespaceURI();
          if (namespaceURI != null) {
            prefix = xmlWriter.getPrefix(namespaceURI);
            if ((prefix == null) || (prefix.length() == 0)) {
              prefix = generatePrefix(namespaceURI);
              xmlWriter.writeNamespace(prefix, namespaceURI);
              xmlWriter.setPrefix(prefix, namespaceURI);
            }

            if (prefix.trim().length() > 0) {
              stringToWrite
                  .append(prefix)
                  .append(":")
                  .append(
                      org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
            } else {
              stringToWrite.append(
                  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
            }
          } else {
            stringToWrite.append(
                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
          }
        }
        xmlWriter.writeCharacters(stringToWrite.toString());
      }
    }

    /** Register a namespace prefix */
    private java.lang.String registerPrefix(
        javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String prefix = xmlWriter.getPrefix(namespace);
      if (prefix == null) {
        prefix = generatePrefix(namespace);
        javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
        while (true) {
          java.lang.String uri = nsContext.getNamespaceURI(prefix);
          if (uri == null || uri.length() == 0) {
            break;
          }
          prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
      return prefix;
    }

    /** Factory class that keeps the parse method */
    public static class Factory {
      private static org.apache.commons.logging.Log log =
          org.apache.commons.logging.LogFactory.getLog(Factory.class);

      /**
       * static method to create the object Precondition: If this object is an element, the current
       * or next start element starts this object and any intervening reader events are ignorable If
       * this object is not an element, it is a complex type and the reader is at the event just
       * after the outer start element Postcondition: If this object is an element, the reader is
       * positioned at its end element If this object is a complex type, the reader is positioned at
       * the end element of its outer element
       */
      public static GetVersionPatchResponse parse(javax.xml.stream.XMLStreamReader reader)
          throws java.lang.Exception {
        GetVersionPatchResponse object = new GetVersionPatchResponse();

        int event;
        javax.xml.namespace.QName currentQName = null;
        java.lang.String nillableValue = null;
        java.lang.String prefix = "";
        java.lang.String namespaceuri = "";
        try {

          while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

          currentQName = reader.getName();

          if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type")
              != null) {
            java.lang.String fullTypeName =
                reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
            if (fullTypeName != null) {
              java.lang.String nsPrefix = null;
              if (fullTypeName.indexOf(":") > -1) {
                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
              }
              nsPrefix = nsPrefix == null ? "" : nsPrefix;

              java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

              if (!"getVersionPatchResponse".equals(type)) {
                // find namespace for the prefix
                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                return (GetVersionPatchResponse) ExtensionMapper.getTypeObject(nsUri, type, reader);
              }
            }
          }

          // Note all attributes that were handled. Used to differ normal attributes
          // from anyAttributes.
          java.util.Vector handledAttributes = new java.util.Vector();

          reader.next();

          while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

          if (reader.isStartElement()
              && new javax.xml.namespace.QName("", "getVersionPatchReturn")
                  .equals(reader.getName())) {

            nillableValue =
                reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
            if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

              java.lang.String content = reader.getElementText();

              object.setGetVersionPatchReturn(
                  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

            } else {

              reader.getElementText(); // throw away text nodes if any.
            }

            reader.next();

          } // End of if for expected property start element
          else {
            // 1 - A start element we are not expecting indicates an invalid parameter was passed
            throw new org.apache.axis2.databinding.ADBException(
                "Unexpected subelement " + reader.getName());
          }

          while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

          if (reader.isStartElement())
            // 2 - A start element we are not expecting indicates a trailing invalid property

            throw new org.apache.axis2.databinding.ADBException(
                "Unexpected subelement " + reader.getName());

        } catch (javax.xml.stream.XMLStreamException e) {
          throw new java.lang.Exception(e);
        }

        return object;
      }
    } // end of factory class
  }

  public static class GetState implements org.apache.axis2.databinding.ADBBean {

    public static final javax.xml.namespace.QName MY_QNAME =
        new javax.xml.namespace.QName("http://DefaultNamespace", "getState", "ns1");

    /**
     * @param parentQName
     * @param factory
     * @return org.apache.axiom.om.OMElement
     */
    public org.apache.axiom.om.OMElement getOMElement(
        final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory)
        throws org.apache.axis2.databinding.ADBException {

      return factory.createOMElement(
          new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME));
    }

    public void serialize(
        final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
      serialize(parentQName, xmlWriter, false);
    }

    public void serialize(
        final javax.xml.namespace.QName parentQName,
        javax.xml.stream.XMLStreamWriter xmlWriter,
        boolean serializeType)
        throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

      java.lang.String prefix = null;
      java.lang.String namespace = null;

      prefix = parentQName.getPrefix();
      namespace = parentQName.getNamespaceURI();
      writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

      if (serializeType) {

        java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://DefaultNamespace");
        if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
          writeAttribute(
              "xsi",
              "http://www.w3.org/2001/XMLSchema-instance",
              "type",
              namespacePrefix + ":getState",
              xmlWriter);
        } else {
          writeAttribute(
              "xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "getState", xmlWriter);
        }
      }

      xmlWriter.writeEndElement();
    }

    private static java.lang.String generatePrefix(java.lang.String namespace) {
      if (namespace.equals("http://DefaultNamespace")) {
        return "ns1";
      }
      return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
    }

    /** Utility method to write an element start tag. */
    private void writeStartElement(
        java.lang.String prefix,
        java.lang.String namespace,
        java.lang.String localPart,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
      if (writerPrefix != null) {
        xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
      } else {
        if (namespace.length() == 0) {
          prefix = "";
        } else if (prefix == null) {
          prefix = generatePrefix(namespace);
        }

        xmlWriter.writeStartElement(prefix, localPart, namespace);
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
    }

    /** Util method to write an attribute with the ns prefix */
    private void writeAttribute(
        java.lang.String prefix,
        java.lang.String namespace,
        java.lang.String attName,
        java.lang.String attValue,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
      if (writerPrefix != null) {
        xmlWriter.writeAttribute(writerPrefix, namespace, attName, attValue);
      } else {
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
        xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
      }
    }

    /** Util method to write an attribute without the ns prefix */
    private void writeAttribute(
        java.lang.String namespace,
        java.lang.String attName,
        java.lang.String attValue,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      if (namespace.equals("")) {
        xmlWriter.writeAttribute(attName, attValue);
      } else {
        xmlWriter.writeAttribute(
            registerPrefix(xmlWriter, namespace), namespace, attName, attValue);
      }
    }

    /** Util method to write an attribute without the ns prefix */
    private void writeQNameAttribute(
        java.lang.String namespace,
        java.lang.String attName,
        javax.xml.namespace.QName qname,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {

      java.lang.String attributeNamespace = qname.getNamespaceURI();
      java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
      if (attributePrefix == null) {
        attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
      }
      java.lang.String attributeValue;
      if (attributePrefix.trim().length() > 0) {
        attributeValue = attributePrefix + ":" + qname.getLocalPart();
      } else {
        attributeValue = qname.getLocalPart();
      }

      if (namespace.equals("")) {
        xmlWriter.writeAttribute(attName, attributeValue);
      } else {
        registerPrefix(xmlWriter, namespace);
        xmlWriter.writeAttribute(attributePrefix, namespace, attName, attributeValue);
      }
    }
    /** method to handle Qnames */
    private void writeQName(
        javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String namespaceURI = qname.getNamespaceURI();
      if (namespaceURI != null) {
        java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
        if (prefix == null) {
          prefix = generatePrefix(namespaceURI);
          xmlWriter.writeNamespace(prefix, namespaceURI);
          xmlWriter.setPrefix(prefix, namespaceURI);
        }

        if (prefix.trim().length() > 0) {
          xmlWriter.writeCharacters(
              prefix
                  + ":"
                  + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
        } else {
          // i.e this is the default namespace
          xmlWriter.writeCharacters(
              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
        }

      } else {
        xmlWriter.writeCharacters(
            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
      }
    }

    private void writeQNames(
        javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {

      if (qnames != null) {
        // we have to store this data until last moment since it is not possible to write any
        // namespace data after writing the charactor data
        java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
        java.lang.String namespaceURI = null;
        java.lang.String prefix = null;

        for (int i = 0; i < qnames.length; i++) {
          if (i > 0) {
            stringToWrite.append(" ");
          }
          namespaceURI = qnames[i].getNamespaceURI();
          if (namespaceURI != null) {
            prefix = xmlWriter.getPrefix(namespaceURI);
            if ((prefix == null) || (prefix.length() == 0)) {
              prefix = generatePrefix(namespaceURI);
              xmlWriter.writeNamespace(prefix, namespaceURI);
              xmlWriter.setPrefix(prefix, namespaceURI);
            }

            if (prefix.trim().length() > 0) {
              stringToWrite
                  .append(prefix)
                  .append(":")
                  .append(
                      org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
            } else {
              stringToWrite.append(
                  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
            }
          } else {
            stringToWrite.append(
                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
          }
        }
        xmlWriter.writeCharacters(stringToWrite.toString());
      }
    }

    /** Register a namespace prefix */
    private java.lang.String registerPrefix(
        javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
        throws javax.xml.stream.XMLStreamException {
      java.lang.String prefix = xmlWriter.getPrefix(namespace);
      if (prefix == null) {
        prefix = generatePrefix(namespace);
        javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
        while (true) {
          java.lang.String uri = nsContext.getNamespaceURI(prefix);
          if (uri == null || uri.length() == 0) {
            break;
          }
          prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
      return prefix;
    }

    /** Factory class that keeps the parse method */
    public static class Factory {
      private static org.apache.commons.logging.Log log =
          org.apache.commons.logging.LogFactory.getLog(Factory.class);

      /**
       * static method to create the object Precondition: If this object is an element, the current
       * or next start element starts this object and any intervening reader events are ignorable If
       * this object is not an element, it is a complex type and the reader is at the event just
       * after the outer start element Postcondition: If this object is an element, the reader is
       * positioned at its end element If this object is a complex type, the reader is positioned at
       * the end element of its outer element
       */
      public static GetState parse(javax.xml.stream.XMLStreamReader reader)
          throws java.lang.Exception {
        GetState object = new GetState();

        int event;
        javax.xml.namespace.QName currentQName = null;
        java.lang.String nillableValue = null;
        java.lang.String prefix = "";
        java.lang.String namespaceuri = "";
        try {

          while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

          currentQName = reader.getName();

          if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type")
              != null) {
            java.lang.String fullTypeName =
                reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
            if (fullTypeName != null) {
              java.lang.String nsPrefix = null;
              if (fullTypeName.indexOf(":") > -1) {
                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
              }
              nsPrefix = nsPrefix == null ? "" : nsPrefix;

              java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

              if (!"getState".equals(type)) {
                // find namespace for the prefix
                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                return (GetState) ExtensionMapper.getTypeObject(nsUri, type, reader);
              }
            }
          }

          // Note all attributes that were handled. Used to differ normal attributes
          // from anyAttributes.
          java.util.Vector handledAttributes = new java.util.Vector();

          reader.next();

          while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

          if (reader.isStartElement())
            // 2 - A start element we are not expecting indicates a trailing invalid property

            throw new org.apache.axis2.databinding.ADBException(
                "Unexpected subelement " + reader.getName());

        } catch (javax.xml.stream.XMLStreamException e) {
          throw new java.lang.Exception(e);
        }

        return object;
      }
    } // end of factory class
  }

  private org.apache.axiom.om.OMElement toOM(
      cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersionMayor param,
      boolean optimizeContent)
      throws org.apache.axis2.AxisFault {

    try {
      return param.getOMElement(
          cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersionMayor.MY_QNAME,
          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
    } catch (org.apache.axis2.databinding.ADBException e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }
  }

  private org.apache.axiom.om.OMElement toOM(
      cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersionMayorResponse param,
      boolean optimizeContent)
      throws org.apache.axis2.AxisFault {

    try {
      return param.getOMElement(
          cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersionMayorResponse
              .MY_QNAME,
          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
    } catch (org.apache.axis2.databinding.ADBException e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }
  }

  private org.apache.axiom.om.OMElement toOM(
      cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersionMenor param,
      boolean optimizeContent)
      throws org.apache.axis2.AxisFault {

    try {
      return param.getOMElement(
          cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersionMenor.MY_QNAME,
          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
    } catch (org.apache.axis2.databinding.ADBException e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }
  }

  private org.apache.axiom.om.OMElement toOM(
      cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersionMenorResponse param,
      boolean optimizeContent)
      throws org.apache.axis2.AxisFault {

    try {
      return param.getOMElement(
          cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersionMenorResponse
              .MY_QNAME,
          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
    } catch (org.apache.axis2.databinding.ADBException e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }
  }

  private org.apache.axiom.om.OMElement toOM(
      cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetState param,
      boolean optimizeContent)
      throws org.apache.axis2.AxisFault {

    try {
      return param.getOMElement(
          cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetState.MY_QNAME,
          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
    } catch (org.apache.axis2.databinding.ADBException e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }
  }

  private org.apache.axiom.om.OMElement toOM(
      cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetStateResponse param,
      boolean optimizeContent)
      throws org.apache.axis2.AxisFault {

    try {
      return param.getOMElement(
          cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetStateResponse.MY_QNAME,
          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
    } catch (org.apache.axis2.databinding.ADBException e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }
  }

  private org.apache.axiom.om.OMElement toOM(
      cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersion param,
      boolean optimizeContent)
      throws org.apache.axis2.AxisFault {

    try {
      return param.getOMElement(
          cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersion.MY_QNAME,
          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
    } catch (org.apache.axis2.databinding.ADBException e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }
  }

  private org.apache.axiom.om.OMElement toOM(
      cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersionResponse param,
      boolean optimizeContent)
      throws org.apache.axis2.AxisFault {

    try {
      return param.getOMElement(
          cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersionResponse
              .MY_QNAME,
          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
    } catch (org.apache.axis2.databinding.ADBException e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }
  }

  private org.apache.axiom.om.OMElement toOM(
      cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetEstDteAv param,
      boolean optimizeContent)
      throws org.apache.axis2.AxisFault {

    try {
      return param.getOMElement(
          cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetEstDteAv.MY_QNAME,
          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
    } catch (org.apache.axis2.databinding.ADBException e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }
  }

  private org.apache.axiom.om.OMElement toOM(
      cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetEstDteAvResponse param,
      boolean optimizeContent)
      throws org.apache.axis2.AxisFault {

    try {
      return param.getOMElement(
          cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetEstDteAvResponse
              .MY_QNAME,
          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
    } catch (org.apache.axis2.databinding.ADBException e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }
  }

  private org.apache.axiom.om.OMElement toOM(
      cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersionPatch param,
      boolean optimizeContent)
      throws org.apache.axis2.AxisFault {

    try {
      return param.getOMElement(
          cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersionPatch.MY_QNAME,
          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
    } catch (org.apache.axis2.databinding.ADBException e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }
  }

  private org.apache.axiom.om.OMElement toOM(
      cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersionPatchResponse param,
      boolean optimizeContent)
      throws org.apache.axis2.AxisFault {

    try {
      return param.getOMElement(
          cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersionPatchResponse
              .MY_QNAME,
          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
    } catch (org.apache.axis2.databinding.ADBException e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }
  }

  private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
      org.apache.axiom.soap.SOAPFactory factory,
      cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersionMayor param,
      boolean optimizeContent,
      javax.xml.namespace.QName elementQName)
      throws org.apache.axis2.AxisFault {

    try {

      org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
      emptyEnvelope
          .getBody()
          .addChild(
              param.getOMElement(
                  cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersionMayor
                      .MY_QNAME,
                  factory));
      return emptyEnvelope;
    } catch (org.apache.axis2.databinding.ADBException e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }
  }

  /* methods to provide back word compatibility */

  private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
      org.apache.axiom.soap.SOAPFactory factory,
      cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersionMenor param,
      boolean optimizeContent,
      javax.xml.namespace.QName elementQName)
      throws org.apache.axis2.AxisFault {

    try {

      org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
      emptyEnvelope
          .getBody()
          .addChild(
              param.getOMElement(
                  cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersionMenor
                      .MY_QNAME,
                  factory));
      return emptyEnvelope;
    } catch (org.apache.axis2.databinding.ADBException e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }
  }

  /* methods to provide back word compatibility */

  private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
      org.apache.axiom.soap.SOAPFactory factory,
      cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetState param,
      boolean optimizeContent,
      javax.xml.namespace.QName elementQName)
      throws org.apache.axis2.AxisFault {

    try {

      org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
      emptyEnvelope
          .getBody()
          .addChild(
              param.getOMElement(
                  cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetState.MY_QNAME,
                  factory));
      return emptyEnvelope;
    } catch (org.apache.axis2.databinding.ADBException e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }
  }

  /* methods to provide back word compatibility */

  private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
      org.apache.axiom.soap.SOAPFactory factory,
      cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersion param,
      boolean optimizeContent,
      javax.xml.namespace.QName elementQName)
      throws org.apache.axis2.AxisFault {

    try {

      org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
      emptyEnvelope
          .getBody()
          .addChild(
              param.getOMElement(
                  cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersion
                      .MY_QNAME,
                  factory));
      return emptyEnvelope;
    } catch (org.apache.axis2.databinding.ADBException e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }
  }

  /* methods to provide back word compatibility */

  private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
      org.apache.axiom.soap.SOAPFactory factory,
      cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetEstDteAv param,
      boolean optimizeContent,
      javax.xml.namespace.QName elementQName)
      throws org.apache.axis2.AxisFault {

    try {

      org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
      emptyEnvelope
          .getBody()
          .addChild(
              param.getOMElement(
                  cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetEstDteAv
                      .MY_QNAME,
                  factory));
      return emptyEnvelope;
    } catch (org.apache.axis2.databinding.ADBException e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }
  }

  /* methods to provide back word compatibility */

  private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
      org.apache.axiom.soap.SOAPFactory factory,
      cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersionPatch param,
      boolean optimizeContent,
      javax.xml.namespace.QName elementQName)
      throws org.apache.axis2.AxisFault {

    try {

      org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
      emptyEnvelope
          .getBody()
          .addChild(
              param.getOMElement(
                  cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersionPatch
                      .MY_QNAME,
                  factory));
      return emptyEnvelope;
    } catch (org.apache.axis2.databinding.ADBException e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }
  }

  /* methods to provide back word compatibility */

  /** get the default envelope */
  private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory) {
    return factory.getDefaultEnvelope();
  }

  private java.lang.Object fromOM(org.apache.axiom.om.OMElement param, java.lang.Class type)
      throws org.apache.axis2.AxisFault {

    try {

      if (cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetEstDteAv.class.equals(
          type)) {

        javax.xml.stream.XMLStreamReader reader = param.getXMLStreamReaderWithoutCaching();
        java.lang.Object result =
            cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetEstDteAv.Factory
                .parse(reader);
        reader.close();
        return result;
      }

      if (cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetEstDteAvResponse.class
          .equals(type)) {

        javax.xml.stream.XMLStreamReader reader = param.getXMLStreamReaderWithoutCaching();
        java.lang.Object result =
            cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetEstDteAvResponse
                .Factory.parse(reader);
        reader.close();
        return result;
      }

      if (cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetState.class.equals(
          type)) {

        javax.xml.stream.XMLStreamReader reader = param.getXMLStreamReaderWithoutCaching();
        java.lang.Object result =
            cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetState.Factory.parse(
                reader);
        reader.close();
        return result;
      }

      if (cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetStateResponse.class
          .equals(type)) {

        javax.xml.stream.XMLStreamReader reader = param.getXMLStreamReaderWithoutCaching();
        java.lang.Object result =
            cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetStateResponse.Factory
                .parse(reader);
        reader.close();
        return result;
      }

      if (cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersion.class.equals(
          type)) {

        javax.xml.stream.XMLStreamReader reader = param.getXMLStreamReaderWithoutCaching();
        java.lang.Object result =
            cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersion.Factory.parse(
                reader);
        reader.close();
        return result;
      }

      if (cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersionMayor.class
          .equals(type)) {

        javax.xml.stream.XMLStreamReader reader = param.getXMLStreamReaderWithoutCaching();
        java.lang.Object result =
            cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersionMayor.Factory
                .parse(reader);
        reader.close();
        return result;
      }

      if (cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersionMayorResponse
          .class
          .equals(type)) {

        javax.xml.stream.XMLStreamReader reader = param.getXMLStreamReaderWithoutCaching();
        java.lang.Object result =
            cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersionMayorResponse
                .Factory.parse(reader);
        reader.close();
        return result;
      }

      if (cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersionMenor.class
          .equals(type)) {

        javax.xml.stream.XMLStreamReader reader = param.getXMLStreamReaderWithoutCaching();
        java.lang.Object result =
            cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersionMenor.Factory
                .parse(reader);
        reader.close();
        return result;
      }

      if (cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersionMenorResponse
          .class
          .equals(type)) {

        javax.xml.stream.XMLStreamReader reader = param.getXMLStreamReaderWithoutCaching();
        java.lang.Object result =
            cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersionMenorResponse
                .Factory.parse(reader);
        reader.close();
        return result;
      }

      if (cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersionPatch.class
          .equals(type)) {

        javax.xml.stream.XMLStreamReader reader = param.getXMLStreamReaderWithoutCaching();
        java.lang.Object result =
            cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersionPatch.Factory
                .parse(reader);
        reader.close();
        return result;
      }

      if (cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersionPatchResponse
          .class
          .equals(type)) {

        javax.xml.stream.XMLStreamReader reader = param.getXMLStreamReaderWithoutCaching();
        java.lang.Object result =
            cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersionPatchResponse
                .Factory.parse(reader);
        reader.close();
        return result;
      }

      if (cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersionResponse.class
          .equals(type)) {

        javax.xml.stream.XMLStreamReader reader = param.getXMLStreamReaderWithoutCaching();
        java.lang.Object result =
            cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetVersionResponse
                .Factory.parse(reader);
        reader.close();
        return result;
      }

    } catch (java.lang.Exception e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }
    return null;
  }
}
