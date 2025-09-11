package decorator.service;

import java.util.List;

import decorator.entity.Category;

public interface CategoryService {

	void insert(Category cate);
	void update(Category cate);
	void delete(int id);
	Category findById(int id);
	List<Category> findAll();
	List<Category> findAllByUserId(int userid);
}
