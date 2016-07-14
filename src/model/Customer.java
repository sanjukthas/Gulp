package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CUSTOMER database table.
 * 
 */
@Entity
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CUSTOMER_CUSTOMERID_GENERATOR", sequenceName="CUSTOMER_ID_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CUSTOMER_CUSTOMERID_GENERATOR")
	private String customerid;

	private String customeremail;

	private String customername;

	private String customerzip;

	//bi-directional many-to-one association to Review
	@OneToMany(mappedBy="customer")
	private List<Review> reviews;

	public Customer() {
	}

	public String getCustomerid() {
		return this.customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public String getCustomeremail() {
		return this.customeremail;
	}

	public void setCustomeremail(String customeremail) {
		this.customeremail = customeremail;
	}

	public String getCustomername() {
		return this.customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getCustomerzip() {
		return this.customerzip;
	}

	public void setCustomerzip(String customerzip) {
		this.customerzip = customerzip;
	}

	public List<Review> getReviews() {
		return this.reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public Review addReview(Review review) {
		getReviews().add(review);
		review.setCustomer(this);

		return review;
	}

	public Review removeReview(Review review) {
		getReviews().remove(review);
		review.setCustomer(null);

		return review;
	}

}