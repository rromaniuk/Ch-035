package com.crsms.dao;

import java.util.List;
import java.util.Set;

import com.crsms.domain.Group;
import com.crsms.dto.UserIdFNameLNameEmailDto;

public interface GroupDao extends BaseDao<Group> {

	List<Group> getAllByCourseId(Long courseId);

	void deleteById(Long groupId);

	List<UserIdFNameLNameEmailDto> getStudentsFromGroup(Long groupId);

	List<String> selectAlreadySubscribedUsers(Long courseId, Set<String> emails);

	List<UserIdFNameLNameEmailDto> searchStudents(String textToSearch);
	
	List<UserIdFNameLNameEmailDto> getStudentsFromGroupPaginated(Long groupId,
			String sortBy, String sortOrder, Integer offset, Integer count);

}
