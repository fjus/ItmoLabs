package managers;

import classModel.Organization;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Класс CollectionManager. Отвечает за хранение данных коллекции и работу с ней.
 * @author DenisLukash
 */
public class CollectionManager {
    private long currentId = 1;
    private Map<Long, Organization> organizations = new HashMap<>();
    private Stack<Organization> collection = new Stack<>();
    private LocalDateTime lastInitTime;
    private final DumpManager dumpManager;

    public CollectionManager(DumpManager dumpManager) {
        this.lastInitTime = null;
        this.dumpManager = dumpManager;
    }

    public LocalDateTime getLastInitTime() {
        return lastInitTime;
    }

    public Stack<Organization> getCollection() {
        return collection;
    }

    public void setCollection(Stack<Organization> collection) {
        this.collection = collection;
    }

    public Map<Long, Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(Map<Long, Organization> organizations) {
        this.organizations = organizations;
    }

    /**
     * Возвращает организацию по Id.
     */
    public Organization byId(long id) { return organizations.get(id); }

    public boolean isСontain(Organization o) {
        return o == null || byId(o.getId()) != null;
    }

    /**
     * Получает свободный Id.
     */
    public long getFreeId() {
        while (byId(++currentId) != null);
        return currentId;
    }

    /**
     * Добавляет организацию в коллекцию.
     */
    public boolean add(Organization o) {
        if (isСontain(o)) return false;
        organizations.put(o.getId(), o);
        collection.add(o);
        update();
        return true;
    }


    /**
     * Получает свободный Id.
     */
    public boolean remove(long id) {
        var a = byId(id);
        if (a == null) return false;
        organizations.remove(id);
        collection.remove(a);
        update();
        return true;
    }

    /**
     * Сортирует кооллекцию.
     */
    public void update() {
        Collections.sort(collection);
    }

    /**
     * Переворачивает кооллекцию.
     */
    public void updateInRightOrder() {
        Collections.reverse(collection);
    }

    /**
     * Инициализирует коллекцию.
     */
    public boolean init() {
        collection.clear();
        organizations.clear();
        dumpManager.readCollection(collection);
        lastInitTime = LocalDateTime.now();
        for (var e : collection)
            if (byId(e.getId()) != null) {
                collection.clear();
                organizations.clear();
                return false;
            } else {
                if (e.getId()>currentId) currentId = e.getId();
                organizations.put(e.getId(), e);
            }
        update();
        return true;
    }

    public void saveCollection() {
        dumpManager.writeCollection(collection);
    }

    @Override
    public String toString() {
        if (collection.isEmpty()) return "Коллекция пуста!";

        StringBuilder info = new StringBuilder();
        for (var organization : collection) {
            info.append(organization+"\n\n");
        }
        return info.toString().trim();
    }
}
