package org.shaolin.vogerp.commonmodel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.shaolin.uimaster.page.ajax.json.JSONObject;
import org.shaolin.vogerp.commonmodel.be.IPersonalAccount;
import org.shaolin.vogerp.commonmodel.be.IPersonalInfo;
import org.shaolin.vogerp.commonmodel.be.IRegisterInfo;
import org.shaolin.vogerp.commonmodel.ce.AMemberType;
import org.shaolin.vogerp.commonmodel.internal.PasswordCheckResult;

public interface IUserService {

	public static final String USER_LOGIN_PASSWORDRULES_ACCOUNTLOCKED = "user.login.passwordrules.accountlocked";

	public static final String USER_LOGIN_PASSWORDRULES_PASSWORDINCORRECT = "user.login.passwordrules.passwordincorrect";
	
	public static final String USER_LOGIN_PASSWORDRULES_VERICODEINCORRECT = "user.login.passwordrules.verifycodeincorrect";
	
	public static final String USER_REGISTER_FAIL = "user.register.fail";
	
	public void addListener(UserActionListener listener);
	
	public boolean checkNewAccount(String userAccount);
	
	public boolean register(IRegisterInfo info, HttpServletRequest request);
	
	public PasswordCheckResult checkPasswordPattern(String password);
	
	public String preLogin(HttpServletRequest request);
	
	public boolean checkVerifiAnswer(String answer, HttpServletRequest request);
	
	/**
	 * User login
	 * 
	 * @param user
	 * @param request
	 * @return
	 * 	      if the result is empty, that means the login user is valid.
	 *        otherwise, an error code indicated the error type.
	 * 
	 */
	public String login(IPersonalAccount user, HttpServletRequest request);
	
	public boolean checkUserOnline(HttpSession session);
	
	public void logout(HttpSession session);

	public String getErrorInfo(String errorCode);
	
	void changePassword(IPersonalAccount user, String newPassword);
	
	public IPersonalAccount getPersonalAccount(long userId);
	
	public IPersonalInfo getPersonalInfo(long userId);
	
	public String getUserName(long userId);
	
	/**
	 * Get logined user organization type.
	 * 
	 * @return
	 */
	public String getUserOrganizationType();
	
	/**
	 * Get logined user Id.
	 * @return
	 */
	public long getUserId();
	
	public JSONObject getOnlineUserAsJSON();
	
	public interface UserActionListener {
		void loggedIn(IPersonalAccount account, IPersonalInfo userInfo);
		void registered(IPersonalInfo userInfo);
	}
}
