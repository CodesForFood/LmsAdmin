package com.smoothstack.lms.admin.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_library_branch")
public class LibraryBranch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer branchId;
	
	@Column
	private String branchName;
	
	@Column
	private String branchAddress;

	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}
	
	
	
	
}
