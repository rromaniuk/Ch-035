package com.crsms.repository;

import java.util.List;

import com.crsms.domain.UserInfo;

public interface UserInfoRepository {

	UserInfo save(UserInfo userInfo, Long userId);

	void delete(Long id, Long userId);

	UserInfo getByUserId(Long id,Long userId);

	List<UserInfo> getAll();
}
