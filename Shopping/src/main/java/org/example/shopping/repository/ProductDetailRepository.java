package org.example.shopping.repository;

import jakarta.transaction.Transactional;
import org.example.shopping.dto.request.ProductDetailRequest;
import org.example.shopping.dto.response.ProductDetailResponse;
import org.example.shopping.model.ProductDetail;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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


//    @Modifying
//    @Transactional
//    @Query(value = "INSERT INTO product_detail (product_id, brand_id, category_id, color_id, size_id, sole_id, material_id, created_at, updated_at, quantity, status, price) " +
//            "VALUES (:#{#request.productId}, :#{#request.brandId}, :#{#request.categoryId}, :#{#request.colorId}, :#{#request.sizeId}, :#{#request.soleId}, " +
//            ":#{#request.materialId},:#{#request.created_at}, :#{#request.updated_at}, :#{#request.quantity}, :#{#request.status}, :#{#request.price})",
//            nativeQuery = true)
//    void add(@Param("request") ProductDetailRequest request);
//
//    @Modifying
//    @Transactional
//    @Query(value = "UPDATE product_detail SET product_id = :#{#request.productId}, brand_id = :#{#request.brandId}, " +
//            "category_id = :#{#request.categoryId}, color_id = :#{#request.colorId}, size_id = :#{#request.sizeId}, " +
//            "sole_id = :#{#request.soleId}, material_id = :#{#request.materialId}, created_at = :#{#request.created_at}, " +
//            "updated_at = :#{#request.updated_at}, quantity = :#{#request.quantity}, status = :#{#request.status}, " +
//            "price = :#{#request.price} WHERE id = :#{#request.id}", nativeQuery = true)
//    void update(@Param("request") ProductDetailRequest request);

}

