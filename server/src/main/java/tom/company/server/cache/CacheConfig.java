package tom.company.server.cache;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Objects;


@Configuration
@RequiredArgsConstructor
@Slf4j
public class CacheConfig {

    Logger logger = LoggerFactory.getLogger(CacheConfig.class);

    private final CacheManager cacheManager;

    public void evictAllCaches() {
        cacheManager.getCacheNames()
                    .forEach(cacheName -> Objects.requireNonNull(cacheManager.getCache(cacheName))
                                                 .clear());
    }

    @Scheduled(fixedRate = 3600 * 3 * 1000)
    public void evictAllcachesAtIntervals() {
        logger.info("refreshing cache");
        evictAllCaches();
    }
}
