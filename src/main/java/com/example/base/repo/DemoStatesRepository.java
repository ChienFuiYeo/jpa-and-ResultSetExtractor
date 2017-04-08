package com.example.base.repo;

import java.util.concurrent.CompletableFuture;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.base.entity.DemoStates;

@Repository
public interface DemoStatesRepository extends JpaRepository<DemoStates, String> {

	CompletableFuture<DemoStates> findBySt(String st);
	
	CompletableFuture<String> findStateNameBySt(String st);

}
