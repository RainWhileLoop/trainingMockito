/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rwl.mockitobank.repo;

import com.rwl.mockitobank.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author thanthathon.b
 */
public interface BankAccountRepo extends JpaRepository<BankAccount, Integer> {

    public BankAccount findByNameContains(String name);
}
