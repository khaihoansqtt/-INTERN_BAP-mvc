package com.bap.intern.mvc.dto.cartFeature;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RemoveProductFromCartResDto {
	private int userId;
	private int cartItemId;
}
