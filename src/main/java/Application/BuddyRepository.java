package Application;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;


public interface BuddyRepository extends CrudRepository<BuddyInfo, Long> {

    Collection<BuddyInfo> findByName(String name);

    BuddyInfo findById(long id);

}