package CardInfo.service;

import CardInfo.model.dao.CardInfoDAO;
import CardInfo.model.dao.SscardInfoDAO;
import CardInfo.model.entity.CardInfo;
import CardInfo.model.entity.SscardInfo;

public class GetOldUserService {
	private CardInfo resultCardInfo = new CardInfo();
	private SscardInfo resultSscardInfo = new SscardInfo();
	
	public CardInfo GetOldCard(Integer id) throws Exception{
		setResultCardInfo(new CardInfoDAO().findById(id)); 
		return resultCardInfo;
	}

	public SscardInfo GetOldSscard(Integer id) throws Exception{
		setResultSscardInfo(new SscardInfoDAO().findById(id)); 
		return resultSscardInfo;
	}

	public CardInfo getResultCardInfo() {
		return resultCardInfo;
	}

	public void setResultCardInfo(CardInfo resultCardInfo) {
		this.resultCardInfo = resultCardInfo;
	}

	public SscardInfo getResultSscardInfo() {
		return resultSscardInfo;
	}

	public void setResultSscardInfo(SscardInfo resultSscardInfo) {
		this.resultSscardInfo = resultSscardInfo;
	}
	
}
