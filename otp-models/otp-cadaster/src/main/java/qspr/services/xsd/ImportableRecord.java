/**
 * ImportableRecord.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package qspr.services.xsd;

public class ImportableRecord  implements java.io.Serializable {
    private java.lang.String accuracy;

    private java.lang.String articleId;

    private java.lang.String basketName;

    private java.lang.String casRn;

    private java.lang.Boolean hidden;

    private java.lang.String name;

    private java.lang.String num;

    private java.lang.String propertyName;

    private java.lang.String smiles;

    private java.lang.String unit;

    private java.lang.String value;

    public ImportableRecord() {
    }

    public ImportableRecord(
           java.lang.String accuracy,
           java.lang.String articleId,
           java.lang.String basketName,
           java.lang.String casRn,
           java.lang.Boolean hidden,
           java.lang.String name,
           java.lang.String num,
           java.lang.String propertyName,
           java.lang.String smiles,
           java.lang.String unit,
           java.lang.String value) {
           this.accuracy = accuracy;
           this.articleId = articleId;
           this.basketName = basketName;
           this.casRn = casRn;
           this.hidden = hidden;
           this.name = name;
           this.num = num;
           this.propertyName = propertyName;
           this.smiles = smiles;
           this.unit = unit;
           this.value = value;
    }


    /**
     * Gets the accuracy value for this ImportableRecord.
     * 
     * @return accuracy
     */
    public java.lang.String getAccuracy() {
        return accuracy;
    }


    /**
     * Sets the accuracy value for this ImportableRecord.
     * 
     * @param accuracy
     */
    public void setAccuracy(java.lang.String accuracy) {
        this.accuracy = accuracy;
    }


    /**
     * Gets the articleId value for this ImportableRecord.
     * 
     * @return articleId
     */
    public java.lang.String getArticleId() {
        return articleId;
    }


    /**
     * Sets the articleId value for this ImportableRecord.
     * 
     * @param articleId
     */
    public void setArticleId(java.lang.String articleId) {
        this.articleId = articleId;
    }


    /**
     * Gets the basketName value for this ImportableRecord.
     * 
     * @return basketName
     */
    public java.lang.String getBasketName() {
        return basketName;
    }


    /**
     * Sets the basketName value for this ImportableRecord.
     * 
     * @param basketName
     */
    public void setBasketName(java.lang.String basketName) {
        this.basketName = basketName;
    }


    /**
     * Gets the casRn value for this ImportableRecord.
     * 
     * @return casRn
     */
    public java.lang.String getCasRn() {
        return casRn;
    }


    /**
     * Sets the casRn value for this ImportableRecord.
     * 
     * @param casRn
     */
    public void setCasRn(java.lang.String casRn) {
        this.casRn = casRn;
    }


    /**
     * Gets the hidden value for this ImportableRecord.
     * 
     * @return hidden
     */
    public java.lang.Boolean getHidden() {
        return hidden;
    }


    /**
     * Sets the hidden value for this ImportableRecord.
     * 
     * @param hidden
     */
    public void setHidden(java.lang.Boolean hidden) {
        this.hidden = hidden;
    }


    /**
     * Gets the name value for this ImportableRecord.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this ImportableRecord.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the num value for this ImportableRecord.
     * 
     * @return num
     */
    public java.lang.String getNum() {
        return num;
    }


    /**
     * Sets the num value for this ImportableRecord.
     * 
     * @param num
     */
    public void setNum(java.lang.String num) {
        this.num = num;
    }


    /**
     * Gets the propertyName value for this ImportableRecord.
     * 
     * @return propertyName
     */
    public java.lang.String getPropertyName() {
        return propertyName;
    }


    /**
     * Sets the propertyName value for this ImportableRecord.
     * 
     * @param propertyName
     */
    public void setPropertyName(java.lang.String propertyName) {
        this.propertyName = propertyName;
    }


    /**
     * Gets the smiles value for this ImportableRecord.
     * 
     * @return smiles
     */
    public java.lang.String getSmiles() {
        return smiles;
    }


    /**
     * Sets the smiles value for this ImportableRecord.
     * 
     * @param smiles
     */
    public void setSmiles(java.lang.String smiles) {
        this.smiles = smiles;
    }


    /**
     * Gets the unit value for this ImportableRecord.
     * 
     * @return unit
     */
    public java.lang.String getUnit() {
        return unit;
    }


    /**
     * Sets the unit value for this ImportableRecord.
     * 
     * @param unit
     */
    public void setUnit(java.lang.String unit) {
        this.unit = unit;
    }


    /**
     * Gets the value value for this ImportableRecord.
     * 
     * @return value
     */
    public java.lang.String getValue() {
        return value;
    }


    /**
     * Sets the value value for this ImportableRecord.
     * 
     * @param value
     */
    public void setValue(java.lang.String value) {
        this.value = value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ImportableRecord)) return false;
        ImportableRecord other = (ImportableRecord) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.accuracy==null && other.getAccuracy()==null) || 
             (this.accuracy!=null &&
              this.accuracy.equals(other.getAccuracy()))) &&
            ((this.articleId==null && other.getArticleId()==null) || 
             (this.articleId!=null &&
              this.articleId.equals(other.getArticleId()))) &&
            ((this.basketName==null && other.getBasketName()==null) || 
             (this.basketName!=null &&
              this.basketName.equals(other.getBasketName()))) &&
            ((this.casRn==null && other.getCasRn()==null) || 
             (this.casRn!=null &&
              this.casRn.equals(other.getCasRn()))) &&
            ((this.hidden==null && other.getHidden()==null) || 
             (this.hidden!=null &&
              this.hidden.equals(other.getHidden()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.num==null && other.getNum()==null) || 
             (this.num!=null &&
              this.num.equals(other.getNum()))) &&
            ((this.propertyName==null && other.getPropertyName()==null) || 
             (this.propertyName!=null &&
              this.propertyName.equals(other.getPropertyName()))) &&
            ((this.smiles==null && other.getSmiles()==null) || 
             (this.smiles!=null &&
              this.smiles.equals(other.getSmiles()))) &&
            ((this.unit==null && other.getUnit()==null) || 
             (this.unit!=null &&
              this.unit.equals(other.getUnit()))) &&
            ((this.value==null && other.getValue()==null) || 
             (this.value!=null &&
              this.value.equals(other.getValue())));
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
        if (getAccuracy() != null) {
            _hashCode += getAccuracy().hashCode();
        }
        if (getArticleId() != null) {
            _hashCode += getArticleId().hashCode();
        }
        if (getBasketName() != null) {
            _hashCode += getBasketName().hashCode();
        }
        if (getCasRn() != null) {
            _hashCode += getCasRn().hashCode();
        }
        if (getHidden() != null) {
            _hashCode += getHidden().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getNum() != null) {
            _hashCode += getNum().hashCode();
        }
        if (getPropertyName() != null) {
            _hashCode += getPropertyName().hashCode();
        }
        if (getSmiles() != null) {
            _hashCode += getSmiles().hashCode();
        }
        if (getUnit() != null) {
            _hashCode += getUnit().hashCode();
        }
        if (getValue() != null) {
            _hashCode += getValue().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ImportableRecord.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://services.qspr/xsd", "ImportableRecord"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accuracy");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.qspr/xsd", "accuracy"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("articleId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.qspr/xsd", "articleId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("basketName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.qspr/xsd", "basketName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("casRn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.qspr/xsd", "casRn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hidden");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.qspr/xsd", "hidden"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.qspr/xsd", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("num");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.qspr/xsd", "num"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("propertyName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.qspr/xsd", "propertyName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("smiles");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.qspr/xsd", "smiles"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unit");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.qspr/xsd", "unit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("value");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.qspr/xsd", "value"));
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
