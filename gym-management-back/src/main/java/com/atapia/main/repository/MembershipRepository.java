package com.atapia.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atapia.main.entity.TMembership;

public interface MembershipRepository extends JpaRepository<TMembership, String>{

}
