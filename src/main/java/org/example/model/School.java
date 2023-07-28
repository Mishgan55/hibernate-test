package org.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "school")
public class School {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "school_number")
    private int schoolNumber;
    @OneToOne
    @JoinColumn(name = "principal_id", referencedColumnName = "id")
    private Principal principal;

    public School() {
    }

    public School(int schoolNumber, Principal principal) {
        this.schoolNumber = schoolNumber;
        this.principal = principal;
    }

    public School(int schoolNumber) {
        this.schoolNumber = schoolNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSchoolNumber() {
        return schoolNumber;
    }

    public void setSchoolNumber(int schoolNumber) {
        this.schoolNumber = schoolNumber;
    }

    public Principal getPrincipal() {
        return principal;
    }

    public void setPrincipal(Principal principal) {
        this.principal = principal;
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", schoolNumber=" + schoolNumber +

                '}';
    }
}
