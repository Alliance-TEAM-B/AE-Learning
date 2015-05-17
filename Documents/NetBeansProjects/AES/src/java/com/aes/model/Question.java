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
 * Question generated by hbm2java
 */
@Entity
@Table(name="question"
    ,catalog="aesdatabase"
)
public class Question  implements java.io.Serializable {


     private Integer id;
     private Exam exam;
     private String question;
     private Set<Choices> choiceses = new HashSet<Choices>(0);

    public Question() {
    }

	
    public Question(Exam exam, String question) {
        this.exam = exam;
        this.question = question;
    }
    public Question(Exam exam, String question, Set<Choices> choiceses) {
       this.exam = exam;
       this.question = question;
       this.choiceses = choiceses;
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
    @JoinColumn(name="exam", nullable=false)
    public Exam getExam() {
        return this.exam;
    }
    
    public void setExam(Exam exam) {
        this.exam = exam;
    }

    
    @Column(name="question", nullable=false)
    public String getQuestion() {
        return this.question;
    }
    
    public void setQuestion(String question) {
        this.question = question;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="question")
    public Set<Choices> getChoiceses() {
        return this.choiceses;
    }
    
    public void setChoiceses(Set<Choices> choiceses) {
        this.choiceses = choiceses;
    }




}

