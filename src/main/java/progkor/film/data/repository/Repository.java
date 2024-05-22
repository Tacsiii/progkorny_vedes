package progkor.film.data.repository;

import java.util.List;

/**
 * Generic repository interface for CRUD operations.
 *
 * @param <T> the type of the entity
 * @param <I> the type of the entity's identifier
 */
public interface Repository<T, I> {

    /**
     * Saves an entity.
     *
     * @param item the entity to save
     * @return the saved entity
     */
    T save(T item);

    /**
     * Retrieves an entity by its ID.
     *
     * @param id the ID of the entity to retrieve
     * @return the entity with the specified ID, or null if no entity is found
     */
    T getById(I id);

    /**
     * Retrieves all entities.
     *
     * @return a list of all entities
     */
    List<T> getAll();

    /**
     * Updates an entity.
     *
     * @param item the entity to update
     * @return the updated entity
     */
    T update(T item);

    /**
     * Deletes an entity by its ID.
     *
     * @param id the ID of the entity to delete
     */
    void deleteById(I id);
}
