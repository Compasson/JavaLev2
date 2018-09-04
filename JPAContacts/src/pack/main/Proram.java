package pack.main;

import ru.contacts.model.*;

import java.util.Collection;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Proram {

	public static void main(String[] args) {
		/*
		Scanner sc = new Scanner(System.in);
		System.out.print("Поиск ...");
		String search = sc.nextLine();
		sc.close();
		*/
		
		
		// Entity manager
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAContacts"); // Это имя указывается на этапе создания EclipseJPA проекта
		System.out.println("---------------");
		EntityManager em = emf.createEntityManager();
		
	
		//------------------------------------------
		//Query query = em.createQuery("SELECT e FROM Courses e ");// Строка на JPQL языке к сущьностям поверх класс
		//Query query = em.createQuery("SELECT e FROM Courses e WHERE e.title LIKE :search");// Строка на JPQL языке к сущьностям поверх класса
		Query query = em.createQuery("SELECT e FROM Human e");
		
		/* Можно параметризированные запросы
		query.setParameter("search", "%"+search+"%");//Первый это тип параметра, второй это строка которую ввел пользователь
		*/
		Collection<Human> course =
				(Collection<Human> )query.getResultList(); //Ответ от обьектов ЗАРОС . Менеджеру запросов моно посылать задачи m.createQuery(запрос).
		
		//------------------------------------------
		
		//Вывод коллекции
		for(Human cours : course) {
			System.out.printf("%-30s : %d\n",cours.getFname(), cours.getTel());
		}
		
		//------------------------------------------
		//Начало коммита
		// Add course
		em.getTransaction().begin(); 
		Human c = new Human();
		c.setFname("Наталья");
		c.setLname("Васичкина");
		c.setEmail("natavasya@rambler.ru");
		//с.setTel(457);
		em.persist(c);
		em.getTransaction().commit();// Конец коммита
		
		//-----------------------------------------------
		//Вывод коллекции
		for(Human cours : course) {
			System.out.printf("%-30s : %d\n",cours.getFname(), cours.getTel());
		}
		//------------------------------------------------
		
		
		
		
		/*BigInteger bg = new BigInteger.setBit​(int n);
		c.setTel(89852806635);*/
		
		/* Попытка доступа к таблице с внешними ключами TopPlace к таблице Human
		Query query1 = em.createQuery("SELECT e FROM Lesson e ORDER BY e.teacher DESC"); //Сортирует по int-у. Для строк не работает
		Collection<TopPlace> place =
				(Collection<TopPlace> )query1.getResultList();
		for(TopPlace place : p) {
			System.out.printf("%-30s\n",p.getPlace());
		}*/
	}

}
