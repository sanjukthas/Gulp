package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the REVIEW database table.
 * 
 */
@Entity
@NamedQuery(name="Review.findAll", query="SELECT r FROM Review r")
public class Review implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="REVIEW_REVIEWID_GENERATOR", sequenceName="REVIEW_ID_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="REVIEW_REVIEWID_GENERATOR")
	private String reviewid;

	@Temporal(TemporalType.DATE)
	private Date datevisited;

	private String rating;

	//bi-directional many-to-one association to Resturant
	@ManyToOne
	@JoinColumn(name="RESTURANTID")
	private Resturant resturant;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="CUSTOMERID")
	private Customer customer;

	public Review() {
	}

	public String getReviewid() {
		return this.reviewid;
	}

	public void setReviewid(String reviewid) {
		this.reviewid = reviewid;
	}

	public Date getDatevisited() {
		return this.datevisited;
	}

	public void setDatevisited(Date datevisited) {
		this.datevisited = datevisited;
	}

	public String getRating() {
		return this.rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Resturant getResturant() {
		return this.resturant;
	}

	public void setResturant(Resturant resturant) {
		this.resturant = resturant;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}