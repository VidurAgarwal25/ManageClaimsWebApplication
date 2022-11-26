package com.policy.microservice.exception;

public class ExpiredPolicyException extends RuntimeException{
	
	//serialization is a mechanism to transform an object into a byte stream
		//used during deserialization to verify that the sender and receiver of a serialized object have loaded classes of same serialVersionUID
		
	private static final long serialVersionUID = 1L;

	public ExpiredPolicyException(String msg)
	{
		super(msg);
	}

}
