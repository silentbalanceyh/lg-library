//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.05.05 at 10:17:11 AM CST 
//


package oasis.names.specification.ubl.schema.xsd.priorinformationnotice_2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the oasis.names.specification.ubl.schema.xsd.priorinformationnotice_2 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _PriorInformationNotice_QNAME = new QName("urn:oasis:names:specification:ubl:schema:xsd:PriorInformationNotice-2", "PriorInformationNotice");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: oasis.names.specification.ubl.schema.xsd.priorinformationnotice_2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PriorInformationNoticeType }
     * 
     */
    public PriorInformationNoticeType createPriorInformationNoticeType() {
        return new PriorInformationNoticeType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PriorInformationNoticeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:oasis:names:specification:ubl:schema:xsd:PriorInformationNotice-2", name = "PriorInformationNotice")
    public JAXBElement<PriorInformationNoticeType> createPriorInformationNotice(PriorInformationNoticeType value) {
        return new JAXBElement<PriorInformationNoticeType>(_PriorInformationNotice_QNAME, PriorInformationNoticeType.class, null, value);
    }

}
