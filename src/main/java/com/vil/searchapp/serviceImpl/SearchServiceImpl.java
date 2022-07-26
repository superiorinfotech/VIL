package com.vil.searchapp.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.mongodb.client.MongoCollection;
import com.vil.searchapp.service.SearchService;

@Service
public class SearchServiceImpl  implements SearchService{

	@Autowired
	private MongoTemplate mongoTemplate;
	@Override
	public List<Document> getResults(String serial) {
		
		return  mongoTemplate.find(Query.query(Criteria.where("SERIAL_NO").is(serial)), Document.class, "vil_serial");
	}

}
