package CardInfo.model.entity;
// Generated 2016-4-19 12:40:33 by Hibernate Tools 3.4.0.CR1

/**
 * CardInfo generated by hbm2java
 */
public class CardInfo implements java.io.Serializable {

	private static final long serialVersionUID = 778155021538034164L;
	private Integer id;
	private String userName;
	private Byte idType;
	private String cardNum;
	private String idNum;
	private String telephone;
	private Byte cardStatus;
	private Byte cardCondition;

	public CardInfo() {
	}
	
	public CardInfo(Integer id, String userName, Byte idType, String cardNum, String idNum, String telephone, Byte cardStatus, Byte cardCondition) {
		this.id = id;
		this.userName = userName;
		this.idType = idType;
		this.cardNum = cardNum;
		this.idNum = idNum;
		this.telephone = telephone;
		this.cardStatus = cardStatus;
		this.cardCondition = cardCondition;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Byte getIdType() {
		return this.idType;
	}

	public void setIdType(Byte idType) {
		this.idType = idType;
	}

	public String getCardNum() {
		return this.cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getIdNum() {
		return this.idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Byte getCardStatus() {
		return this.cardStatus;
	}

	public void setCardStatus(Byte cardStatus) {
		this.cardStatus = cardStatus;
	}

	public Byte getCardCondition() {
		return cardCondition;
	}

	public void setCardCondition(Byte cardCondition) {
		this.cardCondition = cardCondition;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
