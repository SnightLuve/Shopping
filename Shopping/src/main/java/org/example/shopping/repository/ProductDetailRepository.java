package org.example.shopping.repository;

import org.example.shopping.dto.response.ProductDetailResponse;
import org.example.shopping.model.ProductDetail;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {
    @Query("select new org.example.shopping.dto.response.ProductDetailResponse(pd.id,p.name,b.name,c.name," +
            "s.name,pd.quantity,pd.created_at,pd.updated_at) " +
            "from ProductDetail pd join Product p on p.id=pd.product.id " +
            "join Brand  b on b.id=pd.brand.id  " +
            "join Color c on c.id=pd.color.id " +
            "join Size  s on s.id=pd.size.id  " +
            "order by pd.id desc")
    List<ProductDetailResponse> getAll();

    @Query("select new org.example.shopping.dto.response.ProductDetailResponse(pd.id,p.name,b.name,c.name," +
            "s.name,pd.quantity,pd.created_at,pd.updated_at) " +
            "from ProductDetail pd join Product p on p.id=pd.product.id " +
            "join Brand b on b.id=pd.brand.id " +
            "join Color c on c.id=pd.color.id " +
            "join Size s on s.id=pd.size.id " +
            "where (:brandId is null or b.id = :brandId) and " +
            "(:colorId is null or c.id = :colorId) and " +
            "(:sizeId is null or s.id = :sizeId) and " +
            "(:productId is null or p.id=:productId)" +
            "order by pd.id desc")
    List<ProductDetailResponse> filter(Pageable pageable, Long brandId, Long colorId, Long sizeId, Long productId);


}

