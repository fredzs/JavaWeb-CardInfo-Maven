package CardInfo.model.dao;
// Generated 2016-4-19 12:40:33 by Hibernate Tools 3.4.0.CR1

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.StringType;

import CardInfo.model.entity.SscardInfo;
import CardInfo.util.HibernateUtil;

/**
 * Home object for domain model class SscardInfo.
 * @see com.model.entity.SscardInfo
 * @author Hibernate Tools
 */
public class SscardInfoDAO {
	HibernateUtil util = new HibernateUtil();
	Long startTime, endTime;
	private static Logger logger = Logger.getLogger(SscardInfoDAO.class);
	/*--------------------------CURD--------------------------*/
	public boolean add(String userName, String idNum, String sscardNum, Byte sscardCondition) throws Exception {
		HibernateUtil.init("");
		Session session = util.getSession();  
		boolean bool = false;
        try {  
        	SscardInfo sscardInfo = new SscardInfo(1,idNum, sscardNum, userName, sscardCondition);
        	Transaction tran = session.beginTransaction();//��ʼ����  
            session.save(sscardInfo);//ִ��  
            tran.commit();//�ύ  
            bool = true;
            return bool;
        } catch (Exception e) {  
            logger.error("SscardInfoDAO.add()���������쳣:");  
            e.printStackTrace();  
            throw e; // �쳣
        } finally {  
            util.closeSession(session);  
        }  
	}
	public boolean remove(Integer id) throws Exception {
		HibernateUtil.init("");
		Session session = util.getSession();  
		boolean bool = false;
        try {  
        	SscardInfo instance = session.get(SscardInfo.class, id);
        	Transaction tran = session.beginTransaction();//��ʼ���� 
            session.delete(instance);//ִ��  
            tran.commit();//�ύ  
            bool = true;
            return bool;
        } catch (Exception e) {  
            logger.error("SscardInfo.remove()���������쳣:");  
            e.printStackTrace();  
            throw e; // �쳣
        } finally {  
            util.closeSession(session);  
        }  
	}
	public boolean update(Integer id, String userName, String idNum, String sscardNum, Byte sscardCondition) throws Exception {
		HibernateUtil.init("");
		Session session = util.getSession();  
		boolean bool = false;
        try {  
        	SscardInfo sscardInfo = new SscardInfo(id ,userName, idNum, sscardNum, sscardCondition);
        	Transaction tran = session.beginTransaction();//��ʼ����  
            session.update(sscardInfo);//ִ��  
            tran.commit();//�ύ  
            bool = true;
            return bool;
        } catch (Exception e) {  
            logger.error("SscardInfo.update()���������쳣:");  
            e.printStackTrace();  
            throw e; // �쳣
        } finally {  
            util.closeSession(session);  
        }  
	}
	public SscardInfo findById(java.lang.Integer id) throws Exception {
		HibernateUtil.init("");
		Session session = util.getSession();  
		try {
			SscardInfo instance = session.get(SscardInfo.class, id);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		} finally {  
            util.closeSession(session);  
        }  
	}
	@SuppressWarnings("unchecked")
	public List<SscardInfo> findByRange(Integer index, Integer offset) throws Exception {
		HibernateUtil.init("");
		Session session = util.getSession();  
        try {  
        	String queryString = "SELECT * FROM sscard_info LIMIT " + index + "," + offset;
        	startTime = System.currentTimeMillis();
			@SuppressWarnings("rawtypes")
			List result = session.createSQLQuery(queryString).addEntity(SscardInfo.class).setCacheable(true).list();
			endTime = System.currentTimeMillis();
			logger.debug(queryString + "\n���ִ��ʱ��Ϊ:" + (endTime - startTime) + "���롣");  
            return result;
        } catch (Exception e) {  
            logger.error("SscardInfo.findByRange()���������쳣:");  
            e.printStackTrace();  
            throw e; // �쳣
        } finally {  
            util.closeSession(session);  
        }  
	}

	@SuppressWarnings("unchecked")
	public List<SscardInfo> findByConditionList(String searchCondition, List<String> searchList, Integer index, Integer offset) throws Exception {
		HibernateUtil.init("");
		Session session = util.getSession();  
        try {  
        	String queryString = "SELECT * FROM sscard_info where " + searchCondition +  " in ( " ;
        	int i = 0;
        	for (i = 0; i < searchList.size() - 1; i++) {
        		queryString += "'" + searchList.get(i) + "' , "; 
			}
        	queryString += "'" + searchList.get(i) + "' ) LIMIT " + index + "," + offset; 
        	startTime = System.currentTimeMillis();
			@SuppressWarnings("rawtypes")
			List result = session.createSQLQuery(queryString).addEntity(SscardInfo.class).setCacheable(true).list();
			endTime = System.currentTimeMillis();
			logger.debug(queryString + "\n���ִ��ʱ��Ϊ:" + (endTime - startTime) + "���롣");  
            return result;
        } catch (Exception e) {  
            logger.error("SscardInfo.findByCondition()���������쳣:");  
            e.printStackTrace();  
            throw e; // �쳣
        } finally {  
            util.closeSession(session);  
        }  
	}
	
