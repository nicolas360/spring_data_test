package com.zhuc.test;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.web.util.HtmlUtils;

public class Test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(HtmlUtils.htmlEscape("&"));
		System.out.println(HtmlUtils.htmlUnescape("&amp;asdasdsad&*("));

		String[] a = null;
		String[] b = new String[] { "1", "2" };
		String[] c = ArrayUtils.addAll(a, b);

		System.out.println(Arrays.toString(c));
		System.out.println();
		System.out.println();
		System.out.println();
	}

}
