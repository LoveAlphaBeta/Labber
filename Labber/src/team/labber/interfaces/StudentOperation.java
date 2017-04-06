/**  
 * @Title StudentOperation.java
 * @Package team.labber.interfaces
 * @author TODO
 * 2017��3��5��
 * File Name: StudentOperation.java
 * CopyRright (c) 2016: 
 * File No. 
 * Project Name: Labber
 * @version
 */

package team.labber.interfaces;

import javax.transaction.Transactional;

/**
 * @ClassName StudentOperation
 * @Description TODO
 * @author TODO
 * @version 1.0 Build 0000, 2017��3��5�� ����9:14:26, TODO,
 */

public interface StudentOperation {
	@Transactional
	public void saveStudent(String vName, String vMajor, String vCID,
			String vDocID, String vGender, String currentRole);
}
