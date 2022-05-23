package academy.pocu.comp2500.lab4;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;

public class MemoryCache {
    private static Map<String, MemoryCache> instanceMap = new HashMap<>();
    private static int maxInstanceCount = Integer.MAX_VALUE;
    private EvictionPolicy evictionPolicy;
    private Map<String, Node> entries;
    private int maxEntryCount;
    private OffsetDateTime createdAt;
    private OffsetDateTime modifiedAt;

    private MemoryCache() {
        this.createdAt = OffsetDateTime.now();
        this.modifiedAt = this.createdAt;
        this.entries = new HashMap<>();
        this.maxEntryCount = Integer.MAX_VALUE;
        this.evictionPolicy = EvictionPolicy.LEAST_RECENTLY_USED;
    }

    static private void removeMemoryCacheInstance() {
        String candidateKey = "";
        OffsetDateTime candidateDate = OffsetDateTime.MAX;

        for (Map.Entry<String, MemoryCache> entry : MemoryCache.instanceMap.entrySet()) {
            if (entry.getValue().modifiedAt.compareTo(candidateDate) < 0) {
                candidateDate = entry.getValue().modifiedAt;
                candidateKey = entry.getKey();
            }
        }

        MemoryCache.instanceMap.remove(candidateKey);
    }

    public static MemoryCache getInstance(String instanceKey) {
        if (instanceMap.containsKey(instanceKey)) {
            MemoryCache memoryCache = MemoryCache.instanceMap.get(instanceKey);
            memoryCache.modifiedAt = OffsetDateTime.now();
            return memoryCache;
        }

        MemoryCache memoryCache = new MemoryCache();
        if (MemoryCache.instanceMap.size() >= maxInstanceCount) {
            MemoryCache.removeMemoryCacheInstance();
        }
        MemoryCache.instanceMap.put(instanceKey, memoryCache);
        return memoryCache;
    }

    public static void clear() {
        MemoryCache.instanceMap.clear();
    }

    public static void setMaxInstanceCount(int maxInstanceCount) {
        int countDifference = MemoryCache.instanceMap.size() - maxInstanceCount;

        while (countDifference > 0) {
            MemoryCache.removeMemoryCacheInstance();
            countDifference--;
        }

        MemoryCache.maxInstanceCount = maxInstanceCount;
    }

    public void setEvictionPolicy(EvictionPolicy evictionPolicy) {
        this.evictionPolicy = evictionPolicy;
    }

    private void removeNodeLIFO() {
        String candidateKey = "";
        OffsetDateTime candidateDate = OffsetDateTime.MIN;

        for (Map.Entry<String, Node> entry : this.entries.entrySet()) {
            if (entry.getValue().getCreatedAt().compareTo(candidateDate) > 0) {
                candidateDate = entry.getValue().getCreatedAt();
                candidateKey = entry.getKey();
            }
        }

        this.entries.remove(candidateKey);
    }

    private void removeNodeFIFO() {
        String candidateKey = "";
        OffsetDateTime candidateDate = OffsetDateTime.MAX;

        for (Map.Entry<String, Node> entry : this.entries.entrySet()) {
            if (entry.getValue().getCreatedAt().compareTo(candidateDate) < 0) {
                candidateDate = entry.getValue().getCreatedAt();
                candidateKey = entry.getKey();
            }
        }

        this.entries.remove(candidateKey);
    }

    private void removeNodeLRU() {
        String candidateKey = "";
        OffsetDateTime candidateDate = OffsetDateTime.MAX;

        for (Map.Entry<String, Node> entry : this.entries.entrySet()) {
            if (entry.getValue().getModifiedAt().compareTo(candidateDate) < 0) {
                candidateDate = entry.getValue().getModifiedAt();
                candidateKey = entry.getKey();
            }
        }

        this.entries.remove(candidateKey);
    }

    private void removeNode() {
        switch (this.evictionPolicy) {
            case LAST_IN_FIRST_OUT:
                removeNodeLIFO();
                return;
            case FIRST_IN_FIRST_OUT:
                removeNodeFIFO();
                return;
            case LEAST_RECENTLY_USED:
            default:
                removeNodeLRU();
                return;
        }
    }

    public void addEntry(String key, String value) {
        if (this.entries.containsKey(key)) {
            Node node = this.entries.get(key);
            node.setValue(value);
            return;
        }

        if (this.entries.size() >= this.maxEntryCount) {
            removeNode();
        }


        this.entries.put(key, new Node(value));
    }

    public String getEntryOrNull(String key) {
        return this.entries.containsKey(key) ? this.entries.get(key).getValue() : null;
    }

    public void setMaxEntryCount(int maxEntryCount) {
        int countDifference = this.entries.size() - maxEntryCount;

        while (countDifference > 0) {
            removeNode();
            countDifference--;
        }

        this.maxEntryCount = maxEntryCount;
    }
}

