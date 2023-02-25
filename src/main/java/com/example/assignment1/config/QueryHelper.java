package com.example.assignment1.config;

import com.example.assignment1.models.Pageable;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.*;
import java.util.stream.Collectors;

public class QueryHelper {
    public static PageRequest getPageRequest(Pageable param) {
        return PageRequest.of(param.getPageNo() == null ? 0 : param.getPageNo() - 1,
                param.getPageSize(), QueryHelper.getSort(param.getSortBy()));
    }

    public static Sort getDefaultSort() {
        return Sort.by(Sort.Direction.ASC, "id");
    }
    public static Sort getSort(String param, Sort.Direction direction) {
        return Sort.by(direction, param);
    }

    public static Sort getSort(TreeMap<String, Sort.Direction> map) {
        List<Sort.Order> orderList = new ArrayList<>();
        for (Map.Entry<String, Sort.Direction> entry : map.entrySet()) {
            Sort.Order order = new Sort.Order(entry.getValue(), entry.getKey());
            orderList.add(order);
        }
        return Sort.by(orderList);
    }

    public static Sort getSort(String sortBy) {
        return StringUtils.isBlank(sortBy) ? getDefaultSort()
                : Sort.by(Arrays.stream(sortBy.split(",")).map(
                        (orders) -> getOrder(orders.split(":")))
                .collect(Collectors.toList()));
    }

    private static Sort.Order getOrder(String[] orders) {
        return new Sort.Order(Sort.Direction.fromString(orders[1]), orders[0]);
    }
}
