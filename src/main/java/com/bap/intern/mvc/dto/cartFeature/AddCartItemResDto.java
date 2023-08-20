package com.bap.intern.mvc.dto.cartFeature;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AddCartItemResDto {
	private int userId;
	private int productId;
	private int quantity;
}
