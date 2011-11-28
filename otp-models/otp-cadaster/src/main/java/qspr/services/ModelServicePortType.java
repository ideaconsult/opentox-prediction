/**
 * ModelServicePortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package qspr.services;

public interface ModelServicePortType extends java.rmi.Remote {
    public qspr.services.xsd.CreateEntityResponse createRecord(java.lang.Long sessionId, qspr.services.xsd.ImportableRecord iRecord) throws java.rmi.RemoteException;
    public qspr.services.xsd.ModelResponse applyModelSingleSDF(java.lang.Long modelId, java.lang.String sdf) throws java.rmi.RemoteException;
    public qspr.services.xsd.CreateEntityResponse createModel(java.lang.Long sessionId, java.lang.String modelTemplateXml, java.lang.String modelName, java.lang.String trainingSetName, java.lang.String validationSetName, java.lang.Integer priority) throws java.rmi.RemoteException;
    public qspr.services.xsd.CreateEntityResponse createProperty(java.lang.Long sessionId, qspr.services.xsd.ImportableProperty iProperty) throws java.rmi.RemoteException;
    public qspr.services.xsd.ModelResponse postModel(java.lang.Long modelId, java.lang.String[] sdfs) throws java.rmi.RemoteException;
    public qspr.services.xsd.CreateEntityResponse login(java.lang.String username, java.lang.String password) throws java.rmi.RemoteException;
    public qspr.services.xsd.CreateEntityResponse getModelStatus(java.lang.Long sessionId, java.lang.Long publicModelID) throws java.rmi.RemoteException;
    public qspr.services.xsd.ModelResponse postModelSingleSDF(java.lang.Long modelId, java.lang.String sdf) throws java.rmi.RemoteException;
    public qspr.services.xsd.CreateEntityResponse createPropertyAllArguments(java.lang.Long sessionId, java.lang.String name, java.lang.String defaultUnit, java.lang.String description, java.lang.Integer type, java.lang.String tags) throws java.rmi.RemoteException;
    public qspr.services.xsd.CreateEntityResponse createRecordAllArguments(java.lang.Long sessionId, java.lang.String propertyName, java.lang.String smiles, java.lang.String articleId, java.lang.String value, java.lang.String unit, java.lang.String name, java.lang.String casRn, java.lang.Boolean hidden, java.lang.String basketName) throws java.rmi.RemoteException;
    public void log(java.lang.String msg) throws java.rmi.RemoteException;
    public qspr.services.xsd.ModelResponse fetchModel(java.lang.Long taskId) throws java.rmi.RemoteException;
    public long[] getModelIDs(java.lang.Long sessionId, java.lang.String queryOnName) throws java.rmi.RemoteException;
    public qspr.services.xsd.PropertyPrediction[] getModelStatistics(java.lang.Long sessionId, java.lang.Long publicModelId) throws java.rmi.RemoteException;
}
