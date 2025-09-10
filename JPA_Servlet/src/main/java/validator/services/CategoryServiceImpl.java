package validator.services;

import java.util.List;

import validator.dao.CategoryDao;
import validator.dao.impl.CategoryDaoImpl;
import validator.entity.Category;

public class CategoryServiceImpl implements CategoryService {

	CategoryDao cateDao = new CategoryDaoImpl();
	
	@Override
	public void insert(Category cate) {
		cateDao.insert(cate);
	}
	
	@Override
	public void update(Category cate) {
		cateDao.update(cate);
	}
	
	@Override
	public void delete(int id) {
		cateDao.delete(id);
	}
	
	@Override
	public Category findById(int id) {
		return cateDao.findById(id);
	}
	
	@Override
	public List<Category> findAll() {
		return cateDao.findAll();
	}
	
	@Override
	public List<Category> findAllByUserId (int userId) {
		return cateDao.findAllByUserId(userId);
	}
}
