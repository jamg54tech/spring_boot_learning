package com.curso.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.curso.test.dao.ApiProductsDao;
import com.curso.test.dao.EnvTest;
import com.curso.test.dao.TestAutowired;
import com.curso.test.models.Product;

@RestController
public class ProductsController {
	
	
	@Autowired
	ApiProductsDao<Product> productService;
	
	@Autowired
	EnvTest test;
	
	@Autowired
	TestAutowired test2;

	@RequestMapping(value = "api/test")
    public  String test(){
       
		return this.test.getVariable1();
    }
	
	@RequestMapping(value = "api/test/autowired")
    public  String test2(){
       
		return this.test2.getNombre();
    }
	
	@RequestMapping(value = "api/products")
    public  List<Product> getProducts(){
       
		return this.productService.fetchData();
    }
	
	@RequestMapping(value = "api/products/{id}")
    public  Product getProduct(@PathVariable int id){
       
		return this.productService.getItemData(id);
    }
	
	@RequestMapping(value = "api/product",method = RequestMethod.POST)
    public  Product addProduct(@RequestBody Product input){
       
		return this.productService.addItem(input);
    }
}
