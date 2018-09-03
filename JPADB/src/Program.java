
import ru.web.model.*;

import java.util.Collection;
import java.util.Scanner;

import javax.persistence.*; 

public class Program {

	public static void main(String[] args) throws InterruptedException {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Поиск ...");
		String search = sc.nextLine();
		sc.close();
		
		// Entity manager
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyWebORM");
		EntityManager em = emf.createEntityManager();
		
		
		//Query query = em.createQuery("SELECT e FROM Courses e ");// Строка на JPQL языке к сущьностям поверх класс
		Query query = em.createQuery("SELECT e FROM Courses e WHERE e.title LIKE :search");// Строка на JPQL языке к сущьностям поверх класса
		
		// Можно параметризированные запросы
		query.setParameter("search", "%"+search+"%");//Первый это тип параметра, второй это строка которую ввел пользователь
		
		Collection<Courses> course =
				(Collection<Courses> )query.getResultList();
		
		for(Courses cours : course) {
			System.out.printf("%-30s : %d\n",cours.getTitle(), cours.getLength());
		}
		
		// Add course
		em.getTransaction().begin(); //Начало коммита
		Courses c = new Courses();
		c.setTitle("Java 1");
		c.setLength(40);
		c.setDescription("Java intro");
		em.persist(c);
		em.getTransaction().commit();// Конец коммита
		
		Query query1 = em.createQuery("SELECT e FROM Lesson e ORDER BY e.teacher DESC"); //Сортирует по int-у. Для строк не работает
		Collection<Lesson> les =
				(Collection<Lesson> )query1.getResultList();
		for(Lesson less : les) {
			System.out.printf("%-30d : %s\n",less.getTeacher(), less.getRoom());
		}
		
	}

}
