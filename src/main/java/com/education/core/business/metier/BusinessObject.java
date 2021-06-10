package com.education.core.business.metier;

import com.education.core.business.dao.IObjectDAO;

public class BusinessObject implements IBusinessObject{

	@MyAnnotation
	private IObjectDAO dao;

	public BusinessObject(IObjectDAO dao){
		this.dao = dao;
	}

	public BusinessObject(){}

	public IObjectDAO getDao() {
		return dao;
	}

	public void setDao(IObjectDAO dao) {
		this.dao = dao;
	}
	
    @Override
	public double calcul(){
		double nb = dao.getValue();
		return 2 * nb;
	}
 
	
}
