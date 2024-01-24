package kg.aiylbank.aiylbanktask.repository;

import kg.aiylbank.aiylbanktask.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}