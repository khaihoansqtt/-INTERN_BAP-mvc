package com.bap.intern.mvc.dto.showOrder;

import com.bap.intern.mvc.entity.OrderItem;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemDto extends OrderItem {
	
	public OrderItemDto(OrderItem orderItem) { 
		setItemId(orderItem.getItemId());
		setQuantity(orderItem.getQuantity());
		setPrice(orderItem.getPrice()); 
		setDeleteFlg(orderItem.getDeleteFlg());
	}
}
