package HomeWork;

import java.util.List;

import org.hibernate.Session;

public class MainRadaDao {
	private List<Fraction> fraction;
	private MainRada rada;
	
	public void addFraction() {
		Session session = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			session.beginTransaction();
			
			fraction = session.createCriteria(Fraction.class).list();
			rada = new MainRada(fraction);
			session.save(rada.addFraction());
			
			session.getTransaction().commit();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("Sorry - operation is failure.");
		} finally {
			closeSession(session);
		}
	}

	public void removeFraction() {
		Session session = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			session.beginTransaction();
			
			fraction = session.createCriteria(Fraction.class).list();
			rada = new MainRada(fraction);
			session.delete(rada.removeFraction());
			
			session.getTransaction().commit();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("Sorry - operation is failure.");
		} finally {
			closeSession(session);
		}
	}

	public void printAllFractions() {
		Session session = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			
			fraction = session.createCriteria(Fraction.class).list();
			rada = new MainRada(fraction);
			rada.printAllFractions();
			
		} catch (Exception e) {
			System.out.println("Sorry - operation is failure.");
		} finally {
			closeSession(session);
		}
	}

	public void printFraction() {
		Session session = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			
			fraction = session.createCriteria(Fraction.class).list();
			rada = new MainRada(fraction);
			rada.printFraction();

		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("Sorry - operation is failure.");
		} finally {
			closeSession(session);
		}
	}

	public void addDeputat() {
		Session session = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			session.beginTransaction();
			
			fraction = session.createCriteria(Fraction.class).list();
			rada = new MainRada(fraction);
			session.update(rada.addDeputat());
			
			session.getTransaction().commit();
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("Sorry - operation is failure.");
		} finally {
			closeSession(session);
		}
	}

	public void removeDeputat() {
		Session session = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			session.beginTransaction();
			
			fraction = session.createCriteria(Fraction.class).list();
			rada = new MainRada(fraction);
			session.update(rada.removeDeputat());
			
			session.getTransaction().commit();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}  catch (Exception e) {
			e.printStackTrace();
			System.out.println("Sorry - operation is failure.");
		} finally {
			closeSession(session);
		}
	}

	public void printAllBraberTakers() {
		Session session = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			
			fraction = session.createCriteria(Fraction.class).list();
			rada = new MainRada(fraction);
			rada.printAllBraberTakers();

		} catch (Exception e) {
			System.out.println("Sorry - operation is failure.");
		} finally {
			closeSession(session);
		}
	}

	public void printMaxBraberTaker() {
		Session session = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			
			fraction = session.createCriteria(Fraction.class).list();
			rada = new MainRada(fraction);
			rada.printMaxBraberTaker();
			
		} catch (Exception e) {
			System.out.println("Sorry - operation is failure.");
		} finally {
			closeSession(session);
		}
	}

	public void clearFraction() {
		Session session = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			session.beginTransaction();
			
			fraction = session.createCriteria(Fraction.class).list();
			rada = new MainRada(fraction);
			session.update(rada.clearFraction());
			
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Sorry - operation is failure.");
		} finally {
			closeSession(session);
		}
	}
	
	public void resetDataBaseToDefault(List<Fraction> def) {
		Session session = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			session.beginTransaction();
			
			saveData(def, session);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Sorry - operation is failure.");
			e.printStackTrace();
		} finally {
			closeSession(session);
		}
	}
	
	private void saveData(List<Fraction> result, Session session) {
		session.createQuery("DELETE FROM Person").executeUpdate();
		session.createQuery("DELETE FROM Fraction").executeUpdate();
		for (Fraction frac : result) {
			session.saveOrUpdate(frac);
		}
	}
	
	private void closeSession(Session session) {
		if ((session != null) && (session.isOpen())) {
			session.close();
		}
	}
}
