package Entities;

import Enums.VisitStatus;

import javax.persistence.*;
import java.util.Date;

@NamedQuery(name = "getActivityById", query = "select a from Activity a where a.visitor=:visit")

@Entity
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    Visitor visitor;
    private String date;
    @Enumerated(EnumType.STRING)
    private VisitStatus status;
    @Lob
    private String purpose;
    private String personVisited;

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getPersonVisited() {
        return personVisited;
    }

    public void setPersonVisited(String personVisited) {
        this.personVisited = personVisited;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public VisitStatus getStatus() {
        return status;
    }

    public void setStatus(VisitStatus status) {
        this.status = status;
    }
}
