package net.jco.sentinelx.aspects_aspectj.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "stlx_cache_entry")
public class CacheEntry implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_cache_entry")
    @SequenceGenerator(name = "seq_cache_entry", sequenceName = "seq_cache_entry", initialValue = 1, allocationSize = 1)
    @Column(name = "cache_entry_id")
    private Long id;

    @Column(name = "cache_name")
    private String cacheName;

    @Column(name = "key")
    private String key;

    @Column(name = "value_type")
    private String valueType;

    @Column(name = "value_json")
    private String valueJson;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "expires_at")
    private LocalDateTime expiresAt;

    @Column(name = "last_access_at")
    private LocalDateTime lastAccessAt;

    @Column(name = "hit_count")
    private Long hitCount;

    @Column(name = "cached_null")
    private Boolean cachedNull;

}
