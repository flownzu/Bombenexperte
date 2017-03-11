public class KomplizierteKabel {
	boolean serial;
	boolean port;
	boolean batteries;
	
	public KomplizierteKabel(boolean _s, boolean _p, boolean _b){
		this.serial = _s;
		this.port = _p;
		this.batteries = _b;
	}
	
	public boolean cutCable(boolean _r, boolean _b, boolean _w, boolean _l, boolean _s){
		if(_r){
			if(_b){
				if(_l){
					if(_s){
						return false;
					}
					else{
						return this.serial;
					}
				}
				else{
					if(_s){
						return this.port;
					}
					else{
						return this.serial;
					}
				}
			}
			else{
				if(_l){
					if(_s){
						return this.batteries;
					}
					else{
						return this.batteries;
					}
				}
				else{
					if(_s){
						return true;
					}
					else{
						return this.serial;
					}
				}
			}
		}
		if(_b){
			if(_l){
				if(_s){
					return this.port;
				}
				else{
					return this.port;
				}
			}
			else{
				if(_s){
					return false;
				}
				else{
					return this.serial;
				}
			}
		}
		if(_w){
			if(_l){
				if(_s){
					return this.batteries;
				}
				else{
					return false;
				}
			}
			else{
				if(_s){
					return true;
				}
				else{
					return true;
				}
			}
		}
		System.out.println("nix gefunden");
		return false;
	}
}