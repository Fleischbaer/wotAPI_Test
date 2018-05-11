package fachklassen;

public class Spieler {
	private Long account_id;
	private String nickname;
	public Long getAccount_id() {
		if(account_id == null) {
			account_id = Long.valueOf("-1");
		}
		return account_id;
	}
	public void setAccount_id(Long account_id) {
		this.account_id = account_id;
	}
	public String getNickname() {
		if(nickname == null) {
			nickname = "";
		}
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Spieler 
				&& ((Spieler)obj).getAccount_id()==getAccount_id()) {
			return true;
		} else {
			return false;
		}
	}
	
}
