package com.cpf.web.book;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cpf.bean.BookBuilder;
import com.cpf.common.bean.ResponseBean;
import com.cpf.common.constant.CommonConstant;
import com.cpf.common.util.JsonUtil;
import com.cpf.common.util.LogUtil;
import com.cpf.common.util.StringUtil;
import com.cpf.constant.BookValue;
import com.cpf.constant.WebConstant;
import com.cpf.entity.book.BookCategory;
import com.cpf.service.book.BookCategoryService;
import com.cpf.util.CodeUtil;
import com.cpf.util.NetUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller(value="/book")
public class BookController
{
	@Autowired
	@Qualifier("bookCategoryService")
	private BookCategoryService bookCategoryService;
	
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
			while(it.hasNext()){
				JSONObject json=it.next();
				String name=json.getString(WebConstant.KEY_DOUBAN_NAME);
				if (bookCategoryService.isBookCategoryExist(name))
				{
					list.add(bookCategoryService.addBookCategory(name));
				}
			}
			
			//构建图书对象
			BookBuilder builder=new BookBuilder();
			Date now=new Date();
			builder.setValue(BookValue.ADDTIME, now);
			builder.setValue(BookValue.AUTHOR, map.get(WebConstant.KEY_DOUBAN_AUTHOR));
			builder.setValue(BookValue.CODE, CodeUtil.createCode(isbnCode));
			builder.setValue(BookValue.EDITTIME, now);
			builder.setValue(BookValue.IMAGELARGE, map.get(WebConstant.KEY_DOUBAN_LARGE));
			builder.setValue(BookValue.IMAGEMEDIUM, map.get(WebConstant.KEY_DOUBAN_MEDIUM));
			builder.setValue(BookValue.IMAGESMALL, map.get(WebConstant.KEY_DOUBAN_SMALL));
			builder.setValue(BookValue.ISBNCODE, isbnCode);
			builder.setValue(BookValue.PUBDATE, map.get(WebConstant.KEY_DOUBAN_PUBDATE));
			builder.setValue(BookValue.PUBLISHER, map.get(WebConstant.KEY_DOUBAN_PUBLISHER));
			builder.setValue(BookValue.SUMMARY, map.get(WebConstant.KEY_DOUBAN_SUMMARY));
			builder.setValue(BookValue.CATEGORYS, list);
		} catch (Exception e)
		{
			e.printStackTrace();
			LogUtil.logException("BookController addBookByCode", e);
			return new ResponseBean(CommonConstant.RESPONSE_CODE_500, CommonConstant.MSG_ADD_FAIL);
		}
		
	}
}
