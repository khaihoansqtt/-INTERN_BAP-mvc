package com.bap.intern.mvc.dto.showUser;

import com.bap.intern.mvc.entity.User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserResDto extends User {
	
	public UserResDto(User user) {
		setUserId(user.getUserId());
		setUserName(user.getUserName());
		setDeleteFlg(user.getDeleteFlg());
	}
}
