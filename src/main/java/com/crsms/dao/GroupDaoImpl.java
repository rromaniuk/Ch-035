package com.crsms.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.crsms.domain.Group;
import com.crsms.dto.UserIdAndEmailDto;

@Repository
public class GroupDaoImpl extends BaseDaoImpl<Group> implements GroupDao {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Group> getAllByCourseId(Long courseId) {
		List<Group> groups = new ArrayList<>();
		try {
			groups = this.getSessionFactory()
						 .getCurrentSession()
						 .getNamedQuery(Group.GET_ALL_BY_COURSE_ID)
						 .setParameter("courseId", courseId)
						 .list();
		} catch (Exception e) {
			this.getLogger().error("Error in getting all groups by course id: " + e);
			throw e;
		}
		return groups;
	}

	@Override
	public void deleteById(Long groupId) {
		try {
			this.getSessionFactory()
				.getCurrentSession()
				.getNamedQuery(Group.DELETE_BY_ID)
				.setParameter("id", groupId)
				.executeUpdate();
		} catch (Exception e) {
			getLogger().error("Error in delete group by id: " + e);
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserIdAndEmailDto> getStudentsIdsAndEmailsFromGroup(Long groupId) {
		try {
			return this.getSessionFactory()
					   .getCurrentSession()
					   .getNamedQuery(Group.GET_STUDENTS_IDS_AND_EMAILS_FROM_GROUP)
					   .setParameter("id", groupId)
					   .list();
		} catch (Exception e) {
			getLogger().error("Error in get students id and email from group: " + e);
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> selectAlreadySubscribedUsers(Long courseId, Set<String> emails) {
		try {
			return this.getSessionFactory()
					   .getCurrentSession()
					   .getNamedQuery(Group.SELECT_ALREADY_SUBSCRIBED_USERS)
					   .setParameter("courseId", courseId)
					   .setParameterList("emails", emails)
					   .list();
		} catch (Exception e) {
			getLogger().error("Error in select already subscribed users: " + e);
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserIdAndEmailDto> searchStudents(String textToSearch) {
		try {
			return this.getSessionFactory()
					   .getCurrentSession()
					   .getNamedQuery(Group.SEARCH_STUDENTS)
					   .setParameter("textToSearch", "%" + textToSearch + "%")
					   .list();
		} catch (Exception e) {
			getLogger().error("Error in search students: " + e);
			throw e;
		}
	}

}
