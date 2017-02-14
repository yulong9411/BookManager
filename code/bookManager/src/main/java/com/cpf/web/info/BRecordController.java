package com.cpf.web.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cpf.common.bean.ResponseBean;
import com.cpf.common.constant.CommonConstant;
import com.cpf.common.util.StringUtil;
import com.cpf.constant.WebConstant;
import com.cpf.entity.book.Book;
import com.cpf.entity.system.BReader;
import com.cpf.service.book.BookService;
import com.cpf.service.system.BReaderService;

@Controller
@RequestMapping(value="/book_record")
public class BRecordController {
	
	@Autowired
	@Qualifier("bookService")
	private BookService bookService;
	
	@Autowired
	@Qualifier("bReaderService")
	private BReaderService bReaderService;
	
	//验证编码的图书是否存在，验证用户是否还能够借书
	@RequestMapping(value="borrowBook",method=RequestMethod.POST)
	@ResponseBody
	public Object borrowBook(String code,Long readerId){
		if(StringUtil.isBlank(code)||null == readerId){
			return new ResponseBean(CommonConstant.RESPONSE_CODE_400, CommonConstant.MSG_PARAMETER_EMPTY);
		}
		Book book=this.bookService.retrieveBookByCode(code);
		if(book==null)
			return new ResponseBean(CommonConstant.RESPONSE_CODE_400, WebConstant.BOOK_IS_NO_EXIST);
		BReader reader=this.bReaderService.retrieveBReaderById(readerId);
		
	}
	
}
