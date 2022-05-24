package academy.pocu.comp2500.lab4;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryCache {
    private static Map<String, MemoryCache> instanceMap = new HashMap<>();
    private static List<String> instanceList = new ArrayList<>();
    private static int maxInstanceCount = Integer.MAX_VALUE;
    private EvictionPolicy evictionPolicy;
    private int maxEntryCount;
    private List<String> entryListInTimeOrder;
    private List<String> entryListInUsedOrder;
    private Map<String, String> entryMap;

    private MemoryCache() {
        this.maxEntryCount = Integer.MAX_VALUE;
        this.evictionPolicy = EvictionPolicy.LEAST_RECENTLY_USED;
        this.entryListInTimeOrder = new ArrayList<>();
        this.entryListInUsedOrder = new ArrayList<>();
        this.entryMap = new HashMap<>();
    }

    static private void moveToRecent(final String key) {
        instanceList.remove(key);
        instanceList.add(0, key);
    }

    static private void addInstance(final String key, final MemoryCache memoryCache) {
        instanceMap.put(key, memoryCache);
        instanceList.add(0, key);
        MemoryCache.removeInstanceTillValidCount();
    }

    static private void removeInstance() {
        final int lastIndex = instanceList.size() - 1;

        String key = instanceList.get(lastIndex);
        instanceList.remove(lastIndex);
        instanceMap.remove(key);
    }

    static private void removeInstanceTillValidCount() {
        while (MemoryCache.instanceMap.size() > MemoryCache.maxInstanceCount) {
            MemoryCache.removeInstance();
        }
    }

    static public MemoryCache getInstance(final String key) {
        if (instanceMap.containsKey(key)) {
            moveToRecent(key);
            return MemoryCache.instanceMap.get(key);
        }

        final MemoryCache memoryCache = new MemoryCache();
        MemoryCache.addInstance(key, memoryCache);

        return memoryCache;
    }

    static public void clear() {
        MemoryCache.instanceList.clear();
        MemoryCache.instanceMap.clear();
    }

    static public void setMaxInstanceCount(final int maxInstanceCount) {
        MemoryCache.maxInstanceCount = maxInstanceCount;
        removeInstanceTillValidCount();
    }

    public void setEvictionPolicy(final EvictionPolicy evictionPolicy) {
        this.evictionPolicy = evictionPolicy;
    }

    private void removeEntry() {
        String target;
        switch (this.evictionPolicy) {
            case FIRST_IN_FIRST_OUT:
                target = this.entryListInTimeOrder.get(0);
                break;
            case LAST_IN_FIRST_OUT:
                target = this.entryListInTimeOrder.get(this.entryListInTimeOrder.size() - 1);
                break;
            case LEAST_RECENTLY_USED:
            default:
                target = this.entryListInUsedOrder.get(this.entryListInUsedOrder.size() - 1);
                break;
        }
        this.entryListInUsedOrder.remove(target);
        this.entryListInTimeOrder.remove(target);
        this.entryMap.remove(target);
    }

    private void removeEntryTillValidCount() {
        while (this.entryMap.size() > this.maxEntryCount) {
            removeEntry();
        }
    }

    private void moveEntryToRecent(final String key) {
        this.entryListInUsedOrder.remove(key);
        this.entryListInUsedOrder.add(0, key);
    }

    public void addEntry(final String key, final String value) {
        if (this.entryMap.containsKey(key)) {
            moveEntryToRecent(key);
            this.entryMap.put(key, value);
            return;
        }

        this.entryMap.put(key, value);
        this.removeEntryTillValidCount();
        this.entryListInUsedOrder.add(0, key);
        this.entryListInTimeOrder.add(key);
    }

    public String getEntryOrNull(final String key) {
        if (this.entryMap.containsKey(key)) {
            this.moveEntryToRecent(key);
        }

        return this.entryMap.get(key);
    }

    public void setMaxEntryCount(final int maxEntryCount) {
        this.maxEntryCount = maxEntryCount;
        removeEntryTillValidCount();
    }
}

