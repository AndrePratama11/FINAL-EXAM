/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B.FinalExam;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "person")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
    @NamedQuery(name = "Person.findById", query = "SELECT p FROM Person p WHERE p.id = :id"),
    @NamedQuery(name = "Person.findByNik", query = "SELECT p FROM Person p WHERE p.nik = :nik"),
    @NamedQuery(name = "Person.findByNama", query = "SELECT p FROM Person p WHERE p.nama = :nama"),
    @NamedQuery(name = "Person.findByTtl", query = "SELECT p FROM Person p WHERE p.ttl = :ttl"),
    @NamedQuery(name = "Person.findByTiimestamp", query = "SELECT p FROM Person p WHERE p.tiimestamp = :tiimestamp")})
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NIK")
    private String nik;
    @Column(name = "Nama")
    private String nama;
    @Column(name = "TTL")
    private String ttl;
    @Lob
    @Column(name = "Foto")
    private byte[] foto;
    @Basic(optional = false)
    @Column(name = "tiimestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tiimestamp;

    public Person() {
    }

    public Person(Integer id) {
        this.id = id;
    }

    public Person(Integer id, Date tiimestamp) {
        this.id = id;
        this.tiimestamp = tiimestamp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTtl() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Date getTiimestamp() {
        return tiimestamp;
    }

    public void setTiimestamp(Date tiimestamp) {
        this.tiimestamp = tiimestamp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "B.FinalExam.Person[ id=" + id + " ]";
    }
    
}
