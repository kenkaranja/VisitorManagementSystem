package Entities;

import Enums.VisitStatus;
import Enums.VisitorCategory;

import javax.persistence.*;
import java.util.Date;

@NamedQueries({
        @NamedQuery(name = "getVisitorById", query = "SELECT v FROM Visitor v WHERE v.idNumber=:idNumber"),
        @NamedQuery(name = "viewAllVisitors", query = "SELECT V FROM Visitor v")
})

@Entity
public class Visitor extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(unique = true)
    private String idNumber;
    @Enumerated(EnumType.STRING)
    private VisitorCategory visitorCategory;
    @Enumerated(EnumType.STRING)
    private VisitStatus status;

    public VisitStatus getStatus() {
        return status;
    }

    public void setStatus(VisitStatus status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public VisitorCategory getVisitorCategory() {
        return visitorCategory;
    }

    public void setVisitorCategory(VisitorCategory visitorCategory) {
        this.visitorCategory = visitorCategory;
    }


}
