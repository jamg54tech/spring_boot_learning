package com.curso.test.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.test.models.Product;

@Service

public class ApiProductsDaoImpl implements ApiProductsDao<Product> {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<Product> fetchData() {
		ResponseEntity<Product[]> response = restTemplate.getForEntity("https://fakestoreapi.com/products",
				Product[].class);
		Product[] data = response.getBody();
		List<Product> objectsList = Arrays.asList(data);
		// Manejar la respuesta
		return objectsList;
	}

	@Override
	public Product getItemData(int id) {
		ResponseEntity<Product> response = restTemplate.getForEntity("https://fakestoreapi.com/products/" + id,
				Product.class);
		Product data = response.getBody();
		return data;
	}

	@Override
	public Product addItem(Product input) {

		HttpHeaders headers = new HttpHeaders();
		// headers.set("ApiIntegrationCode", "HUCXSL...");
		// headers.set("UserName", "fdfsk...");
		// headers.set("Secret", "yR*42...");

		HttpEntity<Product> httpEntity = new HttpEntity<>(input, headers);

		ResponseEntity<Product> response = restTemplate.postForEntity("https://fakestoreapi.com/products", httpEntity,
				Product.class);

		Product data = response.getBody();

		if (response.getStatusCode() == HttpStatus.OK) {
			System.out.println("Request successful");
			return data;
		} else {
			System.out.println("Request failed with status code: " + response.getStatusCode());
			return null;
		}

	}

}
