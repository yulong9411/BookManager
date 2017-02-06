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

@Entity
@Table(name="book")
public class Book
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="hasDelete")
	private String hasDelete;
	
	@Column(name="code")
	private String code;
	
	@Column(name="isbnCode")
	private String isbnCode;
	
	@Column(name="addTime")
	private Date addTime;
	
	@Column(name="author")
	private String author;
	
	@ManyToMany(cascade={CascadeType.PERSIST})
	@JoinTable(name="book_category_relation",joinColumns=@JoinColumn(name="bookId"),
	inverseJoinColumns=@JoinColumn(name="categoryId"))
	private List<BookCategory> categorys;
	
	@Column(name="publisher")
	private String publisher;
	
	@Column(name="editTime")
	private Date editTime;
	
	@Column(name="summary")
	private String summary;
	
	@Column(name="pubDate")
	private Date pubDate;
	
	@Column(name="imageLarge")
	private String imageLarge;
	
	@Column(name="imageMedium")
	private String imageMedium;
	
	@Column(name="imageSmall")
	private String imageSmall;

	
	public Book(){}
	
	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getHasDelete()
	{
		return hasDelete;
	}

	public void setHasDelete(String hasDelete)
	{
		this.hasDelete = hasDelete;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String getIsbnCode()
	{
		return isbnCode;
	}

	public void setIsbnCode(String isbnCode)
	{
		this.isbnCode = isbnCode;
	}

	public Date getAddTime()
	{
		return addTime;
	}

	public void setAddTime(Date addTime)
	{
		this.addTime = addTime;
	}

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}


	public List<BookCategory> getCategorys()
	{
		return categorys;
	}

	public void setCategorys(List<BookCategory> categorys)
	{
		this.categorys = categorys;
	}

	public String getPublisher()
	{
		return publisher;
	}

	public void setPublisher(String publisher)
	{
		this.publisher = publisher;
	}

	public Date getEditTime()
	{
		return editTime;
	}

	public void setEditTime(Date editTime)
	{
		this.editTime = editTime;
	}

	public String getSummary()
	{
		return summary;
	}

	public void setSummary(String summary)
	{
		this.summary = summary;
	}

	public Date getPubDate()
	{
		return pubDate;
	}

	public void setPubDate(Date pubDate)
	{
		this.pubDate = pubDate;
	}

	public String getImageLarge()
	{
		return imageLarge;
	}

	public void setImageLarge(String imageLarge)
	{
		this.imageLarge = imageLarge;
	}

	public String getImageMedium()
	{
		return imageMedium;
	}

	public void setImageMedium(String imageMedium)
	{
		this.imageMedium = imageMedium;
	}

	public String getImageSmall()
	{
		return imageSmall;
	}

	public void setImageSmall(String imageSmall)
	{
		this.imageSmall = imageSmall;
	}
}
