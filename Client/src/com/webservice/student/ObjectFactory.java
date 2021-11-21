
package com.webservice.student;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.webservice.student package. 
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

    private final static QName _SelectCourseReturn_QNAME = new QName("http://server", "selectCourseReturn");
    private final static QName _Id_QNAME = new QName("http://server", "id");
    private final static QName _StudentQueryReturn_QNAME = new QName("http://server", "studentQueryReturn");
    private final static QName _ChangeStudentPasswordReturn_QNAME = new QName("http://server", "changeStudentPasswordReturn");
    private final static QName _StudentId_QNAME = new QName("http://server", "student_id");
    private final static QName _StudentRegisterReturn_QNAME = new QName("http://server", "studentRegisterReturn");
    private final static QName _QueryAllCourseReturn_QNAME = new QName("http://server", "queryAllCourseReturn");
    private final static QName _Nothing_QNAME = new QName("http://server", "nothing");
    private final static QName _GetNameReturn_QNAME = new QName("http://server", "getNameReturn");
    private final static QName _DropCourseReturn_QNAME = new QName("http://server", "dropCourseReturn");
    private final static QName _QueryStudentCourseReturn_QNAME = new QName("http://server", "queryStudentCourseReturn");
    private final static QName _StudentLoginReturn_QNAME = new QName("http://server", "studentLoginReturn");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.webservice.student
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DropArg }
     * 
     */
    public DropArg createDropArg() {
        return new DropArg();
    }

    /**
     * Create an instance of {@link LogArg }
     * 
     */
    public LogArg createLogArg() {
        return new LogArg();
    }

    /**
     * Create an instance of {@link RegArg }
     * 
     */
    public RegArg createRegArg() {
        return new RegArg();
    }

    /**
     * Create an instance of {@link ChanPassArg }
     * 
     */
    public ChanPassArg createChanPassArg() {
        return new ChanPassArg();
    }

    /**
     * Create an instance of {@link SelcetArg }
     * 
     */
    public SelcetArg createSelcetArg() {
        return new SelcetArg();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server", name = "selectCourseReturn")
    public JAXBElement<Boolean> createSelectCourseReturn(Boolean value) {
        return new JAXBElement<Boolean>(_SelectCourseReturn_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server", name = "id")
    public JAXBElement<String> createId(String value) {
        return new JAXBElement<String>(_Id_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server", name = "studentQueryReturn")
    public JAXBElement<String> createStudentQueryReturn(String value) {
        return new JAXBElement<String>(_StudentQueryReturn_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server", name = "changeStudentPasswordReturn")
    public JAXBElement<Boolean> createChangeStudentPasswordReturn(Boolean value) {
        return new JAXBElement<Boolean>(_ChangeStudentPasswordReturn_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server", name = "student_id")
    public JAXBElement<String> createStudentId(String value) {
        return new JAXBElement<String>(_StudentId_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server", name = "studentRegisterReturn")
    public JAXBElement<Boolean> createStudentRegisterReturn(Boolean value) {
        return new JAXBElement<Boolean>(_StudentRegisterReturn_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server", name = "queryAllCourseReturn")
    public JAXBElement<String> createQueryAllCourseReturn(String value) {
        return new JAXBElement<String>(_QueryAllCourseReturn_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server", name = "nothing")
    public JAXBElement<Integer> createNothing(Integer value) {
        return new JAXBElement<Integer>(_Nothing_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server", name = "getNameReturn")
    public JAXBElement<String> createGetNameReturn(String value) {
        return new JAXBElement<String>(_GetNameReturn_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server", name = "dropCourseReturn")
    public JAXBElement<Boolean> createDropCourseReturn(Boolean value) {
        return new JAXBElement<Boolean>(_DropCourseReturn_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server", name = "queryStudentCourseReturn")
    public JAXBElement<String> createQueryStudentCourseReturn(String value) {
        return new JAXBElement<String>(_QueryStudentCourseReturn_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server", name = "studentLoginReturn")
    public JAXBElement<Boolean> createStudentLoginReturn(Boolean value) {
        return new JAXBElement<Boolean>(_StudentLoginReturn_QNAME, Boolean.class, null, value);
    }

}
