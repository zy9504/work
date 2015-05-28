package Control;

import java.util.List;

import org.hibernate.Session;

import Factory.HibernateSessionFactory;
import Model.Goods;
import Model.GoodsDAO;

public class GoodsControl {
	public static GoodsControl control = null;
	public static GoodsControl getControl()
	{
		if(control  ==null)
			control  = new GoodsControl();
		return control;
	}
	
	private Session session;
	private GoodsDAO goodsdao;
	
	public GoodsControl()
	{
		session = HibernateSessionFactory.getSession();
		goodsdao = new GoodsDAO();
	}
	public Goods findByGoodsID(int ID)
	{
		try
		{
			return goodsdao.findById(ID);
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	public List<Goods> findByName(String name)
	{
		try
		{
			return goodsdao.findByName(name);
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	public List<Goods> findAll()
	{
		try
		{
			return goodsdao.findAll();
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	public boolean save(Goods Goods)
	{
		try{
			goodsdao.save(Goods);
    		session.beginTransaction().commit();
    		session.flush();
    		return true;
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		return false;
    	}
	}
	public boolean delete(Goods Goods)
	{
		try{
			goodsdao.delete(Goods);
    		session.beginTransaction().commit();
    		session.flush();
    		return true;
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		return false;
    	}
	}
	public boolean update(Goods Goods)
	{
		try{
			goodsdao.merge(Goods);
    		session.beginTransaction().commit();
    		session.flush();
    		return true;
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		return false;
    	}
	}
}
