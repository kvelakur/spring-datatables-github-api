package com.capone.demo.datatables.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubRepo {

  private String description;
  private String homepage;
  private String name;
  private String full_name;
  private String html_url;    // this is the UI

  private Integer forks_count;
  private Integer stargazers_count;
  private Integer watchers_count;
  private Integer size;
  private Integer open_issues_count;
  private Integer subscribers_count;
  private Long score;

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getHomepage() {
    return homepage;
  }

  public void setHomepage(String homepage) {
    this.homepage = homepage;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getFull_name() {
    return full_name;
  }

  public void setFull_name(String full_name) {
    this.full_name = full_name;
  }

  public String getHtml_url() {
    return html_url;
  }

  public void setHtml_url(String html_url) {
    this.html_url = html_url;
  }

  public Integer getForks_count() {
    return forks_count;
  }

  public void setForks_count(Integer forks_count) {
    this.forks_count = forks_count;
  }

  public Integer getStargazers_count() {
    return stargazers_count;
  }

  public void setStargazers_count(Integer stargazers_count) {
    this.stargazers_count = stargazers_count;
  }

  public Integer getWatchers_count() {
    return watchers_count;
  }

  public void setWatchers_count(Integer watchers_count) {
    this.watchers_count = watchers_count;
  }

  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  public Integer getOpen_issues_count() {
    return open_issues_count;
  }

  public void setOpen_issues_count(Integer open_issues_count) {
    this.open_issues_count = open_issues_count;
  }

  public Integer getSubscribers_count() {
    return subscribers_count;
  }

  public void setSubscribers_count(Integer subscribers_count) {
    this.subscribers_count = subscribers_count;
  }

  public Long getScore() {
    return score;
  }

  public void setScore(Long score) {
    this.score = score;
  }
}
