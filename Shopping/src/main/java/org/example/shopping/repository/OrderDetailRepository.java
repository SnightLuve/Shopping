package org.example.shopping.repository;

import org.example.shopping.dto.response.OrderDetailResponse;
import org.example.shopping.model.Order;
import org.example.shopping.model.OrderDetail;
import org.example.shopping.model.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    List<OrderDetail> findAllByOrder(Order order);

    Optional<OrderDetail> findByOrderAndProductDetail(Order order, ProductDetail productDetail);

    @Query("SELECT new org.example.shopping.dto.response.OrderDetailResponse(" +
            "od.id,pd.id,p.name,c.name,s.name,b.name,od.quantity,od.totalMoney) " +
            "from ProductDetail  pd " +
            "join Product p on pd.product.id=p.id " +
            "join Brand b on pd.brand.id=b.id " +
            "join Color c on pd.color.id=c.id " +
            "join Size s on pd.size.id=s.id " +
            "join OrderDetail od on od.productDetail.id=pd.id")
    List<OrderDetailResponse> getAllProductDetailByOrderId(Long orderId);
}
