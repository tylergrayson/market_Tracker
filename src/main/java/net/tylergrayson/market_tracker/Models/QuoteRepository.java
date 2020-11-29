package net.tylergrayson.market_tracker.Models;

import org.springframework.data.repository.CrudRepository;

public interface QuoteRepository extends CrudRepository <Quote, String> {
}
