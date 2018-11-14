package com.xzl.miaosha.exception;

import com.xzl.miaosha.result.CodeMsg;

public class GlobalException extends RuntimeException{

	
	/**
	 *@author xiezhengliang  
	 *@date 2018年11月14日 下午5:22:15
	 */
	private static final long serialVersionUID = 1L;
	private CodeMsg cm;
	
	public GlobalException(CodeMsg cm) {
		super(cm.toString());
		this.cm = cm;
	}

	public CodeMsg getCm() {
		return cm;
	}

}
