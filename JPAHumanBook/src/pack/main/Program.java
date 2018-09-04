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
		System.out.print("Поиск ...");
		String search = sc.nextLine();
		sc.close();
		*/
		
		
		// Entity manager
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAHumanBook"); // Это имя указывается на этапе создания EclipseJPA проекта
		System.out.println("---------------");
		EntityManager em = emf.createEntityManager();
		
	
		//------------------------------------------
		//Query query = em.createQuery("SELECT e FROM Courses e ");// Строка на JPQL языке к сущьностям поверх класс
		//Query query = em.createQuery("SELECT e FROM Courses e WHERE e.title LIKE :search");// Строка на JPQL языке к сущьностям поверх класса
		Query query = em.createQuery("SELECT e FROM Human e");
		
		/* Можно параметризированные запросы
		query.setParameter("search", "%"+search+"%");//Первый это тип параметра, второй это строка которую ввел пользователь
		*/
		Collection<Human> human =
				(Collection<Human> )query.getResultList(); //Ответ от обьектов ЗАРОС . Менеджеру запросов моно посылать задачи m.createQuery(запрос).
		
		//------------------------------------------
		
		//Вывод коллекции
		for(Human hum : human) {
			System.out.printf("%-15s : %-15s : %-30s : %-30s\n",hum.getFname(), hum.getLname(), hum.getEmail(), hum.getTel());
		}
		
		//------------------------------------------
		//Начало коммита
		// Add course
		em.getTransaction().begin(); 
		Human c = new Human();
		c.setFname("Наталья");
		c.setLname("Васичкина");
		c.setEmail("natavasya@rambler.ru");
		c.setTel("89852806635");
		em.persist(c);
		em.getTransaction().commit();// Конец коммита
		
		/*
		em.getTransaction().begin(); 
		TopTegPK top = new TopTegPK();
		top.setTeg( "Дача Челюха");
		em.persist(c);
		em.getTransaction().commit();// Конец коммита
		
		Query query1 = em.createQuery("SELECT e FROM TopTeg e");

		Collection<TopTegPK> topt =
				(Collection<TopTegPK> )query1.getResultList(); //Ответ от обьектов ЗАРОС . Менеджеру запросов моно посылать задачи m.createQuery(запрос).

		for(TopTegPK t : topt) {
			System.out.printf("%-15d : %-15s\n",t.getHumanId()  , t.getTeg());
		}*/
	}

}
