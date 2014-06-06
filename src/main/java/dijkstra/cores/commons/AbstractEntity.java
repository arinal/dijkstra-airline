package dijkstra.cores.commons;

import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity implements EntityObject {	
	private long id;
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return id;
	}

	@Override
	public void setId(long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);	
	}

	@Override
	public boolean equals(Object other) {
		if (other.getClass() == getClass()) {
			AbstractEntity otherEntity = (AbstractEntity)other;
			return Objects.equals(getId(), otherEntity.getId());			
		}
		return false;
	}	
}
