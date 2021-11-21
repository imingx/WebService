
package com.webservice.teacher;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.webservice.teacher package. 
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

    private final static QName _QueryStudentInCourseReturn_QNAME = new QName("http://server", "queryStudentInCourseReturn");
    private final static QName _TeacherRegisterReturn_QNAME = new QName("http://server", "teacherRegisterReturn");
    private final static QName _ChangeTeacherPasswordReturn_QNAME = new QName("http://server", "changeTeacherPasswordReturn");
    private final static QName _TeacherQueryReturn_QNAME = new QName("http://server", "teacherQueryReturn");
    private final static QName _Id_QNAME = new QName("http://server", "id");
    private final static QName _DeleteCourseReturn_QNAME = new QName("http://server", "deleteCourseReturn");
    private final static QName _TeacherId_QNAME = new QName("http://server", "teacher_id");
    private final static QName _QueryAllCourseReturn_QNAME = new QName("http://server", "queryAllCourseReturn");
    private final static QName _QueryTeacherCourseReturn_QNAME = new QName("http://server", "queryTeacherCourseReturn");
    private final static QName _Nothing_QNAME = new QName("http://server", "nothing");
    private final static QName _GetNameReturn_QNAME = new QName("http://server", "getNameReturn");
    private final static QName _TeacherLoginReturn_QNAME = new QName("http://server", "teacherLoginReturn");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.webservice.teacher
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link OpenCouArg }
     * 
     */
    public OpenCouArg createOpenCouArg() {
        return new OpenCouArg();
    }

    /**
     * Create an instance of {@link RegArg }
     * 
     */
    public RegArg createRegArg() {
        return new RegArg();
    }

    /**
     * Create an instance of {@link LogArg }
     * 
     */
    public LogArg createLogArg() {
        return new LogArg();
    }

    /**
     * Create an instance of {@link ChanPassArg }
     * 
     */
    public ChanPassArg createChanPassArg() {
        return new ChanPassArg();
    }

    /**
     * Create an instance of {@link DeleCouArg }
     * 
     */
    public DeleCouArg createDeleCouArg() {
        return new DeleCouArg();
    }

    /**
     * Create an instance of {@link SicArg }
     * 
     */
    public SicArg createSicArg() {
        return new SicArg();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server", name = "queryStudentInCourseReturn")
    public JAXBElement<String> createQueryStudentInCourseReturn(String value) {
        return new JAXBElement<String>(_QueryStudentInCourseReturn_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server", name = "teacherRegisterReturn")
    public JAXBElement<Boolean> createTeacherRegisterReturn(Boolean value) {
        return new JAXBElement<Boolean>(_TeacherRegisterReturn_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server", name = "changeTeacherPasswordReturn")
    public JAXBElement<Boolean> createChangeTeacherPasswordReturn(Boolean value) {
        return new JAXBElement<Boolean>(_ChangeTeacherPasswordReturn_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server", name = "teacherQueryReturn")
    public JAXBElement<String> createTeacherQueryReturn(String value) {
        return new JAXBElement<String>(_TeacherQueryReturn_QNAME, String.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server", name = "deleteCourseReturn")
    public JAXBElement<Boolean> createDeleteCourseReturn(Boolean value) {
        return new JAXBElement<Boolean>(_DeleteCourseReturn_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server", name = "teacher_id")
    public JAXBElement<String> createTeacherId(String value) {
        return new JAXBElement<String>(_TeacherId_QNAME, String.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server", name = "queryTeacherCourseReturn")
    public JAXBElement<String> createQueryTeacherCourseReturn(String value) {
        return new JAXBElement<String>(_QueryTeacherCourseReturn_QNAME, String.class, null, value);
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
    @XmlElementDecl(namespace = "http://server", name = "teacherLoginReturn")
    public JAXBElement<Boolean> createTeacherLoginReturn(Boolean value) {
        return new JAXBElement<Boolean>(_TeacherLoginReturn_QNAME, Boolean.class, null, value);
    }

}
