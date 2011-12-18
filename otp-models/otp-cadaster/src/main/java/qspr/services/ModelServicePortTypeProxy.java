package qspr.services;

public class ModelServicePortTypeProxy implements qspr.services.ModelServicePortType {
  private String _endpoint = null;
  private qspr.services.ModelServicePortType modelServicePortType = null;
  
  public ModelServicePortTypeProxy() {
    _initModelServicePortTypeProxy();
  }
  
  public ModelServicePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initModelServicePortTypeProxy();
  }
  
  private void _initModelServicePortTypeProxy() {
    try {
      modelServicePortType = (new qspr.services.ModelServiceLocator()).getModelServiceHttpSoap11Endpoint();
      if (modelServicePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)modelServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)modelServicePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (modelServicePortType != null)
      ((javax.xml.rpc.Stub)modelServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public qspr.services.ModelServicePortType getModelServicePortType() {
    if (modelServicePortType == null)
      _initModelServicePortTypeProxy();
    return modelServicePortType;
  }
  
  public qspr.services.xsd.CreateEntityResponse createRecord(java.lang.Long sessionId, qspr.services.xsd.ImportableRecord iRecord) throws java.rmi.RemoteException{
    if (modelServicePortType == null)
      _initModelServicePortTypeProxy();
    return modelServicePortType.createRecord(sessionId, iRecord);
  }
  
  public qspr.services.xsd.ModelResponse applyModelSingleSDF(java.lang.Long modelId, java.lang.String sdf) throws java.rmi.RemoteException{
    if (modelServicePortType == null)
      _initModelServicePortTypeProxy();
    return modelServicePortType.applyModelSingleSDF(modelId, sdf);
  }
  
  public qspr.services.xsd.CreateEntityResponse createModel(java.lang.Long sessionId, java.lang.String modelTemplateXml, java.lang.String modelName, java.lang.String trainingSetName, java.lang.String validationSetName, java.lang.Integer priority) throws java.rmi.RemoteException{
    if (modelServicePortType == null)
      _initModelServicePortTypeProxy();
    return modelServicePortType.createModel(sessionId, modelTemplateXml, modelName, trainingSetName, validationSetName, priority);
  }
  
  public qspr.services.xsd.CreateEntityResponse createProperty(java.lang.Long sessionId, qspr.services.xsd.ImportableProperty iProperty) throws java.rmi.RemoteException{
    if (modelServicePortType == null)
      _initModelServicePortTypeProxy();
    return modelServicePortType.createProperty(sessionId, iProperty);
  }
  
  public qspr.services.xsd.ModelResponse postModel(java.lang.Long modelId, java.lang.String[] sdfs) throws java.rmi.RemoteException{
    if (modelServicePortType == null)
      _initModelServicePortTypeProxy();
    return modelServicePortType.postModel(modelId, sdfs);
  }
  
  public qspr.services.xsd.CreateEntityResponse login(java.lang.String username, java.lang.String password) throws java.rmi.RemoteException{
    if (modelServicePortType == null)
      _initModelServicePortTypeProxy();
    return modelServicePortType.login(username, password);
  }
  
  public qspr.services.xsd.CreateEntityResponse getModelStatus(java.lang.Long sessionId, java.lang.Long publicModelID) throws java.rmi.RemoteException{
    if (modelServicePortType == null)
      _initModelServicePortTypeProxy();
    return modelServicePortType.getModelStatus(sessionId, publicModelID);
  }
  
  public qspr.services.xsd.ModelResponse postModelSingleSDF(java.lang.Long modelId, java.lang.String sdf) throws java.rmi.RemoteException{
    if (modelServicePortType == null)
      _initModelServicePortTypeProxy();
    return modelServicePortType.postModelSingleSDF(modelId, sdf);
  }
  
  public qspr.services.xsd.CreateEntityResponse createPropertyAllArguments(java.lang.Long sessionId, java.lang.String name, java.lang.String defaultUnit, java.lang.String description, java.lang.Integer type, java.lang.String tags, java.lang.String options) throws java.rmi.RemoteException{
    if (modelServicePortType == null)
      _initModelServicePortTypeProxy();
    return modelServicePortType.createPropertyAllArguments(sessionId, name, defaultUnit, description, type, tags, options);
  }
  
  public qspr.services.xsd.CreateEntityResponse createRecordAllArguments(java.lang.Long sessionId, java.lang.String propertyName, java.lang.String smiles, java.lang.String articleId, java.lang.String value, java.lang.String unit, java.lang.String name, java.lang.String casRn, java.lang.Boolean hidden, java.lang.String basketName) throws java.rmi.RemoteException{
    if (modelServicePortType == null)
      _initModelServicePortTypeProxy();
    return modelServicePortType.createRecordAllArguments(sessionId, propertyName, smiles, articleId, value, unit, name, casRn, hidden, basketName);
  }
  
  public void log(java.lang.String msg) throws java.rmi.RemoteException{
    if (modelServicePortType == null)
      _initModelServicePortTypeProxy();
    modelServicePortType.log(msg);
  }
  
  public qspr.services.xsd.ModelResponse fetchModel(java.lang.Long taskId) throws java.rmi.RemoteException{
    if (modelServicePortType == null)
      _initModelServicePortTypeProxy();
    return modelServicePortType.fetchModel(taskId);
  }
  
  public long[] getModelIDs(java.lang.Long sessionId, java.lang.String queryOnName) throws java.rmi.RemoteException{
    if (modelServicePortType == null)
      _initModelServicePortTypeProxy();
    return modelServicePortType.getModelIDs(sessionId, queryOnName);
  }
  
  public qspr.services.xsd.PropertyPrediction[] getModelStatistics(java.lang.Long sessionId, java.lang.Long publicModelId) throws java.rmi.RemoteException{
    if (modelServicePortType == null)
      _initModelServicePortTypeProxy();
    return modelServicePortType.getModelStatistics(sessionId, publicModelId);
  }
  
  
}