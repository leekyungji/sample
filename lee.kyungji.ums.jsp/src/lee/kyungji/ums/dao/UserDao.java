package lee.kyungji.ums.dao;
import java.util.List;
import lee.kyungji.ums.domain.User;

public interface UserDao {
	List<User> getUsers();//사용자 정보 목록
	User getUser(int userNo);// 사용자 정보 한명
	boolean addUser(String userName);// 사용자 정보 추가
	boolean updateUser(User user);//사용자 정보 수정
	boolean delUser(int userNo);// 사용자 정보 삭제
}
