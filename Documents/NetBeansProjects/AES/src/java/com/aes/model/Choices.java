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
 * Choices generated by hbm2java
 */
@Entity
@Table(name="choices"
    ,catalog="aesdatabase"
)
public class Choices  implements java.io.Serializable {


     private Integer id;
     private Question question;
     private boolean isanswer;

    public Choices() {
    }

    public Choices(Question question, boolean isanswer) {
       this.question = question;
       this.isanswer = isanswer;
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
    @JoinColumn(name="question", nullable=false)
    public Question getQuestion() {
        return this.question;
    }
    
    public void setQuestion(Question question) {
        this.question = question;
    }

    
    @Column(name="isanswer", nullable=false)
    public boolean isIsanswer() {
        return this.isanswer;
    }
    
    public void setIsanswer(boolean isanswer) {
        this.isanswer = isanswer;
    }




}

