/**  
 * @Title Visit.java
 * @Package team.labber.beans
 * @author TODO
 * 2017��3��5��
 * File Name: Visit.java
 * CopyRright (c) 2016: 
 * File No. 
 * Project Name: Labber
 * @version
 */

package team.labber.interfaces;

import java.util.List;

import javax.transaction.Transactional;

import team.labber.entities.Persons;
import team.labber.entities.Visitors;

/**
 * @ClassName Visit
 * @Description TODO
 * @author TODO
 * @version 1.0 Build 0000, 2017��3��5�� ����3:12:09, TODO,
 */

public interface VisitorsOperation {
	@Transactional
	public void doVisit(Persons persons);

	public List<Persons> getPersonsByVisitDocID(String docID);

	public boolean isFirstVisit(String visitorsDocID);

	public Visitors hasVisitedInOneDay(Persons persons);

	@Transactional
	public void addComments(Visitors visitor, String comments, int score);

}
