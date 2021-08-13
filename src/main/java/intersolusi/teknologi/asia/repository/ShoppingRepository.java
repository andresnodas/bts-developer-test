package intersolusi.teknologi.asia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import intersolusi.teknologi.asia.entity.Shopping;

@Repository
public interface ShoppingRepository extends JpaRepository<Shopping, Long> {

}
