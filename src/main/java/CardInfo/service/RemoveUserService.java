package CardInfo.service;

import CardInfo.model.dao.CardInfoDAO;
import CardInfo.model.dao.SscardInfoDAO;

public class RemoveUserService {
	public boolean removeCardUser(Integer id) throws Exception {
		return new CardInfoDAO().remove(id);
	}
	public boolean removeSscardUser(Integer id) throws Exception {
		return new SscardInfoDAO().remove(id);
	}
}
