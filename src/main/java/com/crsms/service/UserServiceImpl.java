
package com.crsms.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crsms.dao.UserDao;
import com.crsms.domain.Role;
import com.crsms.domain.User;
import com.crsms.domain.UserInfo;
import com.crsms.util.Invocable;
import com.crsms.util.PageParams;

/**
 * 
 * @author Roman Romaniuk
 *
 */
@Service("userService")
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
	
	private static final long STUDENT_ROLE_ID = 2;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleService roleService;

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private TeacherRequestService teacherRequestService;

	private Role studentRole;
	
	@PostConstruct
	private void postConstruct() {
		this.studentRole = this.roleService.getRoleById(STUDENT_ROLE_ID);
	}
	
	@Override
	@Transactional
	public User saveUser(User user) {
			user.setEmail(user.getEmail().toLowerCase());
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			userDao.save(user);
			UserInfo userInfo = new UserInfo();
			userInfoService.save(userInfo);
			userInfo.setUser(user);
			userInfoService.update(userInfo);
			
		return user;
	}
	
	@Override
	@Transactional
	public User saveUser(User user, boolean teacherRequest) {
		this.saveUser(user);	
		user.setRole(this.studentRole);
		this.update(user);
		
		if (teacherRequest) {
			teacherRequestService.createRequest(user);
		}
		
		return user;
	}
	
	@Override
	public User createAndSaveStudent(String email, String password) {
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		return saveUser(user, false);
	}
	
	@Override
	public boolean changePassword(String email, String currentPassword, String newPassword) {
		User user = getUserByEmail(email);
		
		if (!this.passwordEncoder.matches(currentPassword, user.getPassword())) {
			return false;
		}
		
		user.setPassword(this.passwordEncoder.encode(newPassword));
		userDao.update(user);
		
		return true;
	}
	
	@Override
	public User getUserByEmail(String email) {
		return userDao.getUserByEmail(email);
	}
	
	@Override
	public User getUserByEmail(String email, List<Invocable<User>> initializers) {
		User user = userDao.getUserByEmail(email);
		for (Invocable<User> initalizer : initializers) {
			initalizer.invoke(user);
		}
		return user;
	}

	@Override
	public boolean isEmailExists(String email) {
		return userDao.getUserByEmail(email.toLowerCase()) != null;
	}

	public long getRowsCount(String keyWord) {
		return userDao.getRowsCount(keyWord);
	}

	@Override
	public List<User> getPagingUsers(int offSet, int itemsPerPage, 
									String sortingField, String order, String keyWord) {
		return userDao.getPagingUsers(offSet, itemsPerPage, 
									sortingField, order, keyWord);
	}
	
	@Override
	public List<User> getSearchResult(PageParams pageParams,
			String sortingField, String order, String keyWord) {
		
		pageParams.setOffset((pageParams.getPage() - 1) * pageParams.getItemsPerPage());
		pageParams.setRowsCount(userDao.getRowsCount(keyWord));
		pageParams.setLastPage ((int) ((pageParams.getRowsCount() / pageParams.getItemsPerPage())));
		
		if (pageParams.getRowsCount() > (pageParams.getLastPage() * pageParams.getItemsPerPage())) 
			pageParams.setLastPage (pageParams.getLastPage()+1);
		return userDao.getSearchResult(pageParams, sortingField, keyWord);
	}

	@Override
	public long getUsersToApproveCount() {
		return userDao.getUsersToApproveCount();
	}

	@Override
	public List<User> getUsersToApprove(Boolean teacherRequest) {
		return userDao.getUsersToApprove(teacherRequest);
	}
}
