package org.example;

import org.example.model.Principal;
import org.example.model.School;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTeatForPrincipal {
    public static void main(String[] args) {

        Configuration configuration= new Configuration().addAnnotatedClass(Principal.class).
                addAnnotatedClass(School.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

//            Principal principal = session.get(Principal.class, 1);
//            School school = principal.getSchool();
//            System.out.println(school);

//            School school = session.get(School.class, 2);
//            Principal principal = school.getPrincipal();
//            System.out.println(principal);

//            Principal mikhail = new Principal("Mikhail", 25);
//            School school = new School(43,mikhail);
//            mikhail.setSchool(school);
//            session.persist(school);

            Principal hanna = new Principal("hanna", 25);
            School school = session.get(School.class, 3);
            school.setPrincipal(hanna);
            session.persist(hanna);
            session.persist(school);




            session.getTransaction().commit();
        }finally {
            session.close();
        }

    }
}
