package lee.kyungji.ums.dao.mapper;
import java.util.List;
import lee.kyungji.ums.domain.User;

public interface UserMapper {	
	List<User> getUsers();	
	User getUser(int userId);		
	int addUser(User user);		
	int updateUser(User user);	
	int delUser(int userNo);
}

