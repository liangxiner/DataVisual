package com.dv.action;

import java.util.List;

import com.dv.action.base.LoginBaseAction;
import com.dv.entity.User;
import com.dv.util.StaticData;
import com.opensymphony.xwork2.ActionContext;



@SuppressWarnings("serial")
public class LoginAction extends LoginBaseAction {
	private String username; 			// 接受用户编号
	private String password;	// 接受用户密码
	
	public String userLogin()
	{
		List<User> user=userservice.allowLogin(username, password);
		if(user.size()>=1)
		{
			ActionContext.getContext().getSession().put("username", username);
			return "success";
		}
		else
		{
			return "error";
		}
		
	}

	public String loadLibs(){
		StaticData sd = StaticData.getInstance();
		sd.setAr();
		return SUCCESS;
	}
	
	public String logout(){
		ActionContext.getContext().getSession().clear();
		return SUCCESS;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
