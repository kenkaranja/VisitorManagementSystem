package Entities;

import javax.persistence.*;

@NamedQueries({

        @NamedQuery(name = "viewAllReceiptionist", query = "select r from Receptionist r"),
        @NamedQuery(name = "getReceptionistById", query = "select r from Receptionist r where workId=:workid"),
        @NamedQuery(name = "loginReceptionist", query = "select r from Receptionist  r where r.username=:username and r.password=:password")
})
@Entity
public class Receptionist extends Person {

    @Column(unique = true)
    private String workId;
    private String password;
    @Column(unique = true)
    private String username;


    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
