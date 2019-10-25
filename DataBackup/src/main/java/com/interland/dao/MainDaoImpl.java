package com.interland.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.interland.entities.Backup;
import com.interland.entities.Main;

@Repository
@Transactional
public class MainDaoImpl implements MainDao {

	@Autowired
	EntityManager em;

	@Override
	public List<Main> findRecordsByDate(int offset, int limit) {
		try {
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Main> cq = cb.createQuery(Main.class);
			Root<Main> record = cq.from(Main.class);
			List<Predicate> predicates = new ArrayList<>();

			//Calculate the date before 2 months from current date.
			LocalDate pastDate = LocalDate.now().minusMonths(2);

			predicates.add(cb.lessThan(record.get("date"), pastDate));
			cq.where(predicates.toArray(new Predicate[0]));
			
			return em.createQuery(cq).setFirstResult(offset).setMaxResults(limit).getResultList();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Long getCountRecordsByDate() {
		try {
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Long> cq = cb.createQuery(Long.class);
			Root<Main> record = cq.from(Main.class);
			List<Predicate> predicates = new ArrayList<>();

			//Calculate the date before 2 months from current date.
			LocalDate pastDate = LocalDate.now().minusMonths(2);

			predicates.add(cb.lessThan(record.get("date"), pastDate));
			cq.where(predicates.toArray(new Predicate[0]));
			cq.select(cb.count(record)); //count the records.
			
			return em.createQuery(cq).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (long) 0;
	}

	@Override
	public Integer insert(Backup main) {
		em.persist(main);
		return main.getId();
	}

	@Override
	public void delete(Main main) {
		em.remove(em.contains(main) ? main : em.merge(main));
	}

	@Override
	public Integer insert(Main main) {
		em.persist(main);
		return main.getId();
	}

}
