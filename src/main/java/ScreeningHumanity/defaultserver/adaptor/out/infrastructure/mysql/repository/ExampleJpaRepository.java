package ScreeningHumanity.defaultserver.adaptor.out.infrastructure.mysql.repository;

import ScreeningHumanity.defaultserver.adaptor.out.infrastructure.mysql.entity.ExampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleJpaRepository extends JpaRepository<ExampleEntity, Long> {

}
