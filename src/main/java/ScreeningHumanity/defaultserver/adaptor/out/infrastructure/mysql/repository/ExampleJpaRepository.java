package ScreeningHumanity.defaultserver.adaptor.out.infrastructure.mysql.repository;

import ScreeningHumanity.defaultserver.adaptor.out.infrastructure.mysql.entity.ExampleEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleJpaRepository extends JpaRepository<ExampleEntity, Long> {

    Optional<ExampleEntity> findByEmail(String email);
}
