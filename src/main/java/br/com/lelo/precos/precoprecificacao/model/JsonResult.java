package br.com.lelo.precos.precoprecificacao.model;

public class JsonResult {

	private String id;
	private boolean ok;
	private String rev;

	public String getRev() {
		return rev;
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public void setRev(String rev) {
		this.rev = rev;
	}

	public final String getId() {
		return id;
	}

	public final void setId(String id) {
		this.id = id;
	}

}
