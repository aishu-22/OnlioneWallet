package com.capgemini.onlineWallet.Dao;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.onlineWallet.Entities.User;
import com.capgemini.onlineWallet.Entities.WalletAccount;
import com.capgemini.onlineWallet.Entities.WalletTransaction;

/***************************************************************************************************************
* @author:       Aishwarya Srivastava                                                                          * 
* Description:   It is a dao class which is used to access the data stored in our relational database.         *
* Version :      1.0                                                                                           *
* Created Date:  21-APR-2020                                                                                   *
****************************************************************************************************************/

@Repository
public class OnlineWalletDaoImpl implements OnlineWalletDao {
	//@Autowired
	 @PersistenceContext
	EntityManager em;
	
	
	
	@Override
	public void addUser(User user) {
	em.persist(user);
	}
	
	@Override
	public void persistTransaction(WalletTransaction transaction) {
		em.merge(transaction);
	}
	
	@Override
	public void addAccount(WalletAccount account) {
		em.persist(account);
	}
	
	@Override
	public User getUser(Integer userId) {
		User user = em.find(User.class, userId);
		return user;
	}
	@Override
	public WalletAccount getAccount(Integer accountId) {
		WalletAccount account=em.find(WalletAccount.class, accountId);
		return account;
	}

	@Override
	public WalletTransaction getTransaction(Integer transactionId) {
		WalletTransaction transaction=em.find(WalletTransaction.class, transactionId);
		return transaction;
	}

	@Override
	public WalletTransaction getBalance(double accountBalance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WalletTransaction setBalance(double accountBalance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WalletTransaction setDescription(String description) {
		// TODO Auto-generated method stub
		return null;
	}


	
}