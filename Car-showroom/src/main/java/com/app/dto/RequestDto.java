	package com.app.dto;

	import java.util.Scanner;

	
import com.app.model.OrderInfo;
import com.app.model.User;

	public class RequestDto {
		Scanner sn = new Scanner(System.in);

		public User registerRequest() {
			System.out.println("enter your userName:");
			String uname = sn.next();
			System.out.println("enter your email:");
			String email = sn.next();
			System.out.println("enter your password:");
			String password = sn.next();
			System.out.println("enter your mobile:");
			long mobile = sn.nextLong();
			System.out.println("enter your address:");
			String address = sn.next();
			System.out.println("enter your role");
			String role = sn.next();
			return new User(uname, email, password, address, mobile, role);
		}

		public LogInDto loginRequest() {
			System.out.println("enter your username:");
			String uname = sn.next();
			System.out.println("enter your password:");
			String password = sn.next();
			System.out.println("enter your role");
			String role = sn.next();
			return new LogInDto(uname, password, role);

		}

		public OrderInfo addOrder() {
			System.out.println("Enter your carId:");
			int carId = sn.nextInt();
			System.out.println("enter your carName:");
			String carName = sn.next();
			System.out.println("enter your fuelType: ");
			String fueltype = sn.next();
			System.out.println("enter your carprice:");
			double carprice = sn.nextDouble();
			System.out.println("enter your colour:");
			String colour = sn.next();
			return new OrderInfo(carId,carName,carprice,fueltype,colour); 

		}

	}


