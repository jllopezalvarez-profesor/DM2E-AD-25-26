package es.jllopezalvarez.examenpractica.repositories;

import es.jllopezalvarez.examenpractica.entities.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends ListCrudRepository<Project, Integer> {
    List<Project> findAllByExpectedIncomeGreaterThanEqualOrderByProjectId(Double expectedIncomeIsGreaterThan);

    @Query(value = "from Project p where p.expectedIncome >= :expectedIncome select p")
    List<Project> findProjectParte2Jpql(Double expectedIncome);

    @Query(value = "select * from project where expected_income >= :expectedIncome", nativeQuery = true)
    List<Project> findProjectParte2Sql(Double expectedIncome);

    Page<Project> findAllByExpectedIncomeGreaterThanEqualOrderByProjectId(Double expectedIncomeIsGreaterThan, Pageable pageInfo);


}
