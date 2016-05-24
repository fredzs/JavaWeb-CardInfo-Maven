package CardInfo.service;

import java.util.ArrayList;
import java.util.List;

import CardInfo.model.dao.CardInfoDAO;
import CardInfo.model.dao.SscardInfoDAO;
import CardInfo.model.dao.TAppUserInfoDAO;
import CardInfo.model.entity.CardInfo;
import CardInfo.model.entity.SscardInfo;
import CardInfo.model.result.BandingResult;
import CardInfo.model.result.SearchResult;
import CardInfo.util.Password;
import CardInfo.util.SearchConditionMap;

public class SearchUserService {
	private List<SearchResult> show_result_list = new ArrayList<SearchResult>();
	private List<CardInfo> resultCardInfo = new ArrayList<CardInfo>();
	private List<SscardInfo> resultSscardInfo = new ArrayList<SscardInfo>();
	private List<BandingResult> show_banding_list = new ArrayList<BandingResult>();
	
	public List<SearchResult> SearchUserInfoById(String env, String type, String id) throws Exception{
		if (type.equals("0")) {
			setShow_result_list(new TAppUserInfoDAO().findByCardNo(env, id)); 
		}
		else {
			setShow_result_list(new TAppUserInfoDAO().findBySscardNo(env,id)); 
		}
		return show_result_list;
	}
	
	public List<SearchResult> ShowUserInfoByRange(String env, Integer index, Integer offset) throws Exception{
		setShow_result_list(new TAppUserInfoDAO().findByRange(env, index, offset)); 
		return show_result_list;
	}
	
	// ����card_info���������ѯ�����ļ�¼����
	public Integer ShowCardAmountByCondition(String search_condition, List<String> searchList) throws Exception {
		return new CardInfoDAO().findAmountByConditionList(search_condition, searchList); 
	}
	// ����sscard_info���������ѯ�����ļ�¼����
	public Integer ShowSscardAmountByCondition(String search_condition, List<String> searchList) throws Exception {
		return new SscardInfoDAO().findAmountByConditionList(search_condition, searchList); 
	}
	
	// ����card_info���������ѯ���������м�¼
	public List<CardInfo> findCardByCondition(String search_condition, List<String> searchList, Integer index, Integer offset) throws Exception {
		setResultCardInfo(new CardInfoDAO().findByConditionList(search_condition, searchList, index, offset)); 
		return resultCardInfo;
	}
	// ����sscard_info���������ѯ���������м�¼
	public List<SscardInfo> findSscardByCondition(String search_condition, List<String> searchList, Integer index, Integer offset) throws Exception{
		setResultSscardInfo(new SscardInfoDAO().findByConditionList(search_condition, searchList, index, offset)); 
		return resultSscardInfo;
	}
	
	// ����card_info���������ѯ������¼��cardNum�б�
	public List<String> findCardNumListByCondition(String search_condition, List<String> searchList, Integer index, Integer offset) throws Exception {
		return new CardInfoDAO().findCardNumListByConditionList(search_condition, searchList, index, offset); 
	}
	// ����sscard_info���������ѯ������¼��cardNum�б�
	public List<String> findSscardNumListByCondition(String search_condition, List<String> searchList, Integer index, Integer offset) throws Exception{
		return new SscardInfoDAO().findSscardNumListByConditionList(search_condition, searchList, index, offset); 
	}
	
	// ����cardNumList��t_app_userinfo���в�ѯ���
	public List<BandingResult> findBandingResult(String searchCondition, String env, List<String> cardNumList, String cardType) throws Exception{
		if (cardType.equals("0")) {
			setShow_banding_list(new TAppUserInfoDAO().findBanding(env, cardNumList, SearchConditionMap.getCardConditon().get(searchCondition))); 
		}
		else {
			setShow_banding_list(new TAppUserInfoDAO().findBanding(env, cardNumList, SearchConditionMap.getSscardConditon().get(searchCondition))); 
		}
		return show_banding_list;
	}
	
	// ����ǰ��ҳ�����ʾ����ͨ������������ݿ��еõ�������MD5ֵ��д��ԭ����
	public void rewritePassword(List<BandingResult> list){
		Password.rewrite(list);
	}
		
	public Integer ShowUserAmount(String env) throws Exception{
		return new TAppUserInfoDAO().amount(env); 
	}
	
	
	/*-----------------------------------------------------------------------*/
	/*--------------------------getters and setters--------------------------*/
	/*-----------------------------------------------------------------------*/
	
	public List<SearchResult> getShow_result_list() {
		return show_result_list;
	}

	public void setShow_result_list(List<SearchResult> show_result_list) {
		this.show_result_list = show_result_list;
	}

	public List<CardInfo> getResultCardInfo() {
		return resultCardInfo;
	}

	public void setResultCardInfo(List<CardInfo> resultCardInfo) {
		this.resultCardInfo = resultCardInfo;
	}

	public List<SscardInfo> getResultSscardInfo() {
		return resultSscardInfo;
	}

	public void setResultSscardInfo(List<SscardInfo> resultSscardInfo) {
		this.resultSscardInfo = resultSscardInfo;
	}

	public List<BandingResult> getShow_banding_list() {
		return show_banding_list;
	}

	public void setShow_banding_list(List<BandingResult> show_banding_list) {
		this.show_banding_list = show_banding_list;
	}
	
}
