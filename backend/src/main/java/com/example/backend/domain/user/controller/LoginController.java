package com.example.backend.domain.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "LoginController", description = "로그인 도메인")
public class LoginController {
	@GetMapping("/login")
	public String getLoginPage() {
		return "login";
	}

	@GetMapping("/car")
	public List<Car> carPage() {
		List<Car> cars = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			cars.add(new Car(i, "Brand " + i, "Model " + i, 2020));
		}
		return cars;
	}

	static class Car {
		private int id;
		private String brand;
		private String model;
		private int year;

		public Car(int id, String brand, String model, int year) {
			this.id = id;
			this.brand = brand;
			this.model = model;
			this.year = year;
		}

		public int getId() {
			return id;
		}

		public String getBrand() {
			return brand;
		}

		public String getModel() {
			return model;
		}

		public int getYear() {
			return year;
		}

		public void setId(int id) {
			this.id = id;
		}

		public void setBrand(String brand) {
			this.brand = brand;
		}

		public void setModel(String model) {
			this.model = model;
		}

		public void setYear(int year) {
			this.year = year;
		}
	}
}
