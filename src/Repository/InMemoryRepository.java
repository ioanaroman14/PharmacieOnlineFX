package Repository;

import Domain.Entity;
import Domain.IValidator;
import UI.CustomException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryRepository<T extends Entity> implements IRepository<T> {

    private Map<String, T> storage = new HashMap<>();
    private IValidator<T> validator;

    public InMemoryRepository (IValidator<T> validator){
        this.validator =validator;
    }
    public T findById(String id){
        return storage.get(id);
    }

    /**
     * Adds or updates a entity if it already exists.
     * @param entity the entity to add or update.
     */

    public void upsert(T entity){
        validator.validate(entity);
        storage.put(entity.getId(), entity);
    }

    /**
     * Removes a entity with a given id.
     * @param id the id.
     * @throws RuntimeException if there is no entity with the given id.
     */

    public void remove(String id){
        if(!storage.containsKey(id)){
            //throw new InMemoryRepositoryExcwption("There is no entity with the given id to remove.");
            try {
                throw new CExceptionInMemoryRepository("There is no entity with the given id to remove");
            } catch (CExceptionInMemoryRepository e) {
                e.printStackTrace();
            }
        }
        storage.remove(id);
    }
    public List<T> getAll(){
        return new ArrayList<>(storage.values());
    }
}
