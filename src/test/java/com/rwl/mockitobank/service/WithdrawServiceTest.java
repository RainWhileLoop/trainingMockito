/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rwl.mockitobank.service;

import com.rwl.mockitobank.model.BankAccount;
import com.rwl.mockitobank.repo.BankAccountRepo;
import com.rwl.mockitobank.service.impl.WithdrawServiceImpl;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.util.ReflectionTestUtils;

/**
 *
 * @author thanthathon.b
 */
public class WithdrawServiceTest {

    private WithdrawService withdrawService;
    private BankAccountRepo bankAccountRepo;
    private BankAccount account;

    public WithdrawServiceTest() {
    }

    @Before
    public void setUp() {
        withdrawService = new WithdrawServiceImpl();
        bankAccountRepo = Mockito.mock(BankAccountRepo.class);
        account = new BankAccount();
        account.setBalances(1000d);
        // findOne with any id, return account that balance = 1000
        Mockito.when(bankAccountRepo.findOne(Mockito.anyInt())).thenReturn(account);

        // findOne with id only 1
//        Mockito.when(bankAccountRepo.findOne(1)).thenReturn(account);
        ReflectionTestUtils.setField(withdrawService, "bankAccountRepo", bankAccountRepo);
    }

    @After
    public void tearDown() {

    }

    @Test(expected = RuntimeException.class)
    public void have1000_withdraw1005_should_ThrowException() {
        Double balance = withdrawService.widthdraw(1, 1005d);
    }

    @Test
    public void have1000_withdraw500_should_Remain500() {
        Double balance = withdrawService.widthdraw(1, 500d);
        Assertions.assertThat(balance)
                .isEqualTo(500d);
    }

    @Test
    public void have1000_withdraw1000_should_Remain0() {
        Double balance = withdrawService.widthdraw(1, 1000d);
        Assertions.assertThat(balance)
                .isEqualTo(0d);
    }

    @Test
    public void demo_verify() {
        account = Mockito.mock(BankAccount.class);
        Mockito.when(account.getBalances()).thenReturn(1000d);
        Mockito.when(bankAccountRepo.findOne(Mockito.anyInt())).thenReturn(account);
        ReflectionTestUtils.setField(withdrawService, "bankAccountRepo", bankAccountRepo);
        
        Double balance = withdrawService.widthdraw(1, 500d);
        Mockito.verify(account).setBalances(500d);
    }
}
