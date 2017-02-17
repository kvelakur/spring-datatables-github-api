package com.capone.demo.datatables.datatables;

import java.util.Objects;

public class DataTablesRequest {

  private Integer draw;

  private Integer start;

  private Integer length;

  private String search_value;

  private Integer sort_index;

  private String sort_order;

  public Integer getDraw() {
    return draw;
  }

  public void setDraw(Integer draw) {
    this.draw = draw;
  }

  public Integer getStart() {
    return start;
  }

  public void setStart(Integer start) {
    this.start = start;
  }

  public Integer getLength() {
    return length;
  }

  public void setLength(Integer length) {
    this.length = length;
  }

  public String getSearch_value() {
    return search_value;
  }

  public void setSearch_value(String search_value) {
    this.search_value = search_value;
  }

  public Integer getSort_index() {
    return sort_index;
  }

  public void setSort_index(Integer sort_index) {
    this.sort_index = sort_index;
  }

  public String getSort_order() {
    return sort_order;
  }

  public void setSort_order(String sort_order) {
    this.sort_order = sort_order;
  }
}
