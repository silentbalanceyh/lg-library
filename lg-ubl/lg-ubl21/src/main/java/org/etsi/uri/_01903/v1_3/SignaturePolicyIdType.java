//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.05.05 at 10:17:11 AM CST 
//


package org.etsi.uri._01903.v1_3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.w3._2000._09.xmldsig_.TransformsType;


/**
 * <p>Java class for SignaturePolicyIdType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SignaturePolicyIdType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SigPolicyId" type="{http://uri.etsi.org/01903/v1.3.2#}ObjectIdentifierType"/>
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}Transforms" minOccurs="0"/>
 *         &lt;element name="SigPolicyHash" type="{http://uri.etsi.org/01903/v1.3.2#}DigestAlgAndValueType"/>
 *         &lt;element name="SigPolicyQualifiers" type="{http://uri.etsi.org/01903/v1.3.2#}SigPolicyQualifiersListType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SignaturePolicyIdType", propOrder = {
    "sigPolicyId",
    "transforms",
    "sigPolicyHash",
    "sigPolicyQualifiers"
})
public class SignaturePolicyIdType {

    @XmlElement(name = "SigPolicyId", required = true)
    protected ObjectIdentifierType sigPolicyId;
    @XmlElement(name = "Transforms", namespace = "http://www.w3.org/2000/09/xmldsig#")
    protected TransformsType transforms;
    @XmlElement(name = "SigPolicyHash", required = true)
    protected DigestAlgAndValueType sigPolicyHash;
    @XmlElement(name = "SigPolicyQualifiers")
    protected SigPolicyQualifiersListType sigPolicyQualifiers;

    /**
     * Gets the value of the sigPolicyId property.
     * 
     * @return
     *     possible object is
     *     {@link ObjectIdentifierType }
     *     
     */
    public ObjectIdentifierType getSigPolicyId() {
        return sigPolicyId;
    }

    /**
     * Sets the value of the sigPolicyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link ObjectIdentifierType }
     *     
     */
    public void setSigPolicyId(ObjectIdentifierType value) {
        this.sigPolicyId = value;
    }

    /**
     * Gets the value of the transforms property.
     * 
     * @return
     *     possible object is
     *     {@link TransformsType }
     *     
     */
    public TransformsType getTransforms() {
        return transforms;
    }

    /**
     * Sets the value of the transforms property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransformsType }
     *     
     */
    public void setTransforms(TransformsType value) {
        this.transforms = value;
    }

    /**
     * Gets the value of the sigPolicyHash property.
     * 
     * @return
     *     possible object is
     *     {@link DigestAlgAndValueType }
     *     
     */
    public DigestAlgAndValueType getSigPolicyHash() {
        return sigPolicyHash;
    }

    /**
     * Sets the value of the sigPolicyHash property.
     * 
     * @param value
     *     allowed object is
     *     {@link DigestAlgAndValueType }
     *     
     */
    public void setSigPolicyHash(DigestAlgAndValueType value) {
        this.sigPolicyHash = value;
    }

    /**
     * Gets the value of the sigPolicyQualifiers property.
     * 
     * @return
     *     possible object is
     *     {@link SigPolicyQualifiersListType }
     *     
     */
    public SigPolicyQualifiersListType getSigPolicyQualifiers() {
        return sigPolicyQualifiers;
    }

    /**
     * Sets the value of the sigPolicyQualifiers property.
     * 
     * @param value
     *     allowed object is
     *     {@link SigPolicyQualifiersListType }
     *     
     */
    public void setSigPolicyQualifiers(SigPolicyQualifiersListType value) {
        this.sigPolicyQualifiers = value;
    }

}
