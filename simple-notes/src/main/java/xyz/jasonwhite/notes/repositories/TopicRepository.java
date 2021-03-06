package xyz.jasonwhite.notes.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import xyz.jasonwhite.notes.model.Category;
import xyz.jasonwhite.notes.model.Topic;

@Repository
public interface TopicRepository extends CrudRepository<Topic, Long> {
    
    @Override
    @Query("SELECT t FROM Topic t WHERE t.owner = ?#{ authentication.name } OR t.permission = 'PUBLIC'")
    Iterable<Topic> findAll();
    
    @Override
    @Query("SELECT t FROM Topic t WHERE t.id = :id AND (t.owner = ?#{ authentication.name } OR t.permission = 'PUBLIC')")
    Optional<Topic> findById(@Param("id") Long id);
    
    @Query(
        "SELECT DISTINCT t FROM Topic t " +
        "JOIN t.categories c " +
        "WHERE c IN :categories AND (t.owner = ?#{ authentication.name } OR t.permission = 'PUBLIC')")
    Iterable<Topic> findByCategoriesIn(@Param("categories") Iterable<Category> categories);

}
