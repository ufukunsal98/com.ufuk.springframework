package com.ufuk.repository;

import com.ufuk.domain.Kisi;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author ufukremzi
 */
public interface KisiRepository extends ElasticsearchRepository<Kisi , String> {

    @Query("{\"bool\": {\"must\": [{\"match\": {\"ad\": \"?0\"}}]}}")
    List<Kisi> getCustomQuery(String name);
}
