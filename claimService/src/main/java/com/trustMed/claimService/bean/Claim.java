package com.trustMed.claimService.bean;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Claim")
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Claim {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "claim_number")
    private String claimNumber;

	@NotNull
	@Column(name = "claim_amount")
    private double claimAmount;

	@NotNull
	@Column(name = "claim_date")
    private Date claimDate;

	@Column(name = "assigned_to")
    private String assignedTo;

	// Define the many-to-one relationship with Insurance
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "insurance_id")
    @JsonBackReference
    private Insurance insurance;

	/*
	 * // Define the one-to-one relationship with Treating Doctor Questionnaire
	 * 
	 * @OneToOne(mappedBy = "claim", cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name="FamilyDrQuestionnaire_id")
	 * 
	 * @JsonBackReference private FamilyDoctorQuestionnaire familyDrQuestionnaire;
	 * 
	 * // Define the one-to-one relationship with InsuredQuestionnaire
	 * 
	 * @OneToOne(mappedBy = "claim", cascade = CascadeType.ALL, orphanRemoval =
	 * true)
	 * 
	 * @JoinColumn(name="insuredQuestionnaire_id")
	 * 
	 * @JsonBackReference private InsuredQuestionnaire insuredQuestionnaire;
	 * 
	 * // Define the one-to-one relationship with Treating Doctor Questionnaire
	 * 
	 * @OneToOne(mappedBy = "claim", cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name="TreatingDrQuestionnaire_id")
	 * 
	 * @JsonBackReference private TreatingDrQuestionnaire treatingDrQuestionnaire;
	 */

	public Claim(String claimNumber, @NotNull double claimAmount, @NotNull Date claimDate, String assignedTo,
			@NotNull Insurance insurance/*, InsuredQuestionnaire insuredQuestionnaire, FamilyDoctorQuestionnaire familyDrQuestionnaire, TreatingDrQuestionnaire treatingDrQuestionnaire	*/) {
		super();
		this.claimNumber = claimNumber;
		this.claimAmount = claimAmount;
		this.claimDate = claimDate;
		this.assignedTo = assignedTo;
		this.insurance = insurance;
//		this.insuredQuestionnaire = insuredQuestionnaire;
//		this.familyDrQuestionnaire = familyDrQuestionnaire;
//		this.treatingDrQuestionnaire = treatingDrQuestionnaire;
	}
	
}