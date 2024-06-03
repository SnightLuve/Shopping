SELECT pd.id,p.name,b.name,c.name,cl.name,s.name,so.name,m.name,pd.quantity FROM product_detail pd
join product p on pd.product_id = p.id
join brand b on pd.brand_id = b.id
join category c on pd.category_id = c.id
join color cl on pd.color_id = cl.id
join size s on pd.size_id = s.id
join sole so on pd.sole_id = so.id
join material m on pd.material_id = m.id;


select *from product_detail;
select *from discount;
select *from cart;

select * from cartdetail;

select * from users;





