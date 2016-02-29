import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class Asfandyar_Khan_userTest {

	//DatabaseSigleton
	//Asfandyar Khan
	
	//constructor doesn't do anything
	
	//getInstance()
	@Test
	public void test1() 
	{
		DatabaseSingleton instance = null;
		ArrayList<Quiz> quizzes = new ArrayList<Quiz>();
		ArrayList<User> users = new ArrayList<User>();
		
		
		assertEquals(null, instance);
		
		assertNotEquals(null,DatabaseSingleton.getInstance());

		
	}
	
	// test set quizzes and get quiz
	@Test
	public void test2() 
	{
		DatabaseSingleton instance = DatabaseSingleton.getInstance();;
		ArrayList<Quiz> quizzes = new ArrayList<Quiz>();
		
		
		
        Quiz qz1 = new Quiz("Q1");
        Quiz qz2= new Quiz("Q2");

        quizzes.add(qz1);

		DatabaseSingleton.setQuizzes(quizzes);
		

		assertEquals(qz1  , instance.getQuiz("Q1"));
		assertEquals(null  , instance.getQuiz("Q2"));
        quizzes.add(qz2);
		assertEquals(qz2  , instance.getQuiz("Q2"));

	}
	
	//Get and Set Users
	@Test
	public void test3() 
	{
		DatabaseSingleton instance = DatabaseSingleton.getInstance();;
		ArrayList<User> users = new ArrayList<User>();
		
	    DatabaseSingleton.setUsers(users);
		
		
	    User usr1 = new User("John Smith","Student", "jsmith", "pass");
	    User usr2 = new User("bob Smith","Student", "bsmith", "pass1");        

		assertNotEquals(null  , DatabaseSingleton.getUsers());

	    users.add(usr1);

		assertEquals(1  , DatabaseSingleton.getUsers().size());

		users.add(usr2);

		assertEquals(2  , DatabaseSingleton.getUsers().size());

	}
	
	//LoadDatabase
	@Test
	public void test4() 
	{
		DatabaseSingleton instance = DatabaseSingleton.getInstance();;
		ArrayList<User> users = new ArrayList<User>();
		ArrayList<Quiz> quizzes = new ArrayList<Quiz>();

		instance.loadDatabase("database.txt");
		
		assertNotEquals(0 , DatabaseSingleton.getUsers().size());

		assertNotEquals(null , instance.getQuiz("QUIZ1"));

		assertEquals(null , instance.getQuiz("QUIZ10"));

	}
}
