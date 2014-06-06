package dijkstra.infras.data.inmemory;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import dijkstra.cores.commons.EntityObject;
import dijkstra.cores.commons.Repository;

public abstract class InMemoryRepositoryBase<T extends EntityObject> 
	implements Repository<T>, Iterable<T> {
		
	protected abstract ArrayList<T> getData();

	public Iterator<T> iterator() {
		return getData().iterator();
	}

	@Override
	public long count() {
		return getData().size();
	}

	@Override
	public T findOne(Long id) {
		for (T entity : this)
			if ( entity.getId() == id )
				return entity;
		return null;
	}

	@Override
	public Iterable<T> findAll() {
		return getData();
	}

	@Override
	public <S extends T> S save(S entity) {		
		getData().add(entity);
		entity.setId(count());
		return entity;
	}

	@Override
	public void delete(T entity) {
		getData().remove(entity);		
	}
	
	@Override
	public <S extends T> Iterable<S> save(Iterable<S> entities) {
		for (S item : entities)
			save(item);
		return entities;
	}

	@Override
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<T> findAll(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends T> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub		
	}
	
	@Override
	public Iterable<T> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<T> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	@Override
//	public long count(String key) {
//		return search(key, null).getTotalElements();
//	}
	
	public abstract Page<T> search(String key, Pageable page);		
}
