package fachklassen;

public class Spieler {
	private Long account_id;
	private String nickname;
	private String client_language;
	private Long last_battle_time;
	private Long created_at;
	private Long updated_at;
	//private //TODO
	private Short global_rating;
	private Long clan_id;
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
	
	public String getClient_language() {
		if(client_language == null) {
			client_language = "";
		}
		return client_language;
	}
	public void setClient_language(String client_language) {
		this.client_language = client_language;
	}
	public Long getLast_battle_time() {
		return last_battle_time;
	}
	public void setLast_battle_time(Long last_battle_time) {
		this.last_battle_time = last_battle_time;
	}
	public Long getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Long created_at) {
		this.created_at = created_at;
	}
	public Long getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Long updated_at) {
		this.updated_at = updated_at;
	}
	public Short getGlobal_rating() {
		return global_rating;
	}
	public void setGlobal_rating(Short global_rating) {
		this.global_rating = global_rating;
	}
	public Long getClan_id() {
		return clan_id;
	}
	public void setClan_id(Long clan_id) {
		this.clan_id = clan_id;
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
