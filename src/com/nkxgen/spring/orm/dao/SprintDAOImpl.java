package com.nkxgen.spring.orm.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.nkxgen.spring.orm.model.Sprint;
import com.nkxgen.spring.orm.model.SprintDto;
import com.nkxgen.spring.orm.model.Sprints;

@Component
public class SprintDAOImpl implements SprintDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Sprints getSprintById(int sprintId) {
        return entityManager.find(Sprints.class, sprintId);
    }

    @Override
    public List<Sprints> getAllSprints() {
        String jpql = "SELECT s FROM Sprint s";
        Query query = entityManager.createQuery(jpql);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void createSprint(Sprints sprint) {
        entityManager.persist(sprint);
    }

    @Override
    @Transactional
    public void updateSprint(Sprints sprint) {
        entityManager.merge(sprint);
    }

    @Override
    @Transactional
    public void deleteSprint(int sprintId) {
        Sprints sprint = entityManager.find(Sprints.class, sprintId);
        if (sprint != null) {
            entityManager.remove(sprint);
        }
    }

    
    
    @Override
  	public List<SprintDto> getSprintbyprojectId(Integer projectId) {
  		short getProjectId = projectId.shortValue();
  		TypedQuery<Sprint> query = entityManager
  				.createQuery("SELECT s FROM Sprint s WHERE s.project.projectId = :proj_id", Sprint.class);
  		query.setParameter("proj_id", getProjectId);
  		List<Sprint> sprints = query.getResultList();

  		List<SprintDto> sprintDTOList = new ArrayList<>();

  		for (Sprint sprint : sprints) {
  			SprintDto Sprintdto = SprintDto.fromEntity(sprint);
  			sprintDTOList.add(Sprintdto);
  		}

  		return sprintDTOList;
  	}
}
 