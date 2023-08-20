package com.bap.intern.mvc.dto.showOrder;

import com.bap.intern.mvc.entity.Order;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderResDto extends Order {
	
	public OrderResDto(Order order) { 
		setOrderId(order.getOrderId());
		setOrderDate(order.getOrderDate());
		setTotalAmount(order.getTotalAmount()); 
		setDeleteFlg(order.getDeleteFlg());
		setOrderItems(order.getOrderItems());
	}
}
