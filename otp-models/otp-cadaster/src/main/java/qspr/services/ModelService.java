/**
 * ModelService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package qspr.services;

public interface ModelService extends javax.xml.rpc.Service {
    public java.lang.String getModelServiceHttpSoap12EndpointAddress();

    public qspr.services.ModelServicePortType getModelServiceHttpSoap12Endpoint() throws javax.xml.rpc.ServiceException;

    public qspr.services.ModelServicePortType getModelServiceHttpSoap12Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
    public java.lang.String getModelServiceHttpSoap11EndpointAddress();

    public qspr.services.ModelServicePortType getModelServiceHttpSoap11Endpoint() throws javax.xml.rpc.ServiceException;

    public qspr.services.ModelServicePortType getModelServiceHttpSoap11Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
