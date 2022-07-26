package com.vil.searchapp.service;

import org.springframework.stereotype.Service;

import java.util.List;

import org.bson.Document;

@Service
public interface SearchService {

	public List<Document> getResults(String serial);
}
