package ch.sjost.jsobra.matliste.repositories;

import ch.sjost.jsobra.matliste.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<Material, Long> {

}
