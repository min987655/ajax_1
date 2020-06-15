package com.cos.product.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.product.db.DBconn;
import com.cos.product.model.Product;

public class ProductRepository {
	private static final String TAG = "ProductRepository : "; 
	
	private static ProductRepository instance = new ProductRepository();
	private ProductRepository() {}
	public static ProductRepository getInstance() {
		return instance;
	}
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public List<Product> findAll() {
		final String SQL = "SELECT id, name, type, price, count FROM product ORDER BY id ASC";
		List<Product> products = new ArrayList<>();
		
		try {
			conn = DBconn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Product product = Product.builder()
						.id(rs.getInt(1))
						.name(rs.getString(2))
						.type(rs.getString(3))
						.price(rs.getInt(4))
						.count(rs.getInt(5))
						.build();
				products.add(product);
				System.out.println(TAG + "product : " + product);
			}
			return products;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "findAll : " + e.getMessage());
		} finally {
			DBconn.close(conn, pstmt, rs);
		}
		return null;
	}
	
}
