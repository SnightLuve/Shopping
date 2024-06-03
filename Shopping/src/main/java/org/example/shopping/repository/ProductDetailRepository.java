package org.example.shopping.repository;

import org.example.shopping.dto.reponse.ProductDetailResponse;
import org.example.shopping.model.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {
    @Query("select new org.example.shopping.dto.reponse.ProductDetailResponse(pd.id,p.id,b.id,ca.id,c.id,s.id,so.id,m.id,pd.quantity,pd.created_at,pd.updated_at) from ProductDetail pd join Product p on p.id=pd.product.id join Brand  b on b.id=pd.brand.id join Category  ca on ca.id=pd.category.id join Color c on c.id=pd.color.id join Size  s on s.id=pd.size.id join Sole so on so.id=pd.sole.id join Material m on m.id=pd.material.id order by pd.id desc  ")
    List<ProductDetailResponse> getAll();
}

