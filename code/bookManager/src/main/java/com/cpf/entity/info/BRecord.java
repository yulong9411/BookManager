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

import com.cpf.entity.book.Book;
import com.cpf.entity.system.BReader;

@Entity
@Table(name="borrow_record")
public class BRecord
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="book")
	private Book book;
	
	@ManyToOne
	@JoinColumn(name="reader")
	private BReader reader;
	
	@Column(name="borrowTime")
	private Date borrowTime;
	
	/**
	 * 是否续借，0:不续借
	 */
	@Column(name="renew")
	private String renew;
	
	@Column(name="backTime")
	private Date backTime;
	
	@Column(name="type")
	private String type;//0：借阅，1：预约
	
	@Column(name="hasDelete")
	private String hasDelete;

	public BRecord(Book book, BReader reader, Date borrowTime, String renew, Date backTime, String type,
			String hasDelete) {
		super();
		this.book = book;
		this.reader = reader;
		this.borrowTime = borrowTime;
		this.renew = renew;
		this.backTime = backTime;
		this.type = type;
		this.hasDelete = hasDelete;
	}

	public BRecord() {
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

	public Book getBook()
	{
		return book;
	}

	public void setBook(Book book)
	{
		this.book = book;
	}

	public BReader getReader()
	{
		return reader;
	}

	public void setReader(BReader reader)
	{
		this.reader = reader;
	}

	public Date getBorrowTime()
	{
		return borrowTime;
	}

	public void setBorrowTime(Date borrowTime)
	{
		this.borrowTime = borrowTime;
	}

	public String getRenew()
	{
		return renew;
	}

	public void setRenew(String renew)
	{
		this.renew = renew;
	}

	public Date getBackTime()
	{
		return backTime;
	}

	public void setBackTime(Date backTime)
	{
		this.backTime = backTime;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
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
