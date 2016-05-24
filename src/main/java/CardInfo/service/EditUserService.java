package CardInfo.service;

import CardInfo.model.dao.CardInfoDAO;
import CardInfo.model.dao.SscardInfoDAO;

public class EditUserService {
	public boolean editCardUser(Integer id, String userName, Byte idType, String cardNum, String idNum, String telephone, Byte cardStatus, Byte cardCondition) throws Exception {
		return new CardInfoDAO().update(id, userName, idType, cardNum, idNum, telephone, cardStatus, cardCondition);
	}
	public boolean editSscardUser(Integer id, String userName, String idNum, String sscardNum, Byte sscardCondition) throws Exception {
		return new SscardInfoDAO().update(id, idNum, sscardNum, userName, sscardCondition);
	}
}
