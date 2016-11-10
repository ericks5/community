/********************************************************************************* 
* Ephesoft is a Intelligent Document Capture and Mailroom Automation program 
* developed by Ephesoft, Inc. Copyright (C) 2015 Ephesoft Inc. 
* 
* This program is free software; you can redistribute it and/or modify it under 
* the terms of the GNU Affero General Public License version 3 as published by the 
* Free Software Foundation with the addition of the following permission added 
* to Section 15 as permitted in Section 7(a): FOR ANY PART OF THE COVERED WORK 
* IN WHICH THE COPYRIGHT IS OWNED BY EPHESOFT, EPHESOFT DISCLAIMS THE WARRANTY 
* OF NON INFRINGEMENT OF THIRD PARTY RIGHTS. 
* 
* This program is distributed in the hope that it will be useful, but WITHOUT 
* ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS 
* FOR A PARTICULAR PURPOSE.  See the GNU Affero General Public License for more 
* details. 
* 
* You should have received a copy of the GNU Affero General Public License along with 
* this program; if not, see http://www.gnu.org/licenses or write to the Free 
* Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 
* 02110-1301 USA. 
* 
* You can contact Ephesoft, Inc. headquarters at 111 Academy Way, 
* Irvine, CA 92617, USA. or at email address info@ephesoft.com. 
* 
* The interactive user interfaces in modified source and object code versions 
* of this program must display Appropriate Legal Notices, as required under 
* Section 5 of the GNU Affero General Public License version 3. 
* 
* In accordance with Section 7(b) of the GNU Affero General Public License version 3, 
* these Appropriate Legal Notices must retain the display of the "Ephesoft" logo. 
* If the display of the logo is not reasonably feasible for 
* technical reasons, the Appropriate Legal Notices must display the words 
* "Powered by Ephesoft". 
********************************************************************************/ 

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.05.14 at 09:01:24 PM IST 
//


