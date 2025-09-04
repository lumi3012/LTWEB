package loginRegister_bt02.dao;

import java.sql.*;
import java.util.*;

import loginRegister_bt02.connect.DBConnect;
import loginRegister_bt02.model.Category;

public class CategoryDaoImpl implements CategoryDao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    public void insert(Category category) {
        String sql = "INSERT INTO Category(name, icon) VALUES(?,?)";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, category.getName());
            ps.setString(2, category.getIcon());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    @Override
    public void update(Category category) {
        String sql = "UPDATE Category SET name=?, icon=? WHERE id=?";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, category.getName());
            ps.setString(2, category.getIcon());
            ps.setInt(3, category.getId());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Category WHERE id=?";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    @Override
    public Category findById(int id) {
        String sql = "SELECT * FROM Category WHERE id=?";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Category(rs.getInt("id"), rs.getString("name"), rs.getString("icon"));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }

    @Override
    public List<Category> findAll() {
        List<Category> list = new ArrayList<>();
        String sql = "SELECT * FROM Category";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt("id"), rs.getString("name"), rs.getString("icon")));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }
}
