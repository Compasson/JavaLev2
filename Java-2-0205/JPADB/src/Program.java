

import ru.specialist.web.model.*;

import java.util.Collection;
import java.util.Scanner;

import javax.persistence.*;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Поиск: ");
		String search = sc.nextLine();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyWebORM");
		EntityManager em = emf.createEntityManager();
		
		// JPQL
		Query query = em.createQuery("SELECT e FROM Course e WHERE e.title LIKE :search");
		query.setParameter("search", "%"+search+"%");
		Collection<Course> courses = 
				(Collection<Course> )query.getResultList();
		
		//for(Course course : courses)
		//	System.out.printf("%-30s : %d\n", course.getTitle(), course.getLength());
		courses.stream().map(c->c.getTitle()).forEach(System.out::println);
		
		
		em.getTransaction().begin();
		Course c = new Course();
		c.setTitle("Java 1");
		c.setLength(40);
		c.setDescription("Java intro");
		em.persist(c);
		em.getTransaction().commit();
		

	}

}
