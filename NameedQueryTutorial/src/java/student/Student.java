/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author xiaoming
 */
@Entity
@Table(name = "STUDENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")
    , @NamedQuery(name = "Student.findByStudid", query = "SELECT s FROM Student s WHERE s.studid = :studid")
    , @NamedQuery(name = "Student.findByStudname", query = "SELECT s FROM Student s WHERE s.studname = :studname")
    , @NamedQuery(name = "Student.findByLikePostcode", query = "SELECT s FROM Student s WHERE s.studpostcode LIKE '1%'")
    , @NamedQuery(name = "Student.findByStudpostcode", query = "SELECT s FROM Student s WHERE s.studpostcode = :studpostcode")})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "STUDID")
    private Integer studid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "STUDNAME")
    private String studname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "STUDPOSTCODE")
    private String studpostcode;
    @JoinColumn(name = "COURSEID", referencedColumnName = "COURSEID")
    @ManyToOne(optional = false)
    private Course courseid;

    public Student() {
    }

    public Student(Integer studid) {
        this.studid = studid;
    }

    public Student(Integer studid, String studname, String studpostcode) {
        this.studid = studid;
        this.studname = studname;
        this.studpostcode = studpostcode;
    }

    public Integer getStudid() {
        return studid;
    }

    public void setStudid(Integer studid) {
        this.studid = studid;
    }

    public String getStudname() {
        return studname;
    }

    public void setStudname(String studname) {
        this.studname = studname;
    }

    public String getStudpostcode() {
        return studpostcode;
    }

    public void setStudpostcode(String studpostcode) {
        this.studpostcode = studpostcode;
    }

    public Course getCourseid() {
        return courseid;
    }

    public void setCourseid(Course courseid) {
        this.courseid = courseid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studid != null ? studid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.studid == null && other.studid != null) || (this.studid != null && !this.studid.equals(other.studid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "student.Student[ studid=" + studid + " ]";
    }
    
}
