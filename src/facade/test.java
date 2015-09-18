/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

/**
 *
 * @author bbalt
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        facade f = new facade();
        f.addStudent("Pak", "Sol");
        System.out.println(f.getStudents().toString());
        System.out.println(f.getStudents("jan").toString());
        System.out.println("Sum of ID 1 = "+f.studyPointSum(1));
        System.out.println("Total sum = "+f.totalStudyPointSum());
        f.getHighestSPScore();
        
    }
    
}
