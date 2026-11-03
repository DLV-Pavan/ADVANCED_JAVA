
package com.ecommerce.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class main {

    public static void main(String[] args) {

        Configuration configuration = new Configuration().configure();
        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Find order with ID 1
            CustomerOrder order =
                session.get(CustomerOrder.class, 1);

            if (order != null) {
                session.remove(order);

                transaction.commit();

                System.out.println("Order deleted successfully!");
            } else {
                transaction.rollback();
                System.out.println("Order not found!");
            }

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();

        } finally {
            session.close();
            factory.close();
        }
    }
}
