/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rwl.mockitobank.service.impl;

import com.rwl.mockitobank.model.BankAccount;
import com.rwl.mockitobank.repo.BankAccountRepo;
import com.rwl.mockitobank.service.WithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author thanthathon.b
 */
@Service
public class WithdrawServiceImpl implements WithdrawService {

    @Autowired
    private BankAccountRepo bankAccountRepo;

    @Override
    public Double widthdraw(Integer accountId, Double amount) {
        BankAccount account = bankAccountRepo.findOne(accountId);
        if (account.getBalances() >= amount) {
            account.setBalances(account.getBalances() - amount);
            return account.getBalances();
        } else {
            throw new RuntimeException("Balance not enough!");
        }
    }

}
