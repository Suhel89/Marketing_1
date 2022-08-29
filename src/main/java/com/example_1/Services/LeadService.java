package com.example_1.Services;

import java.util.List;

import com.example_1.Entity.Lead;

public interface LeadService {
	
public void saveLead(Lead lead);
public List<Lead> listLeads();
public void deleteLeadById(long id);
public Lead getOneLead(long id);






}
