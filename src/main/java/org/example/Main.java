package org.example;

import org.example.config.FactoryConfiguration;
import org.example.embed.FullName;
import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Session session= FactoryConfiguration.getInstance().getSession();

        FullName fullName = new FullName("Ashan","Malshan");

        Student student = new Student();
        student.setId(3);
        student.setName(fullName);
        student.setAddress("panadura");
        Transaction transaction = session.beginTransaction();

       // session.update(student);
        session.save(student);
      // session.delete(student);

        Student student1 = session.get(Student.class,1);
        if (student1 != null){
            System.out.println(student1.getId());
            System.out.println(student1.getAddress());
            System.out.println(student1.getName().getFirstName());
            System.out.println(student1.getName().getLastName());
        }
        transaction.commit();
        session.close();
    }
}