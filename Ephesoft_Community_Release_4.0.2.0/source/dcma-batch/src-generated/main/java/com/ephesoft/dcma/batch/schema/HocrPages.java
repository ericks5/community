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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="Signature" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="HocrPage" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="PageID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Orientation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="DeskewAngle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Corners">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Corner" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="X" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="Y" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Spans">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Span" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="Coordinates" type="{}coordinates"/>
 *                                       &lt;element name="OcrConfidence" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Barcodes">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Barcode" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="Content" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="Type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="Coordinates" type="{}coordinates"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="HocrContent" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "signature",
    "hocrPage"
})
@XmlRootElement(name = "HocrPages")
public class HocrPages
    implements Serializable
{

    private final static long serialVersionUID = 100L;
    @XmlElement(name = "Signature", required = true)
    protected String signature;
    @XmlElement(name = "HocrPage")
    protected List<HocrPages.HocrPage> hocrPage;

    /**
     * Gets the value of the signature property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignature() {
        return signature;
    }

    /**
     * Sets the value of the signature property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignature(String value) {
        this.signature = value;
    }

    /**
     * Gets the value of the hocrPage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hocrPage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHocrPage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HocrPages.HocrPage }
     * 
     * 
     */
    public List<HocrPages.HocrPage> getHocrPage() {
        if (hocrPage == null) {
            hocrPage = new ArrayList<HocrPages.HocrPage>();
        }
        return this.hocrPage;
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
     *         &lt;element name="PageID" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Title" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Orientation" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="DeskewAngle" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Corners">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Corner" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="X" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="Y" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Spans">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Span" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="Coordinates" type="{}coordinates"/>
     *                             &lt;element name="OcrConfidence" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Barcodes">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Barcode" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="Content" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="Type" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="Coordinates" type="{}coordinates"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="HocrContent" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "pageID",
        "title",
        "orientation",
        "deskewAngle",
        "corners",
        "spans",
        "barcodes",
        "hocrContent"
    })
    public static class HocrPage
        implements Serializable
    {

        private final static long serialVersionUID = 100L;
        @XmlElement(name = "PageID", required = true)
        protected String pageID;
        @XmlElement(name = "Title", required = true)
        protected String title;
        @XmlElement(name = "Orientation", required = true)
        protected String orientation;
        @XmlElement(name = "DeskewAngle", required = true)
        protected String deskewAngle;
        @XmlElement(name = "Corners", required = true)
        protected HocrPages.HocrPage.Corners corners;
        @XmlElement(name = "Spans", required = true)
        protected HocrPages.HocrPage.Spans spans;
        @XmlElement(name = "Barcodes", required = true)
        protected HocrPages.HocrPage.Barcodes barcodes;
        @XmlElement(name = "HocrContent", required = true)
        protected String hocrContent;

        /**
         * Gets the value of the pageID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPageID() {
            return pageID;
        }

        /**
         * Sets the value of the pageID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPageID(String value) {
            this.pageID = value;
        }

        /**
         * Gets the value of the title property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTitle() {
            return title;
        }

        /**
         * Sets the value of the title property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTitle(String value) {
            this.title = value;
        }

        /**
         * Gets the value of the orientation property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOrientation() {
            return orientation;
        }

        /**
         * Sets the value of the orientation property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOrientation(String value) {
            this.orientation = value;
        }

        /**
         * Gets the value of the deskewAngle property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDeskewAngle() {
            return deskewAngle;
        }

        /**
         * Sets the value of the deskewAngle property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDeskewAngle(String value) {
            this.deskewAngle = value;
        }

        /**
         * Gets the value of the corners property.
         * 
         * @return
         *     possible object is
         *     {@link HocrPages.HocrPage.Corners }
         *     
         */
        public HocrPages.HocrPage.Corners getCorners() {
            return corners;
        }

        /**
         * Sets the value of the corners property.
         * 
         * @param value
         *     allowed object is
         *     {@link HocrPages.HocrPage.Corners }
         *     
         */
        public void setCorners(HocrPages.HocrPage.Corners value) {
            this.corners = value;
        }

        /**
         * Gets the value of the spans property.
         * 
         * @return
         *     possible object is
         *     {@link HocrPages.HocrPage.Spans }
         *     
         */
        public HocrPages.HocrPage.Spans getSpans() {
            return spans;
        }

        /**
         * Sets the value of the spans property.
         * 
         * @param value
         *     allowed object is
         *     {@link HocrPages.HocrPage.Spans }
         *     
         */
        public void setSpans(HocrPages.HocrPage.Spans value) {
            this.spans = value;
        }

        /**
         * Gets the value of the barcodes property.
         * 
         * @return
         *     possible object is
         *     {@link HocrPages.HocrPage.Barcodes }
         *     
         */
        public HocrPages.HocrPage.Barcodes getBarcodes() {
            return barcodes;
        }

        /**
         * Sets the value of the barcodes property.
         * 
         * @param value
         *     allowed object is
         *     {@link HocrPages.HocrPage.Barcodes }
         *     
         */
        public void setBarcodes(HocrPages.HocrPage.Barcodes value) {
            this.barcodes = value;
        }

        /**
         * Gets the value of the hocrContent property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getHocrContent() {
            return hocrContent;
        }

        /**
         * Sets the value of the hocrContent property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setHocrContent(String value) {
            this.hocrContent = value;
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
         *         &lt;element name="Barcode" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="Content" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="Type" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="Coordinates" type="{}coordinates"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
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
            "barcode"
        })
        public static class Barcodes
            implements Serializable
        {

            private final static long serialVersionUID = 100L;
            @XmlElement(name = "Barcode")
            protected List<HocrPages.HocrPage.Barcodes.Barcode> barcode;

            /**
             * Gets the value of the barcode property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the barcode property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getBarcode().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link HocrPages.HocrPage.Barcodes.Barcode }
             * 
             * 
             */
            public List<HocrPages.HocrPage.Barcodes.Barcode> getBarcode() {
                if (barcode == null) {
                    barcode = new ArrayList<HocrPages.HocrPage.Barcodes.Barcode>();
                }
                return this.barcode;
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
             *         &lt;element name="Content" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="Type" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="Coordinates" type="{}coordinates"/>
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
                "content",
                "type",
                "coordinates"
            })
            public static class Barcode
                implements Serializable
            {

                private final static long serialVersionUID = 100L;
                @XmlElement(name = "Content", required = true)
                protected String content;
                @XmlElement(name = "Type", required = true)
                protected String type;
                @XmlElement(name = "Coordinates", required = true)
                protected Coordinates coordinates;

                /**
                 * Gets the value of the content property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getContent() {
                    return content;
                }

                /**
                 * Sets the value of the content property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setContent(String value) {
                    this.content = value;
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
                 * Gets the value of the coordinates property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Coordinates }
                 *     
                 */
                public Coordinates getCoordinates() {
                    return coordinates;
                }

                /**
                 * Sets the value of the coordinates property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Coordinates }
                 *     
                 */
                public void setCoordinates(Coordinates value) {
                    this.coordinates = value;
                }

            }

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
         *         &lt;element name="Corner" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="X" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="Y" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
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
            "corner"
        })
        public static class Corners
            implements Serializable
        {

            private final static long serialVersionUID = 100L;
            @XmlElement(name = "Corner")
            protected List<HocrPages.HocrPage.Corners.Corner> corner;

            /**
             * Gets the value of the corner property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the corner property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getCorner().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link HocrPages.HocrPage.Corners.Corner }
             * 
             * 
             */
            public List<HocrPages.HocrPage.Corners.Corner> getCorner() {
                if (corner == null) {
                    corner = new ArrayList<HocrPages.HocrPage.Corners.Corner>();
                }
                return this.corner;
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
             *         &lt;element name="X" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="Y" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
                "x",
                "y"
            })
            public static class Corner
                implements Serializable
            {

                private final static long serialVersionUID = 100L;
                @XmlElement(name = "X", required = true)
                protected String x;
                @XmlElement(name = "Y", required = true)
                protected String y;

                /**
                 * Gets the value of the x property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getX() {
                    return x;
                }

                /**
                 * Sets the value of the x property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setX(String value) {
                    this.x = value;
                }

                /**
                 * Gets the value of the y property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getY() {
                    return y;
                }

                /**
                 * Sets the value of the y property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setY(String value) {
                    this.y = value;
                }

            }

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
         *         &lt;element name="Span" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="Coordinates" type="{}coordinates"/>
         *                   &lt;element name="OcrConfidence" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
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
            "span"
        })
        public static class Spans
            implements Serializable
        {

            private final static long serialVersionUID = 100L;
            @XmlElement(name = "Span")
            protected List<HocrPages.HocrPage.Spans.Span> span;

            /**
             * Gets the value of the span property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the span property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getSpan().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link HocrPages.HocrPage.Spans.Span }
             * 
             * 
             */
            public List<HocrPages.HocrPage.Spans.Span> getSpan() {
                if (span == null) {
                    span = new ArrayList<HocrPages.HocrPage.Spans.Span>();
                }
                return this.span;
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
             *         &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="Coordinates" type="{}coordinates"/>
             *         &lt;element name="OcrConfidence" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
                "value",
                "coordinates",
                "ocrConfidence"
            })
            public static class Span
                implements Serializable
            {

                private final static long serialVersionUID = 100L;
                @XmlElement(name = "Value", required = true)
                protected String value;
                @XmlElement(name = "Coordinates", required = true)
                protected Coordinates coordinates;
                @XmlElement(name = "OcrConfidence", required = true)
                protected String ocrConfidence;

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
                 * Gets the value of the coordinates property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Coordinates }
                 *     
                 */
                public Coordinates getCoordinates() {
                    return coordinates;
                }

                /**
                 * Sets the value of the coordinates property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Coordinates }
                 *     
                 */
                public void setCoordinates(Coordinates value) {
                    this.coordinates = value;
                }

                /**
                 * Gets the value of the ocrConfidence property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getOcrConfidence() {
                    return ocrConfidence;
                }

                /**
                 * Sets the value of the ocrConfidence property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setOcrConfidence(String value) {
                    this.ocrConfidence = value;
                }

            }

        }

    }

}
