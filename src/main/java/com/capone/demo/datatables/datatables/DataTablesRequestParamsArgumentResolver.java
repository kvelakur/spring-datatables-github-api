package com.capone.demo.datatables.datatables;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

public class DataTablesRequestParamsArgumentResolver implements HandlerMethodArgumentResolver {

  @Override
  public boolean supportsParameter(final MethodParameter parameter) {
    return parameter.getParameterAnnotation(DataTablesRequestParams.class) != null;
  }

  @Override
  public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
    HttpServletRequest httpRequest = (HttpServletRequest) webRequest.getNativeRequest();
    DataTablesRequest tablesRequest = new DataTablesRequest();

    tablesRequest.setDraw(Integer.valueOf(httpRequest.getParameter("draw")));
    tablesRequest.setStart(Integer.valueOf(httpRequest.getParameter("start")));
    tablesRequest.setLength(Integer.valueOf(httpRequest.getParameter("length")));
    tablesRequest.setSearch_value(httpRequest.getParameter("search[value]"));
    final Integer sort_index = httpRequest.getParameter("order[0][column]") == null ? 3 : Integer.valueOf(httpRequest.getParameter("order[0][column]"));
    tablesRequest.setSort_index(sort_index);
    tablesRequest.setSort_order(httpRequest.getParameter("order[0][dir]"));
    return tablesRequest;
  }

}
