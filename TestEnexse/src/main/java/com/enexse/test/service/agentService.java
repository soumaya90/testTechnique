package com.enexse.test.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.server.ResponseStatusException;

import com.enexse.test.models.agents;
import com.enexse.test.repository.agentRepository;

@Service
public class agentService {
	
	
	@Autowired
	agentRepository agentRep ;
	
	
	
	    //get all agents
		public List<agents> findAll() {		
			List <agents> agents=agentRep.findAll();
			return agents ;
		}
		
		
		//post an agent
		@Transactional
		public agents addAgent(agents agent) {

	         agents newAgent =agentRep.save(agent);
	         return newAgent ;
				
			}
		
		//update an agent
		public agents update(String name, agents updatedAgent) {
			
			
			agents agent=agentRep.findByName(name);
					
		    agent.setName(name);
		    agent.setDateAdd(updatedAgent.getDateAdd());
		    agent.setIp(updatedAgent.getIp());
		    agent.setLastKeepAlive(updatedAgent.getLastKeepAlive());
		    agent.setOs(updatedAgent.getOs());
		    agent.setVersion(updatedAgent.getVersion());
					
		    agents updatedAgents= agentRep.save(agent);

		     return updatedAgent;  

		}
		
	  //delete an agent
		public void deleteById(int id)  {
			
			
			agents agent =
					agentRep
		            .findById((long)id)
		            .orElseThrow(() -> new ResponseStatusException(org.springframework.http.HttpStatus.NOT_FOUND," Not Found"));
			        
			       agentRep.delete(agent);
		}
		
		
	 //getting the number of agents
		 public int allAgents() {		
				
		    	return  agentRep.totalAgents();
		}
		 
		  
	 // getting the number of active agents
		 
		 public int activeAgents() {		
				
		    	return  agentRep.nbreActiveAgents();
		}
		 
		 
		
		  
		 // getting the number of disconnected agents
			 
			 public int DisconnectedAgents() {		
					
			    	return  agentRep.DisconnectedAgents();
			}
			 
			 
          // getting the number of pending agents
			 
			 public int pendingAgents() {		
					
			    	return  agentRep.pendingAgents();
			}
			 
			 
			 
          // getting the number of never connected agents
			 
			 public int neverConnectedAgents() {		
					
			    	return  agentRep.neverConnectedAgents();
			}
		    
		
			

}
