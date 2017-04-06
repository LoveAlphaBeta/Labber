/**  
 * @Title PersonsOprationImpl.java
 * @Package team.labber.beans
 * @author TODO
 * 2017年3月5日
 * File Name: PersonsOprationImpl.java
 * CopyRright (c) 2016: 
 * File No. 
 * Project Name: Labber
 * @version
 */

package team.labber.beans;

import team.labber.dao.PersonsDAO;
import team.labber.interfaces.PersonsOperation;

/**
 * @ClassName PersonsOprationImpl
 * @Description TODO
 * @author TODO
 * @version 1.0 Build 0000, 2017年3月5日 下午3:32:03, TODO,
 */

public class PersonsOprationImpl implements PersonsOperation {
	private PersonsDAO personsDAO = new PersonsDAO();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * team.labber.interfaces.PersonsOperation#getIdentity(java.lang.String)
	 */
	@Override
	public String getIdentity(String DocID) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see team.labber.interfaces.PersonsOperation#getRole(java.lang.String)
	 */
	@Override
	public String getRole(String DocID) {
		// TODO Auto-generated method stub
		return null;
	}

}
