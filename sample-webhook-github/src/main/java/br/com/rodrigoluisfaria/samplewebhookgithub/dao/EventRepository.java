package br.com.rodrigoluisfaria.samplewebhookgithub.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rodrigoluisfaria.samplewebhookgithub.po.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
	
	List<Event> findByNumber(Long number);
	
}
