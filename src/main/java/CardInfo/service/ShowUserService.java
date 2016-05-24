package CardInfo.service;

import java.util.ArrayList;
import java.util.List;
import CardInfo.model.dao.CardInfoDAO;
import CardInfo.model.dao.SscardInfoDAO;
import CardInfo.model.dao.TAppUserInfoDAO;
import CardInfo.model.entity.CardInfo;
import CardInfo.model.entity.SscardInfo;
import CardInfo.model.result.BandingResult;
import CardInfo.util.Password;

public class ShowUserService {
	private List<CardInfo> resultCardInfo = new ArrayList<CardInfo>();
	private List<SscardInfo> resultSscardInfo = new ArrayList<SscardInfo>();
	private List<BandingResult> show_result_list = new ArrayList<BandingResult>();
	
	public List<CardInfo> ShowCardByRange(Integer index, Integer offset) throws Exception{
		setResultCardInfo(new CardInfoDAO().findByRange(index, offset)); 
		return resultCardInfo;
	}
	
	public void rewritePassword(List<BandingResult> list){
		Password.rewrite(list);
	}
	
	public List<BandingResult> ShowBandingResult(String env, List<String> cardNoList, String cardType){
		try {
			if (cardType.equals("0")) {
				setShow_result_list(new TAppUserInfoDAO().findBanding(env, cardNoList, "cardno"));
			}
			else {
				setShow_result_list(new TAppUserInfoDAO().findBanding(env,cardNoList, "sscardno")); 
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return show_result_list;
	}
	
	public List<String> ShowCardNoByRange(Integer index, Integer offset) throws Exception{
		return new CardInfoDAO().findCardNumList(index, offset);
	}
	
	public List<String> ShowSscardNoByRange(Integer index, Integer offset) throws Exception{
		return new SscardInfoDAO().findSscardNumByRange(index, offset); 
	}
	
	public Integer ShowCardAmount() throws Exception{
		return new CardInfoDAO().findAmount(); 
	}
	
	public List<SscardInfo> ShowSscardByRange(Integer index, Integer offset) throws Exception{
		setResultSscardInfo(new SscardInfoDAO().findByRange(index, offset)); 
		return resultSscardInfo;
	}
	
	public Integer ShowSscardAmount() throws Exception{
		return new SscardInfoDAO().findAmount(); 
	}
	
	/*-----------------------------------------------------------------------*/
	/*--------------------------getters and setters--------------------------*/
	/*-----------------------------------------------------------------------*/
	
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

	public List<BandingResult> getShow_result_list() {
		return show_result_list;
	}

	public void setShow_result_list(List<BandingResult> show_result_list) {
		this.show_result_list = show_result_list;
	}
}
