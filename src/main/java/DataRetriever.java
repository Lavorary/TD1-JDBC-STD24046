import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor

public class DataRetriever {

   private DBConnection dbConnection;



    public List<Category> getAllCategories() throws SQLException {
        List<Category> categories = new ArrayList<>();

        String query = "SELECT id, name FROM product_category ORDER BY id DESC";

        try(Connection connection = dbConnection.getDBConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query)) {
                while (resultSet.next()) {
                   Category category = new Category(resultSet.getInt("id"), resultSet.getString("name"));

                   categories.add(category);
                }
                resultSet.close();
                statement.close();
                connection.close();
                return categories;

        } catch (SQLException e)  {
            e.printStackTrace();
            throw new SQLException("Failed to retrieve categories", e);
        }

    }


    List<Product> getProductList(int page, int size) throws SQLException {
        List<Product> product = new ArrayList<>();

        int offset = (page - 1) * size;

      String query = """
                SELECT p.id, p.name, pc.name as category_name " +
                      FROM product p " +
                      LEFT JOIN product_category pc ON p.category_id = pc.id " +
                      ORDER BY p.id " +
                      LIMIT ? OFFSET ?
                """;



        try(Connection connection = dbConnection.getDBConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery(query)) {
            statement.setInt(1, offset);
            statement.setInt(2, size);

            while (resultSet.next()) {
                Product product1 = new Product(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getTimestamp("creationDateTime").toInstant(), new Category(resultSet.getInt("category_id"), resultSet.getString("category_name") ));

            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to retrieve products", e);
        }
        return product;
    }
    }



