package com.capgemini.onlineWallet.Dao;

import com.capgemini.onlineWallet.Entities.User;
import com.capgemini.onlineWallet.Entities.WalletAccount;
import com.capgemini.onlineWallet.Entities.WalletTransaction;

public interface OnlineWalletDao {
	User getUser(Integer userId);
	WalletAccount getAccount(Integer accountId);
	WalletTransaction getTransaction(Integer transactionId);
	WalletTransaction setBalance(double accountBalance);
	WalletTransaction getBalance(double accountBalance);
	WalletTransaction setDescription(String description);
	void persistTransaction(WalletTransaction transaction);
	void addUser(User user);
	void addAccount(WalletAccount account);
	
}
