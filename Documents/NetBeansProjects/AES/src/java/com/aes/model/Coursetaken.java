package com.aes.model;
// Generated May 17, 2015 2:15:07 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Coursetaken generated by hbm2java
 */
@Entity
@Table(name="coursetaken"
    ,catalog="aesdatabase"
)
public class Coursetaken  implements java.io.Serializable {


     private Integer id;
     private Course course;
     private User user;

    public Coursetaken() {
    }

    public Coursetaken(Course course, User user) {
       this.course = course;
       this.user = user;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="course", nullable=false)
    public Course getCourse() {
        return this.course;
    }
    
    public void setCourse(Course course) {
        this.course = course;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user", nullable=false)
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }




}


