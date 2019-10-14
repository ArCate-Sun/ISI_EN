package com.wkl.isien.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ParameterRepository extends JpaRepository<Parameter,Long>{
	Parameter findFirstByPname(String pname);
}
