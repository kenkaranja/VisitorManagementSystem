package Entities;

import javax.persistence.*;

@NamedQuery(name = "LoginHost", query = "select h from Host h where h.password=:password and h.username=:username")
@Entity
public class Host extends Person {
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
