package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {

}