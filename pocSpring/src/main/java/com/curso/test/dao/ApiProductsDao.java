package com.curso.test.dao;

import java.util.List;

public interface ApiProductsDao<T> {
	List<T> fetchData();
	T getItemData(int id);
	T addItem(T input);
}
