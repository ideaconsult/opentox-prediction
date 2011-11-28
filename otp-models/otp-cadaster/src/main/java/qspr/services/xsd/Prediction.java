/**
 * Prediction.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package qspr.services.xsd;

public class Prediction  implements java.io.Serializable {
    private java.lang.String error;

    private qspr.services.xsd.PropertyPrediction[] predictions;

    public Prediction() {
    }

    public Prediction(
           java.lang.String error,
           qspr.services.xsd.PropertyPrediction[] predictions) {
           this.error = error;
           this.predictions = predictions;
    }


    /**
     * Gets the error value for this Prediction.
     * 
     * @return error
     */
    public java.lang.String getError() {
        return error;
    }


    /**
     * Sets the error value for this Prediction.
     * 
     * @param error
     */
    public void setError(java.lang.String error) {
        this.error = error;
    }


    /**
     * Gets the predictions value for this Prediction.
     * 
     * @return predictions
     */
    public qspr.services.xsd.PropertyPrediction[] getPredictions() {
        return predictions;
    }


    /**
     * Sets the predictions value for this Prediction.
     * 
     * @param predictions
     */
    public void setPredictions(qspr.services.xsd.PropertyPrediction[] predictions) {
        this.predictions = predictions;
    }

    public qspr.services.xsd.PropertyPrediction getPredictions(int i) {
        return this.predictions[i];
    }

    public void setPredictions(int i, qspr.services.xsd.PropertyPrediction _value) {
        this.predictions[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Prediction)) return false;
        Prediction other = (Prediction) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.error==null && other.getError()==null) || 
             (this.error!=null &&
              this.error.equals(other.getError()))) &&
            ((this.predictions==null && other.getPredictions()==null) || 
             (this.predictions!=null &&
              java.util.Arrays.equals(this.predictions, other.getPredictions())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getError() != null) {
            _hashCode += getError().hashCode();
        }
        if (getPredictions() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPredictions());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPredictions(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Prediction.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://services.qspr/xsd", "Prediction"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("error");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.qspr/xsd", "error"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("predictions");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.qspr/xsd", "predictions"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://services.qspr/xsd", "PropertyPrediction"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
