package com.cpf.service.info;

import org.springframework.stereotype.Service;

import com.cpf.common.service.BaseServiceImpl;
import com.cpf.entity.info.SearchWord;

@Service("searchWordService")
public class SearchWordServiceImpl extends BaseServiceImpl implements SearchWordService
{

	@Override
	public void addSearchWord(SearchWord searchWord)
	{
		addObject(searchWord);
	}

}
