package com.temosho.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.temosho.application.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{

}
