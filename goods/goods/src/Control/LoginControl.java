package Control;

import java.util.List;

import org.hibernate.Session;

import Factory.HibernateSessionFactory;
import Model.Login;
import Model.LoginDAO;


public class LoginControl {
	
		private static LoginControl control = null; 
		public static LoginControl getLoginControl(){
			if(null==control){
				control = new LoginControl();
			}
			return control;
		}
		

		private LoginDAO LoginDAO = null;
		private Session session = null;
		
		private LoginControl(){
			LoginDAO = new LoginDAO();
			session = HibernateSessionFactory.getSession();
		}
		

		public Login saveLogin(String username,String password,String role){
			Login Login = new Login(username,password,role);
			LoginDAO.save(Login);
			session.beginTransaction().commit();
			session.flush();
			return Login;
		}
	    
		public Login getLoginByName(String username){
			try{
				return (Login)LoginDAO.findByProperty("userName",username).get(0);
			}catch(Exception e)
			{
				return null;
			}

		}
		public List getLoginALL()
		{
			return LoginDAO.findAll();
		}
		public Boolean delete(Login login) {
			try {

				LoginDAO.delete(login);
				session.beginTransaction().commit();
				session.flush();
				return true;

			} catch (Exception e) {
				return false;
			}
		}
		
		
		public Boolean merge(Login login) {
			try {

				LoginDAO.merge(login);
				session.beginTransaction().commit();
				session.flush();
				return true;

			} catch (Exception e) {
				return false;
			}
		}

}
