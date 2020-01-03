package com.capgemini.forestmanagement.exception;

public class LandExceptions extends RuntimeException {
String msg;

public LandExceptions(String msg) {
	super();
	this.msg = msg;
}

}
