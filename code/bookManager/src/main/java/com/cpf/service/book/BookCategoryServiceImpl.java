package com.cpf.service.book;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cpf.common.service.BaseServiceImpl;
import com.cpf.common.util.CollectionUtil;
import com.cpf.dao.book.BookCategoryDao;
import com.cpf.entity.book.BookCategory;

@Service("bookCategoryService")
public class BookCategoryServiceImpl extends BaseServiceImpl implements BookCategoryService
{

	@Autowired
	@Qualifier("bookCategoryDao")
	private BookCategoryDao bookCategoryDao;
	
	@SuppressWarnings("rawtypes")
	@Override
	public boolean isBookCategoryExist(String type)
	{
		List list=bookCategoryDao.retrieveBookCategoryByName(type);
		if (CollectionUtil.isListEmpty(list))
		{
			return false;
		}
		else {
			return true;
		}
	}

	public BookCategory addBookCategory(String type){
		Date now=new Date();
		BookCategory category=new BookCategory(type, now, now);
		this.addObject(category);
		return category;
	}
	
}
