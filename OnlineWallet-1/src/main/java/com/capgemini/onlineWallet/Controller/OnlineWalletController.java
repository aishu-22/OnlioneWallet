package com.capgemini.onlineWallet.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlineWallet.Service.OnlineWalletService;

/******************************************************************************************
*          @author         Aishwarya Srivastava                                           *
*          Description      It is a controller class that processes action for            *
*                           processes like addMoney and transferMoney then maps it        * 
*                           according to the required handler method.                     *
*          Version          1.0                                                           *
*          Created Date     22-APR-2020                                                   *
*******************************************************************************************/
@RestController
public class OnlineWalletController {

	@Autowired
	private OnlineWalletService service;

	@CrossOrigin
	@GetMapping("/addmoney/{accountid}/{amount}")
	public boolean addMoney(@PathVariable(name = "accountid") int accId, @PathVariable(name = "amount") double amt) {
		return service.addMoney(accId, amt);
	}

	@CrossOrigin
	@GetMapping("/transfermoney/{sid}/{rid}/{amt}")
	public boolean transferMoney(@PathVariable(name = "sid") int sid, @PathVariable(name = "rid") int rid,
			@PathVariable(name = "amt") double amt) {
		return service.transferMoney(sid, rid, amt);
	}
}