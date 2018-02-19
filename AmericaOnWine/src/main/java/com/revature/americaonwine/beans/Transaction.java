package com.revature.americaonwine.beans;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "aow_transaction")
public class Transaction {
	@Id
	@SequenceGenerator(name = "transactionGen", sequenceName = "aow_transaction_seq", allocationSize = 1)
	@GeneratedValue(generator = "transactionGen", strategy = GenerationType.SEQUENCE)
	private int id;
	@Column(name = "order_number")
	private String orderNumber;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "inventory_id")
	private InventoryItem inv;
	@Column
	private int quantity;
	@Column(name = "user_id")
	private String userId;
	@Column
	private int rating;
	@Column(name = "transaction_date")
	private Date transactionDate;
	@Column
	private String comments;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public InventoryItem getInv() {
		return inv;
	}

	public void setInv(InventoryItem inv) {
		this.inv = inv;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", orderNumber=" + orderNumber + ", inv=" + inv + ", quantity=" + quantity
				+ ", userId=" + userId + ", rating=" + rating + ", transactionDate=" + transactionDate + ", comments="
				+ comments + "]";
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + id;
		result = prime * result + ((inv == null) ? 0 : inv.hashCode());
		result = prime * result + ((orderNumber == null) ? 0 : orderNumber.hashCode());
		result = prime * result + quantity;
		result = prime * result + rating;
		result = prime * result + ((transactionDate == null) ? 0 : transactionDate.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (id != other.id)
			return false;
		if (inv == null) {
			if (other.inv != null)
				return false;
		} else if (!inv.equals(other.inv))
			return false;
		if (orderNumber == null) {
			if (other.orderNumber != null)
				return false;
		} else if (!orderNumber.equals(other.orderNumber))
			return false;
		if (quantity != other.quantity)
			return false;
		if (rating != other.rating)
			return false;
		if (transactionDate == null) {
			if (other.transactionDate != null)
				return false;
		} else if (!transactionDate.equals(other.transactionDate))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	public Transaction(int id, String orderNumber, InventoryItem inv, int quantity, String userId, int rating,
			Date transactionDate, String comments) {
		super();
		this.id = id;
		this.orderNumber = orderNumber;
		this.inv = inv;
		this.quantity = quantity;
		this.userId = userId;
		this.rating = rating;
		this.transactionDate = transactionDate;
		this.comments = comments;
	}

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
}
