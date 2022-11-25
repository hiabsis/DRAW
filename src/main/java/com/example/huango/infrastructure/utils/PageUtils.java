//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.huango.infrastructure.utils;


import com.example.huango.infrastructure.spring.query.OrderType;
import com.example.huango.infrastructure.spring.query.PageQuery;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.util.StringUtils;

public class PageUtils {

    private PageUtils() {
        throw new IllegalStateException("Utility class");
    }
    public static Sort generateSort(OrderType orderType, String orderBy) {
        if (StringUtils.isEmpty(orderBy)) {
            orderBy = "id";
        }

        if (orderType == null) {
            orderType = OrderType.valueOf("DESC");
        }

        Sort sort;
        if (OrderType.DESC.equals(orderType)) {
            sort = Sort.by(Direction.DESC, new String[]{orderBy});
        } else {
            sort = Sort.by(Direction.ASC, new String[]{orderBy});
        }

        return sort;
    }

    public static PageRequest generatePageRequest(Integer page, Integer size) {
        page = checkPage(page);
        size = checkSize(size);
        return PageRequest.of(page - 1, size);
    }

    public static PageRequest generatePageRequest(Integer page, Integer size, Sort sort) {
        page = checkPage(page);
        size = checkSize(size);
        return PageRequest.of(page - 1, size, sort);
    }

    public static PageRequest generatePageRequest(Integer page, Integer size, OrderType orderType, String orderBy) {
        return generatePageRequest(page, size, generateSort(orderType, orderBy));
    }

    public static PageRequest generatePageRequest(PageQuery vo) {
        return generatePageRequest(vo.getPage(), vo.getPageSize(), generateSort(vo.getOrderType(), vo.getOrderBy()));
    }



    private static int checkPage(Integer page) {
        if (page == null) {
            page = Integer.valueOf("1");
        } else if (page < 1) {
            page = 1;
        }

        return page;
    }

    private static int checkSize(Integer size) {
        if (size == null) {
            size = Integer.valueOf("10");
        } else if (size < 1) {
            size = 1;
        }

        return size;
    }
}