package com.ephesoft.dcma.batch.schema;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for field complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="field">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Confidence" type="{}confidence"/>
 *         &lt;element name="LearnedFileName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="OcrConfidenceThreshold" type="{}confidence"/>
 *         &lt;element name="OcrConfidence" type="{}confidence"/>
 *         &lt;element name="CoordinatesList">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Coordinates" type="{}coordinates" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Page" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="OverlayedImageFileName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FieldOrderNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="FieldValueOptionList" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ForceReview" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="readOnly" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="FieldValueChangeScript" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ExtractionName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "field", propOrder = {
    "name",
    "value",
    "type",
    "confidence",
    "learnedFileName",
    "ocrConfidenceThreshold",
    "ocrConfidence",
    "coordinatesList",
    "page",
    "overlayedImageFileName",
    "fieldOrderNumber",
    "fieldValueOptionList",
    "forceReview",
    "readOnly",
    "fieldValueChangeScript",
    "extractionName"
})
@XmlSeeAlso({
    Column.class,
    DocField.class
})
public class Field
    implements Serializable
{

    private final static long serialVersionUID = 100L;
    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "Value", required = true)
    protected String value;
    @XmlElement(name = "Type", required = true)
    protected String type;
    @XmlElement(name = "Confidence")
    protected float confidence;
    @XmlElement(name = "LearnedFileName", required = true)
    protected String learnedFileName;
    @XmlElement(name = "OcrConfidenceThreshold")
    protected float ocrConfidenceThreshold;
    @XmlElement(name = "OcrConfidence")
    protected float ocrConfidence;
    @XmlElement(name = "CoordinatesList", required = true)
    protected Field.CoordinatesList coordinatesList;
    @XmlElement(name = "Page", required = true)
    protected String page;
    @XmlElement(name = "OverlayedImageFileName", required = true)
    protected String overlayedImageFileName;
    @XmlElement(name = "FieldOrderNumber")
    protected int fieldOrderNumber;
    @XmlElement(name = "FieldValueOptionList", required = true)
    protected String fieldValueOptionList;
    @XmlElement(name = "ForceReview")
    protected boolean forceReview;
    protected boolean readOnly;
    @XmlElement(name = "FieldValueChangeScript")
    protected boolean fieldValueChangeScript;
    @XmlElement(name = "ExtractionName", required = true)
    protected String extractionName;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the confidence property.
     * 
     */
    public float getConfidence() {
        return confidence;
    }

    /**
     * Sets the value of the confidence property.
     * 
     */
    public void setConfidence(float value) {
        this.confidence = value;
    }

    /**
     * Gets the value of the learnedFileName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLearnedFileName() {
        return learnedFileName;
    }

    /**
     * Sets the value of the learnedFileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLearnedFileName(String value) {
        this.learnedFileName = value;
    }

    /**
     * Gets the value of the ocrConfidenceThreshold property.
     * 
     */
    public float getOcrConfidenceThreshold() {
        return ocrConfidenceThreshold;
    }

    /**
     * Sets the value of the ocrConfidenceThreshold property.
     * 
     */
    public void setOcrConfidenceThreshold(float value) {
        this.ocrConfidenceThreshold = value;
    }

    /**
     * Gets the value of the ocrConfidence property.
     * 
     */
    public float getOcrConfidence() {
        return ocrConfidence;
    }

    /**
     * Sets the value of the ocrConfidence property.
     * 
     */
    public void setOcrConfidence(float value) {
        this.ocrConfidence = value;
    }

    /**
     * Gets the value of the coordinatesList property.
     * 
     * @return
     *     possible object is
     *     {@link Field.CoordinatesList }
     *     
     */
    public Field.CoordinatesList getCoordinatesList() {
        return coordinatesList;
    }

    /**
     * Sets the value of the coordinatesList property.
     * 
     * @param value
     *     allowed object is
     *     {@link Field.CoordinatesList }
     *     
     */
    public void setCoordinatesList(Field.CoordinatesList value) {
        this.coordinatesList = value;
    }

    /**
     * Gets the value of the page property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPage() {
        return page;
    }

    /**
     * Sets the value of the page property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPage(String value) {
        this.page = value;
    }

    /**
     * Gets the value of the overlayedImageFileName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOverlayedImageFileName() {
        return overlayedImageFileName;
    }

    /**
     * Sets the value of the overlayedImageFileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOverlayedImageFileName(String value) {
        this.overlayedImageFileName = value;
    }

    /**
     * Gets the value of the fieldOrderNumber property.
     * 
     */
    public int getFieldOrderNumber() {
        return fieldOrderNumber;
    }

    /**
     * Sets the value of the fieldOrderNumber property.
     * 
     */
    public void setFieldOrderNumber(int value) {
        this.fieldOrderNumber = value;
    }

    /**
     * Gets the value of the fieldValueOptionList property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFieldValueOptionList() {
        return fieldValueOptionList;
    }

    /**
     * Sets the value of the fieldValueOptionList property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFieldValueOptionList(String value) {
        this.fieldValueOptionList = value;
    }

    /**
     * Gets the value of the forceReview property.
     * 
     */
    public boolean isForceReview() {
        return forceReview;
    }

    /**
     * Sets the value of the forceReview property.
     * 
     */
    public void setForceReview(boolean value) {
        this.forceReview = value;
    }

    /**
     * Gets the value of the readOnly property.
     * 
     */
    public boolean isReadOnly() {
        return readOnly;
    }

    /**
     * Sets the value of the readOnly property.
     * 
     */
    public void setReadOnly(boolean value) {
        this.readOnly = value;
    }

    /**
     * Gets the value of the fieldValueChangeScript property.
     * 
     */
    public boolean isFieldValueChangeScript() {
        return fieldValueChangeScript;
    }

    /**
     * Sets the value of the fieldValueChangeScript property.
     * 
     */
    public void setFieldValueChangeScript(boolean value) {
        this.fieldValueChangeScript = value;
    }

    /**
     * Gets the value of the extractionName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtractionName() {
        return extractionName;
    }

    /**
     * Sets the value of the extractionName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtractionName(String value) {
        this.extractionName = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Coordinates" type="{}coordinates" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "coordinates"
    })
    public static class CoordinatesList
        implements Serializable
    {

        private final static long serialVersionUID = 100L;
        @XmlElement(name = "Coordinates")
        protected List<Coordinates> coordinates;

        /**
         * Gets the value of the coordinates property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the coordinates property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCoordinates().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Coordinates }
         * 
         * 
         */
        public List<Coordinates> getCoordinates() {
            if (coordinates == null) {
                coordinates = new ArrayList<Coordinates>();
            }
            return this.coordinates;
        }

    }

}