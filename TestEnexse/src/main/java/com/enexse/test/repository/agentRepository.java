package com.enexse.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.enexse.test.models.agents;

@Repository
public interface agentRepository extends JpaRepository<agents, Long>{
	public agents findByName(String name);
	@Query(" SELECT COUNT(*) as nbre FROM agents a where a.id <>0 ")
	int totalAgents();
	
	@Query(" SELECT COUNT(*) as nbre FROM agents a where a.status like 'active'"
			+"and a.name not in('cyr-customer-ossec.local')"
			+ "And a.id <>0 ")
	int nbreActiveAgents();
	
	
	@Query(" SELECT COUNT(*) as nbre FROM agents a where a.status like 'disconnected' "
			+ "and a.name not in('cyr-customer-ossec.local')"
			+" and a.id <>0 ")
	int DisconnectedAgents();
	
	
	@Query(" SELECT COUNT(*) as nbre FROM agents a where a.status like 'pending' "
			+ "and a.name not in('cyr-customer-ossec.local')"
			+" and a.id <>0 ")
	int pendingAgents();
	
	@Query(" SELECT COUNT(*) as nbre FROM agents a where a.status like 'never_connected' "
			+ "and a.name not in('cyr-customer-ossec.local')"
			+" and a.id <>0 ")
	int neverConnectedAgents();
	 

}
