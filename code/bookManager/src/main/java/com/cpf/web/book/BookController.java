package com.cpf.web.book;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cpf.bean.BookBuilder;
import com.cpf.common.bean.ResponseBean;
import com.cpf.common.constant.CommonConstant;
import com.cpf.common.model.Pager;
import com.cpf.common.util.JsonUtil;
import com.cpf.common.util.LogUtil;
import com.cpf.common.util.StringUtil;
import com.cpf.constant.BookValueEnum;
import com.cpf.constant.WebConstant;
import com.cpf.entity.book.BookCategory;
import com.cpf.entity.info.SearchWord;
import com.cpf.entity.system.BReader;
import com.cpf.service.book.BookCategoryService;
import com.cpf.service.book.BookService;
import com.cpf.service.info.SearchWordService;
import com.cpf.util.CodeUtil;
import com.cpf.util.NetUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping(value="/book")
public class BookController
{
	@Autowired
	@Qualifier("bookCategoryService")
	private BookCategoryService bookCategoryService;
	
	@Autowired
	@Qualifier("bookService")
	private BookService bookService;
	
	@Autowired
	@Qualifier("searchWordService")
	private SearchWordService searchWordService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="addBookByCode",method=RequestMethod.POST)
	@ResponseBody
	public Object addBookByCode(String isbnCode){
		try
		{
			if(StringUtil.isBlank(isbnCode))
				return new ResponseBean(CommonConstant.RESPONSE_CODE_400, CommonConstant.MSG_PARAMETER_EMPTY);
			String jsonResult=NetUtil.doGet(WebConstant.DOUBAN_API+isbnCode);
			Map<String, Object> map=JsonUtil.convertJsonToMap(jsonResult);
			//添加图书
			List<BookCategory> list=new ArrayList<>();
			JSONArray arr=(JSONArray) map.get(WebConstant.KEY_DOUBAN_TAGS);
			Iterator<JSONObject> it=arr.iterator();
			Date now=new Date();
			while(it.hasNext()){
				JSONObject json=it.next();
				String name=json.getString(WebConstant.KEY_DOUBAN_NAME);
				if (bookCategoryService.isBookCategoryExist(name))
				{
					list.add(new BookCategory(name, now, now));
				}
			}
			
			//构建图书对象
			BookBuilder builder=new BookBuilder();
			builder.setValue(BookValueEnum.TITLE, map.get(WebConstant.KEY_DOUBAN_TITLE));
			builder.setValue(BookValueEnum.ADD_TIME, now);
			builder.setValue(BookValueEnum.AUTHOR, ((JSONArray)map.get(WebConstant.KEY_DOUBAN_AUTHOR)).get(0));
			builder.setValue(BookValueEnum.CODE, CodeUtil.createCode(isbnCode));
			builder.setValue(BookValueEnum.EDIT_TIME, now);
			builder.setValue(BookValueEnum.IMAGE_LARGE, map.get(WebConstant.KEY_DOUBAN_LARGE));
			builder.setValue(BookValueEnum.IMAGE_MEDIUM, map.get(WebConstant.KEY_DOUBAN_MEDIUM));
			builder.setValue(BookValueEnum.IMAGE_SMALL, map.get(WebConstant.KEY_DOUBAN_SMALL));
			builder.setValue(BookValueEnum.ISBN_CODE, isbnCode);
			builder.setValue(BookValueEnum.PUB_DATE, map.get(WebConstant.KEY_DOUBAN_PUBDATE));
			builder.setValue(BookValueEnum.PUBLISHER, map.get(WebConstant.KEY_DOUBAN_PUBLISHER));
			builder.setValue(BookValueEnum.SUMMARY, map.get(WebConstant.KEY_DOUBAN_SUMMARY));
			builder.setValue(BookValueEnum.CATEGORYS, list);
			this.bookService.addBook(builder.toBook());
			return new ResponseBean(CommonConstant.RESPONSE_CODE_200, CommonConstant.MSG_ADD_SUCCESS);
		} catch (Exception e)
		{
			e.printStackTrace();
			LogUtil.logException("BookController addBookByCode", e);
			return new ResponseBean(CommonConstant.RESPONSE_CODE_500, CommonConstant.MSG_ADD_FAIL);
		}
	}
	
	
	@RequestMapping(value="searchBook",method=RequestMethod.GET)
	@ResponseBody
	public Object searchBook(HttpSession session,Integer pageNo,Integer pageSize
			,String word,Integer categoryId){
		try
		{
			BReader reader=(BReader) session.getAttribute(WebConstant.SESSION_KEY_READER);
			searchWordService.addSearchWord(new SearchWord(word, reader));
			Pager pager=bookService.retrieveBookBySearch(pageNo, pageSize, word, categoryId);
			return new ResponseBean(CommonConstant.RESPONSE_CODE_200, CommonConstant.MSG_ADD_SUCCESS,pager);
		} catch (Exception e)
		{
			e.printStackTrace();
			return new ResponseBean(CommonConstant.RESPONSE_CODE_500, CommonConstant.MSG_ADD_FAIL);
		}
	}
}
