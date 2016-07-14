package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the RESTURANT database table.
 * 
 */
@Entity
@NamedQuery(name="Resturant.findAll", query="SELECT r FROM Resturant r")
public class Resturant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RESTURANT_RESTURANTID_GENERATOR", sequenceName="RESTURANT_ID_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RESTURANT_RESTURANTID_GENERATOR")
	private String resturantid;

	private String restaddress;

	private String restdescription;

	private String restname;

	//bi-directional many-to-one association to Review
	@OneToMany(mappedBy="resturant")
	private List<Review> reviews;

	public Resturant() {
	}

	public String getResturantid() {
		return this.resturantid;
	}

	public void setResturantid(String resturantid) {
		this.resturantid = resturantid;
	}

	public String getRestaddress() {
		return this.restaddress;
	}

	public void setRestaddress(String restaddress) {
		this.restaddress = restaddress;
	}

	public String getRestdescription() {
		return this.restdescription;
	}

	public void setRestdescription(String restdescription) {
		this.restdescription = restdescription;
	}

	public String getRestname() {
		return this.restname;
	}

	public void setRestname(String restname) {
		this.restname = restname;
	}

	public List<Review> getReviews() {
		return this.reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	
}