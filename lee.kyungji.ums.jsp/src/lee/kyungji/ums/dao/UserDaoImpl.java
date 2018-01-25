package lee.kyungji.ums.dao;
import java.util.ArrayList;
import java.util.List;
import lee.kyungji.ums.config.Configuration;
import lee.kyungji.ums.dao.mapper.UserMapper;
import lee.kyungji.ums.domain.User;


public class UserDaoImpl implements UserDao{
	
	private UserMapper usermapper;	
	
	public UserDaoImpl(){
		usermapper = Configuration.getMapper(UserMapper.class);
	}
	//사용자 정보 목록을 뽑아낸다.
	//return: 사용자 정보 목록
	public List<User> getUsers(){
		return usermapper.getUsers();
	}
	//사용자 한명의 정보를 조회한다.
	//return: 사용자정보
	//param: 사용자 번호 
	public User getUser(int userNo){
		User user = null;
		for(User tmp:usermapper.getUsers())
			if(tmp.getUserNo()==userNo)
				user = tmp;
		return user;
	}
	//사용자 정보를 추가한다.
	//return:사용자 정보 추가 성공 여부
	//param: 사용자 이름
	public boolean addUser(String userName){
		User tmp=new User();
		tmp.setUserName(userName);
		usermapper.addUser(tmp);
		return true;
	}
	//사용자 정보를 수정한다.
	//return:사용자 정보 수정 성공 여부
	//param: 사용자 정보
	public boolean updateUser(User user){
		int userNo = user.getUserNo();
		
		boolean isModified = false;
		for(User tmp: usermapper.getUsers())
			if(tmp.getUserNo()==userNo){
				tmp.setUserName(user.getUserName());
				usermapper.updateUser(tmp);
				isModified = true;
			}
		return isModified;
	}
	//사용자 정보를 삭제한다.
	//return:사용자 정보 삭제 성공 여부
	//param: 사용자 번호
	@Override
	public boolean delUser(int userNo) {
		boolean isDel = false;
		
		for(int i =0;i<usermapper.getUsers().size();i++){
			if(usermapper.getUsers().get(i).getUserNo()==userNo){
				usermapper.delUser(userNo);
				isDel=true;
			}
		}
		return isDel;
	}
	
}
