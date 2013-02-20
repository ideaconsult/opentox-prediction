
/**
 * ModelServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package qspr.services;

    /**
     *  ModelServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class ModelServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public ModelServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public ModelServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for createRecordAllArguments method
            * override this method for handling normal response from createRecordAllArguments operation
            */
           public void receiveResultcreateRecordAllArguments(
                    qspr.services.ModelServiceStub.CreateRecordAllArgumentsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from createRecordAllArguments operation
           */
            public void receiveErrorcreateRecordAllArguments(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for createModel method
            * override this method for handling normal response from createModel operation
            */
           public void receiveResultcreateModel(
                    qspr.services.ModelServiceStub.CreateModelResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from createModel operation
           */
            public void receiveErrorcreateModel(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for createProperty method
            * override this method for handling normal response from createProperty operation
            */
           public void receiveResultcreateProperty(
                    qspr.services.ModelServiceStub.CreatePropertyResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from createProperty operation
           */
            public void receiveErrorcreateProperty(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteModel method
            * override this method for handling normal response from deleteModel operation
            */
           public void receiveResultdeleteModel(
                    qspr.services.ModelServiceStub.DeleteModelResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteModel operation
           */
            public void receiveErrordeleteModel(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for postModelForBasket method
            * override this method for handling normal response from postModelForBasket operation
            */
           public void receiveResultpostModelForBasket(
                    qspr.services.ModelServiceStub.PostModelForBasketResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from postModelForBasket operation
           */
            public void receiveErrorpostModelForBasket(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getModelSummaryFraction method
            * override this method for handling normal response from getModelSummaryFraction operation
            */
           public void receiveResultgetModelSummaryFraction(
                    qspr.services.ModelServiceStub.GetModelSummaryFractionResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getModelSummaryFraction operation
           */
            public void receiveErrorgetModelSummaryFraction(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for postModel method
            * override this method for handling normal response from postModel operation
            */
           public void receiveResultpostModel(
                    qspr.services.ModelServiceStub.PostModelResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from postModel operation
           */
            public void receiveErrorpostModel(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteRecordFromBasket method
            * override this method for handling normal response from deleteRecordFromBasket operation
            */
           public void receiveResultdeleteRecordFromBasket(
                    qspr.services.ModelServiceStub.DeleteRecordFromBasketResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteRecordFromBasket operation
           */
            public void receiveErrordeleteRecordFromBasket(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getModelIDs method
            * override this method for handling normal response from getModelIDs operation
            */
           public void receiveResultgetModelIDs(
                    qspr.services.ModelServiceStub.GetModelIDsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getModelIDs operation
           */
            public void receiveErrorgetModelIDs(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getModelStatistics method
            * override this method for handling normal response from getModelStatistics operation
            */
           public void receiveResultgetModelStatistics(
                    qspr.services.ModelServiceStub.GetModelStatisticsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getModelStatistics operation
           */
            public void receiveErrorgetModelStatistics(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for exportBasket method
            * override this method for handling normal response from exportBasket operation
            */
           public void receiveResultexportBasket(
                    qspr.services.ModelServiceStub.ExportBasketResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from exportBasket operation
           */
            public void receiveErrorexportBasket(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getModelName method
            * override this method for handling normal response from getModelName operation
            */
           public void receiveResultgetModelName(
                    qspr.services.ModelServiceStub.GetModelNameResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getModelName operation
           */
            public void receiveErrorgetModelName(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for markRecordExcluded method
            * override this method for handling normal response from markRecordExcluded operation
            */
           public void receiveResultmarkRecordExcluded(
                    qspr.services.ModelServiceStub.MarkRecordExcludedResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from markRecordExcluded operation
           */
            public void receiveErrormarkRecordExcluded(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getModelForProperty method
            * override this method for handling normal response from getModelForProperty operation
            */
           public void receiveResultgetModelForProperty(
                    qspr.services.ModelServiceStub.GetModelForPropertyResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getModelForProperty operation
           */
            public void receiveErrorgetModelForProperty(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for fetchModel method
            * override this method for handling normal response from fetchModel operation
            */
           public void receiveResultfetchModel(
                    qspr.services.ModelServiceStub.FetchModelResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from fetchModel operation
           */
            public void receiveErrorfetchModel(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for createBasket method
            * override this method for handling normal response from createBasket operation
            */
           public void receiveResultcreateBasket(
                    qspr.services.ModelServiceStub.CreateBasketResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from createBasket operation
           */
            public void receiveErrorcreateBasket(java.lang.Exception e) {
            }
                
               // No methods generated for meps other than in-out
                
           /**
            * auto generated Axis2 call back method for getModelSummary method
            * override this method for handling normal response from getModelSummary operation
            */
           public void receiveResultgetModelSummary(
                    qspr.services.ModelServiceStub.GetModelSummaryResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getModelSummary operation
           */
            public void receiveErrorgetModelSummary(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for markRecordIncluded method
            * override this method for handling normal response from markRecordIncluded operation
            */
           public void receiveResultmarkRecordIncluded(
                    qspr.services.ModelServiceStub.MarkRecordIncludedResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from markRecordIncluded operation
           */
            public void receiveErrormarkRecordIncluded(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for postModelSingleSDF method
            * override this method for handling normal response from postModelSingleSDF operation
            */
           public void receiveResultpostModelSingleSDF(
                    qspr.services.ModelServiceStub.PostModelSingleSDFResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from postModelSingleSDF operation
           */
            public void receiveErrorpostModelSingleSDF(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for convertUnits method
            * override this method for handling normal response from convertUnits operation
            */
           public void receiveResultconvertUnits(
                    qspr.services.ModelServiceStub.ConvertUnitsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from convertUnits operation
           */
            public void receiveErrorconvertUnits(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for createPropertyAllArguments method
            * override this method for handling normal response from createPropertyAllArguments operation
            */
           public void receiveResultcreatePropertyAllArguments(
                    qspr.services.ModelServiceStub.CreatePropertyAllArgumentsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from createPropertyAllArguments operation
           */
            public void receiveErrorcreatePropertyAllArguments(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for login method
            * override this method for handling normal response from login operation
            */
           public void receiveResultlogin(
                    qspr.services.ModelServiceStub.LoginResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from login operation
           */
            public void receiveErrorlogin(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addRecordToBasket method
            * override this method for handling normal response from addRecordToBasket operation
            */
           public void receiveResultaddRecordToBasket(
                    qspr.services.ModelServiceStub.AddRecordToBasketResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addRecordToBasket operation
           */
            public void receiveErroraddRecordToBasket(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for createRecord method
            * override this method for handling normal response from createRecord operation
            */
           public void receiveResultcreateRecord(
                    qspr.services.ModelServiceStub.CreateRecordResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from createRecord operation
           */
            public void receiveErrorcreateRecord(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getBasketIDs method
            * override this method for handling normal response from getBasketIDs operation
            */
           public void receiveResultgetBasketIDs(
                    qspr.services.ModelServiceStub.GetBasketIDsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getBasketIDs operation
           */
            public void receiveErrorgetBasketIDs(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getModelStatus method
            * override this method for handling normal response from getModelStatus operation
            */
           public void receiveResultgetModelStatus(
                    qspr.services.ModelServiceStub.GetModelStatusResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getModelStatus operation
           */
            public void receiveErrorgetModelStatus(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for applyModelSingleSDF method
            * override this method for handling normal response from applyModelSingleSDF operation
            */
           public void receiveResultapplyModelSingleSDF(
                    qspr.services.ModelServiceStub.ApplyModelSingleSDFResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from applyModelSingleSDF operation
           */
            public void receiveErrorapplyModelSingleSDF(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for applyModelSingleSDFWithUnits method
            * override this method for handling normal response from applyModelSingleSDFWithUnits operation
            */
           public void receiveResultapplyModelSingleSDFWithUnits(
                    qspr.services.ModelServiceStub.ApplyModelSingleSDFWithUnitsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from applyModelSingleSDFWithUnits operation
           */
            public void receiveErrorapplyModelSingleSDFWithUnits(java.lang.Exception e) {
            }
                


    }
    