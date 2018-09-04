package pack.main;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ru.humanbook.model.*;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Scanner sc = new Scanner(System.in);
		System.out.print("����� ...");
		String search = sc.nextLine();
		sc.close();
		*/
		
		
		// Entity manager
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAHumanBook"); // ��� ��� ����������� �� ����� �������� EclipseJPA �������
		System.out.println("---------------");
		EntityManager em = emf.createEntityManager();
		
	
		//------------------------------------------
		//Query query = em.createQuery("SELECT e FROM Courses e ");// ������ �� JPQL ����� � ���������� ������ �����
		//Query query = em.createQuery("SELECT e FROM Courses e WHERE e.title LIKE :search");// ������ �� JPQL ����� � ���������� ������ ������
		Query query = em.createQuery("SELECT e FROM Human e");
		
		/* ����� ������������������� �������
		query.setParameter("search", "%"+search+"%");//������ ��� ��� ���������, ������ ��� ������ ������� ���� ������������
		*/
		Collection<Human> human =
				(Collection<Human> )query.getResultList(); //����� �� �������� ����� . ��������� �������� ���� �������� ������ m.createQuery(������).
		
		//------------------------------------------
		
		//����� ���������
		for(Human hum : human) {
			System.out.printf("%-15s : %-15s : %-30s : %-30s\n",hum.getFname(), hum.getLname(), hum.getEmail(), hum.getTel());
		}
		
		//------------------------------------------
		//������ �������
		// Add course
		em.getTransaction().begin(); 
		Human c = new Human();
		c.setFname("�������");
		c.setLname("���������");
		c.setEmail("natavasya@rambler.ru");
		c.setTel("89852806635");
		em.persist(c);
		em.getTransaction().commit();// ����� �������
		
		/*
		em.getTransaction().begin(); 
		TopTegPK top = new TopTegPK();
		top.setTeg( "���� ������");
		em.persist(c);
		em.getTransaction().commit();// ����� �������
		
		Query query1 = em.createQuery("SELECT e FROM TopTeg e");

		Collection<TopTegPK> topt =
				(Collection<TopTegPK> )query1.getResultList(); //����� �� �������� ����� . ��������� �������� ���� �������� ������ m.createQuery(������).

		for(TopTegPK t : topt) {
			System.out.printf("%-15d : %-15s\n",t.getHumanId()  , t.getTeg());
		}*/
	}

}
