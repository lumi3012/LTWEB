package validator.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
//import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;



@Entity
@Table(name="categories")
@NamedQuery(name="Category.findAll", query = "SELECT c FROM Category c")
public class Category implements Serializable{

	private static final long serialVersionID = 1L;
	
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="cate_name", columnDefinition = "NVARCHAR(255)")
	private String catename;
	
	@Column(name="icons")
	private String icon;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id", nullable=false)
	private User user;
	
	public Category() {
		
	}
	
	public Category(int id, String catename, String icon) {
		this.id = id;
		this.catename = catename;
		this.icon = icon;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the catename
	 */
	public String getCatename() {
		return catename;
	}

	/**
	 * @param catename the catename to set
	 */
	public void setCatename(String catename) {
		this.catename = catename;
	}

	/**
	 * @return the icon
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * @param icon the icon to set
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
