package com.hateoas.order.repository;

import com.hateoas.order.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "/order")
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    /**
     * 根据用户查找获取所有的订单信息
     * @param user
     * @return
     */
    List<OrderEntity> findByUser(@Param("user") String user);

}
