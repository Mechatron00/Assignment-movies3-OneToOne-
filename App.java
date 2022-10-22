package com.ProjectAssignment.Movies3;

import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class App 
{
    public static void main( String[] args )
    {
    	 StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
         Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
         SessionFactory factory=meta.getSessionFactoryBuilder().build();
         Session session=factory.openSession();
         Transaction t=session.beginTransaction();
         System.out.println("Session Created");
         
         Movie m=new Movie();
         m.setMovieName("Kantara");
         //session.save(m);
         
         Year y=new Year();
         y.setYearOfRelease(2022);
         //session.save(y);
         
         m.setYear(y);
         y.setMovie(m);
         
         TypedQuery query=session.createQuery("from Movie");
         List<Movie> list=query.getResultList();
         
         Iterator<Movie> itr=list.iterator();
         
         while (itr.hasNext())
         {
  		Movie mv = itr.next();
  		
  		System.out.println("Movie Name:"+mv.getMovieName());
  		Year year=mv.getYear();
  		
  		System.out.println("Year Of Releae:"+year.getYearOfRelease());
  		}
         
         t.commit();
         session.close();
         
    }
}
