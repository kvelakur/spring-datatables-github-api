package com.capone.demo.datatables.repository;

import com.capone.demo.datatables.datatables.DataTablesRequest;
import com.capone.demo.datatables.domain.GithubReposSearch;

import java.io.IOException;
import java.net.URISyntaxException;

public interface GithubReposRepository {

  GithubReposSearch findAll(DataTablesRequest tablesRequest) throws URISyntaxException, IOException;

}
