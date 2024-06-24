package com.github.proposalapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.github.proposalapp.model.Proposal;

import jakarta.transaction.Transactional;

@Repository
public interface ProposalRepository extends JpaRepository<Proposal, Long> {
	
    List<Proposal> findAllByIntegratedIsFalse();

    @Transactional
    @Modifying
    @Query(value = "UPDATE proposal SET approved = :approved, observation = :observation WHERE id = :id", nativeQuery = true)
    void updateProposal(Long id, boolean approved, String observation);
    
    @Transactional
    @Modifying
    @Query(value = "UPDATE proposal SET integrated = :integrated WHERE id = :id")
    void updateStatusIntegrated(Long id, boolean integrated);

}
