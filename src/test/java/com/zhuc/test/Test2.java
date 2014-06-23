package com.zhuc.test;

import org.springframework.web.util.HtmlUtils;

public class Test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(HtmlUtils.htmlEscape("&"));
		System.out.println(HtmlUtils.htmlUnescape("&amp;asdasdsad&*("));
	}

}
