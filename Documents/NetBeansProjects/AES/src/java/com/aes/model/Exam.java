package com.aes.model;
// Generated May 17, 2015 2:15:07 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Exam generated by hbm2java
 */
@Entity
@Table(name="exam"
    ,catalog="aesdatabase"
)
public class Exam  implements java.io.Serializable {


     private Integer id;
     private Course course;
     private Set<Question> questions = new HashSet<Question>(0);
     private Set<Examtaken> examtakens = new HashSet<Examtaken>(0);

    public Exam() {
    }

	
    public Exam(Course course) {
        this.course = course;
    }
    public Exam(Course course, Set<Question> questions, Set<Examtaken> examtakens) {
       this.course = course;
       this.questions = questions;
       this.examtakens = examtakens;
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

@OneToMany(fetch=FetchType.LAZY, mappedBy="exam")
    public Set<Question> getQuestions() {
        return this.questions;
    }
    
    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="exam")
    public Set<Examtaken> getExamtakens() {
        return this.examtakens;
    }
    
    public void setExamtakens(Set<Examtaken> examtakens) {
        this.examtakens = examtakens;
    }




}


