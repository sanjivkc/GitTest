package com.vihaans.core.dao.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vihaans.core.dao.Auditable;
import com.vihaans.core.dao.model.User;
import com.vihaans.core.dao.repo.UserRepository;
import com.vihaans.core.util.AuditingActionType;

@Service
public class UserService {

	@Autowired
	UserRepository repository;
	
	@Transactional
	@Auditable(actionType = AuditingActionType.CREATE, failedActionType = AuditingActionType.CREATE_FAILED)
	public void add(User user) {
        repository.save(user);
    }

	@Transactional
	@Auditable(actionType = AuditingActionType.DELETE, failedActionType = AuditingActionType.DELETE_FAILED)
    public void delete(long id) 
	{
        repository.deleteById(id);
    }

	public User getUser(String userId) 
	{
		return repository.findByUserId(userId).orElse(null);
    }
    
	public User getUserById(long id) 
    {
        Optional<User> optional = repository.findById(id);
        return optional.orElseThrow(() -> new NotFoundException("Couldn't find a User with id: " + id));
    }
	
}