	public Integer findAmount() throws Exception {
		HibernateUtil.init("");
		Session session = util.getSession();  
        try {  
        	String queryString = "SELECT COUNT(1) FROM sscard_info";
        	SQLQuery sqlQuery = session.createSQLQuery(queryString).addScalar("COUNT(1)", StringType.INSTANCE);
        	sqlQuery.setCacheable(true);
        	startTime = System.currentTimeMillis();
        	Integer amount = Integer.valueOf((String) sqlQuery.uniqueResult());
			endTime = System.currentTimeMillis();
			logger.debug(queryString + "\n���ִ��ʱ��Ϊ:" + (endTime - startTime) + "���롣");  
            return amount;
        } catch (Exception e) {  
            logger.error("SscardInfoDAO.amount()���������쳣:");  
            e.printStackTrace();  
            throw e; // �쳣
        } finally {  
            util.closeSession(session);  
        }  
	}
	
	public Integer findAmountByConditionList(String search_condition, List<String> searchList) throws Exception {
		HibernateUtil.init("");
		Session session = util.getSession();  
        try {  
        	String queryString = "SELECT COUNT(*) FROM sscard_info where " + search_condition +  " in ( " ;
        	int i = 0;
        	for (i = 0; i < searchList.size() - 1; i++) {
        		queryString += "'" + searchList.get(i) + "' , "; 
			}
        	queryString += "'" + searchList.get(i) + "' );";
        	SQLQuery sqlQuery = session.createSQLQuery(queryString).addScalar("COUNT(*)", StringType.INSTANCE);
        	sqlQuery.setCacheable(true);
        	startTime = System.currentTimeMillis();
        	Integer amount = Integer.valueOf((String) sqlQuery.uniqueResult());
			endTime = System.currentTimeMillis();
			logger.debug(queryString + "\n���ִ��ʱ��Ϊ:" + (endTime - startTime) + "���롣");  
            return amount;
        } catch (Exception e) {  
            logger.error("SscardInfoDAO.amountByCondition()���������쳣:");  
            e.printStackTrace();  
            throw e; // �쳣
        } finally {  
            util.closeSession(session);  
        }  
	}

	@SuppressWarnings("unchecked")
	public List<String> findSscardNumByRange(Integer index, Integer offset) throws Exception {
		HibernateUtil.init("");
		Session session = util.getSession();  
        try {  
        	String queryString = "select sscardNum from sscard_info LIMIT " + index + "," + offset;
        	startTime = System.currentTimeMillis();
			@SuppressWarnings("rawtypes")
			List result = session.createSQLQuery(queryString).addScalar("sscardNum", StringType.INSTANCE).setCacheable(true).list();
			endTime = System.currentTimeMillis();
			logger.debug(queryString + "\n���ִ��ʱ��Ϊ:" + (endTime - startTime) + "���롣");  
            return result;
        } catch (Exception e) {  
            logger.error("SscardInfoDAO.findSscardNoByRange()���������쳣:");  
            e.printStackTrace();  
            throw e; // �쳣
        } finally {  
            util.closeSession(session);  
        }  
	}
	
	@SuppressWarnings("unchecked")
	public List<String> findSscardNumListByConditionList(String searchCondition, List<String> searchList, Integer index, Integer offset) throws Exception {
		HibernateUtil.init("");
		Session session = util.getSession();  
        try {  
        	String queryString = "select sscardNum from sscard_info where " + searchCondition +  " in ( " ;
        	int i = 0;
        	for (i = 0; i < searchList.size() - 1; i++) {
        		queryString += "'" + searchList.get(i) + "' , "; 
			}
        	queryString += "'" + searchList.get(i) + "' )" + " LIMIT " + index + "," + offset; 
        	startTime = System.currentTimeMillis();
			@SuppressWarnings("rawtypes")
			List result = session.createSQLQuery(queryString).addScalar("sscardNum", StringType.INSTANCE).setCacheable(true).list();
			endTime = System.currentTimeMillis();
			logger.debug(queryString + "\n���ִ��ʱ��Ϊ:" + (endTime - startTime) + "���롣");  
            return result;
        } catch (Exception e) {  
            logger.error("SScardInfoDAO.findSscardNumListByCondition()���������쳣:");  
            e.printStackTrace();  
            throw e; // �쳣
        } finally {  
            util.closeSession(session);  
        }  
	}
}
