package com.capgemini.onlineWallet.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
/***************************************************************************************
 * @author:      Aishwarya Srivastava                                                  *
 * Description:  It is a entity class that provides the entities that are              * 
 *               going to be used in the application.                                  *
 * Version :     1.0                                                                   *
 * Created Date: 20-APR-2020                                                           *
 ***************************************************************************************/

@Entity
@Table(name = "WalletAccount")

public class WalletAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int accountId;

	@Column(name = "accountBalance")
	private Double accountBalance = 0.0;

	private String status;

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public Double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

	

}