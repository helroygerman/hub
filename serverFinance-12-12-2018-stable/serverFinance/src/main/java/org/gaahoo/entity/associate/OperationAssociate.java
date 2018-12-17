package org.gaahoo.entity.associate;

import java.util.List;

import org.gahoo.entity.Operation;
import org.gahoo.entity.PosteDepense;
import org.gahoo.entity.User;

public class OperationAssociate {

	private Operation operation;
	private List<PosteDepense> poste;
	private User user;
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Operation getOperation() {
		return operation;
	}
	public void setOperation(Operation operation) {
		this.operation = operation;
	}
	public List<PosteDepense> getPoste() {
		return poste;
	}
	
	public void setPoste(List<PosteDepense> poste) {
		this.poste = (List<PosteDepense>) poste;
	}
	public OperationAssociate(Operation operation, List<PosteDepense> poste) {
		super();
		this.operation = operation;
		this.poste = poste;
	}
	public OperationAssociate() {
		super();
	}
	
	
	
	
	
	
}
