package com.capone.demo.datatables.controller;

import com.capone.demo.datatables.datatables.DataTablesResponse;
import com.capone.demo.datatables.datatables.DataTablesRequest;
import com.capone.demo.datatables.datatables.DataTablesRequestParams;
import com.capone.demo.datatables.domain.GithubRepo;
import com.capone.demo.datatables.service.GithubRepoSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class GithubReposController {

  @Autowired
  GithubRepoSearchService service;

  @RequestMapping(value = "/githubRepos", method = GET)
  public
  @ResponseBody
  DataTablesResponse<List<GithubRepo>> getEmployees(@DataTablesRequestParams DataTablesRequest dataTablesRequest) throws IOException, URISyntaxException {
    return service.findAll(dataTablesRequest);
  }

}
