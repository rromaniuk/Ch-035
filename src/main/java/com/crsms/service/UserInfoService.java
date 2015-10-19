package com.crsms.service;

import java.util.List;

import com.crsms.domain.UserInfo;
import com.crsms.util.NotFoundException;

public interface UserInfoService {

	UserInfo save(UserInfo userInfo, Long userId) throws NotFoundException;

	void delete(Long id, Long userId) throws NotFoundException;

	UserInfo getByUserId(Long id,Long userId) throws NotFoundException;

	List<UserInfo> getAll() throws NotFoundException;

	UserInfo update(UserInfo userInfo, Long userId) throws NotFoundException;
}
