package org.gaahoo.helper;

import java.util.UUID;

public class DataHelper {

	
	public static String uuid(){
        UUID uuid = UUID.randomUUID();
        return  uuid.toString();
    }
}
