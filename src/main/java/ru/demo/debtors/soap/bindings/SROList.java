//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.12.21 at 09:21:02 AM MSK 
//


package ru.demo.debtors.soap.bindings;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SROList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SROList"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SROList" type="{http://tempuri.org/}ArrayOfSroRegisterItem" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SROList", propOrder = {
    "sroList"
})
public class SROList {

    @XmlElement(name = "SROList")
    protected ArrayOfSroRegisterItem sroList;

    /**
     * Gets the value of the sroList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfSroRegisterItem }
     *     
     */
    public ArrayOfSroRegisterItem getSROList() {
        return sroList;
    }

    /**
     * Sets the value of the sroList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfSroRegisterItem }
     *     
     */
    public void setSROList(ArrayOfSroRegisterItem value) {
        this.sroList = value;
    }

}
