package telran.spring.data.model;

import java.util.Objects;

public class Mark {

	public long stid;
	public long suid;
	public int mark;
	
	public Mark(long stid, long suid, int mark) {
		this.stid = stid;
		this.suid = suid;
		this.mark = mark;
	}
	public Mark() {
		
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(mark, stid, suid);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mark other = (Mark) obj;
		return mark == other.mark && stid == other.stid && suid == other.suid;
	}
	
}
