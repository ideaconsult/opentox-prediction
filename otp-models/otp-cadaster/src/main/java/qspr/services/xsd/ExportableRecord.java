/**
 * ExportableRecord.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package qspr.services.xsd;

public class ExportableRecord  implements java.io.Serializable {
    private java.lang.String comment;

    private java.lang.String externalId;

    private java.lang.String introducer;

    private java.lang.String modifier;

    private java.lang.String molNum;

    private java.lang.Integer moleculeId;

    private java.lang.String property;

    private java.lang.Long recordId;

    private java.lang.Double value;

    private java.lang.String valueStr;

    public ExportableRecord() {
    }

    public ExportableRecord(
           java.lang.String comment,
           java.lang.String externalId,
           java.lang.String introducer,
           java.lang.String modifier,
           java.lang.String molNum,
           java.lang.Integer moleculeId,
           java.lang.String property,
           java.lang.Long recordId,
           java.lang.Double value,
           java.lang.String valueStr) {
           this.comment = comment;
           this.externalId = externalId;
           this.introducer = introducer;
           this.modifier = modifier;
           this.molNum = molNum;
           this.moleculeId = moleculeId;
           this.property = property;
           this.recordId = recordId;
           this.value = value;
           this.valueStr = valueStr;
    }


    /**
     * Gets the comment value for this ExportableRecord.
     * 
     * @return comment
     */
    public java.lang.String getComment() {
        return comment;
    }


    /**
     * Sets the comment value for this ExportableRecord.
     * 
     * @param comment
     */
    public void setComment(java.lang.String comment) {
        this.comment = comment;
    }


    /**
     * Gets the externalId value for this ExportableRecord.
     * 
     * @return externalId
     */
    public java.lang.String getExternalId() {
        return externalId;
    }


    /**
     * Sets the externalId value for this ExportableRecord.
     * 
     * @param externalId
     */
    public void setExternalId(java.lang.String externalId) {
        this.externalId = externalId;
    }


    /**
     * Gets the introducer value for this ExportableRecord.
     * 
     * @return introducer
     */
    public java.lang.String getIntroducer() {
        return introducer;
    }


    /**
     * Sets the introducer value for this ExportableRecord.
     * 
     * @param introducer
     */
    public void setIntroducer(java.lang.String introducer) {
        this.introducer = introducer;
    }


    /**
     * Gets the modifier value for this ExportableRecord.
     * 
     * @return modifier
     */
    public java.lang.String getModifier() {
        return modifier;
    }


    /**
     * Sets the modifier value for this ExportableRecord.
     * 
     * @param modifier
     */
    public void setModifier(java.lang.String modifier) {
        this.modifier = modifier;
    }


    /**
     * Gets the molNum value for this ExportableRecord.
     * 
     * @return molNum
     */
    public java.lang.String getMolNum() {
        return molNum;
    }


    /**
     * Sets the molNum value for this ExportableRecord.
     * 
     * @param molNum
     */
    public void setMolNum(java.lang.String molNum) {
        this.molNum = molNum;
    }


    /**
     * Gets the moleculeId value for this ExportableRecord.
     * 
     * @return moleculeId
     */
    public java.lang.Integer getMoleculeId() {
        return moleculeId;
    }


    /**
     * Sets the moleculeId value for this ExportableRecord.
     * 
     * @param moleculeId
     */
    public void setMoleculeId(java.lang.Integer moleculeId) {
        this.moleculeId = moleculeId;
    }


    /**
     * Gets the property value for this ExportableRecord.
     * 
     * @return property
     */
    public java.lang.String getProperty() {
        return property;
    }


    /**
     * Sets the property value for this ExportableRecord.
     * 
     * @param property
     */
    public void setProperty(java.lang.String property) {
        this.property = property;
    }


    /**
     * Gets the recordId value for this ExportableRecord.
     * 
     * @return recordId
     */
    public java.lang.Long getRecordId() {
        return recordId;
    }


    /**
     * Sets the recordId value for this ExportableRecord.
     * 
     * @param recordId
     */
    public void setRecordId(java.lang.Long recordId) {
        this.recordId = recordId;
    }


    /**
     * Gets the value value for this ExportableRecord.
     * 
     * @return value
     */
    public java.lang.Double getValue() {
        return value;
    }


    /**
     * Sets the value value for this ExportableRecord.
     * 
     * @param value
     */
    public void setValue(java.lang.Double value) {
        this.value = value;
    }


    /**
     * Gets the valueStr value for this ExportableRecord.
     * 
     * @return valueStr
     */
    public java.lang.String getValueStr() {
        return valueStr;
    }


    /**
     * Sets the valueStr value for this ExportableRecord.
     * 
     * @param valueStr
     */
    public void setValueStr(java.lang.String valueStr) {
        this.valueStr = valueStr;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ExportableRecord)) return false;
        ExportableRecord other = (ExportableRecord) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.comment==null && other.getComment()==null) || 
             (this.comment!=null &&
              this.comment.equals(other.getComment()))) &&
            ((this.externalId==null && other.getExternalId()==null) || 
             (this.externalId!=null &&
              this.externalId.equals(other.getExternalId()))) &&
            ((this.introducer==null && other.getIntroducer()==null) || 
             (this.introducer!=null &&
              this.introducer.equals(other.getIntroducer()))) &&
            ((this.modifier==null && other.getModifier()==null) || 
             (this.modifier!=null &&
              this.modifier.equals(other.getModifier()))) &&
            ((this.molNum==null && other.getMolNum()==null) || 
             (this.molNum!=null &&
              this.molNum.equals(other.getMolNum()))) &&
            ((this.moleculeId==null && other.getMoleculeId()==null) || 
             (this.moleculeId!=null &&
              this.moleculeId.equals(other.getMoleculeId()))) &&
            ((this.property==null && other.getProperty()==null) || 
             (this.property!=null &&
              this.property.equals(other.getProperty()))) &&
            ((this.recordId==null && other.getRecordId()==null) || 
             (this.recordId!=null &&
              this.recordId.equals(other.getRecordId()))) &&
            ((this.value==null && other.getValue()==null) || 
             (this.value!=null &&
              this.value.equals(other.getValue()))) &&
            ((this.valueStr==null && other.getValueStr()==null) || 
             (this.valueStr!=null &&
              this.valueStr.equals(other.getValueStr())));
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
        if (getComment() != null) {
            _hashCode += getComment().hashCode();
        }
        if (getExternalId() != null) {
            _hashCode += getExternalId().hashCode();
        }
        if (getIntroducer() != null) {
            _hashCode += getIntroducer().hashCode();
        }
        if (getModifier() != null) {
            _hashCode += getModifier().hashCode();
        }
        if (getMolNum() != null) {
            _hashCode += getMolNum().hashCode();
        }
        if (getMoleculeId() != null) {
            _hashCode += getMoleculeId().hashCode();
        }
        if (getProperty() != null) {
            _hashCode += getProperty().hashCode();
        }
        if (getRecordId() != null) {
            _hashCode += getRecordId().hashCode();
        }
        if (getValue() != null) {
            _hashCode += getValue().hashCode();
        }
        if (getValueStr() != null) {
            _hashCode += getValueStr().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ExportableRecord.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://services.qspr/xsd", "ExportableRecord"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comment");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.qspr/xsd", "comment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("externalId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.qspr/xsd", "externalId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("introducer");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.qspr/xsd", "introducer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("modifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.qspr/xsd", "modifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("molNum");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.qspr/xsd", "molNum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("moleculeId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.qspr/xsd", "moleculeId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("property");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.qspr/xsd", "property"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("recordId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.qspr/xsd", "recordId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("value");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.qspr/xsd", "value"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valueStr");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.qspr/xsd", "valueStr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
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
