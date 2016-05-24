package CardInfo.service;

import CardInfo.model.dao.CardInfoDAO;
import CardInfo.model.dao.SscardInfoDAO;

public class AddUserService {
	public boolean addCardUser(String userName, Byte idType, String cardNum, String idNum, String telephone, Byte cardStatus, Byte cardCondition) throws Exception {
		return new CardInfoDAO().add(userName, idType, cardNum, idNum, telephone, cardStatus, cardCondition);
	}
	public boolean addSscardUser(String userName, String idNum, String sscardNum, Byte sscardCondition) throws Exception {
		return new SscardInfoDAO().add(userName, idNum, sscardNum, sscardCondition);
	}
}
