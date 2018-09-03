
import ru.web.model.*;

import java.util.Collection;
import java.util.Scanner;

import javax.persistence.*; 

public class Program {

	public static void main(String[] args) throws InterruptedException {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("����� ...");
		String search = sc.nextLine();
		sc.close();
		
		// Entity manager
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyWebORM");
		EntityManager em = emf.createEntityManager();
		
		
		//Query query = em.createQuery("SELECT e FROM Courses e ");// ������ �� JPQL ����� � ���������� ������ �����
		Query query = em.createQuery("SELECT e FROM Courses e WHERE e.title LIKE :search");// ������ �� JPQL ����� � ���������� ������ ������
		
		// ����� ������������������� �������
		query.setParameter("search", "%"+search+"%");//������ ��� ��� ���������, ������ ��� ������ ������� ���� ������������
		
		Collection<Courses> course =
				(Collection<Courses> )query.getResultList();
		
		for(Courses cours : course) {
			System.out.printf("%-30s : %d\n",cours.getTitle(), cours.getLength());
		}
		
		// Add course
		em.getTransaction().begin(); //������ �������
		Courses c = new Courses();
		c.setTitle("Java 1");
		c.setLength(40);
		c.setDescription("Java intro");
		em.persist(c);
		em.getTransaction().commit();// ����� �������
		
		Query query1 = em.createQuery("SELECT e FROM Lesson e ORDER BY e.teacher DESC"); //��������� �� int-�. ��� ����� �� ��������
		Collection<Lesson> les =
				(Collection<Lesson> )query1.getResultList();
		for(Lesson less : les) {
			System.out.printf("%-30d : %s\n",less.getTeacher(), less.getRoom());
		}
		
	}

}
