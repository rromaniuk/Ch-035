package com.crsms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crsms.domain.UserInfo;
import com.crsms.repository.UserInfoRepository;
import com.crsms.util.NotFoundException;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoRepository repository; 
	@Override
	@Transactional
	public UserInfo save(UserInfo userInfo, Long userId) throws NotFoundException {
		return repository.save(userInfo, userId);
	}

	@Override
	@Transactional
	public void delete(Long id, Long userId) throws NotFoundException {
		repository.delete(id, userId);
	}

	@Override
	public UserInfo getByUserId(Long id, Long userId) throws NotFoundException {
		return repository.getByUserId(id, userId);
	}

	@Override
	public List<UserInfo> getAll() throws NotFoundException {
		return repository.getAll();
	}

	@Override
	@Transactional
	public UserInfo update(UserInfo userInfo, Long userId) throws NotFoundException {
		return repository.save(userInfo, userId);
	}
}
