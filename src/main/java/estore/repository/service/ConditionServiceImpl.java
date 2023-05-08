package estore.repository.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import estore.repository.Condition;
import estore.repository.ConditionDAO;

@Service
public class ConditionServiceImpl implements ConditionService{

	@Autowired
	ConditionDAO conditionDAO;
	
	@Override
	public List<Condition> findAll() {
		
		return conditionDAO.findAll();
	}

}
