package com.capone.demo.datatables.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.capone.demo.datatables.datatables.DataTablesRequest;
import com.capone.demo.datatables.domain.GithubRepo;
import com.capone.demo.datatables.domain.GithubReposSearch;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

@Repository
public class GithubReposRepositoryRestImpl implements GithubReposRepository {

  private static HttpClient client = null;
  private static final ObjectMapper mapper = new ObjectMapper();
  private static final String DEFAULT_SEARCH = "tetris";
  private final Logger log = LoggerFactory.getLogger(this.getClass());


  @PostConstruct
  public void init() {
    RequestConfig.Builder requestBuilder = RequestConfig.custom();
    requestBuilder = requestBuilder.setConnectTimeout(2000);
    requestBuilder = requestBuilder.setConnectionRequestTimeout(2000);
    client = HttpClientBuilder.create().setDefaultRequestConfig(requestBuilder.build()).build();

  }

  @Override
  public GithubReposSearch findAll(DataTablesRequest dataTablesRequest) throws URISyntaxException, IOException {
    final GithubReposSearch searchResults = performSearch(dataTablesRequest);
    return searchResults;
  }

  private GithubReposSearch performSearch(final DataTablesRequest dataTablesRequest) throws URISyntaxException, IOException {
    final URI uri = new URIBuilder("https://api.github.com/search/repositories")
      .addParameter("q", dataTablesRequest.getSearch_value().isEmpty() ? DEFAULT_SEARCH : dataTablesRequest.getSearch_value())
      .addParameter("per_page", dataTablesRequest.getLength().toString())
      .addParameter("page", ((Integer)(dataTablesRequest.getStart()/dataTablesRequest.getLength())).toString())
      .addParameter("sort", dataTablesRequest.getSort_index() == 3 ? "forks" : "stars")
      .addParameter("order", dataTablesRequest.getSort_order())
      .build();
    final HttpGet getRequest = new HttpGet(uri);
    getRequest.addHeader("accept", "application/json");
    HttpResponse response = null;
    try {
      response = client.execute(getRequest);
    } catch (Exception e) {
      getRequest.releaseConnection();
      log.error("Failed to perform GET", e);
      return emptySearch();
    }


    if (response.getStatusLine().getStatusCode() != 200) {
      getRequest.releaseConnection();
      log.error("Failed : HTTP error code : {}", response.getStatusLine().getStatusCode());
      return emptySearch();
    }

    final String ret = EntityUtils.toString(response.getEntity());
    EntityUtils.consumeQuietly(response.getEntity());
    return mapper.readValue(ret, GithubReposSearch.class);
  }

  private GithubReposSearch emptySearch() {
    final GithubReposSearch empty = new GithubReposSearch();
    empty.setItems(new ArrayList<GithubRepo>());
    empty.setIncomplete_results(true);
    empty.setTotal_count(0);
    return empty;
  }

}
