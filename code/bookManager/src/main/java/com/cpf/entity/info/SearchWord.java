package com.cpf.entity.info;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cpf.constant.WebConstant;
import com.cpf.entity.system.BReader;

@Entity
@Table(name="search_word")
public class SearchWord
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="word")
	private String word;
	
	@Column(name="searchTime")
	private Date searchTime;
	
	@ManyToOne
	@JoinColumn(name="reader")
	private BReader reader;
	
	@Column(name="hasDelete")
	private String hasDelete;

	
	
	public SearchWord(String word, BReader reader)
	{
		this.word = word;
		this.reader = reader;
		this.searchTime=new Date();
		this.hasDelete=WebConstant.HAS_DELETE_NO;
	}

	public SearchWord()
	{
		super();
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getWord()
	{
		return word;
	}

	public void setWord(String word)
	{
		this.word = word;
	}

	public Date getSearchTime()
	{
		return searchTime;
	}

	public void setSearchTime(Date searchTime)
	{
		this.searchTime = searchTime;
	}

	public BReader getReader()
	{
		return reader;
	}

	public void setReader(BReader reader)
	{
		this.reader = reader;
	}

	public String getHasDelete()
	{
		return hasDelete;
	}

	public void setHasDelete(String hasDelete)
	{
		this.hasDelete = hasDelete;
	}
	
	
}
