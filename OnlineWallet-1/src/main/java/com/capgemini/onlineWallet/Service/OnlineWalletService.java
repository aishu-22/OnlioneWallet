package com.capgemini.onlineWallet.Service;
/* *********************Service Interface******************************/

public interface OnlineWalletService {

	boolean transferMoney(int sid, int rid, double amt);

	boolean addMoney(int accId, double amt);

}
