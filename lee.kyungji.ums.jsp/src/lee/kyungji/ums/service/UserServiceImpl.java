package lee.kyungji.ums.service;
import java.util.List;
import lee.kyungji.ums.dao.UserDao;
import lee.kyungji.ums.domain.User;

public class UserServiceImpl implements UserService{
	private UserDao userDao;
	
	public UserServiceImpl(UserDao userDao){
		this.userDao = userDao;
	}
	//사용자 목록을 얻는다.
	//return: 사용자 목록
	@Override
	public List<User> listUsers() {		
		return userDao.getUsers();
	}
	//사용자 한명을 찾는다.
	//return: 사용자
	//param: 사용자번호
	@Override
	public User findUser(int userNo) {		
		return userDao.getUser(userNo);
	}
	//사용자를 등록한다.
	//return:등록 성공 여부
	//param: 사용자 이름
	@Override
	public boolean join(String userName) {		
		return userDao.addUser(userName);
	}
	//사용자 정보를 수정한다.
	//return: 수정 성공 여부
	//param: 수정할 사용자
	@Override
	public boolean correctUser(User user) {
		return userDao.updateUser(user);
	}
	//사용자를 탈퇴시킨다.
	//return: 탈퇴 성공 여부
	//param: 탈퇴할 사용자
	@Override
	public boolean secede(int userNo) {		
		return userDao.delUser(userNo);
	}	
}
