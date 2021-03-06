/*
 * HibernateUtility.java
 *
 * Created on February 10, 2005, 7:57 PM
 */
package org.simplecart.persistence;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Interceptor;
import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;
import net.sf.hibernate.Transaction;
import net.sf.hibernate.cfg.Configuration;

import org.apache.log4j.Category;

/**
 * 
 * 
 * @author Daniel Watrous
 */
public class HibernateUtility {
    private static Category cat = Category.getInstance(HibernateUtility.class
            .getName());

    private static Configuration configuration;

    private static SessionFactory sessionFactory;

    private static final ThreadLocal threadSession = new ThreadLocal();

    private static final ThreadLocal threadTransaction = new ThreadLocal();

    private static final ThreadLocal threadInterceptor = new ThreadLocal();
    // Create the initial SessionFactory from the default configuration files

    static {
        try {
            cat.info("About to start Configuration");
            configuration = new Configuration();
            cat.info("About to start sessionFactory");
            sessionFactory = configuration.configure().buildSessionFactory();
            // We could also let Hibernate bind it to JNDI:
            // configuration.configure().buildSessionFactory()
        } catch (Throwable ex) {
            // We have to catch Throwable, otherwise we will miss
            // NoClassDefFoundError and other subclasses of Error
            cat.error("Building SessionFactory failed.", ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Returns the SessionFactory used for this static class.
     * @return SessionFactory
     */
    public static SessionFactory getSessionFactory() {
        /*
         * Instead of a static variable, use JNDI: SessionFactory sessions =
         * null; try { Context ctx = new InitialContext(); String jndiName =
         * "java:hibernate/HibernateFactory"; sessions =
         * (SessionFactory)ctx.lookup(jndiName); } catch (NamingException ex) {
         * throw new InfrastructureException(ex); } return sessions;
         */
        return sessionFactory;
    }

    /**
     * Returns the original Hibernate configuration.
     * @return Configuration
     */
    public static Configuration getConfiguration() {
        return configuration;
    }

    /**
     * Rebuild the SessionFactory with the static Configuration.
     * @throws HibernateException 
     */
    public static void rebuildSessionFactory() throws HibernateException {
        synchronized (sessionFactory) {
            try {
                sessionFactory = getConfiguration().buildSessionFactory();
            } catch (Exception ex) {
                throw new HibernateException(ex);
            }
        }
    }

    /**
     * Rebuild the SessionFactory with the given Hibernate Configuration.
     * @throws HibernateException 
     * @param cfg 
     */
    public static void rebuildSessionFactory(Configuration cfg)
            throws HibernateException {
        synchronized (sessionFactory) {
            try {
                sessionFactory = cfg.buildSessionFactory();
                configuration = cfg;
            } catch (Exception ex) {
                throw new HibernateException(ex);
            }
        }
    }

    /**
     * Retrieves the current Session local to the thread. <p/>If no Session is
     * open, opens a new Session for the running thread.
     * 
     * 
     * @throws HibernateException 
     * 
     * @return Session
     */
    public static Session getSession() throws HibernateException {
        Session s = (Session) threadSession.get();
        try {
            if (s == null) {
                cat.debug("Opening new Session for this thread.");
                if (getInterceptor() != null) {
                    cat.debug("Using interceptor: "
                            + getInterceptor().getClass());
                    s = getSessionFactory().openSession(getInterceptor());
                } else {
                    s = getSessionFactory().openSession();
                }
                threadSession.set(s);
            }
        } catch (HibernateException ex) {
            throw new HibernateException(ex);
        }
        return s;
    }

    /**
     * Closes the Session local to the thread.
     * @throws HibernateException 
     */
    public static void closeSession() throws HibernateException {
        try {
            Session s = (Session) threadSession.get();
            threadSession.set(null);
            if (s != null && s.isOpen()) {
                cat.debug("Closing Session of this thread.");
                s.close();
            }
        } catch (HibernateException ex) {
            throw new HibernateException(ex);
        }
    }

    /**
     * Start a new database transaction.
     * @throws HibernateException 
     */
    public static void beginTransaction() throws HibernateException {
        Transaction tx = (Transaction) threadTransaction.get();
        try {
            if (tx == null) {
                cat.debug("Starting new database transaction in this thread.");
                tx = getSession().beginTransaction();
                threadTransaction.set(tx);
            }
        } catch (HibernateException ex) {
            throw new HibernateException(ex);
        }
    }

    /**
     * Commit the database transaction.
     * @throws HibernateException 
     */
    public static void commitTransaction() throws HibernateException {
        Transaction tx = (Transaction) threadTransaction.get();
        try {
            if (tx != null && !tx.wasCommitted() && !tx.wasRolledBack()) {
                cat.debug("Committing database transaction of this thread.");
                tx.commit();
            }
            threadTransaction.set(null);
        } catch (HibernateException ex) {
            rollbackTransaction();
            throw new HibernateException(ex);
        }
    }

    /**
     * Commit the database transaction.
     * @throws HibernateException 
     */
    public static void rollbackTransaction() throws HibernateException {
        Transaction tx = (Transaction) threadTransaction.get();
        try {
            threadTransaction.set(null);
            if (tx != null && !tx.wasCommitted() && !tx.wasRolledBack()) {
                cat
                        .debug("Tyring to rollback database transaction of this thread.");
                tx.rollback();
            }
        } catch (HibernateException ex) {
            throw new HibernateException(ex);
        } finally {
            closeSession();
        }
    }

    /**
     * Reconnects a Hibernate Session to the current Thread.
     * @throws HibernateException 
     * @param session The Hibernate Session to be reconnected.
     */
    public static void reconnect(Session session) throws HibernateException {
        try {
            session.reconnect();
            threadSession.set(session);
        } catch (HibernateException ex) {
            throw new HibernateException(ex);
        }
    }

    /**
     * Disconnect and return Session from current Thread.
     * @throws HibernateException 
     * @return Session the disconnected Session
     */
    public static Session disconnectSession() throws HibernateException {
        Session session = getSession();
        try {
            threadSession.set(null);
            if (session.isConnected() && session.isOpen())
                session.disconnect();
        } catch (HibernateException ex) {
            throw new HibernateException(ex);
        }
        return session;
    }

    /**
     * Register a Hibernate interceptor with the current thread.
     * <p>
     * Every Session opened is opened with this interceptor after registration.
     * Has no effect if the current Session of the thread is already open,
     * effective on next close()/getSession().
     * 
     * 
     * 
     * @param interceptor 
     */
    public static void registerInterceptor(Interceptor interceptor) {
        threadInterceptor.set(interceptor);
    }

    /**
     * @return Interceptor 
     */
    private static Interceptor getInterceptor() {
        Interceptor interceptor = (Interceptor) threadInterceptor.get();
        return interceptor;
    }
}
