/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Student;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author bbalt
 */
public class facade {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpqlDemoPU");
    EntityManager em = emf.createEntityManager();
    
    public List<Student> getStudents() {
        Query q = em.createNamedQuery("Student.findAll");
        List<Student> sList = q.getResultList();
        return sList;
    }
    
    public List<Student> getStudents(String name) {
        Query q = em.createNamedQuery("Student.findByFirstname");
        q.setParameter("firstname", name);
        List<Student> sList = q.getResultList();
        return sList;
    }
    
    public List<Student> getStudentsSurname(String name) {
        Query q = em.createNamedQuery("Student.findByFirstname");
        q.setParameter("lastname", name);
        List<Student> sList = q.getResultList();
        return sList;
    }
    
    public int studyPointSum(int id) {
        int sum = 0;
        Query q = em.createQuery("SELECT ps.score FROM Studypoint ps WHERE ps.student.id = :id");
        q.setParameter("id", id);
        List<Integer> spList = q.getResultList();
        for (Integer p : spList) {
            sum = sum + p;
        }
        return sum;
    }
    
    public int totalStudyPointSum() {
        int sum = 0;
        Query q = em.createQuery("SELECT ps.score FROM Studypoint ps");
        List<Integer> spList = q.getResultList();
        for (Integer p : spList) {
            sum = sum + p;
        }
        return sum;
    }
    
    public void getHighestSPScore() {
        List<Integer> spList;
        Query q = em.createQuery("SELECT SUM(ps.score) FROM Studypoint ps GROUP BY ps.student.id");
        spList = q.getResultList();
        System.out.println(spList.get(0));
 //       return spList.get(0);
    }
    
    public void addStudent(String fname, String lname) {
        Student s = new Student(fname, lname);
        try {
             em.getTransaction().begin();
             em.persist(s);
             em.getTransaction().commit();
        }
        finally {
        }
    }
    
    
}
