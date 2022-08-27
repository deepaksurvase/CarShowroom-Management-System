package com.app.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.Util.UtilityClass;
import com.app.model.CustomerOrder;
import com.app.model.OrderInfo;

import jakarta.persistence.OrderBy;
import jakarta.persistence.Query;





public class OrderDao {
	public List<OrderInfo> menus() throws Exception {
		Session session = UtilityClass.getSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("From OrderInfo");

		return ((org.hibernate.query.Query) query).list();

	}

	public List<OrderInfo> audi() {
		Session session = UtilityClass.getSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("From OrderInfo where carName='audiA6'");

		return ((org.hibernate.query.Query) query).list();
	}

	public List<OrderInfo>a1 () {
		Session session = UtilityClass.getSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("From OrderInfo where carName='audiRS7' ");

		
		return ((org.hibernate.query.Query) query).list();
	}

	public List<OrderInfo> a2() {
		Session session = UtilityClass.getSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("From OrderInfo where carName='audiQ5' ");

		return ((org.hibernate.query.Query) query).list();
	}

	public List<OrderInfo> orderId(){
		Session session =UtilityClass.getSession();
		Transaction tx =session.beginTransaction();
		Query query = session.createQuery("select * from CustomerOrder where orderId = ?");
		List<OrderInfo> list =query.getResultList();
		return list;
	}
	public List<CustomerOrder> placeOrer(List<Map<String, Integer>> orders, String carName,String customername) {
		// TODO Auto-generated method stub
		
	
		CustomerOrder customerOrder = new CustomerOrder();

		OrderInfo orderInfo = new OrderInfo();
		List<CustomerOrder> list = new ArrayList();
		for (Map<String, Integer> or : orders) {
			Session session = UtilityClass.getSession();
			Transaction tx = session.beginTransaction();
			for (Entry<String, Integer> s : or.entrySet()) {
				Query query = session.createQuery(
						"From OrderInfo where carName='" + carName + "' and colour='" + s.getKey() + "'");
				List<OrderInfo> list2=query.getResultList(); 
				orderInfo = list2.get(0);
				customerOrder.setColour(orderInfo.getColour());
				customerOrder.setfueltype(orderInfo.getFueltype());
				customerOrder.setcarprice(orderInfo.getCarprice());
				customerOrder.setBill(orderInfo.getCarprice());
				customerOrder.setcustomerName(customername);
				list.add(customerOrder);
				session.save(customerOrder);
				tx.commit();
				

			}
		}
	
				return list;
	}

	 List<OrderInfo> a() {
		// TODO Auto-generated method stub
		return null;
	}

}
