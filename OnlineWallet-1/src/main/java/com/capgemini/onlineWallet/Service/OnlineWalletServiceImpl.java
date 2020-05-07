package com.capgemini.onlineWallet.Service;

import java.time.LocalDate;
import java.util.Random;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.onlineWallet.Dao.OnlineWalletDao;
import com.capgemini.onlineWallet.Entities.WalletAccount;
import com.capgemini.onlineWallet.Entities.WalletTransaction;
import com.capgemini.onlineWallet.Exceptions.InvalidAmountException;
import com.capgemini.onlineWallet.Exceptions.UnauthorizedUserException;
import org.springframework.stereotype.Service;

import com.capgemini.onlineWallet.Dao.OnlineWalletDao;
import com.capgemini.onlineWallet.Entities.WalletAccount;
import com.capgemini.onlineWallet.Exceptions.InvalidAmountException;
import com.capgemini.onlineWallet.Exceptions.UnauthorizedUserException;
/**********************************************************************************************
 * @author:						Aishwarya Srivastava                                          *
 * Description:					It is a service class that provides the services for          * 
 *								add money and transfer money methods                          *
 * Version:						1.0                                                           * 
 * Created:						Date 22-APR-2020                                              *
 **********************************************************************************************/

@Transactional
@Service

public class OnlineWalletServiceImpl implements OnlineWalletService {
	public OnlineWalletServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private OnlineWalletDao dao;

	/*********************************************************************************************************************
	* @author:          Aishwarya Srivastava                                                                             * 
	* Method:           addMoney                                                                                         *
	* Description:      Increments the balance of the user balance with the amount provided                              *
	* @param accountId: User's accountId                                                                                 * 
	* @param amount:    amount which has to be incremented                                                               *
	* @returns:        Amount is added to wallet of the user                                                             *                
	**********************************************************************************************************************/
	@Override
	public boolean addMoney(int accountId, double amount) {

		WalletAccount userAcc = dao.getAccount(accountId);
		if (userAcc.getStatus() == "inactive")
			throw new UnauthorizedUserException("Invalid user");
		if(amount >10000 || amount < 0)
			throw new InvalidAmountException("Amount to be added could not be greater than 10,000 or in negative");
		userAcc.setAccountBalance(userAcc.getAccountBalance() + amount);
		Random random = new Random();
		int transactionId = accountId + random.nextInt(1000);

		WalletTransaction obj = new WalletTransaction();
		obj.setTransactionId(transactionId);
		obj.setDescription("Money added");
		obj.setAmount(amount);
		obj.setAccountBalance(userAcc.getAccountBalance());
		obj.setWalletAccount(userAcc);
		obj.setTransactionDate(LocalDate.now());
		dao.persistTransaction(obj);
		return true;
	}
	/***********************************************************************************************
	 * @author               AISHWARYA                                                             *
	 * Method:               transferMoney                                                         *
	 * Description:          To send money from one wallet account to another                      *
	 * @param senderAccId:   Sender's account Id                                                   *
	 * @param receiverAccId: Receiver's account Id                                                 *
	 * @param amount:        Amount to be sent                                                     *
	 * @returns:             Amount is deducted from sender's wallet account amount is             *                
	 *                       added into receiver's wallet account                                  *                                
	 ***********************************************************************************************/

	@Override
	public boolean transferMoney(int senderAccId, int receiverAccId, double amount) {

		WalletAccount senderAcc = dao.getAccount(senderAccId);
		WalletAccount receiverAcc = dao.getAccount(receiverAccId);
		if (senderAcc.getAccountBalance() < amount)
			throw new InvalidAmountException("Amount to be send can not be greater than the balance ");
		if (senderAcc.getStatus() == "inactive")
			if (receiverAcc.getStatus() == "inactive")
				throw new UnauthorizedUserException("Invalid user");
		if(amount >10000 || amount < 0)
			throw new InvalidAmountException("Amount to be send could not be greater than 10,000 or negative");
		senderAcc.setAccountBalance(senderAcc.getAccountBalance() - amount);
		receiverAcc.setAccountBalance(receiverAcc.getAccountBalance() + amount);

		Random random = new Random();
		int transactionId1 = senderAccId + random.nextInt(1000);
		int transactionId2 = receiverAccId + random.nextInt(1000);

		WalletTransaction obj1 = new WalletTransaction();
		obj1.setTransactionId(transactionId1);
		obj1.setDescription("Money sent");
		obj1.setAmount(amount);
		obj1.setAccountBalance(senderAcc.getAccountBalance());
		obj1.setWalletAccount(senderAcc);
		obj1.setTransactionDate(LocalDate.now());
		dao.persistTransaction(obj1);

		WalletTransaction obj2 = new WalletTransaction();
		obj2.setTransactionId(transactionId2);
		obj2.setDescription("Money Received");
		obj2.setAmount(amount);
		obj2.setAccountBalance(receiverAcc.getAccountBalance());
		obj2.setWalletAccount(receiverAcc);
		obj2.setTransactionDate(LocalDate.now());
		dao.persistTransaction(obj2);

		return true;
	}
}