package com.cpf.entity.book;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="book_category")
public class BookCategory
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="type")
	private String type;
	
	@Column(name="addTime")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date addTime;
	
	@Column(name="editTime")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date editTime;

	@ManyToMany(cascade={CascadeType.PERSIST})
	@JoinTable(name="book_category_relation",joinColumns=@JoinColumn(name="categoryId"),
			inverseJoinColumns=@JoinColumn(name="bookId"))
	private List<Book> books;
	
	public BookCategory (){}
	public BookCategory(String type, Date addTime, Date editTime)
	{
		super();
		this.type = type;
		this.addTime = addTime;
		this.editTime = editTime;
	}

	public List<Book> getBooks()
	{
		return books;
	}

	public void setBooks(List<Book> books)
	{
		this.books = books;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public Date getAddTime()
	{
		return addTime;
	}

	public void setAddTime(Date addTime)
	{
		this.addTime = addTime;
	}

	public Date getEditTime()
	{
		return editTime;
	}

	public void setEditTime(Date editTime)
	{
		this.editTime = editTime;
	}
	
	
}
