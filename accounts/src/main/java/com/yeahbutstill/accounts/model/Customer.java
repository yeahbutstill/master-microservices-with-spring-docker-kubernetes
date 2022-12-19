package com.yeahbutstill.accounts.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;

@Entity
@Getter @Setter
@EqualsAndHashCode @ToString
@AllArgsConstructor @NoArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id")
	private int customerId;

	private String name;

	@Email
	private String email;

	@Column(name = "mobile_number")
	private String mobileNumber;

	@Column(name = "create_dt")
	private LocalDate createDt;

}
