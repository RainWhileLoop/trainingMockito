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

    public WithdrawServiceTest() {
    }

    @Before
    public void setUp() {
        withdrawService = new WithdrawServiceImpl();
        BankAccountRepo bankAccountRepo = new BankAccountRepo() {

            @Override
            public List findAll() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public List findAll(Sort sort) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public List findAll(Iterable itrbl) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public List save(Iterable itrbl) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void flush() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void deleteInBatch(Iterable itrbl) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void deleteAllInBatch() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Page findAll(Pageable pgbl) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public long count() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void delete(Iterable itrbl) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void deleteAll() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public BankAccount findByNameContains(String name) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public <S extends BankAccount> S saveAndFlush(S s) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public BankAccount getOne(Integer id) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public <S extends BankAccount> S save(S s) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public BankAccount findOne(Integer id) {
                BankAccount account = new BankAccount();
                account.setId(1);
                account.setBalances(1000d);
                return account;
            }

            @Override
            public boolean exists(Integer id) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void delete(Integer id) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void delete(BankAccount t) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
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
}
