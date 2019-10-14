package com.wkl.isien.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<News,Long>{
	List<News> findByState(String state);
	List<News> findByStateAndSubplateid(String state,int subplateid);
}
