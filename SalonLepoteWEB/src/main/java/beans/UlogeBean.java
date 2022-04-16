package beans;

import java.util.List;

import managers.UlogaManager;
import model.Uloga;

public class UlogeBean {

	private List<Uloga> u;
	
	public UlogeBean() {
		UlogaManager um = new UlogaManager();
		u = um.getSveUloge();
	}

	public List<Uloga> getU() {
		return u;
	}

	public void setU(List<Uloga> u) {
		this.u = u;
	}
	
	
}
