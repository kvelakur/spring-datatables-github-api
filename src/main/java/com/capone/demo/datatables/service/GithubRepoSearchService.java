package com.capone.demo.datatables.service;

import com.capone.demo.datatables.datatables.DataTablesResponse;
import com.capone.demo.datatables.domain.GithubRepo;
import com.capone.demo.datatables.repository.GithubReposRepository;
import com.capone.demo.datatables.datatables.DataTablesRequest;
import com.capone.demo.datatables.domain.GithubReposSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Service
public class GithubRepoSearchService {

  @Autowired
  GithubReposRepository repository;


  public DataTablesResponse<List<GithubRepo>> findAll(final DataTablesRequest dataTablesRequest) throws IOException, URISyntaxException {
    final DataTablesResponse<List<GithubRepo>> response = DataTablesResponse.newDataTablesResponseFor(dataTablesRequest);
    final GithubReposSearch result = repository.findAll(dataTablesRequest);
    response.setData(result.getItems());
    response.setRecordsTotal(new Long(result.getTotal_count()));
    response.setRecordsFiltered(new Long(result.getTotal_count()));
    response.setDraw(dataTablesRequest.getDraw());
    return response;
  }

}
