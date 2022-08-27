package com.app.test;



import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.app.Dao.LogInDao;
import com.app.Dao.OrderDao;
import com.app.Dao.RegisterDao;
import com.app.dto.LogInDto;
import com.app.dto.RequestDto;
import com.app.dto.UserProfile;
import com.app.model.CustomerOrder;
import com.app.model.OrderInfo;
import com.app.model.User;




public class Customer {
	public static void main(String[] args) throws Exception {

		Scanner sn = new Scanner(System.in);
		RequestDto request = new RequestDto();
		RegisterDao dao = new RegisterDao();
		String CustomerName = "";
		String choice = "";
		do {
			System.out.println("Welcome to my Car-Showroom application");
			System.out.println("press 1.Register");
			System.out.println("press 2.LogIn");
			System.out.println("--------------------------");
			System.out.println("Enter your choice");
			int key = sn.nextInt();
			switch (key) {
			case 1:
				User user = request.registerRequest();
				int i = dao.register(user);
				if (i == 1) {
					System.out.println("Data register successfully.......!");

				} else {
					System.out.println("sorry user not register....!");

				}

				break;
			case 2:
				LogInDto dto = request.loginRequest();
				LogInDao logInDao = new LogInDao();
				UserProfile profile = logInDao.logIn(dto);
				CustomerName = profile.getName();
				if (profile != null && profile.getRole().equalsIgnoreCase("admin")) {
					OrderInfo info = request.addOrder();
					if (info != null) {
						int res = dao.addOrder(info);
						if (res == 1) {
							System.out.println("fueltype added successfully:");

						} else {
							//System.out.println("sorry fueltype not added something went wrong...!");

						}
					}
					System.out.println(info);

				} else {
					OrderDao orderDao = new OrderDao();
					List<OrderInfo> menus = orderDao.menus();
					System.out.println("carName\t carId\t cartype\t colour\t price");
					for (OrderInfo carModels : menus) {
						System.out.println(carModels.getCarName() + "\t" +carModels.getCarId() + "\t"
								+ carModels.getFueltype() + "\t" + carModels.getCarprice() + "\t" + carModels.getColour() + "\t");
					}
					System.out.println("------------------Select  car--------------------");
					System.out.println("Enter your car Name : ");
					Scanner sc=new Scanner(System.in);
					String car = sc.next();
					
					switch (car) {
					case "audiA6":
						String order;
						Map<String, Integer> orders = new HashMap<String, Integer>();
						List<Map<String, Integer>> listOrder = new ArrayList<Map<String, Integer>>();
						do {
							orders = custOrder(orderDao);
							listOrder.add(orders);
							System.out.println("Thank you for booking");
							System.exit(0);
							System.out.println("Enter 1 to continue.");
							
							order = sn.next();
						} while (order.equalsIgnoreCase("order"));
						List<CustomerOrder> customerOrders = new OrderDao().placeOrer(listOrder, car,
								CustomerName);
						String msg=ReciptPrint(customerOrders);
						System.out.println();
						System.out.println(customerOrders);
						break;
					case "audiRS7":
						List<OrderInfo> a1 = orderDao.a1();
						System.out.println("carName\t carId\t cartype\t colour\t price");
						for (OrderInfo carModels : a1) {
							System.out.println(carModels.getCarName() + "\t" + carModels.getCarId() + "\t"
									+ carModels.getFueltype() + "\t" + carModels.getCarprice() + "\t" + carModels.getColour() + "\t");
						}
						break;
					case "audiQ5":
						List<OrderInfo> a2 = orderDao.a2();
						System.out.println("carName\t carId\t cartype\t colour\t price");
						for (OrderInfo carModels : a2) {
							System.out.println(carModels.getCarName() + "\t" +carModels.getCarId() + "\t"
									+carModels.getFueltype() + "\t" +carModels.getCarprice() + "\t" + carModels.getColour() + "\t");
						}
						break;

					}
				}

			default:
			//	System.out.println("Invalid Request");
				break;
			}
			System.out.println("Do you want to continue ?(Y/N)");
			choice = sn.next();

		} while (choice.equalsIgnoreCase("y"));

	}

	private static Map<String, Integer> custOrder(OrderDao orderDao) {
		Scanner sn = new Scanner(System.in);
		List<OrderInfo> audi = orderDao.audi();
		System.out.println("carName\t carId\t cartype\t colour\t price");
		Map<String, Integer> order = new HashMap<String, Integer>();
		for (OrderInfo carModels : audi) {
			System.out.println(carModels.getCarName() + "\t" + carModels.getCarId() + "\t"
					+ carModels.getFueltype() + "\t" + carModels.getCarprice() + "\t" + carModels.getColour() + "\t");
		}
		System.out.println("Enter your colour:");
		String itString = sn.next();
		order.put(itString,1);
		return order;
		
		
	}

	private static String ReciptPrint(List<CustomerOrder> customerOrders ) throws Exception{
		File file = new File("D:\\payment\\order.txt");
		FileWriter fw = new FileWriter(file,true);
		fw.write("Welcome to Car-Showroom application\n");
		fw.append("\t\t\t\t\t"+LocalDate.now());
		fw.append("Customer Name:"+customerOrders.get(1).getCustomerName());
		fw.append("\n-------------------------------------------------------\n");
		fw.append("Order id\tFuelType\tcolour Name\tPrice\t TotalBill");
		for(CustomerOrder c:customerOrders) {
			
			fw.append("\n"+c.getOrderid()+"\t"+c.getFueltype()+"\t"+c.getColourName()+"\t"+c.getPrice()+"\t");
		}
		
		fw.close();
		return "success";
	}
}


	