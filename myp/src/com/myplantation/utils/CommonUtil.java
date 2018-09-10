package com.myplantation.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
/**
 * 
 * @author Rajkumar Pandey
 * 
 */
public class CommonUtil {

	public static  String  b64_sha256(String inputString){ 
		String sh256=Base64.encodeBase64String(DigestUtils.sha256(inputString)).trim();
		return sh256.substring(0, sh256.length()-1);
	}
}
